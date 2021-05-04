package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.TagGroup;
import com.lingDream.root.controller.ControllerImpl;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/tagGroup")
public class TagGroupController extends ControllerImpl<TagGroup> {

    public TagGroupController(MyService<TagGroup> service) {
        super(service, "单词标签组");
    }
}
