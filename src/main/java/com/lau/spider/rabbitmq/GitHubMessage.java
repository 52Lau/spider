package com.lau.spider.rabbitmq;


import lombok.Data;

@Data
public class GitHubMessage {
    private  String username;
    private  Integer page=1;
}
