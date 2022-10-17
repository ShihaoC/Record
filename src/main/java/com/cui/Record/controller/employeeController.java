package com.cui.Record.controller;

import com.cui.Record.config.Status;
import com.cui.Record.entity.Staff;
import com.cui.Record.entity.recordE;
import com.cui.Record.service.impl.staffServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys-employee")
@CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class employeeController {
    Logger logger = Logger.getLogger(employeeController.class);
    @Resource
    private staffServiceImpl staffService; //创建staffServiceImpl对象

    @GetMapping("getMapping")
    public List<recordE> getList(String str) {
        logger.info("查询员工考勤信息-" + str);
        return staffService.getList(str);
    }

    @GetMapping("delete")
    public String delete(String date, String name, Long work) {
        System.out.println(date + "\t" + name);
        int delete = staffService.delete(name, date, work);
        logger.info("删除考勤信息" + date + "\t" + name);
        if (delete > 0) {
            return Status.PASS.toString();
        } else {
            return Status.ERROR.toString();
        }
    }

    @GetMapping("insert")
    public String insert(String date, String name, int work) {
        logger.info("添加考勤信息" + date + "\t" + name + "\t" + work);
        int insert = staffService.insert(name, date, work);
        if (insert > 0) {
            return Status.PASS.toString();
        } else {
            return Status.ERROR.toString();
        }
    }

    @GetMapping("addStaff")
    public String addStaff(String name) {
        logger.info("添加员工" + name);
        int result = staffService.insertStaff(Long.parseLong(staffService.getId()), name);
        if (result != 0) {
            return Status.PASS.toString();
        } else {
            return Status.STAFF_IS_EXISTS.toString();
        }
    }

    @GetMapping("getStaffs")
    public List<Staff> getList() {
        logger.info("调取员工对象集合");
        return staffService.getStaffs();
    }
}
