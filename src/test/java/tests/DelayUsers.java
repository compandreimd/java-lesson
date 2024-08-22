package tests;

import core.BaseT;
import org.testng.annotations.Test;
import tests.models.RespListUsers;
import utils.ReadContent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class DelayUsers extends BaseT<RespListUsers, Object> {
    public DelayUsers() {
        super(new RespListUsers(), "DELAY", new HashMap<>() {{
            put("Page", "{Page}");
            put("PerPage", "{PerPage}");
            put("Delay", "{Delay}");
        }});
    }

    @Test(priority = -1)
    public void testListResourceRequest() {
        request(getSoftAssert()).assertAll("DelayUsers");
    }

    @Test
    public void testListResourceContent() throws IOException {
        content(getSoftAssert(), new ReadContent(new FileInputStream("src/test/resources/users.json")).as(RespListUsers.class));
    }
}
