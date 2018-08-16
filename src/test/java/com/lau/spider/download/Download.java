package com.lau.spider.download;

import com.lau.spider.command.Command;
import org.junit.jupiter.api.Test;

/**
 * @program: spider
 *
 * @description: 下载视频字幕工具
 *
 * @author: Lau52y
 *
 * @create: 2018-08-09 20:59
 **/
public class Download {
    public static final String  YOUTUBE_URL_HEAD="https://www.youtube.com/watch?v=RsVpYDk-XEg";

    //YOUTUBE_DL_VIDEO_LIST 根据URL获取视频和音频的列表
    public static final String YOUTUBE_DL_VIDEO_LIST="youtube-dl -F ";

    /**
     * 下载字幕使用YouToBe-dl
     * @param url
     * @return
     */
    public static String downloadZiMu(String url){

        return null;
    }

    /**
     * 下载视频使用YouToBe-dl 使用ffmpeg合成音频和视频
     * @param url youtube-dl -f 137+140 https://www.youtube.com/watch?v=RsVpYDk-XEg
     * @return
     */
    public static String downloadMovie(String url){

        String cmd=YOUTUBE_DL_VIDEO_LIST+" https://www.youtube.com/watch?v=RsVpYDk-XEg";
        System.out.println(cmd);
        String results=Command.execute(cmd);
        if (!results.contains("137")){
            System.out.println("获取超时！请检查连接或者网络代理！");
        }
        // 所有有视频均下载m4a格式的
        // 判断是否存在1080P
        if (results.contains("137")){
            System.out.println("下载1080P");
        }else if (results.contains("136")){
            System.out.println("下载720P");
        }else if(results.contains("135")){
            System.out.println("下载480P");
        }
        return results;
    }

    /**
     * 获取视频的所有格式以及音频
     * @param url
     * @return
     */
    public static String  getVideoAudiolist(String url){

        String cmd=YOUTUBE_DL_VIDEO_LIST+" https://www.youtube.com/watch?v=RsVpYDk-XEg";
        System.out.println(cmd);
        String results=Command.execute(cmd);
        if (!results.contains("137")){
            System.out.println("获取超时！请检查连接或者网络代理！");
        }
        // 所有有视频均下载m4a格式的
        // 判断是否存在1080P
        if (results.contains("137")){
            System.out.println("下载1080P");
        }else if (results.contains("136")){
            System.out.println("下载720P");
        }else if(results.contains("135")){
            System.out.println("下载480P");
        }
        return results;
    }


    public static void main(String[] args) {
        getVideoAudiolist("downloadMovie");
    }
}
