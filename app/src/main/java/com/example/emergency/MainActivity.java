package com.example.emergency;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<EmergencyModel> emergency = new ArrayList<>();

        emergency.add(new EmergencyModel("Police", R.drawable.police1, 122, R.raw.police));
        emergency.add(new EmergencyModel("Traffic", R.drawable.light, 128, R.raw.traffic));
        emergency.add(new EmergencyModel("Fire", R.drawable.station, 180, R.raw.fireman));
        emergency.add(new EmergencyModel("Ambulance", R.drawable.ambulance, 123, R.raw.ambulance));
        EmergencyAdapter adapter = new EmergencyAdapter(emergency, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.exit:
                finish();
                break;
            case R.id.setting:
                Intent i = new Intent(MainActivity.this, Setting.class);
                startActivity(i);
                break;
            case R.id.camera:
                Intent intent = new Intent(MainActivity.this, Camera.class);
                startActivity(intent);
                break;
            case R.id.info:
                Toast.makeText(this, "App Name : Emergency App\n" + "Version: 1.0.0\n",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.mail:
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}