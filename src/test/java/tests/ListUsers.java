package tests;

import core.BaseClass;
import core.BaseGet;
import core.IAssertable;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.models.RespListUsers;
import tests.models.User;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ListUsers extends BaseGet<RespListUsers>  {
    public ListUsers() {
        super(new RespListUsers(),"USERS", new HashMap<>(){{
            put("Page", "{Page}");
            put("PerPage", "{PerPage}");
        }});
    }
    @Test(priority = -1)
    public void testListUserRequest() {
        request(getSoftAssert()).assertAll("ListUsers");
    }

    @Test
    public void testListUserContent() throws IOException {
        content(getSoftAssert(), new ReadContent(new FileInputStream("src/test/resources/users.json")).as(RespListUsers.class));
    }

}
