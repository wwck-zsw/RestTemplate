package com.zhou.controller;

import com.zhou.conmment.Result;
import com.zhou.entity.Comment;
import com.zhou.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "comments/{id}",method = RequestMethod.GET)
    public List<Comment> queryByNewsId(@PathVariable Integer id){
        List<Comment> comments = commentService.queryByNewsId(id);
        return comments;
    }

    @ResponseBody
    @RequestMapping(value = "comments",method = RequestMethod.POST)
    public String addComment(@RequestBody Comment comment){
        System.out.println(comment);
        Integer integer = commentService.addComment(comment);
        if(integer>0){
            return "success";
        }
        return "error";
    }
}
