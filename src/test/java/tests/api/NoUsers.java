package tests.api;

import core.api.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.models.RespUsers;
import java.io.IOException;
import java.util.HashMap;

public class NoUsers extends BaseT {

    public NoUsers() {
        super(
                new RespUsers(),
                "USER",
                new HashMap<>() {{
                    put("NotUserId", "{UserId}");
                }});
        status = HttpStatus.SC_NOT_FOUND;
    }

    @Test(priority = -1)
    public void testUserRequest() throws IOException {
        request(getSoftAssert()).assertAll("No user");
    }

}
