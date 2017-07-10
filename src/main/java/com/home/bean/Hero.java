package com.home.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liyang on 25/10/2016.
 * li.acerphoenix@gmail.com
 * email to me maybe
 */
@Slf4j
@Component(value="hero")
@Getter
@Setter
public class Hero {
    public Hero() {
        log.info("hero created");
    }
    private String name="default hero name";

    @Autowired
    private Region region;
}
