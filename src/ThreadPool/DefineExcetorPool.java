package ThreadPool;

import java.util.concurrent.*;

/**
 * 核心线程数
 * 最大线程数
 * 阻塞队列
 * 线程工厂
 * 拒绝策略
 */
public class DefineExcetorPool {
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(
                2,
                5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
               // new ThreadPoolExecutor.AbortPolicy());
                new ThreadPoolExecutor.CallerRunsPolicy());



        //模拟10个用户来办理
        try {
            for (int i = 1; i <= 9; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
