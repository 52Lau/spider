package com.lau.spider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.mapper.AccountMapper;
import com.lau.spider.model.Account;
import com.lau.spider.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: AccountServiceImpl
 * @description: Account服务层实现层
 * @author: Lau52y
 * @create: 2018-08-10 00:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Service
public class AccountServiceImpl extends BaseService<Account> implements AccountService {

    @Autowired
    AccountMapper accountMapper;


    @Override
    public LayuiDto findPage(Account Account, int page, int limit) {
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();

        /*if(Account.getCreatedate()!=null){
            criteria.andEqualTo("createdate",Account.getCreatedate());
        }
        if(Account.getCatid()!=null){
            criteria.andEqualTo("catid",Account.getCatid());
        }
        if(Account.getIsvideoaudio()!=null){
            criteria.andEqualTo("isvideoaudio",Account.getIsvideoaudio());
        }
        if(Account.getIssubtitle()!=null){
            criteria.andEqualTo("issubtitle",Account.getIssubtitle());
        }
        if (StringUtils.isNotEmpty(Account.getName())){
            criteria.andLike("name","%"+Account.getName()+"%");
        }
        if(StringUtils.isNotEmpty(Account.getVideoid())){
            criteria.andEqualTo("videoid",Account.getVideoid());
        }*/
        criteria.andEqualTo("status",0);

        PageHelper.startPage(page,limit);
        List<Account> list = accountMapper.selectByExample(example);
        LayuiDto layuiDto=new LayuiDto();
        PageInfo pageInfo=new PageInfo<>(list);
        layuiDto.setCount((int)pageInfo.getTotal());
        layuiDto.setData(list.toArray());
        return layuiDto;
    }
}
