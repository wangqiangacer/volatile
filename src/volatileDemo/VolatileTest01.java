package volatileDemo;

//不保证原子性 ：不能够保证数据的完整性

/**
 * 解决volatile的原子性问题有两种方式：同步锁以及原子类型的数据
 */
public class VolatileTest01 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 1; i <=20; i++) {
            new Thread(()->{
                //每个线程执行1000次
                for (int j = 1; j <=1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }

            },String.valueOf(i)).start();
        }

        //上面20个线程执行完成后得到最终结果
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"  int type  finally number value is:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"  atomic type finally number value is:"+myData.atomicInteger);
    }
}
