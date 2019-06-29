package my.springframework.service.impl;

import my.springframework.annotations.MyService;
import my.springframework.service.IDemoService;

@MyService
public class DemoService implements IDemoService {
    public String get(String name) {
        return "My name is " + name;
    }
}
