package tests;

import core.BaseClass;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.IOException;
import java.io.InputStream;

public class ListUsers extends BaseClass {
    ReadContent read = null;
    @Test(priority = -1)
    public void testListUserRequest() throws IOException {
        var users = ReadConfig.getInstance().getValue("USERS");
        var page = ReadConfig.getInstance().getValue("PAGE");
        users = users.replace("{page}", page);
        CloseableHttpResponse closeableHttpResponse = getRequest(users);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        softAssert.assertEquals(statusCode, HttpStatus.SC_OK, "Status Code deferred!");
        read = new ReadContent(closeableHttpResponse.getEntity().getContent());
        softAssert.assertAll();
    }

    @Test
    public void testListUserContent() throws IOException {
       if(read == null) testListUserRequest();
       softAssert.assertNotNull(read.getContent(), "Could get Content!");
       JSONObject obj = read.getObject();
       softAssert.assertNotNull(obj, "Could get main Object!");
       obj.getInt("page");
       softAssert.assertAll();
    }

}
