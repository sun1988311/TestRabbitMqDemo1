package com.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import redis.clients.jedis.Jedis;

public class RedisJava {

	public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.121.129",6500);
        System.out.println("success");
        System.out.println("service running "+jedis.ping());
        jedis.set("runoobkey", "www.runoob.com");
        System.out.println("redis save string: "+ jedis.get("runoobkey"));
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        List<String> list = jedis.lrange("site-list", 0 ,10);
        for(int i=0; i<list.size(); i++) {
            System.out.println("list: "+list.get(i));
        }
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }

	}

}
