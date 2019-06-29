package my.springframework.service;

import my.springframework.annotations.MyService;

@MyService
public interface IDemoService {
    String get(String name);
}
