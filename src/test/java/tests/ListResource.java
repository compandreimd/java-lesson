package tests;

import core.BaseT;
import org.testng.annotations.Test;
import tests.models.RespListResource;
import utils.ReadContent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ListResource extends BaseT<RespListResource, Object> {
    public ListResource() {
        super(new RespListResource(),"RESOURCES", new HashMap<>(){{
            put("Page", "{Page}");
            put("PerPage", "{PerPage}");
        }});
    }
    @Test(priority = -1)
    public void testListResourceRequest() {
        request(getSoftAssert()).assertAll("ListUsers");
    }

    @Test
    public void testListResourceContent() throws IOException {
       content(getSoftAssert(), new ReadContent(new FileInputStream("src/test/resources/resource.json")).as(RespListResource.class));
    }

}
