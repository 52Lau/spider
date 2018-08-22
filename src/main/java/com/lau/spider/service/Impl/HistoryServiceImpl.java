package com.lau.spider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.mapper.HistoryMapper;
import com.lau.spider.model.History;
import com.lau.spider.service.HistoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: HistoryServiceImpl
 * @description: History服务层实现层
 * @author: Lau52y
 * @create: 2018-08-10 00:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Service
public class HistoryServiceImpl extends BaseService<History> implements HistoryService {

    @Autowired
    HistoryMapper historyMapper;


    @Override
    public LayuiDto findPage(History history, int page, int limit) {
        Example example = new Example(History.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(history.getMention())){
            criteria.andLike("mention","%"+history.getMention()+"%");
        }
        if(StringUtils.isNotEmpty(history.getDesc())){
            criteria.andLike("desc","%"+history.getDesc()+"%");
        }
        if(StringUtils.isNotEmpty(history.getLevel1())){
            criteria.andLike("level1","%"+history.getLevel1()+"%");
        }
        if(StringUtils.isNotEmpty(history.getLevel2())){
            criteria.andLike("level2","%"+history.getLevel2()+"%");
        }
        if(history.getIssend()!=null){
            criteria.andEqualTo("issend",history.getIssend());
        }

        criteria.andEqualTo("status",0);

        PageHelper.startPage(page,limit);
        List<History> list = historyMapper.selectByExample(example);
        LayuiDto layuiDto=new LayuiDto();
        PageInfo pageInfo=new PageInfo<>(list);
        layuiDto.setCount((int)pageInfo.getTotal());
        layuiDto.setData(list.toArray());
        return layuiDto;
    }

    @Override
    public List<History> level1List() {
        return historyMapper.level1List();
    }

    @Override
    public List<History> level2List() {
        return historyMapper.level2List();
    }
}
