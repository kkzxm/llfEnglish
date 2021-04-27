package com.lingDream.llfEnglish.root;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lingDream.root.controller.MyController;
import com.lingDream.root.service.MyService;
import com.lingDream.root.tool.MyPage;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

import static com.lingDream.root.utils.strUtil.StringUtils.lowFirstChar;
import static java.util.Objects.isNull;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-07 09:34
 */
public abstract class LlfEnglishController<T> extends MyController<T> implements BaseController<T> {

    public LlfEnglishController(MyService<T> service, String COMMENT) {
        super(service, COMMENT);
    }

    //region RequestMapping

    //region getPage
    @Override
    public String getPage(Model model, String val, String filter, Integer thisPage) {
        return setThisPageInData(model, val, filter, thisPage);
    }

    //region 相关方法

    //region 分页时需要的信息

    /**
     * 设置数据显示页面需要用的数据,
     * 如果有模糊查询,
     *
     * @param model    模型数据
     * @param val      模糊查询时的值 可以为null
     * @param filter   模糊查询数据库表名 可以为null
     * @param thisPage 当前页
     * @return 前端显示查询结果的页面路径
     */
    protected String setThisPageInData(Model model, String val, String filter, Integer thisPage) {
        if (thisPage == null) thisPage = 1;
        Wrapper<T> wrapper = getWrapper(val, filter);
        MyPage<T> myPage = super.getMyPage(thisPage, 10, wrapper);
        model.addAttribute("page", myPage);

        setPageTitleAndPartAddress(model, val, filter);

        return "admin/index/list";
    }

    /**
     * 设置页面标题,和页面零件地址
     */
    private void setPageTitleAndPartAddress(Model model, String val, String filter) {
        setTitle(model);

        String partAddress = this.getClass().getSimpleName();
        partAddress = lowFirstChar(partAddress.substring(0, partAddress.length() - 10));
        model.addAttribute("partAddress", partAddress);

        /*
        分页时用到的地址
        */
        String limitPath = partAddress + "/getPage?";
        if (!isNull(val)) limitPath += "val=" + val + "&";
        if (!isNull(filter)) limitPath += "filter=" + filter + "&";
        limitPath += "thisPage";
        model.addAttribute("limitPath", limitPath);

        /*
         * 某些组件是否输出
         */
        model.addAttribute("showPart", true);
    }
    //endregion

    /**
     * <pre>
     *      此方法作为拼接条件构造器,
     * 模糊查询或查询分页时,
     * 通过登录的班级账号(管理员)信息,
     * 过滤掉与本班级无关的信息
     * (如果是超级管理员登录,则无视过滤,查询出全部),
     *
     *
     * </pre>
     *
     * @param val     模糊查询时的值
     * @param filter  糊糊查询用的数据库字段名
     * @return 拼接出的条件构造器
     */
    private Wrapper<T> getWrapper(String val, String filter) {
        Wrapper<T> wrapper = new EntityWrapper<>();
        wrapper.like(filter, val);
        return wrapper;
    }
    //endregion

    //endregion

    //region toInsertPage
    @Override
    public String toInsertPage(Model model) {
        return setToInsertPage(model);
    }

    //region 去到添加页面
    public String setToInsertPage(Model model) {
        setPath(model);
        setTitle(model);

        String partAddress = this.getClass().getSimpleName();
        partAddress = partAddress.substring(0, partAddress.length() - 10);
        model.addAttribute("partAddress", lowFirstChar(partAddress));

        return "admin/index/insert";
    }

    /**
     * 设置路径(添加/修改),
     * 此方法应该放在子类toInsertPage的第一行
     */
    protected void setPath(Model model) {
        String path = model.asMap().size() == 0 ? "add" : "update";
        model.addAttribute("path", path);
    }
    //endregion

    //endregion

    //region add

    @Override
    public String add(HttpServletRequest request,T entity, Model model) {
        super.setRequestURL(request, model);
        model.addAttribute("result",COMMENT + "添加成功");
        if (!service.insert(entity)) {
            model.addAttribute("result",COMMENT+"添加失败");
        }
        return "admin/adminPublic/addResult";
    }
    //endregion

    //region del
    @Override
    public String delById(HttpServletRequest request,T entity){
        if (service.deleteById((Serializable) entity)) {
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    //endregion

    //region updateFindById
    @Override
    public String updateFindById(HttpServletRequest request,T entity,Model model) {
        T t = service.selectById((Serializable) entity);
        model.addAttribute("entity",t);
        return toInsertPage(model);
    }
    //endregion

    //region update
    @Override
    public String update(HttpServletRequest request, T entity, Model model) {
        super.setRequestURL(request, model);
        model.addAttribute("result",COMMENT + "修改成功");
        if (!service.updateById(entity)) {
            model.addAttribute("result",COMMENT+"修改失败");
        }
        return "admin/adminPublic/addResult";
    }
    //endregion
    //endregion

    //region 公用
    /**
     * 设置共用的标题
     */
    private void setTitle(Model model){
        String substring = COMMENT.substring(0, COMMENT.indexOf(" →"));
        model.addAttribute("title", substring);
    }
    //endregion
}
