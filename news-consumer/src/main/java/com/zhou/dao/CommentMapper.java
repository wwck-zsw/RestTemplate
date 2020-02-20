package com.zhou.dao;

import com.zhou.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class CommentMapper {
    @Autowired
    private RestTemplate restTemplate;
    //在provider端资源的路径
    private String url="http://localhost:8080/comments";

    //根据新闻编号查询所有评论
    public List<Comment> queryByNewsId(Integer id){
        Comment[] comment = restTemplate.getForObject(url + "/" + id, Comment[].class);
        return Arrays.asList(comment);
    }
    //增加评论
    public String addComment(Comment comment){
        String result = restTemplate.postForObject(url, comment, String.class);
        return result;
    }
}
