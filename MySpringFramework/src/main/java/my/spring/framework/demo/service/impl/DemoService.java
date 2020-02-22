package my.spring.framework.demo.service.impl;


import my.spring.framework.framework.annotations.MyService;
import my.spring.framework.demo.service.IDemoService;

@MyService
public class DemoService implements IDemoService {
    public String get(String name) {
        return "My name is " + name;
    }
}
