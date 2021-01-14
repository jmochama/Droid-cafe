package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY="MY KEY FOR ORDER MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //implement an explicit intent for opening the order activity
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);

            }
        });
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

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
      //  }
//create a switch case block to handle the clicks on the menu items
        switch(item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_call:
                //implement an implicit intent that calls your number
                Uri myUri = Uri.parse("tel:0748842671");
                Intent myIntent = new Intent(Intent.ACTION_DIAL,myUri);
                startActivity(myIntent);
                return true;
                //ADD THE CASE FOR THE OPTIONS
                //ENSURE THE ITEM ABOUT US OPENS A WEB PAGE AND LOCATE US ITEM OPENS A GOOGLE MAP SHOWING YOUR LATITUDE AND LONGITUDE
            case R.id.location:
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=0.518470,35.273911");
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
                return true;

            case R.id.action_about_us:
                String url = "https://www.coffeebean.com/our-story";
                Intent urlIntent = new Intent(Intent.ACTION_VIEW);
                urlIntent.setData(Uri.parse(url));
                startActivity(urlIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //a method for displaying toast messages
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }

    public void showIceCreamMessage(View view) {
        //define what will be done when the user clicks on the image view
        //e.g showing a toast
        //ot even adding an item to a shopping cart or in our case showing a toast
       //displayToast(getString(R.string.ice_cream_order));
        mOrderMessage=getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showDonutOrderMessage(View view) {

        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
        //displayToast(getString(R.string.donut_order));

    }


    public void showFroyoOrderMessage(View view) {

        mOrderMessage = getString(R.string.foroyo_order);
        displayToast(mOrderMessage);

        //displayToast(getString(R.string.froyo_order));
    }
}
