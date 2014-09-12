package com.example.dkelley.hrwear;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyActivity extends Activity {

    TextView mHeartView;
    private TextView mStepsView;
    private AnalogClock clock;
    ImageButton exerciseButton;
    ImageButton resetButton;
    Boolean exerciseStatus = false;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_my);
        clock = (AnalogClock) this.findViewById(R.id.analogClock);
        mHeartView = (TextView) this.findViewById(R.id.heartRateText);
        mStepsView = (TextView) this.findViewById(R.id.stepText);
        chronometer = (Chronometer) this.findViewById(R.id.chronometer);

        exerciseButton = (ImageButton) this.findViewById(R.id.exerciseButton);
        exerciseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                exerciseToggle();
                exerciseStatus = !exerciseStatus;
            }
        });

        resetButton = (ImageButton) this.findViewById(R.id.stopButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                exerciseSessionReset();
            }
        });
    }

    public void exerciseToggle() {
        if (exerciseStatus) {
            exerciseSessionStarted();
        } else {
            exerciseSessionPaused();
        }
    }

    public void exerciseSessionStarted() {
        exerciseButton.setBackground(getResources().getDrawable(R.drawable.ic_action_pause));
        exerciseButton.setPressed(true);
        clock.setVisibility(View.GONE);
        chronometer.setVisibility(View.VISIBLE);
        chronometer.start();
    }

    public void exerciseSessionPaused() {
        exerciseButton.setBackground(getResources().getDrawable(R.drawable.ic_action_play));
        exerciseButton.setPressed(false);
        clock.setVisibility(View.VISIBLE);
        chronometer.setVisibility(View.GONE);
        chronometer.stop();
    }

    public void exerciseSessionReset() {
        exerciseButton.setBackground(getResources().getDrawable(R.drawable.ic_action_play));
        chronometer.setVisibility(View.GONE);
        chronometer.setBase(0);
        clock.setVisibility(View.VISIBLE);

    }
    public void setupSensors() {
       // mSensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
       // mSensorManager.connectSimulator();
//        List<Sensor> allSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
//        for (Sensor s : allSensors) {
//            Log.v("SENSOR: ", s.toString());
//        }
//        if (mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE) != null) {
//            List<Sensor> gravSensors = mSensorManager.getSensorList(Sensor.TYPE_HEART_RATE);
//            for (int i = 0; i < gravSensors.size(); i++) {
//                if ((gravSensors.get(i).getVendor().contains("Google Inc.")) &&
//                        (gravSensors.get(i).getVersion() == 3)) {
//                    // Use the version 3 gravity sensor.
//                    mSensor = gravSensors.get(i);
//                }
//            }
//        } else {
//            mHeartView.setTextColor(getResources().getColor(R.color.red));
//            mHeartView.setText("No HR Sensor!");
//        }
        //Check for pedometer
        //mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_FASTEST);
            //mSensor.
    }



}
