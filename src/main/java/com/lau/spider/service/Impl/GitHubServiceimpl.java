package com.lau.spider.service.Impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lau.spider.GithubSpider.dto.GitHubUserFollowIng;
import com.lau.spider.GithubSpider.dto.GitHubUserFollower;
import com.lau.spider.GithubSpider.dto.GitHubUserInfo;
import com.lau.spider.GithubSpider.dto.GitHubUserRepo;
import com.lau.spider.command.LinuxCommand;
import com.lau.spider.delayMQ.constants.MessageQueueConstants;
import com.lau.spider.delayMQ.enums.message.MessageTypeEnum;
import com.lau.spider.delayMQ.message.QueueMessage;
import com.lau.spider.delayMQ.service.IMessageQueueService;
import com.lau.spider.mapper.GithubMapper;
import com.lau.spider.mapper.GithubuserinfoMapper;
import com.lau.spider.model.Github;
import com.lau.spider.model.Githubuserinfo;
import com.lau.spider.rabbitmq.GitHubMessage;
import com.lau.spider.redis.GitHubKey;
import com.lau.spider.redis.RedisService;
import com.lau.spider.service.GitHubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class GitHubServiceimpl extends BaseService<Github> implements GitHubService {

    private static final Logger log = LoggerFactory.getLogger(GitHubServiceimpl.class);

    static HashMap<String, Object > headers = new HashMap<String, Object>(){{
        put("User-Agent","Mozilla/5.0");
        put("Authorization","token fbaed281465b9c27d0abbc304a3a52be12687659");
        put("Content-Type","application/json");
        put("Accept","application/vnd.github.v3+json");
    }};

    @Autowired
    GithubMapper githubMapper;

    @Autowired
    GithubuserinfoMapper githubuserinfoMapper;

    @Autowired
    private IMessageQueueService messageQueueService;

    @Autowired
    RedisService redisService;

    @Override
    public int start(String username,Integer page) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String keyStr=username+df.format(new Date());
        //一天获取一次
        Integer flag=0;
        if (redisService.exists(GitHubKey.getBaiduKey,"keyStr"))
        try {
            //获取用户名即可
            List<GitHubUserFollower> followerList=gen_user_follwer_url(username,page);
            for (GitHubUserFollower follower: followerList) {
                GitHubMessage gitHubMessage=new GitHubMessage();
                gitHubMessage.setUsername(follower.getLogin());
                send(gitHubMessage,60);
            }
            //获取用户名
            List<GitHubUserFollowIng> followIngList =gen_user_following_url(username,page);
            for(GitHubUserFollowIng followIng:followIngList){
                GitHubMessage gitHubMessage=new GitHubMessage();
                gitHubMessage.setUsername(followIng.getLogin());
                send(gitHubMessage,60);
            }
            flag=1;
        } catch (Exception e) {
            flag=0;
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public int insert(Github github) {
        return githubMapper.insert(github);
    }

    @Override
    public int insertOrUpdate(Githubuserinfo githubuserinfo) {
        return githubuserinfoMapper.insertSelective(githubuserinfo);
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

    /**
     * 获取用户粉丝列表
     * @param username
     * @param page
     * @return
     */
    public List<GitHubUserFollower> gen_user_follwer_url(String username,Integer page){
        List<GitHubUserFollower> followerList = null;
        try {
            String jsonStr = HttpUtil.get("https://api.github.com/users/"+username+"/followers?page="+page, headers);
            followerList = JSON.parseArray(jsonStr, GitHubUserFollower.class);
        } catch (Exception e) {
            log.error("用户名不存在或者请求被限制");
            e.printStackTrace();
        }
        return followerList;
    }

    /**
     * 获取用户关注用户列表
     * @param username
     * @param page
     * @return
     */
    public List<GitHubUserFollowIng> gen_user_following_url(String username,Integer page){
        String jsonStr = HttpUtil.get("https://api.github.com/users/"+username+"/following?page="+page, headers);
        List<GitHubUserFollowIng> followIngList = JSON.parseArray(jsonStr, GitHubUserFollowIng.class);
        return followIngList;
    }

    /**
     * 获取用户项目列表
     * @param username
     * @param page
     * @return
     */
    public static List<GitHubUserRepo> gen_user_repo_url(String username,Integer page){
        String jsonStr = HttpUtil.get("https://api.github.com/users/"+username+"/repos?page="+page, headers);
        List<GitHubUserRepo> repoList = JSON.parseArray(jsonStr, GitHubUserRepo.class);
        return repoList;
    }

    /**
     * 发送消息
     * @param msg 消息
     * @param seconds 延时时间
     * @return
     */
    public String send(GitHubMessage msg, int seconds) {
        /*String msg = RedisService.beanToString(mm);*/
        String json=JSONObject.toJSONString(msg);
        log.info("发送："+json);
        QueueMessage message = new QueueMessage(MessageQueueConstants.QUEUE_HELLO_NAME, json);
        message.setType(MessageTypeEnum.DELAYED.getIndex());
        message.setSeconds(seconds);
        messageQueueService.send(message);
        return "ok";
    }
    public static void main(String[] args) {
        for (int i=1;i<100;i++){
            System.out.println(i);
            List<GitHubUserRepo> repoList=gen_user_repo_url("52Lau",1);
            for (GitHubUserRepo repo: repoList
                 ) {
                System.out.println(repo);
            }
        }
    }
}
