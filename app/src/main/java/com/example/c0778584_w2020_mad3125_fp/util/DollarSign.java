package com.example.c0778584_w2020_mad3125_fp.util;

public class DollarSign {
    private static DollarSign repoObj = new DollarSign();
    public static DollarSign getInstance() {
        return repoObj;
    }
    private DollarSign()
    { }

    public String doubleFormatter(Double d)
    {
        return String.format("$ " + "%,.2f", d);
    }
}
