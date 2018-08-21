package com.lau.spider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.mapper.ContentMapper;
import com.lau.spider.model.Content;
import com.lau.spider.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: ContentServiceImpl
 * @description: Content服务层实现层
 * @author: Lau52y
 * @create: 2018-08-10 00:10
 * <p>·
 * <人生可否变作漫长浪漫程序！>
 **/
@Service
public class ContentServiceImpl extends BaseService<Content> implements ContentService {

   @Autowired
    ContentMapper contentMapper;


    @Override
    public LayuiDto findPage(Content content, int page, int limit) {
        Example example = new Example(Content.class);
        Example.Criteria criteria = example.createCriteria();

        /*if(Content.getCreatedate()!=null){
            criteria.andEqualTo("createdate",Content.getCreatedate());
        }
        if(Content.getCatid()!=null){
            criteria.andEqualTo("catid",Content.getCatid());
        }
        if(Content.getIsvideoaudio()!=null){
            criteria.andEqualTo("isvideoaudio",Content.getIsvideoaudio());
        }
        if(Content.getIssubtitle()!=null){
            criteria.andEqualTo("issubtitle",Content.getIssubtitle());
        }
        if (StringUtils.isNotEmpty(Content.getName())){
            criteria.andLike("name","%"+Content.getName()+"%");
        }
        if(StringUtils.isNotEmpty(Content.getVideoid())){
            criteria.andEqualTo("videoid",Content.getVideoid());
        }*/

        if(content.getTypeid()!=null){
            criteria.andEqualTo("typeid",content.getTypeid());
        }
        if (StringUtils.isNotEmpty(content.getContext())){
            criteria.andLike("context","%"+content.getContext()+"%");
        }

        criteria.andEqualTo("status",0);


        example.orderBy("createdate").desc();

        PageHelper.startPage(page,limit);
        List<Content> list = contentMapper.selectByExample(example);
        LayuiDto layuiDto=new LayuiDto();
        PageInfo pageInfo=new PageInfo<>(list);
        layuiDto.setCount((int)pageInfo.getTotal());
        layuiDto.setData(list.toArray());
        return layuiDto;
    }
}
