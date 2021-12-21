package com.example.mobil_projekt;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TemperatureEventHandler implements SensorEventListener {
    private TextView textview_temp;
    private ImageView imageHeat;
    private ImageView imageCold;
    private ImageView imageDefaultMountain;
    private ImageView imageDefaultCloud;

    public void setTv(TextView textview_temp, ImageView imageHeat, ImageView imageCold, ImageView imageDefaultCloud, ImageView imageDefaultMountain) {
        this.textview_temp = textview_temp;
        this.imageHeat = imageHeat;
        this.imageCold = imageCold;
        this.imageDefaultMountain = imageDefaultMountain;
        this.imageDefaultCloud = imageDefaultCloud;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textview_temp.setText(sensorEvent.values[0] +" °C");

        if (Float.parseFloat(sensorEvent.values[0] + "") > 40)
        {
            imageHeat.setVisibility(View.VISIBLE);
            imageDefaultCloud.setVisibility(View.INVISIBLE);
            imageDefaultMountain.setVisibility(View.INVISIBLE);
        }
        else if (Float.parseFloat(sensorEvent.values[0] + "") < -10)
        {
            imageCold.setVisibility(View.VISIBLE);
            imageDefaultCloud.setVisibility(View.INVISIBLE);
            imageDefaultMountain.setVisibility(View.INVISIBLE);
        }
        else
        {
            imageDefaultCloud.setVisibility(View.VISIBLE);
            imageDefaultMountain.setVisibility(View.VISIBLE);
            imageCold.setVisibility(View.INVISIBLE);
            imageHeat.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
