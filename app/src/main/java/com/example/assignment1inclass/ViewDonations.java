package com.example.assignment1inclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ViewDonations extends AppCompatActivity {

    ArrayList<Donation> ArrayList;

    private RecyclerView my_recycler_view;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donations);

        my_recycler_view = findViewById(R.id.my_recycler_view);

        Bundle b = this.getIntent().getExtras();
        ArrayList = b.getParcelableArrayList("myKey");

        //my_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        myAdapter = new MyAdapter(ArrayList);

        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setAdapter(myAdapter);
    }
}
