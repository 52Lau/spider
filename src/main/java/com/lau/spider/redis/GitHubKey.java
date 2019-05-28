package com.lau.spider.redis;

public class GitHubKey extends BasePrefix {

    private GitHubKey(String prefix) {
        super(prefix);
    }

    public static GitHubKey getBaiduKey= new GitHubKey("github");
}
