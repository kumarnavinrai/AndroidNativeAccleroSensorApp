package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null){
            //Acccelro sensor code
//            Sensor accleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//            if(accleroSensor!=null){
//                sensorManager.registerListener((SensorEventListener) this, accleroSensor, SensorManager.SENSOR_DELAY_NORMAL);
//            }
            //Proxmity sensor code
//            Sensor proxiSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
//            if(proxiSensor!=null){
//                sensorManager.registerListener((SensorEventListener) this, proxiSensor, SensorManager.SENSOR_DELAY_NORMAL);
//            }
            //Light Sensor code
            Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(lightSensor!=null){
                sensorManager.registerListener((SensorEventListener) this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }

        } else {
            Toast.makeText(this, "Sensor service not detected.", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onSensorChanged(SensorEvent event){
        //Acccelro sensor code
//        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
//            ((TextView)findViewById(R.id.txtValues)).setText("X:"+event.values[0] + ", Y: " + event.values[1] + ", Z: " + event.values[2]);
//        }
        //PROXMITY SENSOR CODE
//        if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
//            ((TextView)findViewById(R.id.txtValues)).setText("Values" + event.values[0]);
//
//            if(event.values[0] > 0) {
//                Toast.makeText(this, "Object is Far", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Object is near", Toast.LENGTH_SHORT).show();
//            }
//        }
        if(event.sensor.getType()==Sensor.TYPE_LIGHT){
            ((TextView)findViewById(R.id.txtValues)).setText("Values" + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}