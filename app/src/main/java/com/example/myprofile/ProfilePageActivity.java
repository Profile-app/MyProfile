package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.view.View;
import android.widget.Button;

public class ProfilePageActivity extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
