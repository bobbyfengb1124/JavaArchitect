package my.spring.framework.demo.action;


import my.spring.framework.framework.annotations.MyAutowired;
import my.spring.framework.framework.annotations.MyController;
import my.spring.framework.framework.annotations.MyRequestMapping;
import my.spring.framework.framework.annotations.MyRequestParam;
import my.spring.framework.demo.service.IModifyService;
import my.spring.framework.demo.service.IQueryService;
import my.spring.framework.webmvc.servlet.MyModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MyController
@MyRequestMapping("/demo/web")
public class DemoAction {
    @MyAutowired
    private IQueryService queryService;
    @MyAutowired
    private IModifyService modifyService;

    @MyRequestMapping("/query.json")
    public MyModelAndView query(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("name") String name) {
        String result = queryService.query(name);
        System.out.println("Result : " + result);
        return out(resp, result);
    }


    @MyRequestMapping("/add*.json")
    public MyModelAndView add(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("name") String name, @MyRequestParam("addr") String addr) throws Exception {

        String result = modifyService.add(name, addr);
        return out(resp, result);
    }

    @MyRequestMapping("/remove.json")
    public MyModelAndView remove(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("id") Integer id) {

        String result = modifyService.remove(id);
        return out(resp, result);
    }

    @MyRequestMapping("/edit.json")
    public MyModelAndView edit(HttpServletRequest req, HttpServletResponse resp,
                               @MyRequestParam("id") Integer id, @MyRequestParam("name") String name) {

        String result = modifyService.edit(id, name);
        return out(resp, result);
    }

    private MyModelAndView out(HttpServletResponse resp, String result) {

        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
