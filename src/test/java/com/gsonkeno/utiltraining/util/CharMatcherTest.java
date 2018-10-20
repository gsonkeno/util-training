package com.gsonkeno.utiltraining.util;

import com.google.common.base.CharMatcher;
import org.junit.Test;

public class CharMatcherTest {

    @Test
    public void testChar(){
        boolean b = CharMatcher.is('?').matchesAnyOf("www.?sad?.com");
        System.out.println(b);

        System.out.println(CharMatcher.anyOf("baim").matchesAnyOf("www.baidu.com"));
        System.out.println(CharMatcher.anyOf("baidu").matches('b'));

        System.out.println(CharMatcher.anyOf("baim").matchesAllOf("www.baidu.com"));

    }
}
