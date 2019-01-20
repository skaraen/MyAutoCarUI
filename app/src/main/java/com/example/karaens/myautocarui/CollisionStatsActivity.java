package com.example.karaens.myautocarui;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CollisionStatsActivity extends AppCompatActivity {
    public Geocoder geocoder;
    TextView carname,address,city,state,country,postalcode,fuel,speed,type,time;
    public List<Address> addresses;
    public CollisionStats collisionStats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collision_stats);
        carname=findViewById(R.id.carname);
        address=findViewById(R.id.address);
        city=findViewById(R.id.city);
        state=findViewById(R.id.state);
        country=findViewById(R.id.country);
        postalcode=findViewById(R.id.postalcode);
        fuel=findViewById(R.id.fuel);
        speed=findViewById(R.id.speed);
        type=findViewById(R.id.type);
        time=findViewById(R.id.time);

        collisionStats=new CollisionStats(80.2707,13.0827,"10 AM","bad","1/23/4567","Idkday","45", "IDK", "45");
        showstats();

    }

    private  void showstats()
    {

        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(collisionStats.getClat(), collisionStats.getClng(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        carname.setText(collisionStats.getCarname());
        address.setText(addresses.get(0).getAddressLine(0)); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        city.setText(addresses.get(0).getLocality());
        state.setText(addresses.get(0).getAdminArea());
        country.setText(addresses.get(0).getCountryName());
        postalcode.setText(addresses.get(0).getPostalCode());
        fuel.setText(""+collisionStats.getFuel());
        speed.setText(""+collisionStats.getSpeed());
        type.setText(collisionStats.getType());
        time.setText(collisionStats.getTime());

    }
}