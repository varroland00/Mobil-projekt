package com.example.mobil_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor temperature_sensor;
    private Sensor humidity_sensor;
    private Sensor pressure_sensor;
    private TextView textView_temp;
    private TextView textView_pres;
    private TextView textView_hum;
    private TemperatureEventHandler temperatureHandler;
    private HumidityEventHandler humidityHandler;
    private PressureEventHandler pressureHandler;
    private ImageView imageHeat;
    private ImageView imageCold;
    private ImageView imageDefaultMountain;
    private ImageView imageDefaultCloud;
    private ImageView imagePressure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_temp = findViewById(R.id.Temperature_TV);
        textView_pres = findViewById(R.id.Humidity_TV);
        textView_hum = findViewById(R.id.Pressure_TV);

        imageHeat = findViewById(R.id.imageHeat);
        imageCold = findViewById(R.id.imageCold);
        imageDefaultCloud = findViewById(R.id.imageDefaultCloud);
        imageDefaultMountain = findViewById(R.id.imageDefaultMountain);
        imagePressure = findViewById(R.id.imagePressure);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        temperature_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        humidity_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        pressure_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        temperatureHandler = new TemperatureEventHandler();
        temperatureHandler.setTv(textView_temp, imageHeat, imageCold, imageDefaultCloud, imageDefaultMountain);

        humidityHandler = new HumidityEventHandler();
        humidityHandler.setTv2(textView_pres);

        pressureHandler = new PressureEventHandler();
        pressureHandler.setTv3(textView_hum, imagePressure, imageDefaultCloud, imageDefaultMountain);

        sensorManager.registerListener(temperatureHandler, temperature_sensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(humidityHandler, humidity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(pressureHandler, pressure_sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}