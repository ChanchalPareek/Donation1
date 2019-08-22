package com.example.assignment1inclass;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Donation> myList;

    public MyAdapter(ArrayList<Donation> arrayList) {
        myList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rows, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.donationId.setText(myList.get(i).getName());
        myViewHolder.donationAmount.setText(Integer.toString(myList.get(i).getAmount()));


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView donationId;
        public TextView donationAmount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           donationId = itemView.findViewById(R.id.donationIdRow);
            donationAmount = itemView.findViewById(R.id.donationAmountRow);
        }
    }
}
