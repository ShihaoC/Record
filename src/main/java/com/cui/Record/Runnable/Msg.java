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
                    logger.info("\n" +
                            "============================================================\n"+
                            "\t\t登录 - /sys-user/login - get \n" +
                            "\t\t获取考勤信息 - /sys-employee/getMapping - get \n" +
                            "\t\t删除考勤信息 - /sys-employee/delete - get \n" +
                            "\t\t添加考勤信息 - /sys-employee/insert - get \n" +
                            "\t\t添加员工信息 - /sys-employee/addStaff - get\n" +
                            "\t\t获取员工对象集合 - /sys-employee/getStaffs - get\n"+
                            "============================================================");
                    break;
                default:
                    logger.error("未知命令");
                    break;
            }
        }
    }
}
