package com.lingDream.llfEnglish.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingDream.llfEnglish.entity.TagGroup;
import com.lingDream.llfEnglish.mapper.TagGroupMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class TagGroupService extends ServiceImpl<TagGroupMapper, TagGroup> {

    @Override
    public List<TagGroup> list() {
        final List<TagGroup> list = super.list();//从数据库查到的所有标签组
        List<TagGroup> rootTagGroup = new ArrayList<>();//树形整理过的标签组
        for (TagGroup tagGroup : list) {
            final TagGroup tagGroupParent = tagGroup.getTagGroupParent();
            //如果它没有父级,或者父级等于它本身,就说明它是顶级的(如果是三个或以上单词标签组组成循环依赖,等着改数据库吧)
            if (tagGroupParent == null || tagGroup.getTagGroupId().equals(tagGroupParent.getTagGroupId())) {
                rootTagGroup.add(tagGroup);
            } else {
                //如果它有父级,那就需要去找到它的父级,交将它装到它的父级list中,
                TagGroup parentGroup = getTagGroupById(list, tagGroupParent);
                if (parentGroup != null) {
                    parentGroup.addChild(tagGroup);
                }
            }
        }
        return rootTagGroup;
    }

    private TagGroup getTagGroupById(List<TagGroup> tagGroupList, TagGroup tagGroup) {
        for (TagGroup group : tagGroupList) {
            if (group.equals(tagGroup)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public <E extends IPage<TagGroup>> E page(E page, Wrapper<TagGroup> queryWrapper) {
        page.setRecords(list());
        return page;
    }
}
