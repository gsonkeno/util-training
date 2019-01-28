package com.gsonkeno.utiltraining.util;

import com.gsonkeno.utiltraining.utils.PriorityQueue;
import org.junit.Test;

import java.util.Arrays;

public class PriorityQueueTest {


    /**1千万数据，排序耗时5s左右**/
    @Test
    public void testSort(){
        Integer[] a = new Integer[10000000];

        for(int i=0;i<10000000;i++){
            a[i] = (int) (Math.random()*10000000);
        }
        long start = System.currentTimeMillis();
        Arrays.sort(a);
        System.out.println((System.currentTimeMillis() - start) +" 毫秒");
    }

    /**1千万数据，取得最大的前100个数，lucene堆排序耗时37ms左右**/
    @Test
    public void testSortByLucene(){
        Integer[] a = new Integer[10000000];

        for(int i=0;i<10000000;i++){
            a[i] = (int) (Math.random()*10000000);
        }
        long start = System.currentTimeMillis();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(100) {
            @Override
            protected boolean lessThan(Integer t1, Integer t2) {
                return t1 < t2;
            }
        };

        for(int i=0;i<10000000;i++){
            pq.insertWithOverflow(a[i]);
        }
        Integer[] b = new Integer[100];
        for(int i=99;i>=0;i--){
            b[i] = pq.pop();
        }
        System.out.println((System.currentTimeMillis() - start) +" 毫秒");
        System.out.println(Arrays.asList(b));
    }
}
