package com.lau.spider.delayMQ.config.queue;

import com.lau.spider.delayMQ.constants.MessageQueueConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * token队列配置
 * @author victor
 *
 */
@Configuration
public class TokenQueueConfiguration {

	@Autowired
	@Qualifier("defaultDirectExchange")
	private DirectExchange exchange;
	
	
	@Bean
	public Queue tokenQueue() {
		Queue queue = new Queue(MessageQueueConstants.QUEUE_TOKEN_NAME,true,false,false);
		return queue; 
	}
	
	@Bean
	public Binding  tokenBinding() {
		return BindingBuilder.bind(tokenQueue()).to(exchange).with(MessageQueueConstants.QUEUE_TOKEN_NAME);
	}
	
}
