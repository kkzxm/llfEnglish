package com.lingDream.llfEnglish.admin.controller;

import com.lingDream.llfEnglish.admin.service.ManagerService;
import com.lingDream.llfEnglish.entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static java.util.Objects.isNull;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-26 13:32
 */
@Controller
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(Manager entity, Model model, HttpSession session) {
        Manager loginManager = managerService.login(entity);
        if (!isNull(loginManager)) {
            session.setAttribute("admin",loginManager);
            return toIndexPage(model);
        }
        model.addAttribute("result","账号或密码错误!!!");
        model.addAttribute("manager",entity);
        return admin(model);
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        return "admin/index/login";
    }

    @RequestMapping("/toIndexPage")
    public String toIndexPage(Model model) {
        return "admin/index/index";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session,Model model){
        session.removeAttribute("admin");
        return admin(model);
    }

}
