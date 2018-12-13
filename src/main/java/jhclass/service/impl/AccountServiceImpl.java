package jhclass.service.impl;

import jhclass.dao.AccountMapper;
import jhclass.entity.Account;
import jhclass.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public int add(){
        Account account = new Account();
        account.setId(18);
        account.setName("john");
        account.setBalance(100);

        int ret = accountMapper.insert(account);

        //int i = 10/0;

        return ret;
    }






}

