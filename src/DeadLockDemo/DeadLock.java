package DeadLockDemo;

/**
 * 死锁是两个线程或两个线程以上执行过程中的，因争夺资源而造成资源相互等待的过程
 *
 * 持有自己的锁还想拿对方的锁
 */



class HoldLockThread implements  Runnable{
    private  String lockA;
    private  String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有自己的锁"+lockA+"尝试获得"+lockB);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有自己的锁"+lockB+"尝试获得"+lockA);
            }
        }
    }
}
public class DeadLock {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();
    }
}
