package jhclass.redis;

import jhclass.SpringBoot2DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBoot2DemoApplication.class)
public class StringRedisTemplateTest {
    private static final Logger logger = LoggerFactory.getLogger(StringRedisTemplateTest.class);

    @Autowired
    private StringRedisTemplate strRedisTemplate;

    @Test
    public void testGetStr(){
        String content = strRedisTemplate.opsForValue().get("job");
        logger.info("content:{}",content);
        assertEquals("programmer",content);
    }
}
