package com.example.bishwendra.studenthelp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

public class Notification extends AppCompatActivity {

    NotificationCompat.Builder notification;

    private static final int uniqueID = 37451;

    EditText to ,from, subject ,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        to= (EditText)findViewById(R.id.TF_to);
        from= (EditText)findViewById(R.id.TF_from);
       subject= (EditText)findViewById(R.id.TF_subject);
        message= (EditText)findViewById(R.id.TF_message);


    }

    public void sendEmail (View v){
        if(v.getId() == R.id.B_sendEmail)
        {
            String tostr = to.getText().toString();
            String fromstr = from.getText().toString();
            String subjectstr = subject.getText().toString();
            String messagestr = message.getText().toString();

            notification.setWhen(System.currentTimeMillis());
            notification.setTicker("You got a new Email");
            notification.setContentTitle("Email from "+ fromstr);
            notification.setContentText(subjectstr);

            Intent intent =new Intent(this,Notification.class);
            PendingIntent pendingIntent =PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT);

            notification.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(uniqueID , notification.build());

        }
    }
}
