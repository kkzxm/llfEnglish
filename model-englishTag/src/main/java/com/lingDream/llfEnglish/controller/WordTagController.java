package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.TagGroup;
import com.lingDream.llfEnglish.entity.WordTag;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@RestController
@Controller
@RequestMapping(value = "/wordTag")
public class WordTagController extends ThereController<WordTag> {

    public WordTagController(IService<WordTag> service) {
        super(service, "单词标签");
    }

    @PostMapping("/add")
    public Result add(WordTag wordTag, @RequestParam(defaultValue = "") String tagGroupId) {
        if (!"".equals(tagGroupId)) {
            wordTag.setTagGroup(new TagGroup().setTagGroupId(tagGroupId));
        }
        return super.save(wordTag);
    }

    @PostMapping("/updateById")
    public Result updateById(WordTag wordTag, @RequestParam(defaultValue = "") String tagGroupId) {
        if (!"".equals(tagGroupId)) {
            wordTag.setTagGroup(new TagGroup().setTagGroupId(tagGroupId));
        }
        return super.updateById(wordTag);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(String wordTagId) {
        System.out.println(wordTagId);
        return super.removeById(wordTagId, null);
    }
}
