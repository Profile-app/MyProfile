package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class Signup2Activity extends AppCompatActivity {
    EditText fname,lname,mail,dob;
    DatePickerDialog picker;
    RadioGroup gen_group;
    RadioButton gender;
    Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        fname=findViewById(R.id.FirstName);
        lname=findViewById(R.id.LastName);
        mail=findViewById(R.id.email);
        dob=findViewById(R.id.dob);
        gen_group=findViewById(R.id.radioGender);

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
        //String first_name=fname.getText().toString();
       // String last_name=lname.getText().toString();
       // String  email=mail.getText().toString();
       // String bday=dob.getText().toString();
       // String gen=gender.getText().toString();

        create=findViewById(R.id.buttonCreate);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Signup2Activity.this,ProfilePageActivity.class);
                startActivity(i);
            }
        });


    }
}
