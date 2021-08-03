package com.lingDream.llfEnglish.admin.controller;

import com.lingDream.llfEnglish.admin.service.ManagerService;
import com.lingDream.llfEnglish.entity.Manager;
import com.lingDream.llfEnglish.tool.utils.JWTUtils;
import com.lingDream.llfEnglish.tool.exception.CommonException;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.result.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-26 13:32
 */
@Controller
@RestController
@RequestMapping("/admin")
public class ManagerController {
    private final ManagerService managerService;
    private final JWTUtils jwtUtils;

    public ManagerController(ManagerService managerService,
                             JWTUtils jwtUtils) {
        this.managerService = managerService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping(value = "/login")
    public Result login(@RequestBody Manager entity) {
        final Manager loginManager = managerService.login(entity);
        Result result = new Result(ResultCode.LOGIN_SUCCESS);

        if (loginManager != null) {
            Map<String, String> map = new HashMap<>();
            map.put("managerId", loginManager.getManagerId() + "");
            map.put("name", loginManager.getName());
            map.put("nickName", loginManager.getNickName());
            final String token = jwtUtils.getToken(map);
            result.setData(token);
        } else {
            throw new CommonException(ResultCode.LOGIN_ERROR, entity);
        }
        return result;
    }

    @RequestMapping("/exit")
    public Result exit(String token) {
        return null;
    }
}
