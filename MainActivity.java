package com.example.geocoding;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText editText_address;
TextView textView;
Button button;
Geocoder geocoder;
List<Address> addressList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText_address=(EditText) findViewById(R.id.e_address);
         button=(Button) findViewById(R.id.btn);
         textView=(TextView) findViewById(R.id.text);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 geocoder=new Geocoder(MainActivity.this);
                 try {
                     addressList=geocoder.getFromLocationName(editText_address.getText().toString(),1);
                     if (addressList!=null){
                         double doublelat = addressList.get(0).getLatitude();
                         double doublelon=addressList.get(0).getLongitude();
                         textView.setText(" Latitude is: " + String.valueOf(doublelat) +" || "+ " Longtitude is " + String.valueOf(doublelon));
                         }
                 }catch (Exception e){

                 }
             }
         });
    }
}