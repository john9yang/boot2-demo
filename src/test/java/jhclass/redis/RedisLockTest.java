package jhclass.redis;

import jhclass.SpringBoot2DemoApplication;
import jhclass.entity.DemoTask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest(classes = SpringBoot2DemoApplication.class)
public class RedisLockTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void getWho(){
        String name = (String)redisTemplate.opsForValue().get("who");
        assertEquals("john",name);
    }

    @Test
    public void testGet(){
        RedisLock redisLock = new RedisLock(redisTemplate,"test",1000,1000);
        String job = redisLock.get("job");
        assertEquals("programmer",job);
    }

    @Test
    public void testSetNX(){
        RedisLock redisLock = new RedisLock(redisTemplate,"test",1000,1000);
        redisLock.setNX("job","programmer");
        String job = redisLock.get("job");
        assertEquals("singer",job);
        redisLock.setNX("who","yjh");
        String city = redisLock.get("who");
        assertEquals("john",city);
    }

    @Test
    public void testRedisLock() throws InterruptedException {
        RedisLock redisLock = new RedisLock(redisTemplate, "who", 3000, 3000);

        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5, 10, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for( int i=0;i<5;i++ ){
            DemoTask task = new DemoTask(i,redisLock);
            executor.execute(task);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+ executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }

        Thread.currentThread().join();
    }

    @Test
    public void deleteKey(){
        System.out.println(redisTemplate.opsForValue().get("who_lock"));
        redisTemplate.delete("who_lock");
        boolean hasKey = redisTemplate.hasKey("who_lock");
        assertFalse(hasKey);
    }
}
