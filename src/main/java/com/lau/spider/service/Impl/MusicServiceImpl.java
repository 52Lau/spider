package com.lau.spider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.mapper.MusicMapper;
import com.lau.spider.model.Music;
import com.lau.spider.service.MusicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: MusicServiceImpl
 * @description: Music服务层实现层
 * @author: Lau52y
 * @create: 2018-08-10 00:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Service
public class MusicServiceImpl extends BaseService<Music> implements MusicService {

    @Autowired
    MusicMapper MusicMapper;


    @Override
    public LayuiDto findPage(Music music, int page, int limit) {
        Example example = new Example(Music.class);
        Example.Criteria criteria = example.createCriteria();


        if (StringUtils.isNotEmpty(music.getContent())){
            criteria.andLike("content","%"+music.getContent()+"%");
        }
        if (StringUtils.isNotEmpty(music.getSongname())){
            criteria.andLike("songname","%"+music.getSongname()+"%");
        }
        if (StringUtils.isNotEmpty(music.getSongauthor())){
            criteria.andLike("songauthor","%"+music.getSongauthor()+"%");
        }
        criteria.andEqualTo("status",0);

        PageHelper.startPage(page,limit);
        List<Music> list = MusicMapper.selectByExample(example);
        LayuiDto layuiDto=new LayuiDto();
        PageInfo pageInfo=new PageInfo<>(list);
        layuiDto.setCount((int)pageInfo.getTotal());
        layuiDto.setData(list.toArray());
        return layuiDto;
    }
}
