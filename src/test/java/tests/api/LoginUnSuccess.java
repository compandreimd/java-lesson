package tests.api;

import core.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.entity.Register;
import tests.api.models.RespError;
import tests.api.models.RespListUsers;
import utils.ReadContent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class LoginUnSuccess extends BaseT<RespError, Register> {
   public LoginUnSuccess() throws FileNotFoundException {
        super(RequestType.Post, new RespError(), "LOGIN", new HashMap<>());
       Random rn = new Random();
       var users = new ReadContent(new FileInputStream("src/test/resources/users.json")).as(RespListUsers.class).getData();
       body = Register.builder().email(users.get(rn.nextInt(users.size())).getEmail()).build();
       status = HttpStatus.SC_BAD_REQUEST;
    }
    @Test(priority = 1)
    public void testUnSuccess()  {
        requestJSON(getSoftAssert()).assertAll("Register User");
    }


    @Test
    public void testUnSuccessContent() throws IOException {
        var expected = new RespError();
        expected.setError("Missing email or username");
        content(getSoftAssert(), expected).assertAll();
    }
}
