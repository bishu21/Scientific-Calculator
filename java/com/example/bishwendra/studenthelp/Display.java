package com.example.bishwendra.studenthelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }

    public void onButtondlick(View v) {
        if (v.getId() == R.id.OpenCal) {
            Intent i = new Intent(Display.this, Calculator.class);

            startActivity(i);

        }

    }


}
