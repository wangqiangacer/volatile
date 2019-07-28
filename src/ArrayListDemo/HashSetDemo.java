package ArrayListDemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();//底层HashMap  java.util.ConcurrentModificationException
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());
        //Set<String> set =new  CopyOnWriteArraySet();
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
