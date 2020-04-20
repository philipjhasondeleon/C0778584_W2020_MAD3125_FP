package com.example.c0778584_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.c0778584_w2020_mad3125_fp.R;


import java.util.Calendar;

public class AddNewCustomerActivity extends AppCompatActivity {

    private RadioButton rdBtnMale;
    private RadioButton rdBtnFemale;
    private RadioButton rdBtnOther;
    private EditText edtCustomerIdText;
    private EditText edtFirstNameText;
    private EditText edtLastNameText;
    private EditText edtBirthDateText;
    private EditText edtEmailText;
    private Button btnSave;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);

        edtCustomerIdText = findViewById(R.id.editTextCustomerID);
        edtFirstNameText = findViewById(R.id.editTextFirstName);
        edtLastNameText = findViewById(R.id.editTextLastName);
        edtBirthDateText = findViewById(R.id.editTextBirthdate);
        edtEmailText = findViewById(R.id.editTextEmail);

        rdBtnMale = findViewById(R.id.radioButtonMale);
        rdBtnFemale = findViewById(R.id.radioButtonMale);
        rdBtnOther = findViewById(R.id.radioButtonOther);
        btnSave = findViewById(R.id.buttonSave);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        addDatePicker();
    }


    private void addDatePicker() {
        edtBirthDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddNewCustomerActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = "";
                month = month + 1;
                String monthName = getMonthName(month);
                if (day < 10) {
                    date = "0" + day + "/" + monthName + "/" + year;
                } else {
                    date = day + "/" + monthName + "/" + year;
                }
                edtBirthDateText.setText(date);
            }
        };


        btnSave = findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
                fieldIsEmpty();
            }
        });
    }

    public static String getMonthName(int monthNumber) {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber - 1];
    }
    public String getGender()
    {
        if (rdBtnMale.isChecked()){
            return "Male";
        }
        else if (rdBtnFemale.isChecked()) {
            return "Female";
        }
        else if(rdBtnOther.isChecked())
        {
            return "Other";
        }
        return null;
    }



    private void fieldIsEmpty() {
        boolean Flag = false;
        if (edtCustomerIdText.getText().toString().isEmpty()) {
            edtCustomerIdText.setError("Please enter Customer ID");
            Flag = true;
            return;
        }
        if (edtFirstNameText.getText().toString().isEmpty()) {
            edtFirstNameText.setError("Please enter your first name");
            Flag = true;
            return;
        }
        if (edtLastNameText.getText().toString().isEmpty()) {
            edtLastNameText.setError("Please enter your Last Name");
            Flag = true;
            return;
        }
//
    }
}
