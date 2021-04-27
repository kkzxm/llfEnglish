package com.lingDream.llfEnglish.service;

import com.lingDream.llfEnglish.entity.WordAndTypeRelation;
import com.lingDream.llfEnglish.entity.WordType;
import com.lingDream.root.mapper.MyMapper;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class WordTypeService extends MyService<WordType> {
    private final MyMapper<WordAndTypeRelation> wordAndTypeRelationMyMapper;
    public WordTypeService(MyMapper<WordType> baseMapper,
                           MyMapper<WordAndTypeRelation> wordAndTypeRelationMyMapper) {
        super(baseMapper);
        this.wordAndTypeRelationMyMapper = wordAndTypeRelationMyMapper;
    }

    @Override
    public boolean deleteById(Serializable oldWordType) {
        wordAndTypeRelationMyMapper.deleteById(new WordAndTypeRelation().setWordType((WordType) oldWordType));
        return super.deleteById(oldWordType);
    }
}
