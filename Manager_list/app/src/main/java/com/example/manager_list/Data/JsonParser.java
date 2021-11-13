package com.example.manager_list.Data;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    public static String jsonParser(String resultJson) {
    String con = null;
        try {
            JSONObject jsonObject = new JSONObject(resultJson);
            JSONObject jObj = jsonObject.optJSONObject("cin");
            String cin = jsonObject.getString("cin");

            JSONObject jsonObject2 = new JSONObject(cin);
            JSONObject jObj2 = jsonObject.optJSONObject("con");
            con = jsonObject2.getString("con");
            Log.d("파싱", "" + con);

        }
        catch (JSONException e) {
        }
        return con;
    }
}
