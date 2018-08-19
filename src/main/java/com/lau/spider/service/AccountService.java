package com.lau.spider.service;

import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Account;

public interface AccountService extends  IService<Account> {

    LayuiDto findPage(Account account, int page, int limit);
}
