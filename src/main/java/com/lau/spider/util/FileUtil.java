package com.lau.spider.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @program: FileUtil
 * @description: 文件读写工具类
 * @author: Lau52y
 * @create: 2018-08-12 15:56
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
public class FileUtil {

    public static void writeInFileByfb(String filePath,String content) {
        File f=new File(filePath);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            File fileParent = f.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            if(!f.exists()){
                f.createNewFile();
            }
            fw=new FileWriter(f.getAbsoluteFile(),true);  //true表示可以追加新内容
            //fw=new FileWriter(f.getAbsoluteFile()); //表示不追加
            bw=new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
