package com.home.transactional.service;

/**
 * Created by liyang on 12/27/17.
 * liyang70@meituan.com;
 */
public interface PoiService {

    default String me1(){return "hello";}

    default void me2(){System.out.println("hehe");}
}
