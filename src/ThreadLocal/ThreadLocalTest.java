package ThreadLocal;

/**
 * ThreadLocal的底层实现原理：
 *
 *
 */
class  Res{
   // private  int  count=0;
        ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
       @Override
       protected Integer initialValue() {
           //设置当前线程局部变量的初始化的值
           return  0;
       }
   };
    //生成订单号
    public    Integer getNum(){
//        count=count+1;
//        return  count;
        Integer count=threadLocal.get()+1;
        //向ThreadLocal中设置值
        threadLocal.set(count);
        return count;
    }
}
class  ThreadLocalDemo extends  Thread{
    private  Res res;
    public  ThreadLocalDemo(Res res){
        this.res=res;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"-----i:"+i+",number"+res.getNum());
        }

    }
}
public class ThreadLocalTest {
    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocalDemo t1 = new ThreadLocalDemo(res);
        ThreadLocalDemo t2 = new ThreadLocalDemo(res);
        ThreadLocalDemo t3 = new ThreadLocalDemo(res);
        t1.start();
        t2.start();
        t3.start();

    }
}
