package jhclass;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("jhclass.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringBoot2DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringBoot2DemoApplication.class);

    public static void main(String[] args) {
        logger.info("Enter main");
        SpringApplication.run(SpringBoot2DemoApplication.class, args);
    }
}