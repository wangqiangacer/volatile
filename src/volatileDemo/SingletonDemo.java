package volatileDemo;

public class SingletonDemo {
    private  static  SingletonDemo instance=null;
    private  SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"我是构造方法SingletonDemo()");
    }
    //DCL 双端检锁机制 Double check Lock  加锁前和加锁后都进行判断 对象是否为空
    public static    SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
class demo01{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },Thread.currentThread().getName()).start();
        }
    }
}
