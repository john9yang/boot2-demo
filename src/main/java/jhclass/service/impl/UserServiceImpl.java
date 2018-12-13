package jhclass.service.impl;

import jhclass.dao.AccountMapper;
import jhclass.dao.UserMapper;
import jhclass.entity.Account;
import jhclass.entity.User;
import jhclass.service.AccountService;
import jhclass.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public int addAccount() {
        User user = new User();
        user.setAge(88);
        user.setCreateTime(new Date());
        user.setName("测试事务啦加入事务");
        user.setPhone("10010101010");
        userMapper.insert(user);
        //int i = 19/0;

        try{
            //accountService.add();//两个都没有
            //int j =9/0;
            //UserService userServiceProxy = (UserServiceImpl)AopContext.currentProxy();
            //userServiceProxy.addAccountBalance();//两个都有
            addAccountBalance();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("捕获到异常");
        }


        return 0;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public void addAccountBalance() {
        Account acc = new Account();
        acc.setId(18);
        acc.setName("test");
        acc.setBalance(100);
        accountMapper.insert(acc);

        int i = 100/0;
    }


}

