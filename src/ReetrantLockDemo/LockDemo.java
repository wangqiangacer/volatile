package ReetrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        synchronized (new Object()){

        }
        new ReentrantLock();
    }
}
