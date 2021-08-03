package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.Word;
import com.lingDream.llfEnglish.entity.WordAndTypeRelation;
import com.lingDream.llfEnglish.entity.WordType;
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
@RequestMapping(value = "/wordToType")
public class WordAndTypeRelationController extends ThereController<WordAndTypeRelation> {

    public WordAndTypeRelationController(IService<WordAndTypeRelation> service) {
        super(service, "单词与类型关系");
    }

    @PostMapping("/add")
    public Result add(Word word, WordType wordType, String wordAndTypeComment) {
        final WordAndTypeRelation wordAndTypeRelation = new WordAndTypeRelation()
                .setWord(word)
                .setWordType(wordType)
                .setWordAndTypeComment(wordAndTypeComment);
        return super.save(wordAndTypeRelation);
    }

    @DeleteMapping("deleteById")
    public Result deleteById(Word word, WordType wordType) {
        final WordAndTypeRelation wordAndTypeRelation = new WordAndTypeRelation()
                .setWord(word)
                .setWordType(wordType);
        return super.removeById(wordAndTypeRelation, wordAndTypeRelation);
    }

    @PostMapping("updateById")
    public Result updateById(Word word, WordType wordType, String wordAndTypeComment) {
        final WordAndTypeRelation wordAndTypeRelation = new WordAndTypeRelation()
                .setWord(word)
                .setWordType(wordType)
                .setWordAndTypeComment(wordAndTypeComment);
        return super.updateById(wordAndTypeRelation);
    }


}
