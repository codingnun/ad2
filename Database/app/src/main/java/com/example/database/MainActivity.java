package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name=findViewById(R.id.editTextTextPersonName);
        EditText pass=findViewById(R.id.editTextTextPassword);
        EditText repass=findViewById(R.id.editTextTextPassword2);
        Button reg=findViewById(R.id.button);
        DB = new DBHelper(this);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String pass1=pass.getText().toString();
                String repass1=repass.getText().toString();
                if(pass1.equals(repass1)){
                    Boolean checkuser=DB.checkusername(name1);
                    if(checkuser==false){
                        Boolean insert=DB.inserdata(name1,pass1);
                        if(insert==true){
                            Toast.makeText(MainActivity.this,"Registration Succesfull",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this,"Registration UnSuccesfull",Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(MainActivity.this,"user already registerd",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Renter correct password", Toast.LENGTH_SHORT).show();
                }
            }
   });
}
}
