package com.github.gserv.example.jetty.controller;

import com.github.gserv.example.jetty.dao.DemoTableDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by shiying on 2016/4/10.
 */
@Controller
@RequestMapping(value = "/")
public class ExampleController {

    @Resource
    private DemoTableDao demoTableDao;

    @RequestMapping(value = "index")
    @ResponseBody
    public String index() {
        System.out.println(demoTableDao);
        System.out.println(demoTableDao.count());
        System.out.println(demoTableDao.findByName("text1"));
        System.out.println(demoTableDao.findByNameKey("t"));
        return "this is index controller";
    }

}
