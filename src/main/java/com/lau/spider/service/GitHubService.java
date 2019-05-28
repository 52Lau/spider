package com.lau.spider.service;

import com.lau.spider.model.Github;
import com.lau.spider.model.Githubuserinfo;

public interface  GitHubService extends  IService<Github>{
    int start(String username,Integer page);
    int insert(Github github);
    int insertOrUpdate(Githubuserinfo githubuserinfo);
}
