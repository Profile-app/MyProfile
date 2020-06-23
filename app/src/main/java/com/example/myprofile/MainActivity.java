package com.example.myprofile;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView signup;
    Button loginButton;
    EditText userName,password;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_main);

        signup=findViewById(R.id.link_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i=new Intent(getApplicationContext(),OTPActivity.class);
                startActivity(i);
            }
        });

        userName=findViewById(R.id.username);
        password=findViewById(R.id.password);

        loginButton= findViewById(R.id.login_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String user=userName.getText().toString();
                //String pass=password.getText().toString();
                //if(pass.equals("ravi123") && user.equals("ravi1234")){
                        Intent i=new Intent(getApplicationContext(), ProfilePage.class);
                        startActivity(i);

                //}
               // else {
              //      Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
              //  }



            }
        });

    }
}

