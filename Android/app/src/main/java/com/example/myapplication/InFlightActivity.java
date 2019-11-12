package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class InFlightActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter fAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> dataTypes = new ArrayList<>();
    private ArrayList<String> fData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_flight);
        getData();

        Thread updateText = new Thread() {
            @Override
            public void run() {
                try {
                    while(!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateData();
                            }
                        });
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        updateText.start();
    }

    private void getData() {
        dataTypes.add("Alt:");
        fData.add("7");

        dataTypes.add("Vel:");
        fData.add("7");

        dataTypes.add("Thrust:");
        fData.add("7");

        dataTypes.add("Swag:");
        fData.add("7");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.in_flight_recycler);
        inFlightAdapter adapter = new inFlightAdapter(dataTypes, fData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void updateData() {
        dataTypes.clear();
        fData.clear();

        dataTypes.add("Alt:");
        fData.add("8");

        dataTypes.add("Vel:");
        fData.add("8");

        dataTypes.add("Thrust:");
        fData.add("8");

        dataTypes.add("Swag:");
        fData.add("8");

        RecyclerView recyclerView = findViewById(R.id.in_flight_recycler);
        inFlightAdapter adapter = new inFlightAdapter(dataTypes, fData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }

    //go to map
    public void goToMaps(View view) {
        startActivity(new Intent(this, MapsActivity.class));
    }
}
