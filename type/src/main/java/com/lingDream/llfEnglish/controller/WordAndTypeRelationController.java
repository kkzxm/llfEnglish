package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.WordAndTypeRelation;
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
@RequestMapping(value = "/wordAndTypeRelation")
public class WordAndTypeRelationController extends LlfEnglishController<WordAndTypeRelation> {

    public WordAndTypeRelationController(MyService<WordAndTypeRelation> service) {
        super(service, "单词与类型关系 → ");
    }

    //endregion

    @Override
    public String add(HttpServletRequest request, WordAndTypeRelation entity, Model model) {
        return super.add(request, entity, model);
    }

    @Override
    public String delById(HttpServletRequest request, WordAndTypeRelation entity) {
        return super.delById(request, entity);
    }

    @Override
    public String updateFindById(HttpServletRequest request, WordAndTypeRelation entity, Model model) {
        return super.updateFindById(request, entity, model);
    }

    @Override
    public String update(HttpServletRequest request, WordAndTypeRelation entity, Model model) {
        return super.update(request, entity, model);
    }
}
