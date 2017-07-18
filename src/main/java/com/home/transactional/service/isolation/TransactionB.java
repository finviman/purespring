package com.home.transactional.service.isolation;

import com.home.transactional.dao.UserDao;
import com.home.transactional.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        final int liyang = userDao.updateAllFreeze("7");
        System.out.println(liyang);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 所谓repeatable read引起的幻读，就是txB更新范围记录，txA在此范围内插入一行，txB再读时，会看到插入的这一行。
         * 妈的在mysql时可以实现的，怎么这里又不行，尼玛见鬼。
         */
        final List<User> liyang1 = userDao.getAll();
        for (User user : liyang1) {
            System.out.println(user.getFreeze());
        }
    }
}
