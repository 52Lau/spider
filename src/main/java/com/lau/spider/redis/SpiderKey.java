package com.lau.spider.redis;

public class SpiderKey extends BasePrefix {

	public SpiderKey(String prefix) {
		super(prefix);
	}
	public static SpiderKey getYouToBeKey = new SpiderKey("youtube");
}
