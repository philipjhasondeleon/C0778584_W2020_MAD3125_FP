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

import com.example.c0778584_w2020_mad3125_fp.R;

import java.util.Calendar;


public class AddNewBillActivity extends AppCompatActivity {

    private EditText edtBillIdText;
    private EditText edtBillDateText;
    private EditText edtBillType;
    private Button btnSaveBill;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);


        edtBillIdText = findViewById(R.id.editTextBillID);
        edtBillDateText = findViewById(R.id.editTextBillDate);
        edtBillType = findViewById(R.id.editTextBillType);
        btnSaveBill = findViewById(R.id.buttonSaveBill);

        addDatePicker();
    }
    private void addDatePicker() {
        edtBillDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddNewBillActivity.this,
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
                edtBillDateText.setText(date);
            }
        };

        btnSaveBill = findViewById(R.id.buttonSaveBill);
        btnSaveBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                fieldIsEmpty();
            }
        });

    }
    public static String getMonthName(int monthNumber) {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber - 1];
    }
    private void fieldIsEmpty() {
        boolean Flag = false;
        if (edtBillIdText.getText().toString().isEmpty()) {
            edtBillIdText.setError("Please enter Bill ID");
            Flag = true;
            return;
        }
//
    }
}
