package com.example.navigationdrawerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

public class PeopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_people);

        Button buttonCama1 = (Button)findViewById(R.id.buttonCama1);
        buttonCama1.setBackgroundColor(Color.parseColor(BedColor.colorBed1));
        TextView textViewCama1 = (TextView)findViewById(R.id.textViewCama1);
        textViewCama1.setText(BedColor.estadoBed1);

        Button buttonCama2 = (Button)findViewById(R.id.buttonCama2);
        buttonCama2.setBackgroundColor(Color.parseColor(BedColor.colorBed2));
        TextView textViewCama2 = (TextView)findViewById(R.id.textViewCama2);
        textViewCama2.setText(BedColor.estadoBed2);

        Button buttonCama3 = (Button)findViewById(R.id.buttonCama3);
        buttonCama3.setBackgroundColor(Color.parseColor(BedColor.colorBed3));
        TextView textViewCama3 = (TextView)findViewById(R.id.textViewCama3);
        textViewCama3.setText(BedColor.estadoBed3);

        Button buttonCama4 = (Button)findViewById(R.id.buttonCama4);
        buttonCama4.setBackgroundColor(Color.parseColor(BedColor.colorBed4));
        TextView textViewCama4 = (TextView)findViewById(R.id.textViewCama4);
        textViewCama4.setText(BedColor.estadoBed4);

        Button buttonCama5 = (Button)findViewById(R.id.buttonCama5);
        buttonCama5.setBackgroundColor(Color.parseColor(BedColor.colorBed5));
        TextView textViewCama5 = (TextView)findViewById(R.id.textViewCama5);
        textViewCama5.setText(BedColor.estadoBed5);


    }
}

class BedColor
{
    static String colorBed1 = "#4CAF50";
    static String colorBed2 = "#4CAF50";
    static String colorBed3 = "#4CAF50";
    static String colorBed4 = "#4CAF50";
    static String colorBed5 = "#4CAF50";
    static String estadoBed1 = "Estado 1";
    static String estadoBed2 = "Estado 1";
    static String estadoBed3 = "Estado 1";
    static String estadoBed4 = "Estado 1";
    static String estadoBed5 = "Estado 1";

}

