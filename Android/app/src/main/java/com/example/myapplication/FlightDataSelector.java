package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
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
        File file = new File(this.getFilesDir(), currentTime.toString());
        FileOutputStream outStream;
        try{
            outStream = openFileOutput(file.getName(), this.MODE_PRIVATE);
            outStream.write(testData.getBytes());
        } catch (Exception e){
            e.printStackTrace();
        }

        ///////////////////////////////////////////////
        //                END TEST CODE              //
        ///////////////////////////////////////////////
    }
}
