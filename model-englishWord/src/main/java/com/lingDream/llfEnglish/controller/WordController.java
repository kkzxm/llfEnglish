package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.Word;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RestController
@RequestMapping(value = "/word")
public class WordController extends ThereController<Word> {

    public WordController(IService<Word> service) {
        super(service, "英语单词");
    }

    @PostMapping("/add")
    public Result add(@RequestBody Word word) {
        return super.save(word);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(String wordId) {
        return super.removeById(wordId, new Word().setWordId(wordId));
    }

    @PostMapping("updateById")
    protected Result updateById(@RequestBody Word word) {
        return super.updateById(word);
    }
}
