package adapter.loginadapter.typeone;

import adapter.loginadapter.ResultMsg;
import templatemethod.jdbctemplate.Member;

public class SigninService {

    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, "Register Successful", new Member());
    }

    public ResultMsg login(String username, String password) {
        return null;
    }
}
