package com.example.myprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity  extends AppCompatActivity {
    EditText user,pass;
    Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        user=findViewById(R.id.username1);
        pass=findViewById(R.id.password1);
        String name=user.getText().toString();
        //String password=pass.getText().toString();
        if(name.equals("ravi123")){
            user.setError("Username already exist");
            user.requestFocus();
            return;
        }

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ProfilePage.class);
                startActivity(i);

                }
        });
    }

}
