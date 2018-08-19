package com.lau.spider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.mapper.WishMapper;
import com.lau.spider.model.Wish;
import com.lau.spider.service.WishService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: WishServiceImpl
 * @description: Wish服务层实现层
 * @author: Lau52y
 * @create: 2018-08-10 00:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Service
public class WishServiceImpl extends BaseService<Wish> implements WishService {

    @Autowired
    WishMapper wishMapper;


    @Override
    public LayuiDto findPage(Wish wish, int page, int limit) {
        Example example = new Example(Wish.class);
        Example.Criteria criteria = example.createCriteria();

        /*if(Wish.getCreatedate()!=null){
            criteria.andEqualTo("createdate",Wish.getCreatedate());
        }
        if(Wish.getCatid()!=null){
            criteria.andEqualTo("catid",Wish.getCatid());
        }
        if(Wish.getIsvideoaudio()!=null){
            criteria.andEqualTo("isvideoaudio",Wish.getIsvideoaudio());
        }
        if(Wish.getIssubtitle()!=null){
            criteria.andEqualTo("issubtitle",Wish.getIssubtitle());
        }
        if (StringUtils.isNotEmpty(Wish.getName())){
            criteria.andLike("name","%"+Wish.getName()+"%");
        }
        if(StringUtils.isNotEmpty(Wish.getVideoid())){
            criteria.andEqualTo("videoid",Wish.getVideoid());
        }*/
        criteria.andEqualTo("status",0);

        PageHelper.startPage(page,limit);
        List<Wish> list = wishMapper.selectByExample(example);
        LayuiDto layuiDto=new LayuiDto();
        PageInfo pageInfo=new PageInfo<>(list);
        layuiDto.setCount((int)pageInfo.getTotal());
        layuiDto.setData(list.toArray());
        return layuiDto;
    }

    @Override
    public List<Wish> findTop() {
        return wishMapper.findTop();
    }

    @Override
    public int insert(Wish wish) {
        return wishMapper.insert(wish);
    }
}
