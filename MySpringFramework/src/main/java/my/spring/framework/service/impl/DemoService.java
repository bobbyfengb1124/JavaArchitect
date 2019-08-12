package my.spring.framework.service.impl;


import my.spring.framework.framework.annotations.MyService;
import my.spring.framework.service.IDemoService;

@MyService
public class DemoService implements IDemoService {
    public String get(String name) {
        return "My name is " + name;
    }
}
