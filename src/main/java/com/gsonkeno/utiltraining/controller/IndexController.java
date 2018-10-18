package com.gsonkeno.utiltraining.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.AssertTrue;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gaosong
 * @since 2018-10-19
 */
@RestController
public class IndexController {

    @RequestMapping(name = "/index")
    public Map<String,Object> index(String q,String city){

        System.out.println("q对象是否为空?" + (null == q));
        System.out.println("city对象是否为空?" + (null == city));
        Map<String,Object> map = new HashMap<>();
        map.put("CODE","1");
        map.put("MSG","成功");
        return map;
    }
}
