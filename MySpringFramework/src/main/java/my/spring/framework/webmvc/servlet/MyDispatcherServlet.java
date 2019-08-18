package my.spring.framework.webmvc.servlet;

import my.spring.framework.framework.annotations.MyController;
import my.spring.framework.framework.annotations.MyRequestMapping;
import my.spring.framework.framework.context.MyApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyDispatcherServlet extends HttpServlet {

    private final String LOCATION = "contextConfigLocation";

    private List<MyHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<MyHandlerMapping, MyHandlerAdapter> handlerAdapters = new HashMap<>();

    private List<MyViewResolver> viewResolvers = new ArrayList<>();

    private MyApplicationContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {


        context = new MyApplicationContext(config.getInitParameter(LOCATION));

        initStrategies(context);

        System.out.println("my spring mvcframework is init");
    }

    private void initStrategies(MyApplicationContext context) {

        // nine strategies
        initMultipartResolver(context);
        initLocaleResolver(context);
        initThemeResolver(context);

        initHandlerMappings(context);
        initHandlerAdapters(context);

        initHandlerExceptionResolvers(context);
        initRequestToViewNameTranslator(context);

        initViewResolvers(context);
        initFlashMapManager(context);


    }

    private void initFlashMapManager(MyApplicationContext context) {

    }

    private void initViewResolvers(MyApplicationContext context) {
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRoorDir = new File(templateRootPath);

        for (File file : templateRoorDir.listFiles()) {
            System.out.println("initViewResolvers: " + file.getName());
            this.viewResolvers.add(new MyViewResolver(templateRoot));
        }

    }

    private void initRequestToViewNameTranslator(MyApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(MyApplicationContext context) {

    }

    private void initHandlerAdapters(MyApplicationContext context) {

        for (MyHandlerMapping handlerMapping : this.handlerMappings) {
            this.handlerAdapters.put(handlerMapping, new MyHandlerAdapter());
        }
    }

    private void initHandlerMappings(MyApplicationContext context) {

        String[] beanNames = context.getBeanDefinitionNames();
        try {
            for (String beanName : beanNames) {
                Object controller = context.getBean(beanName);

                Class<?> clazz = controller.getClass();

                if (!clazz.isAnnotationPresent(MyController.class)) {
                    continue;
                }

                String baseUrl = "";

                if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                    MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);
                    baseUrl = requestMapping.value();
                }

                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                        continue;
                    }

                    MyRequestMapping requestMapping = method.getAnnotation(MyRequestMapping.class);
                    String regex = ("/" + baseUrl + requestMapping.value().replaceAll("\\*", ".*"))
                            .replaceAll("/+", "/");
                    Pattern pattern = Pattern.compile(regex);
                    this.handlerMappings.add(new MyHandlerMapping(pattern, controller, method));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void initThemeResolver(MyApplicationContext context) {

    }

    private void initLocaleResolver(MyApplicationContext context) {

    }

    private void initMultipartResolver(MyApplicationContext context) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("<font size='25' color='blue'>500 Exception</font><br/>Details:<br/>" +
                    Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]", "")
                            .replaceAll("\\s", "\r\n")
                    + "<font color='green'><i>Copyright@Bobby</i></font>");
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("doDispatch is called.");

        MyHandlerMapping handler = getHandler(req);
        if (handler == null) {
            processDispatchResult(req, resp, new MyModelAndView("404"));
            return;
        }

        MyHandlerAdapter ha = getHandlerAdapter(handler);

        MyModelAndView mv = ha.handle(req, resp, handler);

        processDispatchResult(req, resp, mv);

    }

    private MyHandlerAdapter getHandlerAdapter(MyHandlerMapping handler) {
        if (this.handlerAdapters.isEmpty()) {
            return null;
        }
        MyHandlerAdapter ha = this.handlerAdapters.get(handler);
        if (ha.supports(handler)) {
            return ha;
        }

        return null;
    }

    private MyHandlerMapping getHandler(HttpServletRequest req) {

        if (this.handlerMappings.isEmpty()) {
            return null;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");

        for (MyHandlerMapping handlerMapping : handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handlerMapping;
        }

        return null;
    }


    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, MyModelAndView myModelAndView) throws Exception {

        if (null == myModelAndView) {
            return;
        }

        if (this.viewResolvers.isEmpty()) {
            return;
        }

        if (this.viewResolvers != null) {
            System.out.println("viewResolvers size: " + viewResolvers.size());
            for (MyViewResolver viewResolver : this.viewResolvers) {
                System.out.println("myModelAndView getViewName(): " + myModelAndView.getViewName());
                MyView view = viewResolver.resolveViewName(myModelAndView.getViewName(), null);
                if (view != null) {
                    System.out.println("myModelAndView.getModel(): " + myModelAndView.getModel());
                    view.render(myModelAndView.getModel(), req, resp);
                    return;
                }
            }
        }
    }
}
