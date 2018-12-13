package jhclass.service;


import jhclass.entity.User;

public interface UserService {

    public int add(User user);

    /**
     * 功能描述：测试事务
     * @return
     */
    public int addAccount();


    public void addAccountBalance();

}
