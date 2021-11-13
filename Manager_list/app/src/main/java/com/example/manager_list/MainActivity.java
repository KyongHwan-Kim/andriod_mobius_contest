package com.example.manager_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manager_list.HttpConnector.UID.UID;
import com.example.manager_list.HttpConnector.UID.Virtual_beer;
import com.example.manager_list.HttpConnector.UID.Virtual_paper;
import com.example.manager_list.HttpConnector.UID.Virtual_water;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView cnt_text;
    private ListView list;
    private Virtual_water vw;
    private Virtual_beer vb;
    private Virtual_paper vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String water_data = null;
        String beer_data = null;
        String paper_data = null;
        // swipeRefreshLayout = findViewById(R.id.swiperefreshlayout);


        list = (ListView)findViewById(R.id.list);
        water_data = vw.run();
        Log.i("water","data : "+water_data);
        beer_data = vb.run();
        Log.i("beer","data : "+beer_data);
        paper_data = vp.run();
        Log.i("paper","data : "+paper_data);
        // swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            //@Override
            //public void onRefresh() {
                /* swipe 시 진행할 동작 */


                /* 업데이트가 끝났음을 알림 */
                //swipeRefreshLayout.setRefreshing(false);
            //}
       // });

        List<String> data = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);

        data.add("Water");
        data.add("Beer");
        data.add("Paper");
        adapter.notifyDataSetChanged();

        /*UID Thread = new UID();
        //Thread.start();
        Virtual_water Thread = new Virtual_water();
        Thread.start();
        Virtual_beer Thread = new Virtual_beer();
        Thread.start();
        Virtual_paper Thread = new Virtual_paper();
        Thread.start();*/

    }
}