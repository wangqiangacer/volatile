package AtomicReference;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicDemo {
    public static void main(String[] args) {
        User zhangsan = new User("zhangsan", 22);
        User lisi = new User("lisi", 23);
        AtomicReference<User>  atomicReference=new AtomicReference<User>();
        atomicReference.set(zhangsan);
        System.out.println(atomicReference.compareAndSet(zhangsan, lisi));
        System.out.println(atomicReference.get().toString());

    }
}
