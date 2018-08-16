package com.lau.spider.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 使用Gson把json字符串转成Map
 * @author
 * @date
 */
public class JsonUtilscv {

	/**
	 * @param
	 * @return obj的json字符串
	 */
	public static JSONObject stringToJsonObject(String text){
		return JSON.parseObject(text);
	}

	/**
	 * @param
	 * @return obj的json字符串
	 */
	public static <T> T JsonStringToObject(String jsonStr, Class<T> cl){
		try{
			T t = JSON.parseObject(jsonStr, cl);
			return t;
		}catch(Exception e){

		}
		return null;
	}


	public static void stringToJsonObject(String json, Class<Object> baiduClass) {

	}
}