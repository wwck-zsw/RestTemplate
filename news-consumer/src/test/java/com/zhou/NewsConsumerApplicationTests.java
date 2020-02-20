package com.zhou;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zhou.dao.DetailMapper;
import com.zhou.entity.Detail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsConsumerApplicationTests {

    @Test
    public void contextLoads() {
        Detail detail=new Detail();
        detail.setId(1L);
        detail.setSummary("牡丹");
        detail.setTitle("菏泽");
        detail.setAuthor("zsw");
        detail.setCreatedate(new Timestamp(new Date().getTime()));
        String s = JSON.toJSONString(detail);
        System.out.println(s);
    }

}
