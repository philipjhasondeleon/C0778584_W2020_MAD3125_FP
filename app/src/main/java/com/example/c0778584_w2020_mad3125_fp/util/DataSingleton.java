package com.example.c0778584_w2020_mad3125_fp.util;

import com.example.c0778584_w2020_mad3125_fp.R;
import com.example.c0778584_w2020_mad3125_fp.model.Bill;
import com.example.c0778584_w2020_mad3125_fp.model.Customer;
import com.example.c0778584_w2020_mad3125_fp.model.Hydro;
import com.example.c0778584_w2020_mad3125_fp.model.Internet;
import com.example.c0778584_w2020_mad3125_fp.model.Mobile;

import java.util.HashMap;

public class DataSingleton {
    private static DataSingleton repoObj = new DataSingleton();
    public static DataSingleton getInstance() {
        return repoObj;
    }
    private DataSingleton() { }
    private HashMap<String, Customer> customerMap = new HashMap<>();

    public HashMap getCustomerMap(){
        return this.customerMap;
    }
    public void populateData()
    {
        Customer c1 = new Customer("C1","Philip","DeLeon",
                "Male","jhasondeleon@gmail.com","asd","asd","Toronto",
                "03/02/1997", R.drawable.person_male);
        Customer c2 = new Customer("C2","Karen","Sy",
                "Female","karena@gmail.com","123","123","Scarborough",
                "12/12/1998",R.drawable.person_female);
        Mobile m1 = new Mobile("M01",
                "3/10/2012",
                Bill.BillType.Mobile,
                "SAMSUNG",
                "All Canada Plan",
                "8634750302",
                3,
                32);
        Hydro h1 = new Hydro( "H01",
                "10/5/2012",
                Bill.BillType.Hydro,
                "HydroCA",
                16);
        Internet in1 = new Internet("I01",
                "10/6/2013",
                Bill.BillType.Internet,
                "Fido",
                41);
        c2.addBill("I01", in1);
        c1.addBill("M01", m1);
        c1.addBill("H01", h1);
        customerMap.put(c1.getCustomerId(),c1);
        customerMap.put(c2.getCustomerId(),c2);
    }
}