package ProConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResouce{
    private  volatile  boolean Flag=true;//默认开启生产和消费
    private AtomicInteger atomicInteger=new AtomicInteger();
    BlockingQueue<String> blockingQueue=null;
    public  MyResouce( BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public  void MyPro() throws InterruptedException {
        String data="";
        boolean returnValue;
        while (Flag){
           data= atomicInteger.getAndIncrement()+"";
          returnValue= blockingQueue.offer(data,2, TimeUnit.SECONDS);
          if(returnValue){
              System.out.println(Thread.currentThread().getName()+"插入数据"+data+"成功！");
          }else {
              System.out.println(Thread.currentThread().getName()+"插入数据"+data+"失败！");
          }
          Thread.sleep(1000);

        }
        //如果flag为false了就停止生产
        System.out.println(Thread.currentThread().getName()+"Flag =false");

    }


    public  void MyConsumer ()throws  Exception{
        String result=null;
        while (Flag){
           result= blockingQueue.poll(2,TimeUnit.SECONDS);
           if(null==result||result.equalsIgnoreCase("")){
               Flag=false;
               System.out.println(Thread.currentThread().getName()+"超过两秒钟没有取到蛋糕，消费退出");

               System.out.println();
               return;
           }
            System.out.println(Thread.currentThread().getName()+"消费队列"+result+"成功");
        }
    }

    public  void stop(){
        this.Flag=false;
    }
}
public class Proconsumer_BlockQueueDemo {
    public static void main(String[] args) {
        MyResouce myResouce = new MyResouce(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产现场启动");
            try {
                myResouce.MyPro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"MyPro").start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费线程启动");
            try {
                myResouce.MyConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"MyConsumer").start();

        try {
            Thread.sleep(5000);
            myResouce.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
