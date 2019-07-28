package FailLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo {
    public static void main(String[] args) {
        /**
         * 对于ReetrantLock 是非公平锁 （插队）
         * 公平锁：按照一定的有序顺序
         */
        Lock lock=new ReentrantLock();//This is equivalent to using {@code ReentrantLock(false)


    }
}
