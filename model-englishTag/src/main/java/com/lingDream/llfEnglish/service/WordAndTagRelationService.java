package com.lingDream.llfEnglish.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingDream.llfEnglish.entity.WordAndTagRelation;
import com.lingDream.llfEnglish.mapper.WordAndTagRelationMapper;
import com.lingDream.llfEnglish.tool.utils.ServiceUtils;
import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class WordAndTagRelationService extends ServiceImpl<WordAndTagRelationMapper, WordAndTagRelation> {
    private final ServiceUtils serviceUtils;

    public WordAndTagRelationService(ServiceUtils serviceUtils) {
        this.serviceUtils = serviceUtils;
    }

    @Override
    public boolean save(WordAndTagRelation entity) {
        entity.setWord(serviceUtils.beforeTheSaveOrUpdate(entity.getWord(), "wordSelf"));
        entity.setWordTag(serviceUtils.beforeTheSaveOrUpdate(entity.getWordTag(), "wordTagName"));
        return super.save(entity);
    }

    @Override
    public boolean updateById(WordAndTagRelation entity) {
        entity.setWord(serviceUtils.beforeTheSaveOrUpdate(entity.getWord(), "wordSelf"));
        entity.setWordTag(serviceUtils.beforeTheSaveOrUpdate(entity.getWordTag(), "wordTagName"));
        return super.updateById(entity);
    }


}
