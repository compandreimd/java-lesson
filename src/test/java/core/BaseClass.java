package core;

import lombok.NonNull;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
        Delete;
        public @NotNull HttpUriRequest asHttpReq(URI uri){
            return switch (this) {
                case Get -> new HttpGet(uri);
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                case Delete -> new HttpPatch(uri);
            };
        }
        public @NonNull  HttpUriRequest asHttpReq(String uri){
            return switch (this) {
                case Get -> new HttpGet(uri);
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                case Delete -> new HttpPatch(uri);
            };
        }
        public @NonNull HttpUriRequest asHttpReq(){
            return switch (this) {
                case Get -> new HttpGet();
                case Post -> new HttpPost();
                case Put -> new HttpPut();
                case Patch -> new HttpPatch();
                case Delete -> new HttpPatch();
            };
        }

        public @Nullable HttpEntityEnclosingRequestBase asHttpEntityReq(URI uri){
            return switch (this) {
                case Get -> null;
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                case Delete -> new HttpPatch(uri);
            };
        }
        public @Nullable HttpEntityEnclosingRequestBase asHttpEntityReq(String uri){
            return switch (this) {
                case Get -> null;
                case Post -> new HttpPost(uri);
                case Put -> new HttpPut(uri);
                case Patch -> new HttpPatch(uri);
                case Delete -> new HttpPatch(uri);
            };
        }
        public @Nullable HttpEntityEnclosingRequestBase asHttpEntityReq(){
            return switch (this) {
                case Get -> null;
                case Post -> new HttpPost();
                case Put -> new HttpPut();
                case Patch -> new HttpPatch();
                case Delete -> new HttpPatch();
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


}
