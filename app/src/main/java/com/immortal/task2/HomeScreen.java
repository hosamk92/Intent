package com.immortal.task2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by IMMORTAl on 7/16/2017.
 */

public class HomeScreen extends AppCompatActivity {

    TextView TV_Name,TV_Email,TV_Password,TV_Year,TV_Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        Intent IN_MainActivityIntent = getIntent();
        String Gender = IN_MainActivityIntent.getStringExtra("Gender");
        String Name = IN_MainActivityIntent.getStringExtra("Name");
        String Password = IN_MainActivityIntent.getStringExtra("Password");
        String Email = IN_MainActivityIntent.getStringExtra("Email");
        String Year = IN_MainActivityIntent.getStringExtra("Year");

        TV_Gender = (TextView)findViewById(R.id.TV_Gender);
        TV_Email = (TextView)findViewById(R.id.TV_Email);
        TV_Name = (TextView)findViewById(R.id.TV_Name);
        TV_Password = (TextView)findViewById(R.id.TV_Password);
        TV_Year = (TextView)findViewById(R.id.TV_Year);


        TV_Gender.setText(Gender);
        TV_Email.setText(Email);
        TV_Name.setText(Name);
        TV_Password.setText(Password);
        TV_Year.setText(Year);

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
       finish();
        return true;
    }
    private int PICK_IMAGE_REQUEST = 1;

    public void SelectAvatar(View v)
    {
        Intent intent = new Intent();
        // Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.ImagV_Avatar);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
