package com.cui.Record.Runnable;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Msg implements Runnable{
    @Override
    public void run() {
        Logger logger = Logger.getLogger(Msg.class);
        Scanner input = new Scanner(System.in);
        while (true){
            switch (input.next()){
                case "stop":
                case "quit":
                case "exit":
                    logger.warn("退出");
                    System.exit(0);
                    break;
                case "java-v":
                    logger.info("JDK:"+System.getProperty("java.specification.version"));
                    break;
                case "clear":
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    break;
                case "interfaces":
                    logger.info("\n登录 - login - get \n" +
                            "获取考勤信息 - getMapping - get \n" +
                            "删除考勤信息 - delete - get \n" +
                            "添加考勤信息 - insert - get \n" +
                            "添加员工信息 - addStaff - get\n" +
                            "获取员工对象集合 - getStaffs - get");
                    break;
                default:
                    logger.error("未知命令");
                    break;
            }
        }
    }
}
