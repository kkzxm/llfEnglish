package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotations.TableId;
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
public class WordType implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer wordTypeId;
    private String wordTypeName;
    private String wordTypeComment;
}
