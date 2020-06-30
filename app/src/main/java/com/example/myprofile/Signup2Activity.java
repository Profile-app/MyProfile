package com.example.myprofile;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Signup2Activity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fstore;
    EditText fname,lname,mail,dob;
    DatePickerDialog picker;
    RadioGroup gen_group;
    RadioButton gender;
    Button create;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        fname=findViewById(R.id.FirstName);
        lname=findViewById(R.id.LastName);
        mail=findViewById(R.id.email);
        dob=findViewById(R.id.dob);
        gen_group=findViewById(R.id.radioGender);
        final DocumentReference docref=fstore.collection("users_details").document(Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid());
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(Signup2Activity.this,new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();

            }
        });
        int selectid=gen_group.getCheckedRadioButtonId();
        gender=findViewById(selectid);

        create=findViewById(R.id.buttonCreate);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fname.getText().toString().isEmpty() && !lname.getText().toString().isEmpty()&&!mail.getText().toString().isEmpty()&&!dob.getText().toString().isEmpty()&&!gender.getText().toString().isEmpty()) {
                    String first_name=fname.getText().toString();
                    String last_name=lname.getText().toString();
                    String  email=mail.getText().toString();
                    String bday=dob.getText().toString();
                    String gen=gender.getText().toString();

                    Map<String, Object> user = new HashMap<>();
                    user.put("FIRST NAME", first_name);
                    user.put("LAST NAME", last_name);
                    user.put("E-MAIL", email);
                    user.put("DATE OF BIRH", bday);
                    user.put("GENDER", gen);

                    docref.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent i = new Intent(Signup2Activity.this, ProfilePageActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(Signup2Activity.this, "Data is not inserted.", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                } else {
                    Toast.makeText(Signup2Activity.this, "All Fields are Required.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
