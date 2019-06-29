package my.springframework.action;

import my.springframework.annotations.MyAutowired;
import my.springframework.annotations.MyController;
import my.springframework.annotations.MyRequestMapping;
import my.springframework.annotations.MyRequestParam;
import my.springframework.service.IDemoService;

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
