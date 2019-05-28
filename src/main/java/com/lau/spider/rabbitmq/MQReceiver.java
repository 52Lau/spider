package com.lau.spider.rabbitmq;


import com.lau.spider.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);


    @RabbitListener(queues = MQConfig.QUEUE)
    public void receive2(String message) {
        log.info("receive message:" + message);
    }

    @Autowired
    RedisService redisService;



    public String time()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        //return System.currentTimeMillis();
        return df.format(new Date());
    }



    /**
     * 接收到消息去执行
     * @param message
     */
    @RabbitListener(queues=MQConfig.QUEUE)
    public void receive(String message) {
        log.info("receive message:"+message);

    }


}
