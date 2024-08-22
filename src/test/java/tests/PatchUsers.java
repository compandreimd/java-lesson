package tests;

import core.BaseT;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.entity.User;
import tests.models.RespUpdateUser;
import utils.ReadConfig;

import java.io.IOException;
import java.util.HashMap;

public class PatchUsers extends BaseT<RespUpdateUser, User> {
    public PatchUsers() {
        super(RequestType.Patch,new RespUpdateUser(),"PATCH",  new HashMap<>() {{
            put("PatchId", "{UserId}");
        }});
        var config = ReadConfig.getInstance();
        body = User.builder().name(config.getValue("PatchName")).job(config.getValue("PatchJob")).build();
        status = HttpStatus.SC_OK;
    }
    @Test(priority = -1)
    public void testPatchUserRequest() {
        requestJSON(getSoftAssert()).assertAll("PatchUsers");
    }

    @Test
    public void testPatchUserContent() throws IOException {
        var expected = new RespUpdateUser();
        expected.setName(body.getName());
        expected.setJob(body.getJob());
        content(getSoftAssert(), expected).assertAll();
    }

}
