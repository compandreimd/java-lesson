package tests;

import core.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.entity.User;
import tests.models.RespCreateUser;
import utils.ReadConfig;

import java.io.IOException;
import java.util.HashMap;

public class CreateUsers extends BaseT<RespCreateUser, User> {
    public CreateUsers() {
        super(RequestType.Post,new RespCreateUser(),"CREATE", new HashMap<>());
        var config = ReadConfig.getInstance();
        body = User.builder().name(config.getValue("ConfigName")).job(config.getValue("ConfigJob")).build();
        status = HttpStatus.SC_CREATED;
    }
    @Test(priority = -1)
    public void testCreateUserRequest() {
        requestJSON(getSoftAssert()).assertAll("ListUsers");
    }

    @Test
    public void testCreateUserContent() throws IOException {
        var expected = new RespCreateUser();
        expected.setName(body.getName());
        expected.setJob(body.getJob());
        content(getSoftAssert(), expected).assertAll();
    }

}