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

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void operation() {
        final User liyang = userDao.getByName("liyang");
        System.out.println(liyang.getMoney());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 所谓的read_committed引起的 不可重复读，就是txB未提交时，txA读一次，读老数据，txB提交时，txA再读一次，变成了新数据。
         * 所以在此例子中，第一次和第二次读到的数据应该不一样的。在mysql客户端测试是符合预期的。
         * 但是，目前的代码，读取的数据却是一样的。所以，我怀疑是mybatis缓存造成，然后用两种方式验证是否缓存捣乱：
         * 1.开启mysql查询日志，确实没有看到第二次的的查询记录。
         * 2.把第二次的查询参数变一下，就可以在mysql日志中看到查询日志。
         * 看来确实mybatis缓存原因。
         */
        final User liyang1 = userDao.getByName("liyang");
        System.out.println(liyang1.getMoney());
    }
}
