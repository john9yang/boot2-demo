package jhclass.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GlobalPropertiesTest {
    @Autowired
    private GlobalProperties globalProperties;


    @Test
    public void getEmailTest(){
        assertEquals(globalProperties.email,is("test@163.com"));
    }
}
