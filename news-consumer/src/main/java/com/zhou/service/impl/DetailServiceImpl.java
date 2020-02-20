package com.zhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhou.dao.DetailMapper;
import com.zhou.entity.Detail;
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
        PageInfo<Detail> pageInfo = detailMapper.queryByTitle(title,pageNum,pageSize);
        return pageInfo;
    }

    @Override
    public String deleteDetail(Integer id) {
        return detailMapper.deleteDetail(id);
    }

    @Override
    public String test() {
        return detailMapper.test();
    }
}
