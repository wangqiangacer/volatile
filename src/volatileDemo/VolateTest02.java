package volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volate修饰不具有原子性 （同步性 ）
 */
class  VolateNoAtomic extends  Thread{

    //private  static     int count=0;
  private static AtomicInteger atomicInteger= new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
          //  count++;
            atomicInteger.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName()+"--------"+atomicInteger);
    }
}
public class VolateTest02 {
    public static void main(String[] args) {
        VolateNoAtomic[] volateNoAtomics=new VolateNoAtomic[10];
        for (int i = 0; i < volateNoAtomics.length; i++) {
            volateNoAtomics[i]=new VolateNoAtomic();
        }
        for (int i = 0; i < volateNoAtomics.length; i++) {
            volateNoAtomics[i].start();
        }
    }
}
