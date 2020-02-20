package com.zhou.controller;

import com.zhou.conmment.Result;
import com.zhou.entity.Comment;
import com.zhou.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping("queryByNewsId")
    public Result queryByNewsId(Integer id){
        List<Comment> comments = commentService.queryByNewsId(id);
        return Result.defaultSuccess(comments);
    }

    @ResponseBody
    @RequestMapping("addComment")
    public String addComment(Comment comment){
        System.out.println(comment);
        String integer = commentService.addComment(comment);
        return integer;
    }
}
