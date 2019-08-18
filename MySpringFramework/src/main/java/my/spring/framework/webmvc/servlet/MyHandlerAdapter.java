package my.spring.framework.webmvc.servlet;

import my.spring.framework.framework.annotations.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyHandlerAdapter {
    public MyModelAndView handle(HttpServletRequest req, HttpServletResponse resp, MyHandlerMapping handler) throws Exception {
        MyHandlerMapping handlerMapping = handler;

        Map<String, Integer> paramMapping = new HashMap<>();

        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation a : pa[i]) {
                if (a instanceof MyRequestParam) {
                    String paramName = ((MyRequestParam) a).value();
                    if (!"".equals(paramName.trim())) {
                        paramMapping.put(paramName, i);
                    }
                }
            }
        }

        Class<?>[] paramTypes = handlerMapping.getMethod().getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> type = paramTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                paramMapping.put(type.getName(), i);
            }
        }

        Map<String, String[]> reqParameterMap = req.getParameterMap();

        Object[] paramValues = new Object[paramTypes.length];

        for (Map.Entry<String, String[]> param : reqParameterMap.entrySet()) {
            String value = Arrays.
                    toString(param.getValue()).
                    replaceAll("\\[|\\]", "").
                    replaceAll("\\s", "");

            if (!paramMapping.containsKey(param.getKey())) {
                continue;
            }

            int index = paramMapping.get(param.getKey());

            paramValues[index] = caseStringValue(value, paramTypes[index]);
        }

        if (paramMapping.containsKey(HttpServletRequest.class.getName())) {
            int reqIndex = paramMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = req;
        }

        if (paramMapping.containsKey(HttpServletResponse.class.getName())) {
            int respIndex = paramMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] = resp;
        }

        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);
        if (result == null) {
            return null;
        }

        boolean isModelAndView = handlerMapping.getMethod().getReturnType() == MyModelAndView.class;
        if (isModelAndView) {
            return (MyModelAndView) result;
        } else {
            return null;
        }
    }

    private Object caseStringValue(String value, Class<?> paramType) {
        if (paramType == String.class) {
            return value;
        } else if (paramType == Integer.class) {
            return Integer.valueOf(value);
        } else if (paramType == int.class) {
            return Integer.valueOf(value).intValue();
        } else {
            return null;
        }
    }

    public boolean supports(MyHandlerMapping handler) {
        return (handler instanceof MyHandlerMapping);
    }
}
