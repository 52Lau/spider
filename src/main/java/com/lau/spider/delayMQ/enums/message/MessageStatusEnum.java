package com.lau.spider.delayMQ.enums.message;

import com.google.common.collect.ImmutableMap;
import com.lau.spider.delayMQ.enums.IndexedEnum;
import com.lau.spider.delayMQ.enums.IndexedEnumUtil;

/**
 * 消息状态枚举
 * @author victor
 *
 */
public enum MessageStatusEnum implements IndexedEnum<MessageStatusEnum> {

	DEFAULT(10,"default");
	
	MessageStatusEnum(int index, String name){
		this.index = index;
		this.name = name;
	}
	
	private static final ImmutableMap<Integer, MessageStatusEnum> INDEXS = IndexedEnumUtil.toIndexes(values());
	
	private int index;
	
	private String name;

	
	public static MessageStatusEnum indexOf(int index){
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
