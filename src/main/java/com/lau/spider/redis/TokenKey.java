package com.lau.spider.redis;

public class TokenKey extends BasePrefix {

    private TokenKey( String prefix) {
        super(prefix);
    }

    public static TokenKey getTokenKey= new TokenKey("moug");
}
