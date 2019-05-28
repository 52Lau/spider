package com.lau.spider.repository;

import com.lau.spider.model.Imooc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ImoocRepository /*extends ElasticsearchRepository<Imooc, Long> */{
    Page<Imooc> findBytitle(String title, Pageable page);
}
