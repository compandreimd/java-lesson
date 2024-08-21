package tests;

import core.BaseGet;
import org.testng.annotations.Test;
import tests.models.RespListUsers;
import utils.ReadContent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class DelayUsers extends BaseGet<RespListUsers> {
    public DelayUsers() {
        super(new RespListUsers(), "DELAY", new HashMap<>() {{
            put("Page", "{Page}");
            put("PerPage", "{PerPage}");
            put("Delay", "{Delay}");
        }});
    }

    @Test(priority = -1)
    public void testListResourceRequest() {
        request(getSoftAssert()).assertAll("ListUsers");
    }

    @Test
    public void testListResourceContent() throws IOException {
        content(getSoftAssert(), new ReadContent(new FileInputStream("src/test/resources/users.json")).as(RespListUsers.class));
    }
}
