package tests.api;

import core.BaseT;
import org.testng.annotations.Test;
import tests.api.models.RespListUsers;
import tests.api.models.RespUsers;
import utils.ReadConfig;
import utils.ReadContent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class GetUser extends BaseT<RespUsers, Object> {
    public GetUser() {
        super(new RespUsers(), "USER", new HashMap<>() {{
            put("UserId", "{UserId}");
        }});
    }

    @Test(priority = -1)
    public void testUserRequest() throws IOException {
        request(getSoftAssert()).assertAll("Get User");

    }

    @Test
    public void testUserContent() throws IOException {
        RespListUsers data = new ReadContent(new FileInputStream("src/test/resources/users.json")).as(RespListUsers.class);
        var id =  Integer.parseInt(ReadConfig.getInstance().getValue("UserId"));
        var user = data.getData().get(id - 1);
        var expected = new RespUsers();
        expected.setSupport(data.getSupport());
        expected.setData(user);
        content(getSoftAssert(), expected).assertAll();
    }
}
