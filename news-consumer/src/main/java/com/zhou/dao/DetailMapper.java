package com.zhou.dao;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zhou.entity.Detail;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DetailMapper {
    //负责调用provider的方法,获取数据
    @Autowired
    private RestTemplate restTemplate;
    //在provider端资源的路径
    private String url="http://localhost:8080/details";

    //导游provider的方法查询所有用户
    public PageInfo<Detail> queryByTitle(String title,Integer pageNum,Integer pageSize){
        //不能有特殊符号和中文（不推荐）
//        URI uri = UriComponentsBuilder.fromUriString(url)
//                .queryParam("pageSize", "3")
//                .build()
//                .toUri();
//        System.out.println(uri);
//        PageInfo pageInfo = restTemplate.getForObject(uri, PageInfo.class);


        Map<String, Object> params = new HashMap<>();
        params.put("pageSize", pageSize);
        params.put("pageNum", pageNum);
        params.put("title", title);
        //使用占位符，map中不能没有占位符的键值对
        PageInfo pageInfo = restTemplate.getForObject(url + "?pageSize={pageSize}&pageNum={pageNum}&title={title}", PageInfo.class, params);
        //将json字符串转集合
        String json = JSON.toJSONString(pageInfo.getList());
        List<Detail> details = JSON.parseArray(json, Detail.class);
        pageInfo.setList(details);

        return pageInfo;
    }

    //导游provider的方法删除用户
    public String deleteDetail(Integer id){

        ResponseEntity<String> response = restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, null, String.class);
        String result = response.getBody();
        return result;
    }


    public String test(){
        //put传递对象
//        String json = "{\"author\":\"zsw\",\"createdate\":1582010438846,\"id\":1,\"summary\":\"牡丹\",\"title\":\"菏泽\"}";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(json,headers);
//        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/detailsPut", HttpMethod.PUT, entity, String.class);

        //delete传递对象
//        Detail detail=new Detail();
//        detail.setId(1L);
//        detail.setSummary("牡丹");
//        detail.setTitle("菏泽");
//        detail.setAuthor("zsw");
//        detail.setCreatedate(new Timestamp(new Date().getTime()));
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Detail> entity = new HttpEntity<>(detail,headers);
//        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/detailsDelete", HttpMethod.DELETE, entity, String.class);
        //post传递对象
//        String json = "{\"author\":\"zsw\",\"createdate\":1582010438846,\"id\":1,\"summary\":\"牡丹\",\"title\":\"菏泽\"}";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(json,headers);
//        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/detailsPost", HttpMethod.POST, entity, String.class);
//        HttpStatus statusCode = resp.getStatusCode(); // 获取响应码
//        int statusCodeValue = resp.getStatusCodeValue(); // 获取响应码值
//        HttpHeaders headers1 = resp.getHeaders(); // 获取响应头
//        System.out.println("statusCode：" + statusCode);
//        System.out.println("statusCodeValue：" + statusCodeValue);
//        System.out.println("headers：" + headers1);

        //get传递对象
//        RestTemplate restTemplate1 = new RestTemplate();
//        restTemplate1.setRequestFactory(new HttpComponentsClientHttpRequestWithBodyFactory());
//
//        String json = "{\"author\":\"zsw\",\"createdate\":1582010438846,\"id\":1,\"summary\":\"牡丹\",\"title\":\"菏泽\"}";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(json,headers);
//        ResponseEntity<String> resp = restTemplate1.exchange("http://localhost:8080/detailsGet", HttpMethod.GET, entity, String.class);


        //get传递单参
        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/detailsGetD?id={id}&name={name}", HttpMethod.GET, null, String.class,1,"哈哈");
        //post传递单参
//        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/detailsPostD?id={id}&name={name}", HttpMethod.POST, null, String.class,1,"zsw");
        //put传递单参
//        Map<String,Object> map=new HashMap<>();
//        map.put("id",1);
//        map.put("name","zsw");
//        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/detailsPutD?id={id}&name={name}", HttpMethod.PUT, null, String.class,map);
        //delete传递单参
//        Map<String,Object> map=new HashMap<>();
//        map.put("id",1);
//        map.put("name","zsw");
//        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/detailsDeleteD?id={id}&name={name}", HttpMethod.DELETE, null, String.class,map);


        String result = resp.getBody();
        System.out.println(result);
        return result;
    }
    private static final class HttpComponentsClientHttpRequestWithBodyFactory extends HttpComponentsClientHttpRequestFactory {
        @Override
        protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
            if (httpMethod == HttpMethod.GET) {
                return new HttpGetRequestWithEntity(uri);
            }
            return super.createHttpUriRequest(httpMethod, uri);
        }
    }
    private static final class HttpGetRequestWithEntity extends HttpEntityEnclosingRequestBase {
        public HttpGetRequestWithEntity(final URI uri) {
            super.setURI(uri);
        }

        @Override
        public String getMethod() {
            return HttpMethod.GET.name();
        }
    }
}
