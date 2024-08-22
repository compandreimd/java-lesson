package core;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.IOException;
import java.util.Map;

public class BaseGet<T extends IAssertable<T>> extends BaseClass{
    private T instance;
    private String key;
    private Map<String, String> replacer;
    protected int status = HttpStatus.SC_OK;
    public BaseGet(T instance, String key, Map<String, String> replacer) {
        this.instance = instance;
        this.key = key;
        this.replacer = replacer;
    }
    public SoftAssert request(SoftAssert softAssert)  {
        String uri = ReadConfig.getInstance().getValue(key);
        for (Map.Entry<String, String> entry: replacer.entrySet()) {
            uri = uri.replace(entry.getValue(), ReadConfig.getInstance().getValue(entry.getKey()));
        }
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            closeableHttpResponse = getRequest(RequestType.Get, uri);
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            softAssert.assertEquals(statusCode, status, "Status Code deferred!");
            read = new ReadContent(closeableHttpResponse.getEntity().getContent());
            softAssert.assertAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return softAssert;
    }

    public T content(SoftAssert softAssert){
        if(read == null) request(softAssert);
        T resp = read.as((Class<T>)instance.getClass());
        return resp;
    }

    public SoftAssert content(SoftAssert softAssert, T t){
        if(read == null) request(softAssert);
        T resp = content(softAssert);
        Assert.assertNotNull(resp, "Could get main Object!");
        softAssert.assertEquals(resp, t);
        return  softAssert;
    }


}
