package com.example.myprofile;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class OTPActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private EditText edit;
    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_otp);
        edit = findViewById(R.id.editTextMobile);

        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = edit.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    edit.setError("Enter a valid mobile");
                    edit.requestFocus();
                    return;
                }

                Intent intent = new Intent(OTPActivity.this, VerifyOTP.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);


            }
        });



    }
}