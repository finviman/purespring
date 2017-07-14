package com.home.transactional.dao;

import com.home.transactional.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by liyang on 14/7/2017.
 * liyang27@le.com;
 * only in letv.
 */
@Component
public interface UserDao {

    @Select("select * from user where name= #{name}")
    User getByName(String name);
}
