package my.spring.framework.demo.service.impl;

import my.spring.framework.framework.annotations.MyService;
import my.spring.framework.demo.service.IModifyService;

@MyService
public class ModifyService implements IModifyService {
    @Override
    public String add(String name, String addr) throws Exception {
        throw new Exception("故意抛出异常，测试切面通知是否有效");
//        return "modifyService add, name = " + name + ", addr = " + addr;
    }

    @Override
    public String edit(Integer id, String name) {
        return "modifyService edit, id = " + id + ", name = " + name;
    }

    @Override
    public String remove(Integer id) {
        return "modifyService remove, id = " + id;
    }
}
