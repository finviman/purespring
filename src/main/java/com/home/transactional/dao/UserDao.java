package com.home.transactional.dao;

import com.home.transactional.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liyang on 14/7/2017.
 * liyang27@le.com;
 * only in letv.
 */
@Component
public interface UserDao {

    @Select("select * from user where name= #{name}")
    User getByName(String name);

    @Select("select * from user")
    List<User> getAll();

    @Insert("insert into user value(#{name},10,0)")
    int add(@Param("name") String name);

    @Update("update user set money=#{money} where name=#{name}")
    int updateMoney(@Param("money") String money, @Param("name") String name);

    @Update("update user set freeze=#{freeze} where name=#{name}")
    int updateFreeze(@Param("freeze") String freeze,@Param("name") String name);

    @Update("update user set freeze=#{freeze} ")
    int updateAllFreeze(@Param("freeze") String freeze);
}
