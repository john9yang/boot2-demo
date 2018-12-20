package jhclass.service;

import jhclass.SpringBoot2DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBoot2DemoApplication.class)
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void addAccountTest(){
        accountService.add();
    }


}
