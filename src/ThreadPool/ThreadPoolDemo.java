package ThreadPool;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池可以复用
 * 线程池的七个参数
 * 拒绝策略：
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);//创建五个线程
        //ExecutorService executorService = Executors.newSingleThreadExecutor();//创建一个线程
       // ExecutorService executorService = Executors.newCachedThreadPool();//一池N线程
        //模拟10个用户来办理
        try {
            for (int i = 1; i <= 10; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                Thread.sleep(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
