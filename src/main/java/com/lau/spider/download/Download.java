package com.lau.spider.download;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lau.spider.command.Command;
import com.lau.spider.command.LinuxCommand;
import com.lau.spider.util.FileUtil;
import com.lau.spider.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(Download.class);

    public static final String API_KEY="d926b4c42cb0a2d1739edd6336170ecd9daac9b3";

    public static final String  YOUTUBE_URL_HEAD="https://www.youtube.com/watch?v=RsVpYDk-XEg";

    //YouTube-dl命令
    public static final String YOUTUBE_DL="youtube-dl ";

    //YOUTUBE_DL_VIDEO_LIST 根据URL获取视频和音频的列表
    public static final String YOUTUBE_DL_VIDEO_AUDIO_LIST="youtube-dl -F ";

    //Youtube-dl --list-subs 列出所有字幕
    public static final String YOUTUBE_DL_LIST_SUBS="youtube-dl --list-subs ";

    //youtube-dl 下载视频和音频
    public static final String YOUTUBE_DL_DOWNLOAD_VIDEO_AUDIO="youtube-dl -f ";

    //YouTube-dl 合成字幕和视频
    public static final String YOUTUBE_DL_COMPOUND_VIDEO_SUBS="youtube-dl ";

    //上传文件到百度云
    public static final String UPLOAD_BAIDUYUN="youtube-dl ";

    /**
     * 获取所有字幕列表 https://zhuwei.me/y2b/ API
     * @return
     */
    public static String get_list_subs(String videoId){
        String url="https://api.zhuwei.me/v1/captions/"+videoId+"?api-key="+API_KEY;
        String results=HttpUtil.get(url);
        JSONObject jsonObject = JSON.parseObject(results);
        int code=jsonObject.getJSONObject("meta").getInteger("code");
        if (code!=200){
            log.info("该视频没有字幕！");
            return "no subs!";
        }
        boolean isEn=false;
        boolean isZh=false;
        boolean isZh_Hans=false;

        JSONArray result =jsonObject.getJSONObject("response").getJSONObject("captions").getJSONArray("available_captions");
        for (int j = 0; j < result.size(); j++) {
            String language=result.getJSONObject(j).getString("language");
            if ("zh".equals(language)){//中文字幕
                isZh=true;
            }
            if ("en".equals(language)){//英文字幕
                isEn=true;
            }
            if ("zh-Hans".equals(language)){//简体中文字幕
                isZh_Hans=true;
            }

        }
        log.info("存在中文字幕："+isZh+"---存在英文字幕："+isEn+"---存在简体中文字幕："+isZh_Hans);

        if (isZh||isZh_Hans){
            log.info("如果存在中文字幕，即下载中文字幕");
            downloadSubtitle(videoId,"en",true);
        }else if (isEn){
            log.info("如果只有英文字幕，即下载英文字幕");
            downloadSubtitle(videoId,"en",false);
        }
        //不符合条件的话，暂时不下载
        return "subs";

    }


    /**
     * 下载字幕使用https://zhuwei.me/y2b/ API
     * @param language 字幕语言
     * @param videoId 视频ID
     * @param Bilingual 是否生成双语字幕
     * @return
     */
    public static String downloadSubtitle(String videoId,String language,boolean Bilingual){
        String url="https://api.zhuwei.me/v1/captions/"+videoId+"/contents/"+language+"?api-key="+API_KEY;
        if (Bilingual){
            url=url+"&multilanguage=multilanguage";
        }
        log.info(url);
        String results=HttpUtil.get(url);
        JSONObject jsonObject = JSON.parseObject(results);
        int code=jsonObject.getJSONObject("meta").getInteger("code");
        if (code!=200){
            log.info("字幕下载失败！");
            return "downloadSubtitle error!";
        }
        String content=jsonObject.getJSONObject("contents").getString("content");
        FileUtil.writeInFileByfb("/root/"+videoId+".srt",content);
        return "downloadSubtitle successful!";
    }

    /**
     * 使用ffmpeg合成音频和视频
     * @param url
     * @return
     */
    public static String thetic_audio_and_video(String url){

        String cmd=YOUTUBE_DL_VIDEO_AUDIO_LIST+" https://www.youtube.com/watch?v=RsVpYDk-XEg";
        log.info(cmd);
        String results= null;
        try {
            results = LinuxCommand.runCmd(cmd,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * 获取视频的所有格式以及音频
     * @param url
     * @return
     */
    public static String  get_youtube_dl_video_audio_list(String url){

        String cmd=YOUTUBE_DL_VIDEO_AUDIO_LIST+" "+url;
        log.info(cmd);
        String results= null;
        try {
            results = LinuxCommand.runCmd(cmd,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!results.contains("140")){
            log.error("获取超时！请检查连接或者网络代理！");
            return "error";
        }
        // 所有有视频均下载mp4格式的 音频m4a
        if (results.contains("137")){
            log.info("下载1080P");
            get_youtube_dl_download_video_audio("137+140",url);
        }else if (results.contains("136")){
            log.info("下载720P");
            get_youtube_dl_download_video_audio("136+140",url);
        }else if(results.contains("135")){
            log.info("下载480P");
            get_youtube_dl_download_video_audio("135+140",url);
        }
        return results;
    }

    /**
     * 下载视频和音频，优先级别1080P 137>720P 136>480P 135,默认音频为m4a 140
     * @param Sharpness 清晰度
     * @param url 视频连接
     * @return
     */
    public static void get_youtube_dl_download_video_audio(String Sharpness,String url){
        String cmd=YOUTUBE_DL_DOWNLOAD_VIDEO_AUDIO+Sharpness+" "+url;
        log.info(cmd);
        try {
            log.info("正在下载中..........");
            LinuxCommand.runCmd("cd /root/video","UTF-8");
            LinuxCommand.runCmd(cmd,"UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("下载完毕..........");
    }
    public static void main(String[] args) {
        //YOUTUBE_DL_VIDEO_AUDIO_LIST("downloadMovie");


        try {
            //LinuxCommand.versouSshUtil("113.52.135.185", "root", "Lxy@15576771990", 462);
            //get_youtube_dl_video_audio_list("https://www.youtube.com/watch?v=-MT3adqmkio00");
            //get_youtube_dl_download_video_audio("137+140","https://www.youtube.com/watch?v=lrcA8EjJheE");
            //LinuxCommand.runCmd("ifconfig", "UTF-8");
            get_list_subs("oMCijY1XGlQ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
