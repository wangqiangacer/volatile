package CallableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 返回值的问题callcale和runnable
 */
class Thread01 implements  Runnable{

    @Override
    public void run() {

    }
}

class Thread02 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("************ callable coming in");
        return 1024;
    }
}
public class CallableDemo01 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask=new FutureTask<>(new Thread02());
        new Thread(futureTask,"AAA").start();
        try {
            System.out.println("result:"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(Runtime.getRuntime().availableProcessors());//查看cpu核数
    }
}
