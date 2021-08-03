package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.Word;
import com.lingDream.llfEnglish.entity.WordAndTagRelation;
import com.lingDream.llfEnglish.entity.WordTag;
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
@RequestMapping(value = "/wordToTag")
public class WordAndTagRelationController extends ThereController<WordAndTagRelation> {

    public WordAndTagRelationController(IService<WordAndTagRelation> service) {
        super(service, "单词与标签关系");
    }

    @PostMapping("/add")
    public Result add(Word word, WordTag wordTag, String wordAndTagComment) {
        final WordAndTagRelation wordAndTagRelation = new WordAndTagRelation()
                .setWord(word)
                .setWordTag(wordTag)
                .setWordAndTagComment(wordAndTagComment);
        return super.save(wordAndTagRelation);
    }

    @PostMapping("/updateById")
    public Result updateById(Word word, WordTag wordTag, String wordAndTagComment) {
        final WordAndTagRelation wordAndTagRelation = new WordAndTagRelation()
                .setWord(word)
                .setWordTag(wordTag)
                .setWordAndTagComment(wordAndTagComment);
        return super.updateById(wordAndTagRelation);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(Word word, WordTag wordTag) {
        final WordAndTagRelation wordAndTagRelation = new WordAndTagRelation()
                .setWord(word)
                .setWordTag(wordTag);
        return super.removeById(wordAndTagRelation, wordAndTagRelation);
    }

}
