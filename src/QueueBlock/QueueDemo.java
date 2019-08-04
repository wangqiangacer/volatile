package QueueBlock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 *
 * 队列：先到先得
 *
 *
 * 阻塞队列
 */
public class QueueDemo {
    public static void main(String[] args) {
       BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);//初始值为3的阻塞队列
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println("==============");
        System.out.println(blockingQueue.element());//取出首个队列元素
        System.out.println("==============");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }
}
