package cn.edu.scu.middle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisDemo {

    private static Jedis jedis;

    public static void main(String[] args) {
        try {
            connectToRedis();
            testString();
            testList();
            testSet();
            testSortedSet();
            testHash();
            testHyperLogLog();
            testBitmap();
            testGeo();
        } catch (JedisConnectionException e) {
            System.err.println("连接Redis服务器失败: " + e);
        } finally {
            // 关闭Jedis连接
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    private static void connectToRedis() {
        jedis = new Jedis("110.41.162.189", 6379);
        jedis.auth("admin111"); // 连接Redis服务器需要密码时，需要调用auth方法
        System.out.println("服务正在运行: " + jedis.ping());
    }

    private static void testString() {
        // 演示字符串操作
        jedis.set("name", "Fitten");
        System.out.println("设置的名字: " + jedis.get("name"));
    }

    private static void testList() {
        // 演示列表操作
        jedis.lpush("mylist", "item1");
        jedis.lpush("mylist", "item2");
        jedis.lpush("mylist", "item3");
        System.out.println("列表中的所有元素: " + jedis.lrange("mylist", 0, -1));
    }

    private static void testSet() {
        // 演示集合操作
        jedis.sadd("myset", "value1");
        jedis.sadd("myset", "value2");
        jedis.sadd("myset", "value3");
        System.out.println("集合中的所有元素: " + jedis.smembers("myset"));
    }

    private static void testSortedSet() {
        // 演示有序集合操作
        jedis.zadd("mysortedset", 1.0, "value1");
        jedis.zadd("mysortedset", 2.0, "value2");
        jedis.zadd("mysortedset", 3.0, "value3");
        System.out.println("有序集合中的所有元素: " + jedis.zrange("mysortedset", 0, -1));
    }

    private static void testHash() {
        // 演示哈希操作
        jedis.hset("myhash", "field1", "value1");
        jedis.hset("myhash", "field2", "value2");
        System.out.println("哈希中的所有字段: " + jedis.hgetAll("myhash"));
    }

    private static void testHyperLogLog() {
        // 添加一些 IP 地址到 HyperLogLog
        jedis.pfadd("unique_ips", "192.168.1.1");
        jedis.pfadd("unique_ips", "192.168.1.2");
        jedis.pfadd("unique_ips", "192.168.1.1");  //重复的 IP 地址
        jedis.pfadd("unique_ips", "192.168.1.3");

        long unique_ip_count = jedis.pfcount("unique_ips");
        System.out.println("唯一的 IP 数量: " + unique_ip_count);
    }

    private static void testBitmap() {
        // 演示位图操作
        jedis.setbit("mybitmap", 0, true);
        jedis.setbit("mybitmap", 1, false);
        jedis.setbit("mybitmap", 2, true);
        System.out.println("位图中的位数总数: " + jedis.bitcount("mybitmap"));
    }

    private static void testGeo() {
        // 演示地理位置操作
        jedis.geoadd("mygeokey", 116.407396, 39.904211, "北京");
        jedis.geoadd("mygeokey", 121.473701, 31.230416, "上海");
        jedis.geoadd("mygeokey", 113.264385, 23.129112, "广州");
        System.out.println("北京到上海的距离: " + jedis.geodist("mygeokey", "北京", "上海") + " 米");
        System.out.println("地理位置中的所有元素: " + jedis.geopos("mygeokey", "北京", "上海", "广州"));
    }
}
