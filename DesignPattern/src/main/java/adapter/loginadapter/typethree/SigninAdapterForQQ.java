package adapter.loginadapter.typethree;

import adapter.loginadapter.ResultMsg;
import adapter.loginadapter.typeone.SigninService;
import adapter.loginadapter.typetwo.LoginAdapter;
import adapter.loginadapter.typetwo.LoginForQQAdapter;

public class IPassportForQQ implements IPassportForThird {

    private SigninService service = new SigninService();

    @Override
    public ResultMsg login(String id) {
        System.out.println("Login through QQ: " + id);

        return service.login("asdad", "asda");
    }
}
