package com.lingDream.llfEnglish.service;

import com.lingDream.llfEnglish.entity.TagGroup;

import com.lingDream.root.mapper.MyMapper;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class TagGroupService extends MyService<TagGroup>{
    public TagGroupService(MyMapper<TagGroup> baseMapper) {
        super(baseMapper);
    }
}
