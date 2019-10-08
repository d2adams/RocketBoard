package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FlightDataSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_data_selector);
        ///////////////////////////////////////////////
        //TEST CODE REMOVE WHEN ACTUALLY IMPLEMENTING//
        ///////////////////////////////////////////////

        String testData = "3:00,5.0,S,45.3,W,0.5,23.4,43.2,54.2,.02,.33,.41,205.3\n";
        DataPacket testPacket = new DataPacket(testData);

        Date currentTime = Calendar.getInstance().getTime();
        File file = new File(this.getFilesDir(), "Flight: " + currentTime.toString());
        FileOutputStream outStream;
        try{
            outStream = openFileOutput(file.getName(), this.MODE_PRIVATE);
            outStream.write(testData.getBytes());
        } catch (Exception e){
            e.printStackTrace();
        }

        File directory = this.getFilesDir();
        String[] files = directory.list(new FilenameFilter(){
            @Override
            public boolean accept(File directory, String name){
                return name.startsWith("Flight:");
            }
        });
        String TAG ="Filelisting";

        for (String name: files
             ) {
            Log.d(TAG,name);
        }

        RecyclerView rvFiles = (RecyclerView) findViewById(R.id.rvFiles);
        FilesAdapter adapter = new FilesAdapter(files);
        rvFiles.setAdapter(adapter);
        rvFiles.setLayoutManager(new LinearLayoutManager(this));

        ///////////////////////////////////////////////
        //                END TEST CODE              //
        ///////////////////////////////////////////////
    }
}
