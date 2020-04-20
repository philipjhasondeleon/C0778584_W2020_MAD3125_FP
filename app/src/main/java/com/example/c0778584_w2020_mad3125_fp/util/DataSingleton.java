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
                "Male","jhasondeleon@gmail.com","Philip","asd123","Toronto",
                "03/02/1997", R.drawable.person_male);
        Customer c2 = new Customer("C2","Karen","Sy",
                "Female","karen@gmail.com","karen","karen123","Scarborough",
                "12/24/1998", R.drawable.person_female);
        Mobile m1 = new Mobile("M1",
                "1/11/2020",
                Bill.BillType.Mobile,
                "HUAWEI INC.",
                "Unli Call All Day",
                "8636781990",
                21,
                50);
        Hydro h1 = new Hydro( "H1",
                "5/19/2019",
                Bill.BillType.Hydro,
                "Waters",
                9);
        Internet in1 = new Internet("I1",
                "8/23/2020",
                Bill.BillType.Internet,
                "Fido",
                19.4);
        c2.addBill("I1", in1);
        c1.addBill("M1", m1);
        c1.addBill("H1", h1);
        customerMap.put(c1.getCustomerId(),c1);
        customerMap.put(c2.getCustomerId(),c2);

    }
}