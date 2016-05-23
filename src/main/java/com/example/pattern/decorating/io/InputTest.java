package com.example.pattern.decorating.io;

import java.io.*;

public class InputTest {
    public static void main(String[] args){
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(("/home/hale/Backend/Learning/demo/src/main/java/com/example/pattern/decorating/io/test.txt"))));
            while ((c=in.read()) >= 0){
                System.out.println((char)c);
            }
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
