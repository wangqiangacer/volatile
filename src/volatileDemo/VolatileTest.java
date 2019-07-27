package volatileDemo;


//验证volatile的可见性,首先是从主内存中获取变量值，再读取到自己的工作内存中并修改值
public class VolatileTest {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"  come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //睡眠3秒后修改值为60
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+" update number :"+myData.number);
        },"AAA").start();

        while (myData.number==0){
            //main线程就一直在这里等待直到number不等于0
        }
        System.out.println(Thread.currentThread().getName()+"misson is over,main get number value:"+myData.number);
    }
}
