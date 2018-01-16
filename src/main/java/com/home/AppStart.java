package com.home;

import com.home.bean.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by liyang on 25/10/2016.
 * li.acerphoenix@gmail.com
 * email to me maybe
 */
public class AppStart {
    private static final Logger log = LogManager.getLogger("category");
    public static void main(String[] args) {
//        startByXml();

        System.out.println(Integer.MAX_VALUE*60L);
    }

    private static void startByXml() {
//      when you new applicationContext,the beans will be instantiated.except you put a @Lazy annotation on the bean.
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hero r = applicationContext.getBean("hero",Hero.class);
        System.out.println(r.getRegion().getRegionName());
    }

}
