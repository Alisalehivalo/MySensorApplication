package ir.airport.mysensorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
private SensorManager sensorManager;
private Sensor acceleremeter,mMagno,mGyro,mPressure,mLight,mTemp,mHumi;
TextView xValue,yValue,zValue,xGValue,yGValue,zGValue,xMValue,yMValue,zMValue,light,pres,temp,humi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xValue=findViewById(R.id.xValue);
        yValue=findViewById(R.id.yValue);
        zValue=findViewById(R.id.zValue);
        xGValue=findViewById(R.id.xGValue);
        yGValue=findViewById(R.id.yGValue);
        zGValue=findViewById(R.id.zGValue);
        xMValue=findViewById(R.id.xMValue);
        yMValue=findViewById(R.id.yMValue);
        zMValue=findViewById(R.id.zMValue);
        light=findViewById(R.id.light);
        pres=findViewById(R.id.pressure);
        humi=findViewById(R.id.humi);
        temp=findViewById(R.id.temp);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acceleremeter=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (acceleremeter != null){
            sensorManager.registerListener(MainActivity.this,acceleremeter,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG1","Oncreate Registerd");
             }else {
            xValue.setText("Not Supported");
            yValue.setText("Not Supported");
            zValue.setText("Not Supported");
        }
        mGyro=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGyro != null){
            sensorManager.registerListener(MainActivity.this,mGyro,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG2","Oncreate Registerd");
        }else {
            xGValue.setText("Not Supported");
            yGValue.setText("Not Supported");
            zGValue.setText("Not Supported");
        }
        mMagno=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mMagno != null){
            sensorManager.registerListener(MainActivity.this,mMagno,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG3","Oncreate Registerd");
        }else {
            xMValue.setText("Not Supported");
            yMValue.setText("Not Supported");
            zMValue.setText("Not Supported");
        }
        mLight=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight != null){
            sensorManager.registerListener(MainActivity.this,mLight,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG4","Oncreate Registerd");
        }else {
            light.setText("Not Supported");

        }
        mPressure=sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mPressure != null){
            sensorManager.registerListener(MainActivity.this,mPressure,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG5","Oncreate Registerd");
        }else {
            pres.setText("Not Supported");

        }
        mTemp=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (mTemp != null){
            sensorManager.registerListener(MainActivity.this,mTemp,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG6","Oncreate Registerd");
        }else {
            temp.setText("Not Supported");

        }
        mHumi=sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (mHumi != null){
            sensorManager.registerListener(MainActivity.this,mHumi,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG7","Oncreate Registerd");
        }else {
            humi.setText("Not Supported");

        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            xValue.setText("x:"+event.values[0]);
            yValue.setText("y:"+event.values[1]);
            zValue.setText("z:"+event.values[2]);
        }else if (sensor.getType() == Sensor.TYPE_GYROSCOPE){
            xGValue.setText("x:"+event.values[0]);
            yGValue.setText("y:"+event.values[1]);
            zGValue.setText("z:"+event.values[2]);
        }else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            xMValue.setText("x:"+event.values[0]);
            yMValue.setText("y:"+event.values[1]);
            zMValue.setText("z:"+event.values[2]);
        }else if (sensor.getType() == Sensor.TYPE_LIGHT){
            light.setText("Light:"+event.values[0]);

        }else if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            temp.setText("Temp: "+event.values[0]);

        }else if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
            humi.setText("Humidity: "+event.values[0]);

        }else if (sensor.getType() == Sensor.TYPE_PRESSURE){
            pres.setText("Pressure: "+event.values[0]);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
