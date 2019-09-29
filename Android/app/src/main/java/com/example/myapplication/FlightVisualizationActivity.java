package com.example.myapplication;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class FlightVisualizationActivity extends AppCompatActivity {
    LineChart flightPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_visualization);

        flightPath = findViewById(R.id.flightPath);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 0));
        entries.add(new Entry(1, 2));
        entries.add(new Entry(2, 4));
        entries.add(new Entry(3, 6));
        entries.add(new Entry(4, 8));

        LineDataSet dataSet = new LineDataSet(entries, "Flight Path");
        dataSet.setColor((ContextCompat.getColor(this, R.color.colorPrimary)));
        dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        XAxis xAxis = flightPath.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);

        YAxis yAxisRight = flightPath.getAxisRight();
        yAxisRight.setEnabled(false);
        YAxis yAxisLeft = flightPath.getAxisLeft();
        yAxisLeft.setGranularity(1f);

        LineData data = new LineData(dataSet);
        flightPath.setData(data);
    }
}
