package com.meena.newapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void first(View view)
    {
        startActivity(new Intent(this,PlantList.class));
    }
    public void second(View view)
    {
        startActivity(new Intent(this,FruitList.class));
    }
    public void third(View view)
    {
        startActivity(new Intent(this,SpicesList.class));
    }
    public void forth(View view)
    {
        startActivity(new Intent(this,RemedyList.class));
    }

}

/*
public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button one = (Button) findViewById(R.id.textView);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.button4);
        three.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
               startActivity(new Intent(this,PlantList.class));
                Toast.makeText(getApplicationContext(),"List of Plants",Toast.LENGTH_LONG).show();
                break;

            case R.id.button2:
                startActivity(new Intent(this,PlantList.class));
                break;

            case R.id.button3:
                startActivity(new Intent(this,PlantDes.class));
                break;
            case R.id.button4:
                // do your code
                break;
            default:
                break;
        }

    }*/