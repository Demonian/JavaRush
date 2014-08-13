package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter{
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        try{
            if ((off < 0) || (off > cbuf.length) || (len < 0) ||
                    ((off + len) > cbuf.length) || ((off + len) < 0))
            {
                throw new IndexOutOfBoundsException();
            } else if (len == 0)
            {
                return;
            }
            System.out.print(new StringBuilder().append(cbuf).toString().substring(off,off + len));
            super.write(cbuf, off, len);
        } catch (IndexOutOfBoundsException e){
        }
    }

    @Override
    public void write(int c) throws IOException
    {
        char cbuf[] = new char[1];
        cbuf[0] = (char) c;
        write(cbuf, 0, 1);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        try{
            if (len < 0) throw new IndexOutOfBoundsException();
            char cbuf[] = new char[len];
            try
            {
                str.getChars(off, off + len, cbuf, 0);
                write(cbuf, 0, len);
            }
            catch (StringIndexOutOfBoundsException e)
            {
            }
        } catch (IndexOutOfBoundsException e){
        }
    }


    @Override
    public void write(char[] cbuf) throws IOException
    {
        write(cbuf, 0, cbuf.length);
    }

    @Override
    public void write(String str) throws IOException
    {
        write(str, 0, str.length());
    }

}
