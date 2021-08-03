package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.TagGroup;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.result.ResultCode;
import com.lingDream.llfEnglish.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@RestController
@Controller
@RequestMapping(value = "/wordTagGroup")
public class TagGroupController extends ThereController<TagGroup> {

    public TagGroupController(IService<TagGroup> service) {
        super(service, "单词标签组");
    }

    @PostMapping("/add")
    public Result add(TagGroup tagGroup, @RequestParam(defaultValue = "") String tagGroupParentId) {
        tagGroup.setTagGroupId(null);
        if ((!"".equals(tagGroupParentId)) && Long.parseLong(tagGroupParentId) > Integer.MAX_VALUE)
            tagGroup.setTagGroupParent(new TagGroup().setTagGroupId(tagGroupParentId));
        return super.save(tagGroup);
    }

    @PostMapping("/updateById")
    public Result updateById(TagGroup tagGroup, @RequestParam(defaultValue = "") String tagGroupParentId) {
        if ((!"".equals(tagGroupParentId)) && Long.parseLong(tagGroupParentId) > Integer.MAX_VALUE)
            tagGroup.setTagGroupParent(new TagGroup().setTagGroupId(tagGroupParentId));
        return super.updateById(tagGroup);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(TagGroup tagGroup) {
        return super.removeById(tagGroup.getTagGroupId(), tagGroup);
    }

    @RequestMapping("/list")
    public Result list() {
        return new Result(ResultCode.SUCCESS, service.list());
    }
}
