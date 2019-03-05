package jhclass.entity;

import jhclass.redis.RedisLock;

import java.util.concurrent.TimeUnit;

public class DemoTask implements Runnable{

    private Integer num;
    private RedisLock lock;

    public DemoTask(Integer num, RedisLock lock){
        this.num = num;
        this.lock = lock;
    }

    public void run(){
        try {
            if ( lock.lock() ){
                System.out.println("doing some thing:"+num);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
