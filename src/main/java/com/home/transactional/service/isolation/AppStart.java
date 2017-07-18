package com.home.transactional.service.isolation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liyang on 14/7/2017.
 * liyang27@le.com;
 * only in letv.
 */
public class AppStart {
    public static void main(String[] args) throws Exception {
        startByXml();
    }

    private static void startByXml() throws Exception {
//      when you new applicationContext,the beans will be instantiated.except you put a @Lazy annotation on the bean.
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TransactionA txa = applicationContext.getBean(TransactionA.class);
        TransactionB txb = applicationContext.getBean(TransactionB.class);
        new Thread(() -> txa.operation()).start();
        Thread.sleep(300);
        new Thread(() -> txb.operation()).start();
    }
}
