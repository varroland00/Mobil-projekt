package com.example.mobil_projekt;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class HumidityEventHandler implements SensorEventListener {

    private TextView textview_hum;

    public void setTv2(TextView textview_hum) {
        this.textview_hum = textview_hum;
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textview_hum.setText(sensorEvent.values[0] +" %");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
