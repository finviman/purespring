package com.home.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by liyang on 25/10/2016.
 * li.acerphoenix@gmail.com
 * email to me maybe
 */
@Slf4j
@Getter
@Setter
@Component(value="region")
public class Region {
    private String regionName="default regionName";
    public Region() {
        log.info("region created");
    }
}
