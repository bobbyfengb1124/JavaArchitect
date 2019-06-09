package adapter.loginadapter.typeone;

import adapter.loginadapter.ResultMsg;

public class SigningForThirdService extends SigninService {

    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWechar(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String openId) {
        return null;
    }

    public ResultMsg loginForTelephone(String openId) {
        return null;
    }

    private ResultMsg loginForRegist(String username, String password) {
        super.register(username, null);
        return super.login(username, null);
    }
}
