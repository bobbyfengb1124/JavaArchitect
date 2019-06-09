package adapter.loginadapter.typetwo;

import adapter.loginadapter.ResultMsg;
import adapter.loginadapter.typeone.SigninService;

public class PassportForThirdAdapter extends SigninService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechar(String id) {
        return null;
    }

    private ResultMsg processLogin(String id, Class<? extends LoginAdapter> clazz) {

        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(clazz)) {
                return adapter.login(id, adapter);
            } else {
                return null;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelephone(String telepheone) {
        return processLogin(telepheone, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegister(String username, String passport) {
        super.register(username, null);

        return super.login(username, null);
    }

}
