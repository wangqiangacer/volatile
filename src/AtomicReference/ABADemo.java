package AtomicReference;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

//原子引用
public class ABADemo {

    static AtomicReference<Integer> atomicReference=new AtomicReference<>(100);
    //设置版本号为1
    static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(100,1);


    public static void main(String[] args) {
        System.out.println("=========以下是ABA问题的产生==============");
            new Thread(()->{
                atomicReference.compareAndSet(100,101);
                atomicReference.compareAndSet(101,100);

            },"t1").start();


        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());


        },"t2").start();

        System.out.println("=========以下是ABA问题的解决==============");
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号"+stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"第二次版本号"+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"第三次版本号"+atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号"+stamp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("最新版本号:"+atomicStampedReference.getStamp());
            System.out.println("修改是否成功"+atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1));
        },"t4").start();
    }
}
