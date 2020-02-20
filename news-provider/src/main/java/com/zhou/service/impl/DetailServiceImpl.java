package com.zhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhou.entity.Detail;
import com.zhou.mapper.DetailMapper;
import com.zhou.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailMapper detailMapper;

    @Override
    public PageInfo<Detail> queryByTitle(String title,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Detail> details = detailMapper.queryByTitle(title);
        PageInfo<Detail> pageInfo=new PageInfo<>(details);
        return pageInfo;
    }

    @Override
    public Integer deleteDetail(Integer id) {
        return detailMapper.deleteDetailAndComment(id);
    }
}
