package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.WordAndTagRelation;
import com.lingDream.root.controller.ControllerImpl;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/wordAndTagRelation")
public class WordAndTagRelationController extends ControllerImpl<WordAndTagRelation> {

    public WordAndTagRelationController(MyService<WordAndTagRelation> service) {
        super(service, "单词与标签关系");
    }
}
