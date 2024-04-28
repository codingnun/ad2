package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.edit_text);
    }
    public void Save(View view) throws Exception {
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;
        try {
            fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(text.getBytes());
            mEditText.getText().clear();
            Toast.makeText(this,"Saved to "+getFilesDir()+"/"+FILE_NAME,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            throw new Exception(e);
        }
        finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void Load(View view) throws Exception {
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while((text=br.readLine())!=null){
                sb.append(text).append("\n");
            }
            mEditText.setText(sb.toString());
        } catch (Exception e) {
            throw new Exception(e);
        }
        finally {
            if(fis!=null){
                try {

                    fis.close();

                } catch (IOException e) {

                    throw new RuntimeException(e);

                }

            }

}
}
}