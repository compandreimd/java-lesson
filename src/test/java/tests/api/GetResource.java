package tests.api;

import core.api.BaseT;
import org.testng.annotations.Test;
import tests.api.models.RespListResource;
import tests.api.models.RespResource;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class GetResource extends BaseT<RespResource, Object> {
    public GetResource() {
        super(new RespResource(), "RESOURCE", new HashMap<>() {{
            put("ResId", "{ResId}");
        }});
    }

    @Test(priority = -1)
    public void testResourceRequest() throws IOException {
        request(getSoftAssert()).assertAll("Get User");

    }

    @Test
    public void testResourceContent() throws IOException {
        RespListResource data = new ReadContent(new FileInputStream("src/test/resources/resource.json")).as(RespListResource.class);
        var id =  Integer.parseInt(ReadConfig.getInstance().getValue("ResId"));
        var res = data.getData().get(id - 1);
        var expected = new RespResource();
        expected.setSupport(data.getSupport());
        expected.setData(res);
        content(getSoftAssert(), expected).assertAll();
    }
}
