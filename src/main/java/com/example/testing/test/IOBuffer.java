package com.example.testing.test;

import java.io.*;

public class IOBuffer {
    public static void main(String[] args) throws FileNotFoundException {
        try{
            File f = new File("/home/hale/Backend/Learning/demo/src/main/java/com/example/testing/test/myFile.txt");
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int count = 0;
            int b = 0 ;
            while((b = bis.read()) != -1){
                if(b== '\n') {
                    count++;
                }
            }
//bis should be closed in a finally block.
            bis.close() ;
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
}
