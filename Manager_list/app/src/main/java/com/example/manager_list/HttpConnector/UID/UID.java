package com.example.manager_list.HttpConnector.UID;

import android.util.Log;
import com.example.manager_list.Data.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UID extends Thread {

    @Override
    public void run() {

        try {
            URL url = new URL("http://203.253.128.161:7579/Mobius/AISL_VirtualStore/Uid/la"); // 서버 URL

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
                    String UID = null;
                    while (true) {
                        UID = reader.readLine();
                        UID = UID.replace("m2m:cin", "cin");
                        Log.i("line: ", UID);

                        if (UID == null) {
                            break;
                        }
                        JsonParser.jsonParser(UID);
                    }
                    reader.close();
                }
                conn.disconnect();
            }
        } catch (Exception e) {

        }

    }
}