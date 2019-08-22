package com.example.assignment1inclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPickerDonation;
    private TextView    textViewAmount;
    private ProgressBar progressBar;
    private int target = 100000;
    private TextView enterAmount;
    private EditText amount_enter;

    int donationTotal = 0;

    ArrayList<Donation> DonationArrayList = new ArrayList<>();

    Donation d = null;
    private RadioGroup paymentMethod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        numberPickerDonation = findViewById(R.id.numberPickerDonation);
        textViewAmount = findViewById(R.id.textViewTotalAmount);

        paymentMethod = findViewById(R.id.radioGroup);
        progressBar = findViewById(R.id.progressBar);

        enterAmount = findViewById(R.id.enterAmount);
        amount_enter = findViewById(R.id.amount_enter);

        numberPickerDonation.setMinValue(0);
        numberPickerDonation.setMaxValue(1000);
        progressBar.setMax(target);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDonation();
            }
        });
    }

    private void addDonation() {
        
        String method = paymentMethod.getCheckedRadioButtonId()==R.id.payPal ? "Paypal" : "Direct";
        int donation = numberPickerDonation.getValue();
        String donationId = "Donation" + Integer.toString(DonationArrayList.size() + 1);
        String EnterAmount = amount_enter.getText().toString();

        if(donation == 0) {
            if(!EnterAmount.isEmpty()) {
               donation = Integer.parseInt(EnterAmount);
            }
        }
        d = new Donation(method, donation);

        if (donation != 0) {

            DonationArrayList.add(d);

            donationTotal += donation;

            //donationTotal = donation + donationTotal;
            progressBar.setProgress(donationTotal);
            String donationTotalString = "$" + donationTotal;
            textViewAmount.setText(donationTotalString);
            amount_enter.setText("0");
            numberPickerDonation.setValue(Integer.parseInt("0"));


        }
        else {
            Toast.makeText(this, "Please donate", Toast.LENGTH_SHORT).show();

        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(!DonationArrayList.isEmpty()) {

            Bundle b = new Bundle();
            b.putParcelableArrayList("myKey", DonationArrayList);

            Intent i = new Intent( this, ViewDonations.class);

            i.putExtras(b);

            startActivity(i);
        }
        else  {
            Toast toast = Toast.makeText(getApplicationContext(), "please donate first", Toast.LENGTH_LONG);
            toast.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
