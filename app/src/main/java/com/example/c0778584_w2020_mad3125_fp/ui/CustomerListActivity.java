package com.example.c0778584_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.c0778584_w2020_mad3125_fp.R;
import com.example.c0778584_w2020_mad3125_fp.adapter.CustomerAdapter;
import com.example.c0778584_w2020_mad3125_fp.model.Customer;
import com.example.c0778584_w2020_mad3125_fp.util.DataSingleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView rvCustomers;
    private ArrayList customers;
    private ArrayList customerArrayList;
    private CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        rvCustomers =findViewById(R.id.rv_customer_list);

        rvCustomers = findViewById(R.id.rv_customer_list);
        populateCustomers();

        customerAdapter = new CustomerAdapter(customers);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCustomers.setLayoutManager(mLinearLayoutManager);
        rvCustomers.setAdapter(customerAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.buttonAdd:
                startActivity(new Intent(CustomerListActivity.this, AddNewCustomerActivity.class));
        }
        return true;
    }

    private void populateCustomers() {
        DataSingleton.getInstance().populateData();
        customers = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataSingleton.getInstance().getCustomerMap();
        Collection<Customer> demoValues = customerHashMap.values();
        customerArrayList = new ArrayList<>(demoValues);
        customers.addAll(customerArrayList);

    }

}

