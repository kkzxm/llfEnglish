package com.lingDream.llfEnglish.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingDream.llfEnglish.entity.WordAndTypeRelation;
import com.lingDream.llfEnglish.mapper.WordAndTypeRelationMapper;
import com.lingDream.llfEnglish.tool.utils.ServiceUtils;
import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class WordAndTypeRelationService extends ServiceImpl<WordAndTypeRelationMapper, WordAndTypeRelation> {

    private final ServiceUtils serviceUtils;

    public WordAndTypeRelationService(ServiceUtils serviceUtils) {
        this.serviceUtils = serviceUtils;
    }

    @Override
    public boolean save(WordAndTypeRelation entity) {
        entity.setWord(serviceUtils.beforeTheSaveOrUpdate(entity.getWord(), "wordSelf"));
        entity.setWordType(serviceUtils.beforeTheSaveOrUpdate(entity.getWordType(), "wordTypeName"));
        return super.save(entity);
    }

    @Override
    public boolean updateById(WordAndTypeRelation entity) {
        entity.setWord(serviceUtils.beforeTheSaveOrUpdate(entity.getWord(), "wordSelf"));
        entity.setWordType(serviceUtils.beforeTheSaveOrUpdate(entity.getWordType(), "wordTypeName"));
        return super.updateById(entity);
    }
}
