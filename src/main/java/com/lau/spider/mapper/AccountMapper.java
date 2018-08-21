package com.lau.spider.mapper;

import com.lau.spider.model.Account;
import com.lau.spider.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends MyMapper<Account> {

}