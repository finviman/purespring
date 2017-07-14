package com.home.transactional.service.basic;

import com.home.transactional.dao.UserDao;
import com.home.transactional.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liyang on 14/7/2017.
 * liyang27@le.com;
 * only in letv.
 */
@Slf4j
@Service
class SingleTransactionService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void transaction() {
        final User li = userDao.getByName("liyang");
        System.out.println(li.getMoney());
        userDao.updateMoney("0", "liyang");
        userDao.updateFreeze("100.x", "liyang");
    }
}
