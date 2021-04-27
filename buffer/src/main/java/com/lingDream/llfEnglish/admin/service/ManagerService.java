package com.lingDream.llfEnglish.admin.service;

import com.lingDream.llfEnglish.entity.Manager;
import com.lingDream.llfEnglish.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-26 13:33
 */
@Service
public class ManagerService {
    private final ManagerMapper managerMapper;

    public ManagerService(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    public Manager login(Manager entity) {
        return managerMapper.login(entity);
    }
}
