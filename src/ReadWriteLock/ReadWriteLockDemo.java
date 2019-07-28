package ReadWriteLock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**实现的目标是：写入数据是必须保证原子性，读物数据是共享的
 * 多个线程可以同时共享  读 --读 共享
 * 读--写不能共存
 * 写--写不能共存
 * 写操作：原子+独占（原子性）
 */

class MyCache{
    private  volatile HashMap<String,Object> map=new HashMap<>();
    //读写锁
    private ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();

    public  void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入中"+key);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }

    }


    public  void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在读取中");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result= map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成"+result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }

    }

    //清除缓存
    public  void clearMap(){
        map.clear();
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        //五个线程来写入
        for (int i = 1; i <= 5; i++) {
            final  int tempInt=i;
            new Thread(()->{
                cache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        //五个线程来读取
        for (int i = 1; i <= 5; i++) {
            final  int tempInt=i;
            new Thread(()->{
                cache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
