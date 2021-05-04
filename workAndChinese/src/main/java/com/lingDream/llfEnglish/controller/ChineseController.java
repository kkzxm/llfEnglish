package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.Chinese;
import com.lingDream.root.controller.ControllerImpl;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/chinese")
public class ChineseController extends ControllerImpl<Chinese> {

    public ChineseController(MyService<Chinese> service) {
        super(service, "中文组词");
    }

}
