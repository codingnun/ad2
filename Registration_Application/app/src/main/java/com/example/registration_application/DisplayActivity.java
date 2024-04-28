package com.example.registration_application;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.display);

        TextView t=findViewById(R.id.textview);
        Bundle extras=getIntent().getExtras();
        if (extras!=null)
        {
            String subject=extras.getString("subject");
            String gender=extras.getString("gender");
            String qualification=extras.getString("qualification");
            String message = "Subject: " + subject + "\nGender: " + gender + "\nQualification: " + qualification;
            t.setText(message);
        }



    }

}