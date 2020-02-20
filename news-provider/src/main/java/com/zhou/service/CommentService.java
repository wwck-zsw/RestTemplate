package com.zhou.service;

import com.zhou.entity.Comment;

import java.util.List;

public interface CommentService {
    //根据新闻编号查询所有评论
    List<Comment> queryByNewsId(Integer id);
    //增加评论
    Integer addComment(Comment comment);
}
