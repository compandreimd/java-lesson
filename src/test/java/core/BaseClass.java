package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;
import utils.ReadContent;

import java.io.IOException;
import java.net.URI;

public class BaseClass {

    protected ReadContent read = null;

    public enum RequestType {
        Get,
        Post,
        Put,
        Patch,
        Delete,
        Header,
        Option
        ;
        public @NotNull HttpUriRequest asHttpReq(URI uri){
            return switch (this) {
                case Get -> new HttpGet(uri);
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                case Delete -> new HttpDelete(uri);
                case Header -> new HttpHead(uri);
                case Option -> new HttpOptions(uri);
            };
        }
        public @NonNull  HttpUriRequest asHttpReq(String uri){
            return switch (this) {
                case Get -> new HttpGet(uri);
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                case Delete -> new HttpDelete(uri);
                case Header -> new HttpHead(uri);
                case Option -> new HttpOptions(uri);
            };
        }
        public @NonNull HttpUriRequest asHttpReq(){
            return switch (this) {
                case Get -> new HttpGet();
                case Post -> new HttpPost();
                case Put -> new HttpPut();
                case Patch -> new HttpPatch();
                case Delete -> new HttpDelete();
                case Header -> new HttpHead();
                case Option -> new HttpOptions();
            };
        }

        public @Nullable HttpEntityEnclosingRequestBase asHttpEntityReq(URI uri){
            return switch (this) {
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                default -> null;
            };
        }
        public @Nullable HttpEntityEnclosingRequestBase asHttpEntityReq(String uri){
            return switch (this) {
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                default -> null;
            };
        }
        public @Nullable HttpEntityEnclosingRequestBase asHttpEntityReq(){
            return switch (this) {
                case Post -> new HttpPost();
                case Put -> new HttpPut();
                case Patch -> new HttpPatch();
                default -> null;
            };
        }
    }
    protected SoftAssert getSoftAssert() {
        return new SoftAssert();
    }


    /**
     * Request {RequestType}
     * @param type request type
     * @param path address
     * @return http response
     */
    public CloseableHttpResponse getRequest(@NotNull RequestType type, String path) throws IOException{
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient client = HttpClients.createDefault();
        String urn = ReadConfig.getInstance().getValue("URN");
        var get = type.asHttpReq(urn + path);
        closeableHttpResponse = client.execute(get);
      //  client.close();
        return closeableHttpResponse;
    }

    /**
     * Request {RequestType}
     * @param type request type
     * @param path address
     * @return http response
     */
    public CloseableHttpResponse getRequestJSON(@NotNull RequestType type, String path, Object body) throws IOException{
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient client = HttpClients.createDefault();
        String urn = ReadConfig.getInstance().getValue("URN");
        var get = type.asHttpEntityReq(urn + path);
        Assert.assertNotNull(get, "Method Type!");
        ObjectMapper mapper = new ObjectMapper();
        get.setHeader("Content-Type", "application/json");
        get.setEntity(new ByteArrayEntity(mapper.writeValueAsBytes(body)));
        closeableHttpResponse = client.execute(get);
        return closeableHttpResponse;
    }

}
