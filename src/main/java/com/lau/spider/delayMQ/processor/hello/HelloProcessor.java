package com.lau.spider.delayMQ.processor.hello;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.lau.spider.GithubSpider.dto.GitHubUserInfo;
import com.lau.spider.GithubSpider.dto.GitHubUserRepo;
import com.lau.spider.delayMQ.constants.MessageQueueConstants;
import com.lau.spider.delayMQ.service.IMessageQueueService;
import com.lau.spider.rabbitmq.GitHubMessage;
import com.lau.spider.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;


@Component
@RabbitListener(queues = MessageQueueConstants.QUEUE_HELLO_NAME)
public class HelloProcessor {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    /*@Autowired
    RedisService redisService;

    @Autowired
    GitHubService gitHubService;

    @Autowired
    private IMessageQueueService messageQueueService;

    @Autowired
    private GitHubRepository gitHubRepository;

    @Autowired
    private GitHubUserRepository gitHubUserRepository;*/

    static HashMap<String, Object > headers = new HashMap<String, Object>(){{
        put("User-Agent","Mozilla/5.0");
        put("Authorization","token fbaed281465b9c27d0abbc304a3a52be12687659");
        put("Content-Type","application/json");
        put("Accept","application/vnd.github.v3+json");
    }};

    /**
     * 接收到了延时消息后进行判断
     *
     * @param content
     */
    @RabbitHandler
    public void process(String content) {
        logger.info("hello 接受消息：" + content);
        GitHubMessage gitMsg = JSON.parseObject(content, GitHubMessage.class);
        //接收消息，根据用户名获取用户的仓库
        List<GitHubUserRepo> repoList = gen_user_repo_url(gitMsg.getUsername(), gitMsg.getPage());
        for (GitHubUserRepo repo:repoList){
            //存取用户仓库信息
            try {
                //gitHubRepository.insert(repo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        GitHubUserInfo gitHubUserInfo =gen_user_page_url(gitMsg.getUsername());
        //无则增之，有则改之
        if (gitHubUserInfo!=null){
            //gitHubUserRepository.save(gitHubUserInfo);
        }
    }

    /**
     * 获取用户项目列表
     * @param username
     * @param page
     * @return
     */
    public static List<GitHubUserRepo> gen_user_repo_url(String username, Integer page){
        String jsonStr = HttpUtil.get("https://api.github.com/users/"+username+"/repos?page="+page, headers);
        List<GitHubUserRepo> repoList = JSON.parseArray(jsonStr, GitHubUserRepo.class);
        return repoList;
    }

    /**
     * 获取用户主页
     * @param username 用户名
     * @return
     */
    public GitHubUserInfo gen_user_page_url(String username){
        String jsonStr = HttpUtil.get("https://api.github.com/users/"+username, headers);
        GitHubUserInfo gitHubUserInfo = JSON.parseObject(jsonStr, GitHubUserInfo.class);
        return gitHubUserInfo;
    }
}
