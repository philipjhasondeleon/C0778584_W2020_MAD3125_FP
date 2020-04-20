package com.example.c0778584_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.c0778584_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddNewCustomerActivity extends AppCompatActivity {

    private RadioButton rdBtnMale;
    private RadioButton rdBtnFemale;
    private RadioButton rdBtnOther;
    private EditText edtCustomerIdText;
    private EditText edtFirstNameText;
    private EditText edtLastNameText;
    private EditText edtBirthDateText;
    private EditText edtEmailText;
    private Button btnAdd;
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
        rdBtnMale = findViewById(R.id.);
        rdBtnFemale = findViewById(R.id.rdBtnFemale);
        rdBtnOther = findViewById(R.id.rdBtnOther);
        btnAdd = findViewById(R.id.btnAdd);
    }
}
