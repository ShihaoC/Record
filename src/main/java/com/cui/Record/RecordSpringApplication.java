package com.cui.Record;

import com.cui.Record.Runnable.Msg;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecordSpringApplication {
    private static final Logger logger = Logger.getLogger(RecordSpringApplication.class);

    public static void main(String[] args) {
        //启动一个线程接收用户输入信息
        Thread Msg = new Thread(new Msg(), "信息");
        logger.info("创建用户输入信息线程");
        Msg.start();
        logger.info("用户输入信息线程启动成功");
        logger.info("启动SpringBoot应用程序");
        SpringApplication.run(RecordSpringApplication.class, args);
    }
}
