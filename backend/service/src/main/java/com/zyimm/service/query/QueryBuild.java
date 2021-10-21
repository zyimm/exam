package com.zyimm.service.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author zyimm
 */
public class QueryBuild<T, K> {

    /**
     * 构建query
     * 
     * @param queryWrapper
     * @param map          查询map
     * @param request
     * @return QueryWrapper<T>
     */
    public QueryWrapper<T> buildQuery(QueryWrapper<T> queryWrapper, Map<String, String> map, K request) {
        map.forEach((key, val) -> {
            try {
                List<String> methodArray = List.of(val.split("@"));
                // 反射获取
                Method requestMethod = request.getClass().getMethod(methodArray.get(1));
                Type returnType = requestMethod.getReturnType();
                // 反射调用
                Object requestVal = requestMethod.invoke(request);
                Object requestValue = null;
                String typeName = returnType.getTypeName();
                switch (typeName) {
                    case "java.lang.String":
                        requestValue = String.valueOf(requestVal);
                        break;
                    case "java.lang.Integer":
                        requestValue = requestVal;
                        break;
                    default:
                }
                if (requestValue != null) {
                    Method m = queryWrapper.getClass().getMethod(key, Object.class, Object.class);
                    m.invoke(queryWrapper, methodArray.get(0), requestValue);
                }

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.getMessage();
            }
        });
        return queryWrapper;
    }

}
