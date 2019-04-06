package com2027.toolbox.group12.toolbox;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Dennis Ocaka
 *
 * Created at: 03/04/2019
 * Updated at: 05/04/2019
 *
 * The class Contains an implementation of the list view that populates the list with some dummy values aswell
 * as the code needed to fetch the users location. I have not yet included how we fetch the location that needs to be decided, hourly, weekly etc...
 */
public class ListActivity extends AppCompatActivity {

    /* GoogleAPI used to return the users coords */
    private FusedLocationProviderClient client;
    /* A list of tools available */
    private List<Tool> Tools;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise client with the activity it will be used in
        client = LocationServices.getFusedLocationProviderClient(this);

        Uri uri = null;

        // Add some random dummy tools to test the list view
        Tools = new ArrayList<>();
        Tools.add(new Tool("Hammer 38XP200 type B", PayRate.DAY, 12.50, 1, uri ));
        Tools.add(new Tool("Spade", PayRate.DAY, 12.50, 5, uri));
        Tools.add(new Tool("Drill", PayRate.HOUR, 12.50, 3, uri));
        Tools.add(new Tool("Hammer 38XP200 type B", PayRate.DAY, 12.50, 1, uri ));
        Tools.add(new Tool("Spade", PayRate.DAY, 12.50, 5, uri));
        Tools.add(new Tool("Drill", PayRate.HOUR, 12.50, 3, uri));
        Tools.add(new Tool("Hammer 38XP200 type B", PayRate.DAY, 12.50, 1, uri ));
        Tools.add(new Tool("Spade", PayRate.DAY, 12.50, 5, uri));
        Tools.add(new Tool("Drill", PayRate.HOUR, 12.50, 3, uri));
        Tools.add(new Tool("Hammer 38XP200 type B", PayRate.DAY, 12.50, 1, uri ));
        Tools.add(new Tool("Spade", PayRate.DAY, 12.50, 5, uri));
        Tools.add(new Tool("Drill", PayRate.HOUR, 12.50, 3, uri));


        // Initialise the RecyclerView used to present the list
        RecyclerView view = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this, Tools);
        // Define LayoutManager properties: Current content
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(mAdapter);

        // Check if the user has enabled Runtime locations in order to user LocationServices
        if (runtime_permissions()) {
            // Return the best most recent location currently available
            client.getLastLocation().addOnSuccessListener(ListActivity.this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) { // Called when a Task completes successfully

                    if (location != null) {  // if location is available
                        Toast.makeText(ListActivity.this, "Longitude: " + location.getLongitude() + " , Latitude: " + location.getLatitude(), Toast.LENGTH_SHORT);
                    } else {   // otherwise
                        Toast.makeText(ListActivity.this, "No location has been returned", Toast.LENGTH_SHORT);
                    }
                }
            });
        }


    }



    /**
     * In newer Android versions, in order to be able to use the Location Manager class, you will be required to provide the necessary permissions during run-time –
     * Runtime permission check which checks that users with a SDK version
     */
    private boolean runtime_permissions() {
        boolean status = false;

        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
        } else {
            status = true;
        }

        return status;
    }
}
