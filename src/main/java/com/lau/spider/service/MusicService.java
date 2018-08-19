package com.lau.spider.service;

import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Music;

public interface MusicService extends  IService<Music> {
    LayuiDto findPage(Music music, int page, int limit);
}
