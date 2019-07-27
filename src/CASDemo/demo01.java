package CASDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas :比较并交换
 */
public class demo01 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019));
        System.out.println(atomicInteger.compareAndSet(atomicInteger.get(),123));
        System.out.println(atomicInteger.get());

    }
}
