package my.spring.framework.demo.action;

import my.spring.framework.framework.annotations.MyAutowired;
import my.spring.framework.framework.annotations.MyController;
import my.spring.framework.framework.annotations.MyRequestMapping;
import my.spring.framework.framework.annotations.MyRequestParam;
import my.spring.framework.demo.service.IQueryService;
import my.spring.framework.webmvc.servlet.MyModelAndView;

import java.util.HashMap;
import java.util.Map;

@MyController
@MyRequestMapping("/demo")
public class PageAction {

    @MyAutowired
    IQueryService queryService;

    @MyRequestMapping("/first.html")
    public MyModelAndView query(@MyRequestParam("teacher") String teacher) {

        String result = queryService.query(teacher);
        Map<String, Object> model = new HashMap<>();
        model.put("teacher", teacher);
        model.put("data", result);
        model.put("token", "123456");
        return new MyModelAndView("first.html", model);
    }

}
