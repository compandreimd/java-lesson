package tests.api;

import core.api.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.entity.User;
import tests.api.models.RespUpdateUser;
import utils.ReadConfig;

import java.io.IOException;
import java.util.HashMap;

public class PutUsers extends BaseT<RespUpdateUser, User> {
    public PutUsers() {
        super(RequestType.Put,new RespUpdateUser(),"PUT",  new HashMap<>() {{
            put("PutId", "{UserId}");
        }});
        var config = ReadConfig.getInstance();
        body = User.builder().name(config.getValue("PutName")).job(config.getValue("PutJob")).build();
        status = HttpStatus.SC_OK;
    }
    @Test(priority = -1)
    public void testPutUserRequest() {
        requestJSON(getSoftAssert()).assertAll("PutUsers");
    }

    @Test
    public void testPutUserContent() throws IOException {
        var expected = new RespUpdateUser();
        expected.setName(body.getName());
        expected.setJob(body.getJob());
        content(getSoftAssert(), expected).assertAll();
    }

}
