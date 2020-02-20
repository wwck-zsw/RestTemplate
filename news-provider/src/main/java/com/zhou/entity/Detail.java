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
@ApiModel(value = "新闻表")
public class Detail {

    // 新闻编号
    @ApiModelProperty(value = "新闻编号")
    private Long id;

    // 新闻标题
    @ApiModelProperty(value = "新闻标题")
    private String title;

    // 新闻摘要
    @ApiModelProperty(value = "新闻摘要")
    private String summary;

    // 作者
    @ApiModelProperty(value = "作者")
    private String author;

    // 创建日期
    @ApiModelProperty(value = "创建日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdate;

}