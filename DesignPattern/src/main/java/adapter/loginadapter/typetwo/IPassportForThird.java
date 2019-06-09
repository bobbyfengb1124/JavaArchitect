package adapter.loginadapter.typetwo;

import adapter.loginadapter.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechar(String id);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelephone(String telepheone);

    ResultMsg loginForRegister(String username, String passport);
}
