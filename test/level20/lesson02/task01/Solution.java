package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
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

            Asset car = new Asset("car");
            car.setPrice(10000.567);
            Asset home = new Asset("home");
            home.setPrice(499.9);
            Human ivanov = new Human("ivanov");
            ivanov.save(outputStream);
            Human ivanova = new Human("Ivanova", new Asset("home"), car);
            ivanov.save(outputStream);
            Human petrov = new Human("Petrov");
            petrov.save(outputStream);
            Human sidorov = new Human("Sidorov", home, new Asset("dog"));
            sidorov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov.name.equals(somePerson.name)) System.out.println("true: " + ivanov.name + " " + somePerson.name);
            else System.out.println("false: " + ivanov.name + " " + somePerson.name);
            for (int i = 0; i < ivanov.assets.size(); i++){
                if (ivanov.assets.get(i).getName().equals(somePerson.assets.get(i).getName())) System.out.println("assetName true:" + ivanov.assets.get(i).getName() + " " + somePerson.assets.get(i).getName());
                else System.out.println("assetName false:" + ivanov.assets.get(i).getName() + " " + somePerson.assets.get(i).getName());
                if (ivanov.assets.get(i).getPrice() == somePerson.assets.get(i).getPrice()) System.out.println("assetPrice true:" + ivanov.assets.get(i).getPrice() + " " + somePerson.assets.get(i).getPrice());
                else System.out.println("assetPrice false:" + ivanov.assets.get(i).getPrice() + " " + somePerson.assets.get(i).getPrice());
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<Asset>();;

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter =  new PrintWriter(outputStream,true);
            printWriter.println(name);
            if (assets.size() != 0) {
                for (Asset element : assets) {
                    printWriter.print(element.getName());
                    if (element.getPrice() != 0.0) {
                        printWriter.println(" " + element.getPrice());
                    }
                    else printWriter.println(" withoutPrice");
                }
            }
            else printWriter.println("withoutAssets");
            printWriter.println("----------");
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if (bufferedReader.ready()){
                this.name = bufferedReader.readLine();
                String line = "";
                while (!(line = bufferedReader.readLine()).equals("----------")){
                    String[] tmp = line.split(" ");
                    if (!tmp[0].equals("withoutAssets")) {
                        Asset tmpAsset = new Asset(tmp[0]);
                        if (!tmp[1].equals("withoutPrice")) tmpAsset.setPrice(Double.parseDouble(tmp[1]));
                        assets.add(tmpAsset);
                    }
                }
            }
        }
    }
}