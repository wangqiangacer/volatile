package volatileDemo;

 class ResortDemo {
    int a=0;
    boolean flag=false;
    public  void method1(){
        this.a=1;
        this.flag=true;

    }
    public  void method2(){
        if(true){
            a=a+5;
            System.out.println("resort value is:"+a);
        }
    }
}

  class demo{
    public static void main(String[] args) {
        ResortDemo resortDemo = new ResortDemo();
        for (int i = 1; i < 1000; i++) {
            new Thread(()->{
                resortDemo.method1();
                resortDemo.method2();
            },Thread.currentThread().getName()).start();
        }

        //上面20个线程执行完成后得到最终结果
//        while (Thread.activeCount()>2){
//            Thread.yield();
//        }
//        System.out.println(Thread.currentThread().getName()+"  int type  finally number value is:"+resortDemo.a);
    }
}
