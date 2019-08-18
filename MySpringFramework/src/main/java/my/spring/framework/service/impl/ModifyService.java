package my.spring.framework.service.impl;

import my.spring.framework.framework.annotations.MyService;
import my.spring.framework.service.IModifyService;

@MyService
public class ModifyService implements IModifyService {
    @Override
    public String add(String name, String addr) {
        return "modifyService add, name = " + name + ", addr = " + addr;
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
