package tests.api;

import core.api.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.models.RespResource;

import java.io.IOException;
import java.util.HashMap;

public class NoResource extends BaseT {

    public NoResource(){
        super(new RespResource(), "RESOURCE", new HashMap<>() {{
            put("NotResId", "{ResId}");
        }});
        status = HttpStatus.SC_NOT_FOUND;
    }
    @Test(priority = -1)
    public void testResourceRequest() throws IOException {
        request(getSoftAssert()).assertAll("No resource");
    }

}
