package core;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.IOException;
import java.util.Map;

public class BaseT<R extends IAssertable<R>,B> extends BaseClass{
    private final R instance;
    protected B body = null;
    private final String key;
    private final Map<String, String> replacer;
    private final RequestType type;
    protected int status = HttpStatus.SC_OK;
    public BaseT(R instance, String key, Map<String, String> replacer) {
        this(RequestType.Get, instance, key, replacer);
    }
    public BaseT(RequestType type, R instance, String key, Map<String, String> replacer) {
        this.instance = instance;
        this.key = key;
        this.replacer = replacer;
        this.type = type;
    }
    public SoftAssert request(SoftAssert softAssert)  {
        String uri = ReadConfig.getInstance().getValue(key);
        for (Map.Entry<String, String> entry: replacer.entrySet()) {
            uri = uri.replace(entry.getValue(), ReadConfig.getInstance().getValue(entry.getKey()));
        }
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            closeableHttpResponse = getRequest(type, uri);
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            softAssert.assertEquals(statusCode, status, "Status Code deferred!");
            if(statusCode != HttpStatus.SC_NO_CONTENT) {
                read = new ReadContent(closeableHttpResponse.getEntity().getContent());
            }
            softAssert.assertAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return softAssert;
    }
    public SoftAssert requestJSON(SoftAssert softAssert){
        Assert.assertNotNull(body, "Set Body");
        String uri = ReadConfig.getInstance().getValue(key);
        for (Map.Entry<String, String> entry: replacer.entrySet()) {
            uri = uri.replace(entry.getValue(), ReadConfig.getInstance().getValue(entry.getKey()));
        }
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            closeableHttpResponse = getRequestJSON(type, uri, body);
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            softAssert.assertEquals(statusCode, status, "Status Code deferred!");
            if(statusCode != HttpStatus.SC_NO_CONTENT) {
                read = new ReadContent(closeableHttpResponse.getEntity().getContent());
            }
            softAssert.assertAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return softAssert;
    }
    public R content(SoftAssert softAssert){
        if(read == null) request(softAssert);
        R resp = read.as((Class<R>)instance.getClass());
        return resp;
    }
    public SoftAssert content(SoftAssert softAssert, R expected){
        if(read == null) request(softAssert);
        R resp = content(softAssert);
        Assert.assertNotNull(resp, "Could get main Object!");
        resp.asseratableEqual(softAssert, expected);
        return  softAssert;
    }

}

