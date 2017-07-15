package com.home.transactional.service.isolation;

import com.home.transactional.dao.UserDao;
import com.home.transactional.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liyang on 14/7/2017.
 * liyang27@le.com;
 * only in letv.
 */
@Service
public class TransactionB {

    @Autowired
    private UserDao userDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void operation() {
        final User liyang = userDao.getByName("liyang");
        System.out.println(liyang.getMoney());
    }
}
