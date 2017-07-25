package com.example.bishwendra.studenthelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }




    public void onButtonclick(View v){
        EditText a1 = (EditText)findViewById(R.id.TFnum1);
        EditText a2 = (EditText)findViewById(R.id.TFnum2);

        String b1 = a1.getText().toString();
        String b2 = a2.getText().toString();

        if(b1.isEmpty() || b2.isEmpty()){
            Toast emptystring = Toast.makeText(Calculator.this, "One of the field is empty", Toast.LENGTH_SHORT);
            emptystring.show();
        }
        else if(Character.isLetter(b1.charAt(0)) || Character.isLetter(b2.charAt(0))){
            Toast emptystring = Toast.makeText(Calculator.this, "Please enter numbers only", Toast.LENGTH_SHORT);
            emptystring.show();
        }
        else {


            TextView tv = (TextView) findViewById(R.id.Lresult);
            boolean flag = false;
            double num1, num2, ans;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());

            ans = 0;
            int id = v.getId();
            switch (id) {
                case R.id.Badd:
                    ans = num1 + num2;
                    break;
                case R.id.Bminus:
                    ans = num1 - num2;
                    break;
                case R.id.Bmult:
                    ans = num1 * num2;
                    break;
                case R.id.Bdiv:
                    if (num2 == 0) {
                        flag = true;
                    } else
                        ans = num1 / num2;
                    break;

                case R.id.Bsin:
                    ans = Math.sin(num1 / 180 * 22 / 7);
                    break;
                case R.id.Bcos:
                    ans = Math.cos(num1 / 180 * 22 / 7);
                    break;
                case R.id.Btan:
                    ans = Math.tan(num1 / 180 * 22 / 7);
                    break;
                case R.id.Bcosec:
                    ans = 1 / Math.sin(num1 / 180 * 22 / 7);
                    break;
                case R.id.Bsec:
                    ans = 1 / Math.cos(num1 / 180 * 22 / 7);
                    break;
                case R.id.Bcot:
                    ans = 1 / Math.tan(num1 / 180 * 22 / 7);
                    break;

            }

            if (!flag) {
                tv.setText("Answer = " + ans);
            } else
                tv.setText("not defined");

        }
    }


}
