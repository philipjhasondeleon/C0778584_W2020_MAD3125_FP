package com.example.c0778584_w2020_mad3125_fp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0778584_w2020_mad3125_fp.R;
import com.example.c0778584_w2020_mad3125_fp.ui.ShowBillDetailsActivity;
import com.example.c0778584_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>
{
    ArrayList<Customer> customersArrayList;
    public CustomerAdapter(ArrayList<Customer> customerArrayList) {
        this.customersArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        CustomerViewHolder mCustomerViewHolder = new CustomerViewHolder(mView);
        return mCustomerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerViewHolder holder, final int position) {
        Customer mCustomer = this.customersArrayList.get(position);
        holder.txtName.setText(mCustomer.getFull_name());
        holder.customerImage.setImageResource(mCustomer.getCustomerImg());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Customer customer = customersArrayList.get(position);
                Intent mIntent = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
                mIntent.putExtra("CustomerBills", customer);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.customersArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        ImageView customerImage;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtName = itemView.findViewById(R.id.txt_customer_id);
            this.customerImage = itemView.findViewById(R.id.img_customer);
        }
    }
}

