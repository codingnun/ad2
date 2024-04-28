package com.example.registration_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private Button btn;
    private RadioGroup radioGroup;
    private CheckBox cb1,cb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner1=findViewById(R.id.spinner12);
        btn=findViewById(R.id.btn);
        radioGroup=findViewById(R.id.radiogroupgender);
        cb1=findViewById(R.id.Bachelor);
        cb2=findViewById(R.id.Masters);

        List<String> subjects=new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Science");
        subjects.add("Arts");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });




    }

    public void submitForm()
    {
        String subject=spinner1.getSelectedItem().toString();

        int selectedgenderid=radioGroup.getCheckedRadioButtonId();
        RadioButton r=findViewById(selectedgenderid);
        String gender=r.getText().toString();

        StringBuilder qualifications=new StringBuilder();
        if (cb1.isChecked())
        {
            qualifications.append("Bachelor's degree");
        }
        if (cb2.isChecked())
        {
            qualifications.append("Master;s degree");
        }


        Intent intent=new Intent(MainActivity.this,DisplayActivity.class);
        intent.putExtra("subject",subject);
        intent.putExtra("gender",gender);
        intent.putExtra("qualification",qualifications.toString());
        startActivity(intent);
}
}
