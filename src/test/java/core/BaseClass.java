package core;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;

import java.io.IOException;

public class BaseClass {

    protected SoftAssert softAssert = new SoftAssert();

    /**
     * Get Request
     * @param path addresa ge
     * @return
     */
    public CloseableHttpResponse getRequest(String path) throws IOException{
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient client = HttpClients.createDefault();
        String urn = ReadConfig.getInstance().getValue("URN");
        HttpGet get = new HttpGet(urn + path);

        closeableHttpResponse = client.execute(get);
      //  client.close();
        return closeableHttpResponse;
    }

}
