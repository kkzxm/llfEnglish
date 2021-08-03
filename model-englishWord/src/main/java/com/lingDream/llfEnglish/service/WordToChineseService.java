package com.lingDream.llfEnglish.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingDream.llfEnglish.entity.WordToChinese;
import com.lingDream.llfEnglish.tool.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class WordToChineseService extends ServiceImpl<BaseMapper<WordToChinese>, WordToChinese> {
    private final ServiceUtils serviceUtils;

    public WordToChineseService(ServiceUtils serviceUtils) {
        this.serviceUtils = serviceUtils;
    }

    @Override
    public boolean save(WordToChinese entity) {
        entity.setWord(serviceUtils.beforeTheSaveOrUpdate(entity.getWord(), "wordSelf"));
        entity.setChinese(serviceUtils.beforeTheSaveOrUpdate(entity.getChinese(), "chineseInfo"));
        return super.save(entity);
    }

    @Override
    public boolean updateById(WordToChinese entity) {
        entity.setWord(serviceUtils.beforeTheSaveOrUpdate(entity.getWord(), "wordSelf"));
        entity.setChinese(serviceUtils.beforeTheSaveOrUpdate(entity.getChinese(), "chineseInfo"));
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
