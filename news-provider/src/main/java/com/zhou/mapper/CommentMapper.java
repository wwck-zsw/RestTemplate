package com.zhou.mapper;

import com.zhou.entity.Comment;

import java.util.List;

public interface CommentMapper {
    //根据新闻编号查询所有评论
    List<Comment> queryByNewsId(Integer id);
    //增加评论
    Integer addComment(Comment comment);
}
