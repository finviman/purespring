package com.home.transactional.service.propagation;

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
class InnerService {

    @Autowired
    private UserDao userDao;

    @Transactional
    void innerCall() {
        userDao.updateFreeze("100.x", "liyang");
    }
}
