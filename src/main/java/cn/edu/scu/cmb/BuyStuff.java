package cn.edu.scu.cmb;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class BuyStuff {

    // 商品类型及数量，假设每个商品购买积分为1
    private static final Map<Integer, AtomicInteger> products = new ConcurrentHashMap<>();

    // 用户数量
    private static final Integer userNums = 3;

    // 商品数量
    private static final Integer productNums = 10;

    // countdown
    private static final CountDownLatch latch = new CountDownLatch(userNums);


    public static void main(String[] args) throws InterruptedException {

        // 初始化10种商品种类及数量
        for (int i = 0; i < 10; i++) {
            products.put(i, new AtomicInteger(productNums));
        }
        // 初始化用户，并开始购物
        User[] users = new User[userNums];
        for (int i = 0; i < userNums; i++) {
            User user = new User("用户" + i);
            users[i] = user;
            // 每个用户尝试购买50000次
            for (int j = 0; j < productNums; j++) {
                user.run();
                latch.countDown();
            }
        }

        // 等待所有用户购买完成
        latch.await();

        // 用户购买结果
        for (int i = 0; i < userNums; i++) {
            System.out.println(users[i].name);
            System.out.println("剩余积分:" +users[i].money);
            users[i].own.forEach((k,v)->{
                System.out.println("商品 " + k + ":购买" + v + "件");
            });
            System.out.println();
        }

        // 商品剩余结果
        System.out.println("商品剩余");
        products.forEach((k,v)->{
            System.out.println("商品 " + k + ":剩余" + v + "件");
        });


        // 检查商品数量是否正确
        System.out.println();
        System.out.println("商品核算");
        for (int i = 0; i < 10; i++) {
            System.out.print("商品 " + i + ":");
            int sum = 0;
            for (int j = 0; j < userNums; j++) {
                sum += users[j].own.getOrDefault(i,0);
            }
            System.out.print("卖出" + sum + "件");
            int total = sum + products.get(i).get();
            System.out.println("，总共 " + total + "件");

        }
    }


    private static class User implements Runnable {
        // 用户名字
        private String name;
        // 初始积分
        private volatile int money = productNums;
        // 已购商品种类及数量
        private Map<Integer, Integer> own = new HashMap<>();
        // 每个用户随机购物
        private Random random = new Random();

        public User(String name) {
            this.name = name;
        }

        // 购买商品
        @Override
        public void run() {
            Integer id = random.nextInt(10);
            try {
                // 对某一件商品数量加锁
                AtomicInteger num = products.get(id);
                if (num.get() == 0) {
                    throw new ProductNotEnoughException("商品 " + id + " 数量为空");
                }
                Integer integer;
                while((integer = num.get()) > 0 && num.compareAndSet(integer,integer-1)){
                    money--;
                    own.put(id, own.getOrDefault(id, 0) + 1);
                    break;
                }
            } catch (ProductNotEnoughException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }


}



