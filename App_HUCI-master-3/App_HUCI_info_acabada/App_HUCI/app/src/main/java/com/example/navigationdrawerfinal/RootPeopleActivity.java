package com.example.navigationdrawerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RootPeopleActivity extends AppCompatActivity {

    Button  buttonState1, buttonState2, buttonState3, buttonSwitchBed, buttonBed;
    EditText editTextNumberBed;
    TextView textBedState;
    String Bed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_people);

        buttonBed = findViewById(R.id.buttonBed);
        buttonState1 = findViewById(R.id.buttonState1);
        buttonState2 = findViewById(R.id.buttonState2);
        buttonState3 = findViewById(R.id.buttonState3);
        buttonSwitchBed = findViewById(R.id.buttonSwitchBed);
        textBedState = findViewById(R.id.textBedState);
        editTextNumberBed = findViewById(R.id.editTextNumberBed);

        Bed = "1";
        buttonBed.setBackgroundColor(Color.parseColor(BedColor.colorBed1));
        textBedState.setText(BedColor.estadoBed1);



        //button switch bed
        buttonSwitchBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = editTextNumberBed.getText().toString();
                buttonBed.setText("CAMA "+ number);
                Bed = number;
                switch (Bed) {
                    case "1":
                        buttonBed.setBackgroundColor(Color.parseColor(BedColor.colorBed1));
                        textBedState.setText(BedColor.estadoBed1);
                        break;
                    case "2":
                        buttonBed.setBackgroundColor(Color.parseColor(BedColor.colorBed2));
                        textBedState.setText(BedColor.estadoBed2);
                        break;
                    case "3":
                        buttonBed.setBackgroundColor(Color.parseColor(BedColor.colorBed3));
                        textBedState.setText(BedColor.estadoBed3);
                        break;
                    case "4":
                        buttonBed.setBackgroundColor(Color.parseColor(BedColor.colorBed4));
                        textBedState.setText(BedColor.estadoBed4);
                        break;
                    default:
                        buttonBed.setBackgroundColor(Color.parseColor(BedColor.colorBed5));
                        textBedState.setText(BedColor.estadoBed5);
                        break;
                }
            }
        });

        //button state 1
        buttonState1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                buttonBed.setBackgroundColor(Color.parseColor("#4CAF50"));
                textBedState.setText("Estado 1");

                switch (Bed) {
                    case "1":
                        BedColor.colorBed1 = "#4CAF50";
                        BedColor.estadoBed1 = "Estado 1";
                        break;
                    case "2":
                        BedColor.colorBed2 = "#4CAF50";
                        BedColor.estadoBed2 = "Estado 1";
                        break;
                    case "3":
                        BedColor.colorBed3 = "#4CAF50";
                        BedColor.estadoBed3 = "Estado 1";
                        break;
                    case "4":
                        BedColor.colorBed4 = "#4CAF50";
                        BedColor.estadoBed4 = "Estado 1";
                        break;
                    default:
                        BedColor.colorBed5 = "#4CAF50";
                        BedColor.estadoBed5 = "Estado 1";
                        break;
                }
            }
        });

        //button state 2
        buttonState2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                buttonBed.setBackgroundColor(Color.parseColor("#E8D317"));
                textBedState.setText("Estado 2");
                switch (Bed) {
                    case "1":
                        BedColor.colorBed1 = "#E8D317";
                        BedColor.estadoBed1 = "Estado 2";
                        break;
                    case "2":
                        BedColor.colorBed2 = "#E8D317";
                        BedColor.estadoBed2 = "Estado 2";
                        break;
                    case "3":
                        BedColor.colorBed3 = "#E8D317";
                        BedColor.estadoBed3 = "Estado 2";
                        break;
                    case "4":
                        BedColor.colorBed4 = "#E8D317";
                        BedColor.estadoBed4 = "Estado 2";
                        break;
                    default:
                        BedColor.colorBed5 = "#E8D317";
                        BedColor.estadoBed5 = "Estado 2";
                        break;
                }
            }
        });

        //button state 3
        buttonState3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                buttonBed.setBackgroundColor(Color.parseColor("#F44336"));
                textBedState.setText("Estado 3");
                switch (Bed) {
                    case "1":
                        BedColor.colorBed1 = "#F44336";
                        BedColor.estadoBed1 = "Estado 3";
                        break;
                    case "2":
                        BedColor.colorBed2 = "#F44336";
                        BedColor.estadoBed2 = "Estado 3";
                        break;
                    case "3":
                        BedColor.colorBed3 = "#F44336";
                        BedColor.estadoBed3 = "Estado 3";
                        break;
                    case "4":
                        BedColor.colorBed4 = "#F44336";
                        BedColor.estadoBed4 = "Estado 3";
                        break;
                    default:
                        BedColor.colorBed5 = "#F44336";
                        BedColor.estadoBed5 = "Estado 3";
                        break;
                }
            }
        });

    }
}