package com.home.transactional.service;

import com.home.transactional.dao.UserDao;
import com.home.transactional.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liyang on 14/7/2017.
 * liyang27@le.com;
 * only in letv.
 */
@Slf4j
@Service
public class InnerService {

    @Autowired
    private UserDao userDao;

    public void transaction() {
        final User li = userDao.getByName("liyang");
        System.out.println(li.getMoney());
    }
}
