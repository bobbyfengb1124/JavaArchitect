package my.spring.framework.webmvc.servlet;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class MyHandlerMapping {

    private Object controller;
    private Method method;
    private Pattern pattern;

    public MyHandlerMapping() {
    }

    public MyHandlerMapping(Pattern pattern, Object controller, Method method) {

        this.controller = controller;
        this.pattern = pattern;
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
