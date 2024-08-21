package tests;

import core.BaseGet;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.models.RespResource;
import tests.models.RespUsers;

import java.io.IOException;
import java.util.HashMap;

public class NoResource extends BaseGet {

    public NoResource(){
        super(new RespResource(), "RESOURCE", new HashMap<>() {{
            put("NotResId", "{ResId}");
        }});
        status = HttpStatus.SC_NOT_FOUND;
    }
    @Test(priority = -1)
    public void testResourceRequest() throws IOException {
        request(getSoftAssert()).assertAll("No user");
    }

}
