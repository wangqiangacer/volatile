package SpinLockDemo;

import java.util.concurrent.atomic.AtomicReference;

//手写一个自旋锁  BBB线程反复判断 主内存中的值是否为空
 class SpinLock {

    //原子引用线程
    AtomicReference<Thread> atomicReference=new AtomicReference<>();
    public  void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"come in ");
        //主内存中没有线程为null
        while (atomicReference.compareAndSet(null,thread)){

        }

    }

    public  void UnLock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"invoke unLock");
    }
    public static void main(String[] args) {

        SpinLock spinLock = new SpinLock();
        new Thread(()->{
            spinLock.myLock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            spinLock.UnLock();
        },"AAA").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLock.myLock();
            spinLock.UnLock();
        },"BBB").start();
    }
}
