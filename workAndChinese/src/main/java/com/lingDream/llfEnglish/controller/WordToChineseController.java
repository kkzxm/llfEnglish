package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.WordToChinese;
import com.lingDream.root.controller.ControllerImpl;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/wordToChinese")
public class WordToChineseController extends ControllerImpl<WordToChinese> {
    public WordToChineseController(MyService<WordToChinese> service) {
        super(service, "中英关系");
    }

}
