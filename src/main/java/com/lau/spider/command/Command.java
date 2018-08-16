package com.lau.spider.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @program: spider
 *
 * @description: java命令行执行工具  适用windows版本
 *
 * @author: Lau52y
 *
 * @create: 2018-08-09 20:52
 **/
public class Command {
    /** 
    * @Description: 执行命令 
    * @Param:
    * @return:
    * @Author:Lau52y
    * @Date: 2018/8/9 
    */ 
    public static String execute(String command){
        BufferedReader br = null;
        StringBuilder sb=new StringBuilder();
        try {
            Process p = Runtime.getRuntime().exec(command);
            br = new BufferedReader(new InputStreamReader(p.getInputStream(),Charset.forName("GBK")));
            String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }
}
