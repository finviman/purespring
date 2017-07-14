package com.home.transactional.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liyang on 14/7/2017.
 * liyang27@le.com;
 * only in letv.
 */
@Slf4j
public class OuterService {

    @Autowired
    private InnerService innerService;

    @Transactional
    public void transaction() {
        innerService.transaction();
    }
}
