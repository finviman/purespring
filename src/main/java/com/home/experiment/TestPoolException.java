package com.home.experiment;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyang on 25/10/2016.
 * li.acerphoenix@gmail.com
 * email to me maybe
 */
@Slf4j
public class TestPoolException {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(10000),
            Executors.defaultThreadFactory()) {

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            if (t!=null) {
                log.error("here we are, catch the exception.");
            }
        }
    };

    public static void main(String[] args) {
        threadPoolExecutor.execute(()->Integer.parseInt("i want you"));
        threadPoolExecutor.shutdown();
    }

    private static void cannotCatchException(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            service.execute(()->Integer.parseInt("xxx"));
        } catch (Exception e) {
            log.info("swallow this Exception");
        }
        log.info("run this line anyway");
        service.shutdown();
    }

}
