package my.spring.framework.framework.aop.support;

import my.spring.framework.framework.aop.MyAopConfig;
import my.spring.framework.framework.aop.aspect.MyMethodAfterAdvice;
import my.spring.framework.framework.aop.aspect.MyMethodAfterThrowingAdvice;
import my.spring.framework.framework.aop.aspect.MyMethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAdvisedSupport {
    private Class targetClass;
    private Object target;
    private Pattern pointCutClassPattern;

    private transient Map<Method, List<Object>> methodCache;

    private MyAopConfig config;

    public MyAdvisedSupport(MyAopConfig config) {
        this.config = config;
    }

    public Class<Object> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Class<Object> targetClass)
            throws Exception {
        System.out.println("Getting Advices from the method cache, or create a new entry in cache");
        List<Object> cached = methodCache.get(method);

        if (cached == null) {
            System.out.println("There is no advices in cache, going to create an entry in the cache.");
            System.out.println("method.getName(): " + method.getName());
            System.out.println("method.getParameterTypes(): " + method.getParameterTypes());

            Method m = targetClass.getMethod(method.getName(), method.getParameterTypes());
            System.out.println("m: " + m.toString());

            cached = methodCache.get(m);
            System.out.println("cached: " + cached.size());

            this.methodCache.put(m, cached);
        }

        return cached;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public boolean pointCutMatch() {
        return pointCutClassPattern.matcher(this.targetClass.toString()).matches();
    }

    public void parse() {
        System.out.println("standardize the Point Cut Match String");
        System.out.println("Original String: " + config.getPointCut());
        String pointCut = config.getPointCut().replaceAll("\\.", "\\\\.")
                .replaceAll("\\\\.\\*", ".*")
                .replaceAll("\\(", "\\\\(")
                .replaceAll("\\)", "\\\\)");
        System.out.println("String after standardization: " + pointCut);

        String pointCutForClass = pointCut.substring(0, pointCut.lastIndexOf("\\(") - 4);

        pointCutClassPattern = Pattern.compile("class "
                + pointCutForClass.substring(pointCutForClass.lastIndexOf(" ")+1));
        System.out.println("pointCutClassPattern: " + pointCutClassPattern.toString());

        methodCache = new HashMap<>();
        Pattern pattern = Pattern.compile(pointCut);

        try {
            Class aspectClass = Class.forName(config.getAspectClass());
            Map<String, Method> aspectMethods = new HashMap<>();
            for (Method m : targetClass.getMethods()) {
                aspectMethods.put(m.getName(),m);
            }

            System.out.println("====================================");
            for (Method m : targetClass.getMethods()) {
                String methodString = m.toString();
                System.out.println("methodString: " + methodString);
                if(methodString.contains("throws")) {
                    methodString = methodString.substring(0,methodString.lastIndexOf("throws")).trim();
                }
                Matcher matcher = pattern.matcher(methodString);
                if(matcher.matches()) {
                    System.out.println("there is a match.");
                    List<Object> advices = new LinkedList<>();

                    if(!(null == config.getAspectBefore() || "".equals(config.getAspectBefore().trim()))) {
                        System.out.println("There is a match of Aspect Before.");
                        advices.add(new MyMethodBeforeAdvice(aspectMethods.get(config.getAspectBefore()),
                                aspectClass.newInstance()));
                    }

                    if(!(null==config.getAspectAfter()||"".equals(config.getAspectAfter().trim()))) {
                        System.out.println("There is a match of Aspect After.");
                        advices.add(new MyMethodAfterAdvice(aspectMethods.get(config.getAspectAfter()),
                                aspectClass.newInstance()));
                    }

                    if(!(null==config.getAspectAfterThrow()||"".equals(config.getAspectAfterThrow().trim()))) {
                        System.out.println("There is a match of Aspect After Throw.");
                        advices.add(new MyMethodAfterThrowingAdvice(aspectMethods.get(config.getAspectAfterThrow()),
                                aspectClass.newInstance()));
                    }

                    methodCache.put(m, advices);
                }

            }
            System.out.println("====================================");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
