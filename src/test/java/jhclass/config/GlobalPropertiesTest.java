package jhclass.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalPropertiesTest {
    @Autowired
    private GlobalProperties globalProperties;

    @Before
    public void setup() throws IOException {
    }

    @Test
    public void getEmailTest(){
        assertThat(globalProperties.email,is("test@163.com"));
    }
}
