package jhclass.service;

import jhclass.SpringBoot2DemoApplication;
import jhclass.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = SpringBoot2DemoApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addAccountTest(){
        User user = new User();
        user.setAge(31);
        user.setCreateTime(new Date());
        user.setName("John");
        user.setPhone("13828460314");

        userService.add(user);
    }

    @Test
    public void addAccountTestTransaction(){
        userService.addAccount();
    }
}
