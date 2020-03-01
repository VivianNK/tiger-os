package com.example.tigersos;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //Ari's stuff:

        //Setting Ritchie button and making him disappear
        Button ritchie = findViewById(R.id.ritchie);





        /**
        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new MyLocationListener(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //If the user doesn't give GPS permissions, quit.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
        */
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        ritchie.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                //Creating dialog box for confirmation of safety
                dialog.setMessage("Are you in a safe location?");
                dialog.setTitle("");
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        //TODO: Take location info
                        //TODO: Text public safety (or Ari)
                    }
                });
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        // Do nothing presumably??
                    }
                });

                AlertDialog message = dialog.create();
                message.show();







                //TODO: make dialogue box asking whether or not the user is safe.
                //TODO  if yes, then quit the app
                //TODO  if no, text Public Safety
                //Location Stuff
                //TODO: figure out how to send location
                /*Location recentLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                System.out.println("Latitude: " + recentLocation.getLatitude());
                System.out.println("Longitude: " + recentLocation.getLongitude());*/

                //Send text
                //sendSMS();
                }
        });
    }

    private void sendSMS(){
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(String.valueOf(this)), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("5705751358", null, "Hi Ari :)", pi, null);

    }

}
