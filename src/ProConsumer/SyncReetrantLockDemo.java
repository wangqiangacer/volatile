package ProConsumer;
//判断，干活，通知

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private  int number=1;
    private Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();
    public  void  printFiveTime(){
        lock.lock();
        try {
            //判断
            while (number!=1){
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=2;
            c2.signal();//唤醒c2
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public  void  printTenTime(){
        lock.lock();
        try {
            //判断
            while (number!=2){
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=3;
            c3.signal();//唤醒c3
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


    public  void  printFiftentyTime(){
        lock.lock();
        try {
            //判断
            while (number!=3){
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=1;
            c1.signal();//唤醒c1
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}
public class SyncReetrantLockDemo {
    public static void main(String[] args) {


        ShareResource shareResource = new ShareResource();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                shareResource.printFiveTime();
            },"A").start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                shareResource.printTenTime();
            },"B").start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                shareResource.printFiftentyTime();
            },"C").start();
        }

    }
}
