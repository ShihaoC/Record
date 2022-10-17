package com.cui.Record.service;

import com.cui.Record.entity.user;

public interface userService {
    user login(String name, String password);
}