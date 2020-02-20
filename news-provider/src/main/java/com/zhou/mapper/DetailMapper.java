package com.zhou.mapper;

import com.zhou.entity.Detail;

import java.util.List;

public interface DetailMapper {
    //根据标题查询所有新闻信息
    List<Detail> queryByTitle(String title);

    //新闻和评论关联 MySQL多表关联删除
    Integer deleteDetailAndComment(Integer id);
}
