package com.javarush.test.level16.lesson13.bonus01;
import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by San_Lex on 10.07.2014.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageTypes){
        if (imageTypes == ImageTypes.JPG) return new JpgReader();
        else if (imageTypes == ImageTypes.BMP) return new BmpReader();
            else if (imageTypes == ImageTypes.PNG) return new PngReader();
                else if (imageTypes == null) throw new IllegalArgumentException("Неизвестный тип картинки");
                    else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
