package com.lingDream.llfEnglish.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingDream.llfEnglish.entity.*;
import com.lingDream.llfEnglish.mapper.WordMapper;
import com.lingDream.llfEnglish.tool.root.ThereMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.lingDream.llfEnglish.tool.utils.SpringBootGetBean.getServiceBean;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Service
public class WordService extends ServiceImpl<WordMapper, Word> {


    @Override
    public <E extends IPage<Word>> E page(E page, Wrapper<Word> queryWrapper) {
        page.setRecords(baseMapper.limitPage(page.offset(), page.getSize()));
        return page;
    }

    @Override
    @Transactional
    public boolean save(Word entity) {
        //先添加英语单词表,可以自动获得Id
        final boolean save = super.save(entity);

        if (save) {
            //添加内部普通的三张表(当save为通过时才会添加这三张表,并得到新list)
            List<Chinese> chineseList = getNewList(entity.getChineseList());
            List<WordType> wordTypeList = getNewList(entity.getWordTypeList());
            List<WordTag> wordTagList = getNewList(entity.getWordTagList());

            final List<WordToChinese> wordToChineseList = new ArrayList<>();
            final List<WordAndTypeRelation> wordToTypeList = new ArrayList<>();
            final List<WordAndTagRelation> wordToTagList = new ArrayList<>();

            chineseList.forEach(chinese -> wordToChineseList.add(new WordToChinese().setWord(entity).setChinese(chinese)));
            wordTypeList.forEach(wordType -> wordToTypeList.add(new WordAndTypeRelation().setWord(entity).setWordType(wordType)));
            wordTagList.forEach(wordTag -> wordToTagList.add(new WordAndTagRelation().setWord(entity).setWordTag(wordTag)));

            //最后来添加三张关系表
            insertList(wordToChineseList);
            insertList(wordToTypeList);
            insertList(wordToTagList);
        }
        return save;
    }

    /**
     * @param list 需要批量新增的元素
     * @param <E>  实体类
     *             <p>
     *             处理异常: list下标越界(0个元素都没有时,)
     *             类转换异常(当前类并不是There <T>类的子类,没有insertList方法)
     */
    private <E> void insertList(List<E> list) {
        if (list.size() > 0)
            getThereMapper(list.get(0)).insertList(list);
    }

    private <E> boolean insertList(ThereMapper<E> thereMapper, List<E> list) {
        return thereMapper.insertList(list) == list.size();
    }

    private <E> ThereMapper<E> getThereMapper(E e) {
        if (e != null) {
            return (ThereMapper<E>) getServiceBean(e.getClass()).getBaseMapper();
        }
        return null;
    }

    /**
     * 处理:中文翻译,单词类型,单词标签三张表的批量增加,唯一列,避免重复
     */
    private <E> List<E> getNewList(List<E> list) {
        final ThereMapper<E> thereMapper = getThereMapper(list.get(0));
        List<E> newList = new ArrayList<>();//最后返回的,存有id值的list
        List<E> removeList = new ArrayList<>();//存储需要从list中删除哪些元素
        for (E e : list) {
            //在之后需要将selectByOnly转移为NoSql
            final E only = thereMapper.selectByOnly(e);
            /*
            如果查询得到结果不为null,
            则说明该值已存在于数据库,
            需要将该值存起,
            并且还需要将该值从参数list中抹去,
            不让它添加到数据库,
            */
            if (only != null) {
                newList.add(only);
                removeList.add(e);
            }
        }
        //查询去重之后,再将两个list合并在一起,此时,已经每个都有id了
        list.removeAll(removeList);
        if (list.size() > 0 && insertList(thereMapper, list)) {
            newList.addAll(list);
        }
        return newList;
    }
}
