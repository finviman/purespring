package com.home.experiment;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liyang on 25/10/2016.
 * li.acerphoenix@gmail.com
 * email to me maybe
 */
@Slf4j
public class TestLog4j2 {
    public static void main(String[] args) {
        String a = null;
        log.info("treat null like {}",a);

        try {
            Integer.parseInt("haha");
        } catch (Exception e) {
            log.error("treat exception",e);
        }
    }
}
