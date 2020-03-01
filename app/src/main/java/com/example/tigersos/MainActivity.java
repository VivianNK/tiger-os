package com.example.tigersos;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.w3c.dom.Document;

import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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


        /*
         * Establish db connection
         */
        MongoClientURI uri = new MongoClientURI(
                "mongodb://<username>:<password>@tigersos-cluster1-shard-00-00-hhhlw.gcp.mongodb.net:27017,tigersos-cluster1-shard-00-01-hhhlw.gcp.mongodb.net:27017,tigersos-cluster1-shard-00-02-hhhlw.gcp.mongodb.net:27017/test?ssl=true&replicaSet=TigerSOS-Cluster1-shard-0&authSource=admin&retryWrites=true&w=majority");

        MongoClient mongoClient = null;

        try {
            mongoClient = new MongoClient(uri);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        assert mongoClient != null;
        DB db = mongoClient.getDB("journaldev");
        DBCollection col = db.getCollection("users");
    }

}
