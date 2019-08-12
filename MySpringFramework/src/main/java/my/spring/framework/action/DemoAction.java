package my.spring.framework.action;


import my.spring.framework.framework.annotations.MyAutowired;
import my.spring.framework.framework.annotations.MyController;
import my.spring.framework.framework.annotations.MyRequestMapping;
import my.spring.framework.framework.annotations.MyRequestParam;
import my.spring.framework.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MyController
@MyRequestMapping("/demo")
public class DemoAction {
    @MyAutowired
    private IDemoService demoService;

    @MyRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("name") String name) {
//        String result = demoService.get(name);
        String result = "My name is " + name;
        System.out.println("Result : " + result);
        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MyRequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("a") Integer a, @MyRequestParam("b") Integer b) {
        try {
            resp.getWriter().write(a + "+" + b + "=" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MyRequestMapping("/remove")
    public void remove(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("id") Integer id) {

    }
}
