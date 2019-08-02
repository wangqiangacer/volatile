package SemaphoreDemo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟三个停车位
        for (int i = 1; i <= 6; i++) {//模拟6个汽车
            new Thread(()->{
                try {
                    semaphore.acquire();//抢到车位
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    //停三秒钟
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"停车三秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放停车位
                }
            },String.valueOf(i)).start();
        }

    }
}
