package com.example.manager_list.HttpConnector.UID;

import android.util.Log;
import com.example.manager_list.Data.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Virtual_water {
    public String conv_data = null;
    public String run() {

        try {
            URL url = new URL("http://203.253.128.161:7579/Mobius/AISL_VirtualStore/Virtual_inventory/Virtual_water/la"); // 서버 URL

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("Accept", "*/*");

            conn.setRequestProperty("X-M2M-RI", "12345");

            conn.setRequestProperty("X-M2M-Origin", "SOrigin");

            if (conn != null) {
                conn.setConnectTimeout(1000);
                conn.setRequestMethod("GET");
                int resCode = conn.getResponseCode();
                if (resCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String vrWater = null;
                    while (true) {
                        vrWater = reader.readLine();
                        vrWater = vrWater.replace("m2m:cin", "cin");
                        Log.i("line: ", vrWater);

                        if (vrWater == null) {
                            break;
                        }
                        conv_data = JsonParser.jsonParser(vrWater);

                    }
                    reader.close();
                }
                conn.disconnect();
            }
        } catch (Exception e) {

        }
        return conv_data;
    }

}
