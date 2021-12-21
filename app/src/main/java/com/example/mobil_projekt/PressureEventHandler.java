package com.example.mobil_projekt;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PressureEventHandler implements SensorEventListener {

    private TextView textview_pres;
    private ImageView imagePressure;
    private ImageView imageDefaultMountain;
    private ImageView imageDefaultCloud;

    public void setTv3(TextView textview_pres, ImageView imagePressure, ImageView imageDefaultCloud, ImageView imageDefaultMountain) {
        this.textview_pres = textview_pres;
        this.imagePressure = imagePressure;
        this.imageDefaultMountain = imageDefaultMountain;
        this.imageDefaultCloud = imageDefaultCloud;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textview_pres.setText(sensorEvent.values[0] +" hPa");

        if (Float.parseFloat(sensorEvent.values[0] + "") > 800)
        {
            imagePressure.setVisibility(View.VISIBLE);
            imageDefaultCloud.setVisibility(View.INVISIBLE);
            imageDefaultMountain.setVisibility(View.INVISIBLE);
        }
        else
        {
            imageDefaultCloud.setVisibility(View.VISIBLE);
            imageDefaultMountain.setVisibility(View.VISIBLE);
            imagePressure.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
