package com.lau.spider.delayMQ.processor.hello;

import com.lau.spider.delayMQ.constants.MessageQueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
@RabbitListener(queues = MessageQueueConstants.CONCURRENT_CONSUMERS_NAME,containerFactory = "concurrentConsumersContainerFactory")
public class ConcurrentConsumersProcessor {
	
	private  static int num = 0;
	
	@RabbitHandler
    public void process(String content) throws InterruptedException {
		System.out.println("接收消息：" + content);
		num ++;
		System.out.println("消息处理完成" + num);
    }

}
