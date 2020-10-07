package com.app.runcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@RestController
public class DbController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/user-agent")
    public String userAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }


}
