package com.example.bishwendra.studenthelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivitystud extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitystud);
    }

    InputConnection connection;

    DatabaseHelper helper=new DatabaseHelper(this);

    public void onButtonClick(View v){
        if(v.getId() == R.id.button)
        {
            EditText a = (EditText)findViewById(R.id.editText);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.editText2);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)){


                Intent i = new Intent(MainActivitystud.this, Display.class);
                i.putExtra("Username", str);
                startActivity(i);
            }

            else
            {
                Toast temp =Toast.makeText(MainActivitystud.this , "USERNAME AND PASSWORD NOT MATCHED!",Toast.LENGTH_SHORT);
                temp.show();
            }


            connection.finishComposingText();
        }
        if(v.getId() == R.id.button2)
        {

            Intent i = new Intent(MainActivitystud.this, SignUp.class);

            startActivity(i);
        }
        if(v.getId() == R.id.calc)
        {

            Intent i = new Intent(MainActivitystud.this, Calculator.class);

            startActivity(i);
        }

        if(v.getId() == R.id.noti)
        {

            Intent i = new Intent(MainActivitystud.this, Notification.class);

            startActivity(i);
        }



    }


}
