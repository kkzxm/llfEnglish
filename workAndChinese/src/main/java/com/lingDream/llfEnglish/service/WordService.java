package com.lingDream.llfEnglish.service;

import com.lingDream.llfEnglish.entity.Word;
import com.lingDream.llfEnglish.entity.WordAndTagRelation;
import com.lingDream.llfEnglish.entity.WordAndTypeRelation;
import com.lingDream.llfEnglish.entity.WordToChinese;
import com.lingDream.root.mapper.MyMapper;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class WordService extends MyService<Word> {
    private final MyMapper<WordToChinese> wordToChineseMyMapper;
    private final MyMapper<WordAndTypeRelation> wordAndTypeRelationMyMapper;
    private final MyMapper<WordAndTagRelation> wordAndTagRelationMyMapper;

    public WordService(MyMapper<Word> baseMapper,
                       MyMapper<WordToChinese> wordToChineseMyMapper,
                       MyMapper<WordAndTypeRelation> wordAndTypeRelationMyMapper,
                       MyMapper<WordAndTagRelation> wordAndTagRelationMyMapper) {
        super(baseMapper);
        this.wordToChineseMyMapper = wordToChineseMyMapper;
        this.wordAndTypeRelationMyMapper = wordAndTypeRelationMyMapper;
        this.wordAndTagRelationMyMapper = wordAndTagRelationMyMapper;
    }

    @Override
    public boolean deleteById(Serializable oldWord) {
        Word word = (Word) oldWord;

        wordToChineseMyMapper.deleteById(new WordToChinese().setWord(word));
        wordAndTypeRelationMyMapper.deleteById(new WordAndTypeRelation().setWord(word));
        wordAndTagRelationMyMapper.deleteById(new WordAndTagRelation().setWord(word));

        return super.deleteById(oldWord);
    }
}
