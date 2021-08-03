package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.Chinese;
import com.lingDream.llfEnglish.entity.Word;
import com.lingDream.llfEnglish.entity.WordToChinese;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@RestController
@Controller
@RequestMapping(value = "/wordToChinese")
public class WordToChineseController extends ThereController<WordToChinese> {

    public WordToChineseController(IService<WordToChinese> service) {
        super(service, "中英互译关系");
    }

    @PostMapping("/add")
    public Result add(Word word, Chinese chinese, String wordToChineseComment) {
        final WordToChinese wordToChinese = new WordToChinese()
                .setWord(word)
                .setChinese(chinese)
                .setWordToChineseComment(wordToChineseComment);
        return super.save(wordToChinese);
    }

    @PostMapping("updateById")
    public Result updateById(Word word, Chinese chinese, String wordToChineseComment) {
        final WordToChinese wordToChinese = new WordToChinese()
                .setWord(word)
                .setChinese(chinese)
                .setWordToChineseComment(wordToChineseComment);
        return super.updateById(wordToChinese);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(Word word, Chinese chinese) {
        WordToChinese wordToChinese = new WordToChinese().setWord(word).setChinese(chinese);
        return super.removeById(wordToChinese, wordToChinese);
    }
}
