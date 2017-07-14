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
class OuterService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private InnerService innerService;

    @Transactional
    void outerCall() {
        userDao.updateMoney("0", "liyang");
        innerService.innerCall();
    }
}
