package com.example.myprofile;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity {
   FirebaseAuth firebaseAuth;
   FirebaseFirestore fstore;
    EditText user_id,password;
    String userID;
    Button b;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user_id=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        b=findViewById(R.id.buttonContinue);
        firebaseAuth= FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userID= Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();
        final DocumentReference docref=fstore.collection("users").document(userID);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!user_id.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    String uid = user_id.getText().toString();
                    String pass = password.getText().toString();
                    Map<String, Object> user = new HashMap<>();
                    user.put("USER_ID", uid);
                    user.put("PASSWORD", pass);
                    docref.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent i = new Intent(SignupActivity.this, ProfilePageActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(SignupActivity.this, "Data is not inserted.", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                } else {
                    Toast.makeText(SignupActivity.this, "All Fields are Required.", Toast.LENGTH_SHORT).show();
                }
            }
        });
}
}