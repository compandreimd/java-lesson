package tests.api;

import core.api.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.models.RespUsers;

import java.io.IOException;
import java.util.HashMap;

public class RemoveUsers extends BaseT {

    public RemoveUsers() {
        super(RequestType.Delete,
                new RespUsers(),
                "DELETE",
                new HashMap<>() {{
                    put("DeleteId", "{UserId}");
                }});
        status = HttpStatus.SC_NO_CONTENT;
    }

    @Test(priority = -1)
    public void testUserRequest() throws IOException {
        request(getSoftAssert()).assertAll("No user");
    }

}
