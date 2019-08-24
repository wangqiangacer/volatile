package ThreadJoin;

/**
 * 先让子线程执行完毕？？
 * 可以使用join
 * T1 线程执行完成后执行T2再执行T3
 */
public class Threadoo1 {
    public static void main(String[] args) {
        //线程T1
         Thread thread=new Thread(()->{

            for (int i = 0; i < 30; i++) {
                System.out.println(Thread.currentThread().getName()+"子线程 i:"+i);

            }
        },"T1");
         thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //线程T2
        Thread thread1=new Thread(()->{

            for (int i = 0; i < 30; i++) {
                System.out.println(Thread.currentThread().getName()+"子线程 i:"+i);

            }
        },"T2");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程T3
        Thread thread2=new Thread(()->{

            for (int i = 0; i < 30; i++) {
                System.out.println(Thread.currentThread().getName()+"子线程 i:"+i);

            }
        },"T3");
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
