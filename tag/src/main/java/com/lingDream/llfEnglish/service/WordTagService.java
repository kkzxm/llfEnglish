package com.lingDream.llfEnglish.service;

import com.lingDream.llfEnglish.entity.WordAndTagRelation;
import com.lingDream.llfEnglish.entity.WordTag;
import com.lingDream.root.mapper.MyMapper;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class WordTagService extends MyService<WordTag>{
    private final MyMapper<WordAndTagRelation> wordAndTagRelationMyMapper;

    public WordTagService(MyMapper<WordTag> baseMapper,
                          MyMapper<WordAndTagRelation> wordAndTagRelationMyMapper) {
        super(baseMapper);
        this.wordAndTagRelationMyMapper = wordAndTagRelationMyMapper;
    }

    @Override
    public boolean deleteById(Serializable oldWordTag) {
        WordTag wordTag = (WordTag) oldWordTag;
        wordAndTagRelationMyMapper.deleteById(new WordAndTagRelation().setWordTag(wordTag));
        return super.deleteById(oldWordTag);
    }
}
