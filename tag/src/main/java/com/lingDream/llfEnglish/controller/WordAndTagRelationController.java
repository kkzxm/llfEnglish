package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.WordAndTagRelation;
import com.lingDream.llfEnglish.root.LlfEnglishController;
import com.lingDream.root.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RequestMapping(value = "/wordAndTagRelation")
public class WordAndTagRelationController extends LlfEnglishController<WordAndTagRelation> {

    public WordAndTagRelationController(MyService<WordAndTagRelation> service) {
        super(service, "单词与标签关系 → ");
    }

    @Override
    public String add(HttpServletRequest request, WordAndTagRelation entity, Model model) {
        return super.add(request, entity, model);
    }

    @Override
    public String delById(HttpServletRequest request, WordAndTagRelation entity) {
        return super.delById(request, entity);
    }

    @Override
    public String updateFindById(HttpServletRequest request, WordAndTagRelation entity, Model model) {
        return super.updateFindById(request, entity, model);
    }

    @Override
    public String update(HttpServletRequest request, WordAndTagRelation entity, Model model) {
        return super.update(request, entity, model);
    }
}
