package my.spring.framework.webmvc.servlet;

import java.io.File;
import java.util.Locale;

public class MyViewResolver {
    private final String DEFAULT_TEMPLATE_SUFFIX = ".html";

    private File templateRootDir;

    private String viewName;

    public MyViewResolver() {
    }

    public MyViewResolver(String templateRoot) {

        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        System.out.println("MyViewResolver templateRootPath: " + templateRootPath);
        this.templateRootDir = new File(templateRootPath);
    }

    public MyView resolveViewName(String viewName, Locale locale) throws Exception {

        this.viewName = viewName;
        if (null == viewName || "".equals(viewName.trim())) {
            return null;
        }
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFIX);
        System.out.println("viewName: " + viewName);
        File templateFile = new File((templateRootDir.getPath() + "/" + viewName).replaceAll("/+", "/"));

        return new MyView(templateFile);
    }

    public String getViewName() {
        return viewName;
    }
}
