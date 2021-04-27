package com.lingDream.llfEnglish.service;

import com.lingDream.llfEnglish.entity.Chinese;
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
public class ChineseService extends MyService<Chinese>{
    private final MyMapper<WordToChinese> wordToChineseMyMapper;

    public ChineseService(MyMapper<Chinese> baseMapper,
                          MyMapper<WordToChinese> wordToChineseMyMapper) {
        super(baseMapper);
        this.wordToChineseMyMapper = wordToChineseMyMapper;
    }

    @Override
    public boolean deleteById(Serializable oldChinese) {
        Chinese chinese = (Chinese) oldChinese;
        wordToChineseMyMapper.deleteById(new WordToChinese().setChinese(chinese));
        return super.deleteById(oldChinese);
    }
}
