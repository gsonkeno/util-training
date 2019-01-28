工作中经常会使用一些工具类，这些工具类的复用性、可迁移性都比较高，此处记录下平时
自己总结的常用的工具类，供大家参考。

## http请求
- [HttpUtils.java](https://github.com/gsonkeno/util-training/blob/master/src/main/java/com/gsonkeno/utiltraining/utils/HttpUtils.java)
封装了get请求与post请求的方式，使用的是第三方库httpclient.jar。
也提供了controller和测试用例进行验证

- [PriorityQueue.java](https://github.com/gsonkeno/util-training/blob/master/src/main/java/com/gsonkeno/utiltraining/utils/PriorityQueue.java)
区别于jdk提供的PriorityQueue(可以自动扩展),该类摘自Lucene，是定长的。而且数据结构封装的更加灵活，如调整堆顶