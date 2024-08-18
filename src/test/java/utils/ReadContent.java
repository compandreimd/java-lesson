package utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ReadContent {

    private String content;

    public String getContent() {
        return content;
    }

    public ReadContent(InputStream content){
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

    public JSONObject getObject(){
        if(content == null)
            return null;
        return new JSONObject(content);
    }

    public JSONArray getArray(){
        if(content == null)
            return null;
        return new JSONArray(content);
    }
}
