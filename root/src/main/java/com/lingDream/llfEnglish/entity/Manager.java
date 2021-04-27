package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-26 13:26
 */
@Data
@Accessors(chain = true)
public class Manager {
    @TableId(type = IdType.AUTO)
    private Integer managerId;
    private String accountNumber;
    private String managerPassword;
}
