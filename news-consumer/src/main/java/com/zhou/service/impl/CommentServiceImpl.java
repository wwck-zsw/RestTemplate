package com.zhou.service.impl;

import com.zhou.dao.CommentMapper;
import com.zhou.entity.Comment;
import com.zhou.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> queryByNewsId(Integer id) {
        return commentMapper.queryByNewsId(id);
    }

    @Override
    public String addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
