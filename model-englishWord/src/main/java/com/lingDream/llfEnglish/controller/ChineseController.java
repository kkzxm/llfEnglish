package com.lingDream.llfEnglish.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.entity.Chinese;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Controller
@RestController
@RequestMapping(value = "/chinese")
public class ChineseController extends ThereController<Chinese> {

    public ChineseController(IService<Chinese> service) {
        super(service, "中文词组");
    }

    @PostMapping("/add")
    public Result add(@RequestBody Chinese chinese) {
        return super.save(chinese);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(Chinese chinese) {
        return super.removeById(chinese.getChineseId(), chinese);
    }

    @PostMapping("/updateById")
    public Result updateById(@RequestBody Chinese chinese) {
        return super.updateById(chinese);
    }

}
