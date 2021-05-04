package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.Word;
import com.lingDream.root.controller.ControllerImpl;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/word")
public class WordController extends ControllerImpl<Word> {

    public WordController(MyService<Word> service) {
        super(service, "英语单词");
    }

}
