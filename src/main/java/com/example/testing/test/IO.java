package com.example.testing.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IO {
    public static void main(String[] args) {
        try{
            File f = new File("/home/hale/Backend/Learning/demo/src/main/java/com/example/testing/test/myFile.txt");
            FileInputStream fis = new FileInputStream(f);
            int count = 0;
            int b = 0;
            while((b = fis.read()) != -1){
                if(b== '\n') {
                    count++;
                }
            }
// fis should be closed in a finally block.
            fis.close() ;
        }
        catch(IOException io){}
    }
}
