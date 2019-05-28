package com.lau.spider.delayMQ.service;


import com.lau.spider.delayMQ.message.QueueMessage;

/**
 * 
 * @author victor
 * @desc　消息队列接口
 */
public interface IMessageQueueService {

	/**
	 * 发送消息，返回是否发送成功
	 * @param message
	 * @return
	 */
	public void send(QueueMessage message);


	public void sendToken(QueueMessage message);
	
}
