package com.zhou.controller;

import com.github.pagehelper.PageInfo;
import com.zhou.entity.Detail;
import com.zhou.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class DetailController {
    @Autowired
    private DetailService detailService;

    @RequestMapping({"queryByTitle","/"})
    public String queryByTitle(String title, Integer pageNum, Integer pageSize, Model model){
        if (pageNum == null) {
            pageNum=1;
        }
        if (pageSize == null) {
            pageSize=2;
        }
        PageInfo<Detail> pageInfo = detailService.queryByTitle(title, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("title",title);
        return "detail_list";
    }

    @ResponseBody
    @RequestMapping("deleteDetail")
    public String deleteDetail(Integer id){
        return detailService.deleteDetail(id);
    }

    @ResponseBody
    @RequestMapping("test")
    public String test(){
        return detailService.test();
    }
}
