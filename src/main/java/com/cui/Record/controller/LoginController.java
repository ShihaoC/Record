package com.cui.Record.controller;

import com.cui.Record.config.Status;
import com.cui.Record.entity.user;
import com.cui.Record.service.userService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys-user")
@CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class);
    @Resource
    private userService service; //创建userServiceImpl对象

    @GetMapping("login")
    public String login(String name, String password) {
        logger.info("加载登录接口");
        user login = service.login(name, password);
        System.out.println(login);
        if (login == null) {
            return Status.PASSWORD_ERROR.toString();
        } else {
            return Status.PASS.toString();
        }
    }
}
