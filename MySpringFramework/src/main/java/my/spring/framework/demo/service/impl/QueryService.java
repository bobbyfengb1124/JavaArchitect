package my.spring.framework.demo.service.impl;

import my.spring.framework.framework.annotations.MyService;
import my.spring.framework.demo.service.IQueryService;

import java.text.SimpleDateFormat;
import java.util.Date;

@MyService
public class QueryService implements IQueryService {
    @Override
    public String query(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
        System.out.println("这是在业务方法中打印的：" + json);
        return json;
    }
}
