package ArrayListDemo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//ArrayList线程不安全的example
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //java.util.ConcurrentModificationException 并发修改异常
        /**
         *解决方式（两种）
         * 1.new Vector<>(); 但是并发效率大大降低
         *Collections.synchronizedList
         * 2.Collections.synchronizedList(new ArrayList<>());
         * collection是list和set的父接口collections是collection的工具类
         * 3.new CopyOnWriteArrayList<>();
         */
       //List<String> list = new ArrayList<>();
       //List<String> list = new Vector<>();//线程安全 public synchronized boolean add
        //List<String> list=Collections.synchronizedList(new ArrayList<>());
        List<String> list=new CopyOnWriteArrayList<>();
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
