package com.lau.spider.service.Impl;

import com.lau.spider.mapper.ImoocMapper;
import com.lau.spider.model.Imooc;
import com.lau.spider.service.ImoocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImoocServiceImpl extends BaseService<Imooc> implements ImoocService {
    @Autowired
    ImoocMapper imoocMapper;
    @Override
    public int insert(Imooc imooc) {
        return imoocMapper.insert(imooc);
    }
}
