package jhclass.redis;

import jhclass.SpringBoot2DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBoot2DemoApplication.class)
public class RedisLockTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testGet(){
        RedisLock redisLock = new RedisLock(redisTemplate,"test",1000,1000);
        String job = redisLock.get("job");
        assertEquals("programmer",job);
    }

    @Test
    public void testSetNX(){
        RedisLock redisLock = new RedisLock(redisTemplate,"test",1000,1000);
        redisLock.setNX("job","singer");
        String job = redisLock.get("job");
        assertEquals("programmer",job);
        redisLock.setNX("who","yjh");
        String city = redisLock.get("who");
        assertEquals("yjh",city);
    }
}
