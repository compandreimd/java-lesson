package tests.api;

import core.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.entity.Register;
import tests.api.models.RespListUsers;
import tests.api.models.RespRegister;
import tests.api.models.User;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

public class RegisterSuccess extends BaseT<RespRegister, Register> {
   public RegisterSuccess() {
        super(RequestType.Post, new RespRegister(), "REGISTER", new HashMap<>());
    }
    @Test(priority = 1)
    public void testSucessReg() throws FileNotFoundException {
        Random rn = new Random();
        var users = new ReadContent(new FileInputStream("src/test/resources/users.json")).as(RespListUsers.class).getData();
        var config = ReadConfig.getInstance();

        body = Register.builder().email(users.get(rn.nextInt(users.size())).getEmail()).password(config.getValue("Password")).build();
        status = HttpStatus.SC_OK;
        requestJSON(getSoftAssert()).assertAll("Register User");
    }
}
