package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Data
@Accessors(chain = true)
@TableName(value = "word_tag_info",resultMap = "wordTag")
public class WordTag implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer wordTagId;
    private String wordTagName;
    private String tagComment;
    private TagGroup tagGroup;
}
