package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.WordType;
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
@RequestMapping(value = "/wordType")
public class WordTypeController extends ThereController<WordType> {

    public WordTypeController(IService<WordType> service) {
        super(service, "单词类型");
    }

    @PostMapping("/add")
    public Result add(@RequestBody WordType wordType) {
        return super.save(wordType);
    }

    @PostMapping("/updateById")
    public Result updateById(@RequestBody WordType wordType) {
        return super.updateById(wordType);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(WordType wordType) {
        return super.removeById(wordType.getWordTypeId(), wordType);
    }
}
