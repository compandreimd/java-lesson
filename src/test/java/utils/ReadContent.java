package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ReadContent {

    private String content;

    private ObjectMapper mapper = new ObjectMapper();

    public String getContent() {
        return content;
    }

    public ReadContent(InputStream content) {
        // this.content = new BufferedReader( new InputStreamReader(content, StandardCharsets.UTF_8)).lines().collect(Collectors.joining(""));
        try {
            this.content = new String(content.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            this.content = null;
        }
    }

    @Override
    public String toString() {
        return content;
    }

    public JSONObject getObject() {
        if (content == null)
            return null;
        return new JSONObject(content);
    }

    public JSONArray getArray() {
        if (content == null)
            return null;
        return new JSONArray(content);
    }

    public <T> T as(Class<T> clazz) {
        return as(clazz, null);
    }

    public <T> T as(Class<T> clazz, @Nullable SoftAssert softAssert) {
        try {
            T t = mapper.readValue(content, clazz);
            return t;
        } catch (JsonProcessingException e) {
            if (softAssert != null)
                softAssert.assertNotNull(e);
            return null;
        }
    }
}
