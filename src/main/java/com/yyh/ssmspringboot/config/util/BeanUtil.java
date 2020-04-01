package com.yyh.ssmspringboot.config.util;

import com.yyh.ssmspringboot.config.result.ResponseResult;
import com.yyh.ssmspringboot.config.result.ResponseResults;
import com.yyh.ssmspringboot.config.validate.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 对象属性拷贝工具
 *
 * @author zhangquanli
 */
public class BeanUtil {

    /**
     * 拷贝源对象中的属性到目标对象
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        PropertyDescriptor[] targetPds = getPropertyDescriptors(target.getClass());
        for (PropertyDescriptor targetPd : targetPds) {
            if ("class".equals(targetPd.getName())) {
                continue;
            }
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd == null) {
                    continue;
                }
                Method readMethod = sourcePd.getReadMethod();
                if (readMethod != null) {
                    try {
                        Object invoke = readMethod.invoke(source);
                        if (invoke != null) {
                            writeMethod.invoke(target, invoke);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    }
                }
            }
        }
    }

    /**
     * 创建目标对象，并复制源对象中的属性
     *
     * @param source      源对象
     * @param targetClass 目标对象类型
     * @param <T>         泛型
     * @return 目标对象
     */
    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.newInstance();
            PropertyDescriptor[] targetPds = getPropertyDescriptors(targetClass);
            for (PropertyDescriptor targetPd : targetPds) {
                if ("class".equals(targetPd.getName())) {
                    continue;
                }
                Method writeMethod = targetPd.getWriteMethod();
                if (writeMethod != null) {
                    PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                    if (sourcePd == null) {
                        continue;
                    }
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null) {
                        Object invoke = readMethod.invoke(source);
                        if (invoke != null) {
                            writeMethod.invoke(target, invoke);
                        }
                    }
                }
            }
            return target;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) {
        try {
            return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            return new PropertyDescriptor[0];
        }
    }

    private static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {
        try {
            return new PropertyDescriptor(propertyName, clazz);
        } catch (IntrospectionException e) {
            return null;
        }
    }

    /**
     * 在service层实现对象的参数校验
     *
     * @param object 校验对象
     * @return ResponseResult 响应信息
     */
    public static ResponseResult validateParam(Object object) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(object, Insert.class, Update.class);
        List<String> list = new ArrayList<>();
        for (ConstraintViolation<Object> constraintViolation : set) {
            list.add(constraintViolation.getPropertyPath() + constraintViolation.getMessage());
        }
        if (list.size() > 0) {
            return ResponseResults.failure("传入的对象参数出现异常", list);
        }
        return ResponseResults.success();
    }

    /**
     * String字符串转成List<Long>数据格式
     * String str = "1,2,3,4,5,6" -> List<Long> listLong [1,2,3,4,5,6];
     *
     * @param strArr
     * @return
     */
    public static List<Long> stringToLongList(String strArr) {
        return Arrays.stream((strArr.split(",")))
                .map(str -> Long.parseLong(str.trim()))
                .collect(Collectors.toList());
    }

}
