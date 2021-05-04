package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.WordType;
import com.lingDream.root.controller.ControllerImpl;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/wordType")
public class WordTypeController extends ControllerImpl<WordType> {

    public WordTypeController(MyService<WordType> service) {
        super(service, "单词类型");
    }
}
