package com.lau.spider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.mapper.YoutubeMapper;
import com.lau.spider.model.Youtube;
import com.lau.spider.service.YoutubeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: YoutubeServiceImpl
 * @description: Youtube服务层实现层
 * @author: Lau52y
 * @create: 2018-08-10 00:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Service
public class YoutubeServiceImpl extends BaseService<Youtube> implements YoutubeService {

    @Autowired
    YoutubeMapper youtubeMapper;
    @Override
    public int insertYoutuBe(Youtube youtube) {
        return youtubeMapper.insertYoutuBe(youtube);
    }

    @Override
    public LayuiDto findPage(Youtube youtube, int page, int limit) {
        Example example = new Example(Youtube.class);
        Example.Criteria criteria = example.createCriteria();

        if(youtube.getCreatedate()!=null){
            criteria.andEqualTo("createdate",youtube.getCreatedate());
        }
        if(youtube.getCatid()!=null){
            criteria.andEqualTo("catid",youtube.getCatid());
        }
        if(youtube.getIsvideoaudio()!=null){
            criteria.andEqualTo("isvideoaudio",youtube.getIsvideoaudio());
        }
        if(youtube.getIssubtitle()!=null){
            criteria.andEqualTo("issubtitle",youtube.getIssubtitle());
        }
        if (StringUtils.isNotEmpty(youtube.getName())){
            criteria.andLike("name","%"+youtube.getName()+"%");
        }
        if(StringUtils.isNotEmpty(youtube.getVideoid())){
            criteria.andLike("videoid","%"+youtube.getVideoid()+"%");
        }
        criteria.andEqualTo("status",0);

        PageHelper.startPage(page,limit);
        List<Youtube> list = youtubeMapper.selectByExample(example);
        LayuiDto layuiDto=new LayuiDto();
        PageInfo pageInfo=new PageInfo<>(list);
        layuiDto.setCount((int)pageInfo.getTotal());
        layuiDto.setData(list.toArray());
        return layuiDto;
    }
}
