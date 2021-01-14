package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //get the intent and send from the main activity
        Intent intent= getIntent();
        String displayMessage = intent.getStringExtra(MainActivity.EXTRA_ORDER_KEY);
        //create a textview variable to connect with the textview in the layout
        TextView orderDisplay=findViewById(R.id.display_order);
        //setting the textview with the message retrieved from main activity
        orderDisplay.setText(displayMessage);

    }
//this method will handle checked radio buttons
    public void onRadioButtonClicked(View view) {
        //define what to do with the checked radio button
        //create a boolean variable and use the method checked to determine if a redio button is checked
        boolean checked =((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.same_day:
            if(checked)
                displayToast(getString(R.string.same_day_messenger_services));
            break;
            case R.id.next_day:
            if(checked)
                displayToast(getString(R.string.next_day_ground_delivery));
            break;
            case R.id.pick_up:
            if(checked)
                displayToast(getString(R.string.pick_up));
            break;
            default:
            //do something
                break;
        }
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
