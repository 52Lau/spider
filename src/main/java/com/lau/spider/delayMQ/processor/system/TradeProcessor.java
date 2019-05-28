package com.lau.spider.delayMQ.processor.system;

import com.lau.spider.delayMQ.constants.MessageQueueConstants;
import com.lau.spider.delayMQ.enums.message.MessageTypeEnum;
import com.lau.spider.delayMQ.message.QueueMessage;
import com.lau.spider.delayMQ.service.IMessageQueueService;
import com.lau.spider.delayMQ.utils.JSONUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 * @author victor
 * @desc 死信接收处理消费者
 */
@Component
@RabbitListener(queues = MessageQueueConstants.DEFAULT_REPEAT_TRADE_QUEUE_NAME)
public class TradeProcessor {
	
	@Autowired
	private IMessageQueueService messageQueueService;

	@RabbitHandler
    public void process(String content) {
		QueueMessage message = JSONUtils.toBean(content, QueueMessage.class);
		message.setType(MessageTypeEnum.DEFAULT.getIndex());
		messageQueueService.send(message);
    }
}
