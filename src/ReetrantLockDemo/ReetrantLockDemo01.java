package ReetrantLockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 指的是同一个线程外层函数获得锁之后，内层递归函数获取该锁的代码
 */
class Phone implements Runnable{
    public  synchronized  void SendMessage(){
        System.out.println(Thread.currentThread().getName()+"invoke sendmessage");
        sendEmail();
    }
    public  synchronized  void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"#invoke sendemail");
    }
//验证可重入锁
    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        getLock();
    }
    public  void getLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"#invoke getLock");
            setLock();
        }finally {
            lock.unlock();
        }
    }
    public  void setLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"#invoke setLock");
        }finally {
            lock.unlock();
        }
    }
}
public class ReetrantLockDemo01 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.SendMessage();
        },"t1").start();
        new Thread(()->{
        phone.SendMessage();

        },"t2").start();
        Thread.sleep(1000);
        System.out.println("==================");
        new Thread(phone,"t3").start();
        new Thread(phone,"t4").start();
    }
}
