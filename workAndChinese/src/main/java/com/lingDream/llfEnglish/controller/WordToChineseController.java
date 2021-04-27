package com.lingDream.llfEnglish.controller;

import com.lingDream.llfEnglish.entity.WordToChinese;
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
@RequestMapping(value = "/wordToChinese")
public class WordToChineseController extends LlfEnglishController<WordToChinese> {

    public WordToChineseController(MyService<WordToChinese> service) {
        super(service, "中英关系 → ");
    }

    //endregion

    @Override
    public String add(HttpServletRequest request, WordToChinese entity, Model model) {
        return super.add(request,entity, model);
    }

    @Override
    public String delById(HttpServletRequest request, WordToChinese entity) {
        return super.delById(request, entity);
    }

    @Override
    public String updateFindById(HttpServletRequest request, WordToChinese entity, Model model) {
        return super.updateFindById(request, entity, model);
    }

    @Override
    public String update(HttpServletRequest request, WordToChinese entity, Model model) {
        return super.update(request, entity, model);
    }
}
