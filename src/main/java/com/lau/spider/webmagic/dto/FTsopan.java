package com.lau.spider.webmagic.dto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FTsopan {

    /**
     * id : 11702
     * url : https://pan.baidu.com/s/1gf7iy8z
     * pwd :
     * ctime : 2017-02-20 19:23:47
     * size : 0
     * context : jmeter
     * user : 1613392714
     * type : 1
     * ext :
     * valid : 1
     * report : 0
     * engine : 0
     * tags : null
     * has_pwd : true
     */

    private String id;
    private String url;
    private String pwd;
    private String ctime;
    private String size;
    private String context;
    private String user;
    private String type;
    private String ext;
    private String valid;
    private String report;
    private String engine;
    private Object tags;
    private boolean has_pwd;

    public static FTsopan objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), FTsopan.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<FTsopan> arrayFTsopanFromData(String str) {

        Type listType = new TypeToken<ArrayList<FTsopan>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static void main(String[] args) {
        List<FTsopan> s=arrayFTsopanFromData("[{\"id\":\"11702\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1gf7iy8z\",\"pwd\":\"\",\"ctime\":\"2017-02-20 19:23:47\",\"size\":\"0\",\"context\":\"jmeter\",\"user\":\"1613392714\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null},{\"id\":\"11703\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1V2Asm0IAluXSLFb0bGjf1Q\",\"ctime\":\"2018-08-28 19:22:41\",\"size\":\"169557260\",\"context\":\"jmeter\",\"user\":\"\",\"type\":\"0\",\"ext\":\"pdf\",\"valid\":\"1\",\"report\":\"1\",\"engine\":\"0\",\"tags\":null,\"has_pwd\":true},{\"id\":\"11704\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1DcjLgUGjOyzoicVGTsb9fQ\",\"ctime\":\"2018-07-29 09:40:40\",\"size\":\"249718682\",\"context\":\"jmeter\",\"user\":\"\",\"type\":\"0\",\"ext\":\"pdf\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null,\"has_pwd\":true},{\"id\":\"11705\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1nu9YSVv\",\"pwd\":\"\",\"ctime\":\"2016-11-22 00:14:18\",\"size\":\"141545717\",\"context\":\"jmeter\",\"user\":\"\",\"type\":\"0\",\"ext\":\"mp4\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null},{\"id\":\"11706\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1kUECFtl\",\"pwd\":\"\",\"ctime\":\"2016-05-16 02:13:55\",\"size\":\"12772929\",\"context\":\"jmeter\",\"user\":\"293756916\",\"type\":\"0\",\"ext\":\"mp3\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null},{\"id\":\"11707\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1eTsYkE2\",\"ctime\":\"2018-03-01 04:37:09\",\"size\":\"107024294\",\"context\":\"jmeter\",\"user\":\"3879670446\",\"type\":\"0\",\"ext\":\"rar\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null,\"has_pwd\":true},{\"id\":\"11708\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1RfbUNOCSjHT-od9y5-jqJQ\",\"pwd\":\"\",\"ctime\":\"2018-08-28 20:19:20\",\"size\":\"1012956472\",\"context\":\"jmeter\",\"user\":\"3217531513\",\"type\":\"0\",\"ext\":\"rar\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null},{\"id\":\"681283\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1SEy8rNGtfDOHqqo2P5i9xw\",\"pwd\":\"\",\"ctime\":\"2018-03-06 01:05:32\",\"size\":\"0\",\"context\":\"Jmeter\",\"user\":\"2166395444\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null},{\"id\":\"1583681\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1o96Tf2y\",\"pwd\":\"\",\"ctime\":\"2018-01-23 00:00:00\",\"size\":\"80981524\",\"context\":\"\\u5168\\u6808\\u6027\\u80fd\\u6d4b\\u8bd5\\u4fee\\u70bc\\u5b9d\\u5178+JMeter\\u5b9e\\u6218+%2CROAD_TESTING\\u8f6f\\u4ef6\\u6d4b\\u8bd5\\u7ec4\\u7ec4\\u7a3f+%2CP449+%2C2016.10.pdf\",\"user\":\"\",\"type\":\"0\",\"ext\":\"pdf\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"\\\\u8f6f\\\\u4ef6\\\\u6d4b\\\\u8bd5\\\"\"},{\"id\":\"1863053\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1o78GX1w\",\"pwd\":\"\",\"ctime\":\"2017-03-12 00:00:00\",\"size\":\"37318820\",\"context\":\"13.jmeter\\u6027\\u80fd\\u6d4b\\u8bd5\\u5b9e\\u6218FTP\\u7a0b\\u5e8f.avi\\u7b49\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"\\\\u6027\\\\u80fd\\\\u6d4b\\\\u8bd5 \\\\u5b9e\\\\u6218\\\"\"},{\"id\":\"1863056\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1o8nm7Bc\",\"pwd\":\"\",\"ctime\":\"2016-11-24 00:00:00\",\"size\":\"18989711\",\"context\":\"14.jmeter\\u6027\\u80fd\\u6d4b\\u8bd5\\u5b9e\\u6218\\u6570\\u636e\\u5e93mysql.avi\",\"user\":\"\",\"type\":\"0\",\"ext\":\"avi\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"\\\\u6027\\\\u80fd\\\\u6d4b\\\\u8bd5 \\\\u5b9e\\\\u6218\\\"\"},{\"id\":\"2987277\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1c-zNQ29UpmYn7zkrif2g2Q\",\"ctime\":\"2018-10-20 16:08:57\",\"size\":\"0\",\"context\":\"jmeter\\u89c6\\u9891\\u6559\\u5b66\\u8bfe\\u7a0b\",\"user\":\"992619624\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null,\"has_pwd\":true},{\"id\":\"2050611\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1a3OIMQFCMP6K7DjsC_y5Tg\",\"pwd\":\"\",\"ctime\":\"2018-03-06 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u5c0f\\u5f3a\\u89c6\\u9891\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050612\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1dGHvAiH\",\"pwd\":\"\",\"ctime\":\"2018-02-06 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u6574\\u5957\\u8d44\\u6599\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050614\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1geWQWtd\",\"pwd\":\"\",\"ctime\":\"2017-12-12 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u89c6\\u9891\\u6559\\u5b66\\u8bfe\\u7a0b\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050616\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1hrLYz3I\",\"pwd\":\"\",\"ctime\":\"2017-11-20 00:00:00\",\"size\":\"0\",\"context\":\"Jmeter\\u521d\\u7ea7\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050617\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1bSj3sE\",\"pwd\":\"\",\"ctime\":\"2017-07-26 00:00:00\",\"size\":\"0\",\"context\":\"jmeter \\u6027\\u80fd\\u6d4b\\u8bd5\\u89c6\\u9891\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050618\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1pLI4a1P\",\"pwd\":\"\",\"ctime\":\"2017-06-21 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u89c6\\u9891\\u6559\\u5b66\\u8bfe\\u7a0b\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050619\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1bpH4Iyb\",\"pwd\":\"\",\"ctime\":\"2017-05-17 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u6574\\u5957\\u8d44\\u6599\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050620\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1qYazdhU\",\"pwd\":\"\",\"ctime\":\"2017-04-14 00:00:00\",\"size\":\"203958518\",\"context\":\"Jmeter\\u89c6\\u9891+PPT(1).zip\",\"user\":\"\",\"type\":\"0\",\"ext\":\"zip\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2050621\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1nv8ukyP\",\"pwd\":\"\",\"ctime\":\"2017-03-28 00:00:00\",\"size\":\"0\",\"context\":\"jmeter \\u6027\\u80fd\\u6d4b\\u8bd5\\u89c6\\u9891\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2234939\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1YHoZukLiKbXzaz3fjM8ecg\",\"ctime\":\"2018-10-17 13:49:11\",\"size\":\"0\",\"context\":\"04.Jmeter\\u5de5\\u5177\\u5b9e\\u6218\\u89c6\\u9891\\u8bfe\\u7a0b\",\"user\":\"3657833234\",\"type\":\"1\",\"ext\":\".Jmeter\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null,\"has_pwd\":true},{\"id\":\"2309225\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1AkPAd27zagr5ya8oBccIOw\",\"ctime\":\"2018-10-09 19:51:29\",\"size\":\"53451348\",\"context\":\"apache-jmeter-3.2.zip\",\"user\":\"1519137565\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null,\"has_pwd\":true},{\"id\":\"2375982\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1Kp6mv40Fd_MExD0AM-_Qwg\",\"ctime\":\"2018-10-07 07:20:39\",\"size\":\"585181590\",\"context\":\"\\u516c\\u5f00\\u8bfe--20181007--Jmeter ant\\u81ea\\u5b9a\\u4e49\\u62a5\\u544a.mp4\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"0\",\"tags\":null,\"has_pwd\":true},{\"id\":\"2690720\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1sqVY_0ovinZ_xDpWOOnpVw\",\"pwd\":\"\",\"ctime\":\"2018-05-21 00:00:00\",\"size\":\"1793065\",\"context\":\"JMeter\\u4e2d\\u6587\\u4f7f\\u7528\\u624b\\u518c(1).doc\",\"user\":\"\",\"type\":\"0\",\"ext\":\"doc\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2776812\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1qYvwOmK\",\"pwd\":\"\",\"ctime\":\"2017-03-28 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u89c6\\u9891\\u6559\\u5b66\\u8bfe\\u7a0b\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2776813\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1hsBSeuK\",\"pwd\":\"\",\"ctime\":\"2017-03-26 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u89c6\\u9891\\u6559\\u5b66\\u8bfe\\u7a0b\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2776814\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1eRRURtC\",\"pwd\":\"\",\"ctime\":\"2017-03-25 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2776816\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1c16ZnQK\",\"pwd\":\"\",\"ctime\":\"2017-03-09 00:00:00\",\"size\":\"0\",\"context\":\"jmeter \\u6027\\u80fd\\u6d4b\\u8bd5\\u89c6\\u9891\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"},{\"id\":\"2776817\",\"url\":\"https:\\/\\/pan.baidu.com\\/s\\/1i4FANfn\",\"pwd\":\"\",\"ctime\":\"2017-02-06 00:00:00\",\"size\":\"0\",\"context\":\"jmeter\\u6574\\u5957\\u8d44\\u6599\\u7b49\",\"user\":\"\",\"type\":\"1\",\"ext\":\"\",\"valid\":\"1\",\"report\":\"0\",\"engine\":\"4\",\"tags\":\"\\\"jmeter\\\"\"}]\n");
        System.out.println(s);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public boolean isHas_pwd() {
        return has_pwd;
    }

    public void setHas_pwd(boolean has_pwd) {
        this.has_pwd = has_pwd;
    }

    @Override
    public String toString() {
        return "FTsopan{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", pwd='" + pwd + '\'' +
                ", ctime='" + ctime + '\'' +
                ", size='" + size + '\'' +
                ", context='" + context + '\'' +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                ", ext='" + ext + '\'' +
                ", valid='" + valid + '\'' +
                ", report='" + report + '\'' +
                ", engine='" + engine + '\'' +
                ", tags=" + tags +
                ", has_pwd=" + has_pwd +
                '}';
    }
}
