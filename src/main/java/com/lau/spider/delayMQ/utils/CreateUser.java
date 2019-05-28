package com.lau.spider.delayMQ.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateUser {


    public static void createFile(String token) throws IOException{
        String path = "D:\\BaiduYunDownload\\apache-jmeter-4.0\\apache-jmeter-4.0\\bin\\user.txt";
        File file = new File(path);
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        // write
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(token+"\r\n");
        bw.flush();
        bw.close();
        fw.close();
    }
    public static void main(String[] args) throws IOException{
        for (int i = 1; i < 10000; i++) {
            createFile(i+",2");
        }

    }

}