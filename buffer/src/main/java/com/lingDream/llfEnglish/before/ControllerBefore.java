package com.lingDream.llfEnglish.before;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.lingDream.root.utils.strUtil.StringUtils.get_set;
import static java.util.Objects.isNull;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-25 08:27
 */
@Aspect
@Component
public class ControllerBefore {

    @Around("execution(* com.lingDream.llfEnglish.controller.*.*(..))")
    private Object setEntity(ProceedingJoinPoint pjp) throws Throwable {
        Object entity = getEntity(pjp);
        Class<?> entityClass = entity.getClass();
        Field[] declaredFields = entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Class<?> type = declaredField.getType();
            String packageName = type.getPackage().getName();

            if (entityClass.getPackage().getName().equals(packageName)) {
                Object val = autoSetObInfo(pjp, type);
                String set = get_set(declaredField.getName(), "set");
                Method method = entityClass.getMethod(set, type);
                method.invoke(entity,val);
            }
        }
        pjp.getArgs()[1] = entity;
        return pjp.proceed();
    }

    //region 公用
    private HttpServletRequest getRequest(ProceedingJoinPoint pjp) {
        return (HttpServletRequest) pjp.getArgs()[0];
    }

    private <Entity> Entity getEntity(ProceedingJoinPoint pjp) {
        return (Entity) pjp.getArgs()[1];
    }

    private <Entity> Entity autoSetObInfo(ProceedingJoinPoint pjp, Class<Entity> entityClass)
            throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        HttpServletRequest request = getRequest(pjp);
        Entity entity = entityClass.newInstance();
        Field[] declaredFields = entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Class<?> type = declaredField.getType();
            String name = declaredField.getName();
            String val = request.getParameter(name);
            String set = get_set(name, "set");
            Method method = entityClass.getMethod(set, type);
            if (!isNull(val) && Number.class.isAssignableFrom(type)) {
                Object o = type.getConstructor(String.class).newInstance(val);
                method.invoke(entity, o);
            } else {
                method.invoke(entity, val);
            }
        }
        return entity;
    }
    //endregion
}
