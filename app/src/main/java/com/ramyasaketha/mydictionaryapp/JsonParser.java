package com.ramyasaketha.mydictionaryapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ramyasaketha on 8/26/15.
 */
public class JsonParser {

    private static String WEB_URL = "http://api.wordnik.com:80/v4/word.json/";
    private static String WEB_DEF =  "/definitions?limit=200&includeRelated=true&useCanonical=false&includeTags=false&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

    public static ArrayList<String> parseContents(String httpResponse) {
        ArrayList<String> strArray = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(httpResponse);
            for (int i=0; i<array.length();i++) {
                JSONObject jsonObj = array.getJSONObject(i);
                strArray.add(jsonObj.optString("text"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return strArray;
    }

    public static String JsonURL(String searchWord) {
        return WEB_URL + searchWord + WEB_DEF;
    }
}
