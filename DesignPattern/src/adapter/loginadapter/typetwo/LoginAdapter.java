package adapter.loginadapter.typetwo;

import adapter.loginadapter.ResultMsg;

public interface LoginAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
