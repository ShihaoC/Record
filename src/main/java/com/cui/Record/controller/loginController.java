package com.cui.Record.controller;

import com.cui.Record.config.Status;
import com.cui.Record.entity.Staff;
import com.cui.Record.entity.recordE;
import com.cui.Record.entity.user;
import com.cui.Record.service.impl.staffServiceImpl;
import com.cui.Record.service.impl.userServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys-user")
@CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class loginController {
    Logger logger = Logger.getLogger(loginController.class);
    @Resource
    private userServiceImpl service; //创建userServiceImpl对象

    @GetMapping("login")
    public String login(String name, String password) {
        logger.info("加载登录接口");
        user login = service.login(name, password);
        if (login == null) {
            return Status.PASSWORD_ERROR.toString();
        } else {
            return Status.PASS.toString();
        }
    }
}
