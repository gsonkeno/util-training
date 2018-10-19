package com.gsonkeno.utiltraining.utils;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gaosong
 * @since 2018-10-19
 */
public class HttpUtils {

    private static final Log log = LogFactory.getLog(HttpUtils.class);

    public static String get(String url, Map<String, Object> params, int socketTimeout, int connectTimeout){
        CloseableHttpResponse response = null;
        String result = null;
        CloseableHttpClient client = null;
        try {
            client= HttpClients.createDefault();
            StringBuilder sb = new StringBuilder(url);

            if (MapUtils.isNotEmpty(params)) {
                List<NameValuePair> nameValuePairs = Lists.newArrayList();
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
                }
                sb.append(CharMatcher.is('?').matchesAnyOf(url) ? "" : "?");
                sb.append(URLEncodedUtils.format(nameValuePairs, Charset.forName("UTF-8")));
            }
            HttpGet httpGet = new HttpGet(sb.toString());
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).
                    setConnectTimeout(connectTimeout).build();
            httpGet.setConfig(requestConfig);

            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);

            log.info(sb.toString() + " 搜索结果: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(client);
        }

        return result;
    }
}
