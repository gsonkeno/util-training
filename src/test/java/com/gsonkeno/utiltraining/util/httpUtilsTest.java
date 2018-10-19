package com.gsonkeno.utiltraining.util;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import com.gsonkeno.utiltraining.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class httpUtilsTest {

    @Test
    public void testGet(){
        Map<String, Object> params = new HashMap<>();
        params.put("q","美丽 新世界");
        params.put("city","美丽&世界");

        String result = HttpUtils.get("http://127.0.0.1:8080/index", params,
                5000, 5000);
    }

    @Test
    public void testGetUrl(){
        String url = "http://www.baidu.com";
        Map<String,Object> params = new HashMap<>();
        StringBuffer sb = new StringBuffer(url);

        params.put("q","美丽 新世界");
        params.put("name","美丽&世界");

        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        sb.append(CharMatcher.is('?').matchesAnyOf(url) ? "" : "?");
        sb.append(URLEncodedUtils.format(nameValuePairs, Charset.forName("UTF-8")));

        System.out.println(sb.toString());
    }
}
