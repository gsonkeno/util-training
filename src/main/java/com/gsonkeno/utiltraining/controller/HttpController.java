package com.gsonkeno.utiltraining.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求测试controller
 * @author gaosong
 * @since 2018-10-19
 */
@RestController
public class HttpController {
    private static final Log log = LogFactory.getLog(HttpController.class);

    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    public Map<String,Object> testGet(String q,String city){

        log.info("q: " + q + " , city: " + city);
        System.out.println("q对象是否为空?" + (null == q));
        System.out.println("city对象是否为空?" + (null == city));
        Map<String,Object> map = new HashMap<>();
        map.put("CODE","1");
        map.put("MSG","成功");
        return map;
    }

    @RequestMapping(value = "/testPost", method = RequestMethod.POST )
    public Map<String,Object> testPost(@RequestBody String reqContent){
        log.info("requestBody: " + reqContent);
        Map<String,Object> map = new HashMap<>();
        map.put("CODE","1");
        map.put("MSG","成功");
        return map;
    }
}
