package com.immortal.task2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Spinner SP_Gender ;
    EditText ET_Name,ET_Email,ET_Password,ET_Year;
    Button B_Register;
    Intent IN_HomeScreenIntent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SP_Gender = (Spinner)findViewById(R.id.SP_Gender);
        ET_Email = (EditText)findViewById(R.id.ET_email);
        ET_Name = (EditText)findViewById(R.id.ET_Name);
        ET_Password = (EditText)findViewById(R.id.ET_Password);
        ET_Year = (EditText)findViewById(R.id.ET_Year);
        B_Register = (Button)findViewById(R.id.B_Register);

        IN_HomeScreenIntent = new Intent(this,HomeScreen.class);

        String[] items = new String[]{"Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        SP_Gender.setAdapter(adapter);


        B_Register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String Gender = SP_Gender.getSelectedItem().toString();
                String Email = ET_Email.getText().toString();
                String Name = ET_Name.getText().toString();
                String Password = ET_Password.getText().toString();
                String Year = ET_Year.getText().toString();
                if(Email.isEmpty()||Name.isEmpty()||Password.isEmpty()||Year.isEmpty())
                    Toast.makeText(getApplicationContext(),"Enter Missing data",Toast.LENGTH_SHORT).show();
                else
                {
                    IN_HomeScreenIntent.putExtra("Email",Email);
                    IN_HomeScreenIntent.putExtra("Name",Name);
                    IN_HomeScreenIntent.putExtra("Password",Password);
                    IN_HomeScreenIntent.putExtra("Gender",Gender);
                    IN_HomeScreenIntent.putExtra("Year",Year);
                    startActivity(IN_HomeScreenIntent);
                }
            }
        });

    }

}
