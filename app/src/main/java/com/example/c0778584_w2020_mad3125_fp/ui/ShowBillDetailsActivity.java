package com.example.c0778584_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c0778584_w2020_mad3125_fp.R;
import com.example.c0778584_w2020_mad3125_fp.fragment.BillFragment;
import com.example.c0778584_w2020_mad3125_fp.model.Bill;
import com.example.c0778584_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;


public class ShowBillDetailsActivity extends AppCompatActivity {
        FragmentManager mFragmentManager;
        FragmentTransaction mFragmentTransaction;
        private TextView txtTotalAmount;
        private ImageView imgAddButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_bill_details);

            Intent mIntent = getIntent();
            Customer customerObj = mIntent.getParcelableExtra("CustomerBills");

            ArrayList<Bill> bills = customerObj.getBills();

           // txtTotalAmount = findViewById(R.id.);
            imgAddButton = findViewById(R.id.buttonAdd);

            imgAddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(ShowBillDetailsActivity.this, AddNewBillActivity.class);
                    startActivity(mIntent);
                }
            });


            ActionBar mActionBar = getSupportActionBar();
            mActionBar.hide();

            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.container, new BillFragment());
            mFragmentTransaction.commit();


        }


}
