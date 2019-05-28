package com.lau.spider.delayMQ.enums.message;

import com.google.common.collect.ImmutableMap;
import com.lau.spider.delayMQ.enums.IndexedEnum;
import com.lau.spider.delayMQ.enums.IndexedEnumUtil;

public enum MessageGroupEnum implements IndexedEnum<MessageGroupEnum> {

	DEFAULT(10,"default");
	
	
	MessageGroupEnum(int index, String name){
		this.index = index;
		this.name = name;
	}
	
	private static final ImmutableMap<Integer, MessageGroupEnum> INDEXS = IndexedEnumUtil.toIndexes(values());
	
	private int index;
	
	private String name;

	
	public static MessageGroupEnum indexOf(int index){
		return INDEXS.get(index);
	}

	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
