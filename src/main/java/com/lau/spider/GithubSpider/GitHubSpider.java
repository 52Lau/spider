package com.lau.spider.GithubSpider;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.lau.spider.GithubSpider.dto.GitHubDTO;

import java.util.HashMap;
import java.util.List;

public class GitHubSpider {
    public static void main(String[] args) {
        HashMap<String, Object > headers = new HashMap<String, Object>(){{
            put("User-Agent","Mozilla/5.0");
            put("'Authorization'","token fbaed281465b9c27d0abbc304a3a52be12687659");
            put("'Content-Type'","application/json");
            put("Accept","application/json");
        }};
        String jsonStr=HttpUtil.get("https://api.github.com/user/52Lau/ropes",headers);
        GitHubDTO gitHubDTO = JSON.parseObject(jsonStr, GitHubDTO.class);
        List<GitHubDTO.ItemsBean> itemsBeanList= gitHubDTO.getItems();
        System.out.println(gitHubDTO);
    }

}
