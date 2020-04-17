package com.example.c0778584_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c0778584_w2020_mad3125_fp.adapter.CustomerAdapter;
import com.example.c0778584_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

        private RecyclerView rvCustomers;
        private ArrayList<Customer> customers;
        private CustomerAdapter customerAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_customer_list);
            rvCustomers =findViewById(R.id.rv_cust_list);

            rvCustomers = findViewById(R.id.rv_cust_list);
            populateCustomers();

            customerAdapter = new CustomerAdapter(customers);
            RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rvCustomers.setLayoutManager(mLinearLayoutManager);
            rvCustomers.setAdapter(customerAdapter);

        }

        private void populateCustomers() {
            customers = new ArrayList<>();
            customers.add(new Customer("1","Philip","DeLeon",
                    "Male","jhasondeleon@gmail.com","asd","asd","Wilson",
                    "01/01/1991",R.drawable.person_male));
        }

    }
