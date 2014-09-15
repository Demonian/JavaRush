package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
            InputStream inputStream = new FileInputStream("d:/1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user0 = new User();
            javaRush.users.add(user0);
            User user1 = new User();
            user1.setFirstName("Yopta 456");
            user1.setLastName("bratok bratishka");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);
            javaRush.save(outputStream);
            outputStream.flush();

            for (User user : javaRush.users){
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(user.getBirthDate());
                System.out.println(user.isMale());
                try{
                    System.out.println(user.getCountry().getDisplayedName());
                } catch (Exception e){
                    System.out.println("countryEmpty");
                }
            }

            JavaRush javaRush0 = new JavaRush();
            //User user2 = new User();
            //javaRush0.users.add(user2);
            User user3 = new User();
            user3.setFirstName("Kusko ';l'15");
            user3.setLastName("asd hkj hkk");
            user3.setBirthDate(new Date());
            user3.setMale(false);
            user3.setCountry(User.Country.UKRAINE);
            javaRush0.users.add(user3);
            javaRush0.save(outputStream);
            outputStream.flush();

            JavaRush javaRush1 = new JavaRush();
            javaRush1.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User user : loadedObject.users){
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(user.getBirthDate());
                System.out.println(user.isMale());
                try{
                    System.out.println(user.getCountry().getDisplayedName());
                } catch (Exception e){
                    System.out.println("countryEmpty");
                }
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<User>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter =  new PrintWriter(outputStream,true);
            if (users.size() != 0) {
                for (User user : users) {
                    if (user.getFirstName() != null) printWriter.println(user.getFirstName());
                    else printWriter.println("firstnameEmpty");
                    if (user.getLastName() != null) printWriter.println(user.getLastName());
                    else printWriter.println("lastnameEmpty");
                    if (user.getBirthDate() != null) printWriter.println(user.getBirthDate());
                    else printWriter.println("birthdateEmpty");
                    printWriter.println(user.isMale());
                    if (user.getCountry() != null) printWriter.println(user.getCountry().getDisplayedName());
                    else printWriter.println("countryEmpty");
                }
                printWriter.println("-----endOfClass-----");
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            while (bufferedReader.ready()) {
                User user = new User();
                if (!"firstnameEmpty".equals(line)) user.setFirstName(line);
                if (!"lastnameEmpty".equals(line = bufferedReader.readLine())) user.setLastName(line);
                if (!"birthdateEmpty".equals(line = bufferedReader.readLine())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    Date date = sdf.parse(line);
                    user.setBirthDate(date);
                }
                user.setMale("true".equals(bufferedReader.readLine()));
                if (!"countryEmpty".equals(line = bufferedReader.readLine())) {
                    if ("Ukraine".equals(line)) user.setCountry(User.Country.UKRAINE);
                    if ("Russia".equals(line)) user.setCountry(User.Country.RUSSIA);
                    if ("Other".equals(line)) user.setCountry(User.Country.OTHER);
                }
                users.add(user);
                if ("-----endOfClass-----".equals(line = bufferedReader.readLine())) break;
            }
        }
    }
}
