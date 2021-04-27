package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.WordTag;
import com.lingDream.llfEnglish.root.LlfEnglishController;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/wordTag")
public class WordTagController extends LlfEnglishController<WordTag> {

    public WordTagController(MyService<WordTag> service) {
        super(service, "单词标签 → ");
    }
}
