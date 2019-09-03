package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    //Buttons
    Button conn;
    Button trac;
    Button fli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = findViewById(R.id.connect);
        trac = findViewById(R.id.track);
        fli = findViewById(R.id.flight);
        conn.setOnClickListener(this);
        trac.setOnClickListener(this);
        fli.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.connect:
                //startActivity(new Intent(MainActivity.this, newActivity.class));
                break;
            case R.id.track:
                //startActivity(new Intent(this, newActivity.class));
                break;
            case R.id.flight:
                startActivity(new Intent(MainActivity.this, InFlightActivity.class));
                break;
        }
    }
}
