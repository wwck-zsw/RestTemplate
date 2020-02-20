package com.zhou.service;

import com.github.pagehelper.PageInfo;
import com.zhou.entity.Detail;

public interface DetailService {
    //根据标题查询所有新闻信息
    PageInfo<Detail> queryByTitle(String title, Integer pageNum, Integer pageSize);

    //新闻和评论关联 MySQL多表关联删除
    Integer deleteDetail(Integer id);
}
