package com.home.transactional.service.isolation;

import com.home.transactional.dao.UserDao;
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
public class TransactionA {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void operation() {
        log.info("before transaction committed");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userDao.add("a");
        log.info("after transaction committed");
    }
}
