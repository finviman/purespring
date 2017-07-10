package com.home;

import com.home.bean.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liyang on 25/10/2016.
 * li.acerphoenix@gmail.com
 * email to me maybe
 */
@Slf4j
public class AppStart {
    public static void main(String[] args) {
        startByXml();
    }

    private static void startByXml() {
//      when you new applicationContext,the beans will be instantiated.except you put a @Lazy annotation on the bean.
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hero r = applicationContext.getBean("hero",Hero.class);
        System.out.println(r.getRegion().getRegionName());
    }
}
