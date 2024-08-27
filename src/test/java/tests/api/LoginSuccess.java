package tests.api;

import core.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.entity.Register;
import tests.api.models.RespListUsers;
import tests.api.models.RespRegister;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

public class LoginSuccess extends BaseT<RespRegister, Register> {
   public LoginSuccess() {
        super(RequestType.Post, new RespRegister(), "LOGIN", new HashMap<>());
    }
    @Test(priority = 1)
    public void testLogin() throws FileNotFoundException {
        Random rn = new Random();
        var users = new ReadContent(new FileInputStream("src/test/resources/users.json")).as(RespListUsers.class).getData();
        var config = ReadConfig.getInstance();

        body = Register.builder().email(users.get(rn.nextInt(users.size())).getEmail()).password(config.getValue("Password")).build();
        status = HttpStatus.SC_OK;
        requestJSON(getSoftAssert()).assertAll("Register User");
    }
}
