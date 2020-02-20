package com.zhou.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author 懒猴子CG
 * @date 2020-02-12 20:12:32
 * @email 
 */
@Data
@ToString
@ApiModel(value = "评论表")
public class Comment {

    // 评论编号
    @ApiModelProperty(value = "评论编号")
    private Long id;

    // 新闻编号
    @ApiModelProperty(value = "新闻编号")
    private Long newsid;

    // 评论内容
    @ApiModelProperty(value = "评论内容")
    private String content;

    // 评论人
    @ApiModelProperty(value = "评论人")
    private String author;

    // 评论日期
    @ApiModelProperty(value = "评论日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdate;

}