package QueueBlock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 生产一个消费一个
 * 无阻塞队列
 * 同步队列
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue1=new SynchronousQueue<>();
        new Thread(()->{
            try {
                blockingQueue1.put("1");
                System.out.println(Thread.currentThread().getName()+"\t"+"put 1");
                blockingQueue1.put("2");
                System.out.println(Thread.currentThread().getName()+"\t"+"put 2");
                blockingQueue1.put("3");
                System.out.println(Thread.currentThread().getName()+"\t"+"put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();



        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"\t"+"take"+blockingQueue1.take());

                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"\t"+"take"+blockingQueue1.take());

                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"\t"+"take"+blockingQueue1.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
