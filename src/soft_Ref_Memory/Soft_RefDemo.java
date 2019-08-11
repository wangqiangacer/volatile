package soft_Ref_Memory;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Soft_RefDemo {
    public static void main(String[] args) {
        //soft_Ref_Memory();
        weak_Ref();
    }

    public  static  void soft_Ref_Memory(){
        Object o1 = new Object();
        SoftReference<Object> reference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(reference.get());
        o1=null;
        System.gc();
        System.out.println("==============");
        System.out.println(o1);
        System.out.println(reference.get());
    }


    public  static  void weak_Ref(){
        Object o1 = new Object();
        //软引用
       // SoftReference<Object> reference = new SoftReference<>(o1);
        //弱引用
        WeakReference<Object> reference=new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(reference.get());
        o1=null;
        System.gc();
        System.out.println("==============");
        System.out.println(o1);
        System.out.println(reference.get());
    }
}
