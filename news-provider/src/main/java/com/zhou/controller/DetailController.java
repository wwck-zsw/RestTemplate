package com.zhou.controller;

import com.github.pagehelper.PageInfo;
import com.zhou.entity.Detail;
import com.zhou.service.DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api(value = "新闻信息API")
@RestController
public class DetailController {
    @Autowired
    private DetailService detailService;

    @ApiOperation(
            value = "查询全部新闻信息",
            notes = "查询全部新闻信息,包括：新闻编号,新闻标题,新闻摘要,作者,创建日期,没有入参",
            httpMethod = "GET",
            protocols = "HTTP",
            produces = "application/json",
            response = PageInfo.class
    )
    @RequestMapping(value = "details",method = RequestMethod.GET)
    public PageInfo<Detail> queryByTitle(@RequestParam(required = false) String title, @RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize){
//    public PageInfo<Detail> queryByTitle(@RequestBody(required = false) String title, @PathVariable(required = false) Integer pageNum,@RequestBody(required = false) Integer pageSize){
        System.out.println("title："+title+",pageNum:"+pageNum+",pageSize:"+pageSize);
        if (pageNum == null) {
            pageNum=1;
        }
        if (pageSize == null) {
            pageSize=2;
        }
        PageInfo<Detail> pageInfo = detailService.queryByTitle(title, pageNum, pageSize);
        return pageInfo;
    }


    @ApiOperation(
            value = "查询全部新闻信息",
            notes = "查询全部新闻信息,包括：新闻编号,新闻标题,新闻摘要,作者,创建日期,没有入参",
            httpMethod = "GET",
            protocols = "HTTP",
            produces = "application/json",
            response = PageInfo.class
    )
    @RequestMapping(value = "details/{id}",method = RequestMethod.DELETE)
    public String deleteDetail(@PathVariable Integer id){
        Integer integer = detailService.deleteDetail(id);
        if(integer>0){
            return "success";
        }
        return "error";
    }

    //测试get
    @RequestMapping(value = "detailsGet",method = RequestMethod.GET)
    public String test01(@RequestBody Detail detail){
        System.out.println("GET-"+detail);
        return "error";
    }
    //测试post
    @RequestMapping(value = "detailsPost",method = RequestMethod.POST)
    public String test02(@RequestBody Detail detail){
        System.out.println("POST-"+detail);
        return "error";
    }
    //测试put
    @RequestMapping(value = "detailsPut",method = RequestMethod.PUT)
    public String test03(@RequestBody Detail detail){
        System.out.println("PUT-"+detail);
        return "error";
    }
    //测试delete
    @RequestMapping(value = "detailsDelete",method = RequestMethod.DELETE)
    public String test04(@RequestBody Detail detail){
        System.out.println("DELETE-"+detail);
        return "error";
    }

    //测试get少量参数
    @RequestMapping(value = "detailsGetD",method = RequestMethod.GET)
    public String test05(Integer id,String name){
        System.out.println("GET-"+id+"-"+name);
        return "error";
    }
    //测试post
    @RequestMapping(value = "detailsPostD",method = RequestMethod.POST)
    public String test06(Integer id,String name){
        System.out.println("POST-"+id+"-"+name);
        return "error";
    }
    //测试put
    @RequestMapping(value = "detailsPutD",method = RequestMethod.PUT)
    public String test07(Integer id,String name){
        System.out.println("PUT-"+id+"-"+name);
        return "error";
    }
    //测试delete
    @RequestMapping(value = "detailsDeleteD",method = RequestMethod.DELETE)
    public String test08(Integer id,String name){
        System.out.println("DELETE-"+id+"-"+name);
        return "error";
    }
}
