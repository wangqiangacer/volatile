package volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {
     volatile   int number=0;
    public  void addTo60(){
        this.number=60;
    }
    public   void addPlusPlus(){
        number++;
    }
    AtomicInteger atomicInteger=new AtomicInteger();

    public  void addAtomic(){
        //保证volatile的原子性问题Atomically increments by one the current value.
        atomicInteger.getAndIncrement();
    }
}

