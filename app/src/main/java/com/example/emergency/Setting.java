package com.example.emergency;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        RadioGroup group = findViewById(R.id.radioGroup);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                switch (id) {
                    case R.id.small:
                        SharedPreferences.Editor editor;
                        editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
                        editor.putInt("textSize", 16);
                        editor.apply();
                        break;
                    case R.id.medium:
                        SharedPreferences.Editor editor1;
                        editor1 = getSharedPreferences("shared", MODE_PRIVATE).edit();
                        editor1.putInt("textSize", 32);
                        editor1.apply();
                    case R.id.large:
                        SharedPreferences.Editor editor2;
                        editor2 = getSharedPreferences("shared", MODE_PRIVATE).edit();
                        editor2.putInt("textSize", 64);
                        editor2.apply();
                }
            }
        });


    }


}