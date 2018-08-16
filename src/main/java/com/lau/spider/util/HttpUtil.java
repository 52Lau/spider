package com.lau.spider.util;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.minidev.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: HttpUtil
 * @description: 发送post get请求
 * @author: Lau52y
 * @create: 2018-08-12 14:34
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
public class HttpUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 向指定URL发送GET方法的请求
     */
    public static String get(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("Exception occur when send http get request!", e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 发送HttpPost请求
     *
     * @param strURL 服务地址
     * @param params
     * @return 成功:返回json字符串<br/>
     */
    public static String jsonPost(String strURL, Map<String, String> params) {
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(JSONUtils.toJSONString(params));
            out.flush();
            out.close();

            int code = connection.getResponseCode();
            InputStream is = null;
            if (code == 200) {
                is = connection.getInputStream();
            } else {
                is = connection.getErrorStream();
            }

            // 读取响应
            int length = (int) connection.getContentLength();// 获取长度
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // utf-8编码
                return result;
            }

        } catch (IOException e) {
            log.error("Exception occur when send http post request!", e);
        }
        return "error"; // 自定义错误信息
    }

    public static void main(String[] args) {
        String s = get("https://api.zhuwei.me/v1/captions/oMCijY1XGlQ?api-key=a2d09c7d76fced01f8be4b1f4cce8bec");
        System.out.println(s);
        JSONObject jsonObject = JSON.parseObject(s);

        int meta=jsonObject.getJSONObject("meta").getInteger("code");
        System.out.println(meta);

        boolean isEn=false;
        boolean isZh=false;
        boolean isZh_Hans=false;

        JSONArray result =jsonObject.getJSONObject("response").getJSONObject("captions").getJSONArray("available_captions");
        for (int j = 0; j < result.size(); j++) {
            String language=result.getJSONObject(j).getString("language");
            String contentUrl=result.getJSONObject(j).getString("caption_content_url");
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
        System.out.println(isZh+"+"+isEn+"+"+isZh_Hans);

        if (isZh||isZh_Hans){
            log.info("如果存在中文字幕，即下载中文字幕");
            //System.out.println("如果存在中文字幕，即下载中文字幕");
        }else if (isEn){
            log.info("如果只有英文字幕，即下载英文字幕");
            //System.out.println("如果只有英文字幕，即下载英文字幕");
        }
        //不符合条件的话，暂时不下载



    }
}
