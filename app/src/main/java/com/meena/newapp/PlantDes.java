package com.meena.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class PlantDes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_des);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            String aPos = getIntent().getStringExtra("pos");
            int pos = Integer.parseInt(aPos);

            TextView tv1 = findViewById(R.id.textView);

            TextView tv2 = findViewById(R.id.textView2);

            TextView tv3 = findViewById(R.id.textView3);

            TextView tv4 = findViewById(R.id.textView4);

            ImageView image = findViewById(R.id.imageView);

            String json = getJsonString();
            String name="",bname="",parts="",uses="",images="";
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray events = jsonObject.getJSONArray("plant");
                JSONObject a = (JSONObject)events.getJSONObject(pos);

                name= a.getString("name");
                bname= a.getString("bname");
                uses= a.getString("uses");
                parts= a.getString("parts");
                images=a.getString("image");

                int resourceId = getResources().getIdentifier(images, "drawable", "com.meena.newapp");
                image.setImageResource(resourceId);

                tv1.setText(name);
                tv2.setText(bname);
                tv3.setText(uses);
                tv4.setText(parts);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        String getJsonString(){
            String json = null;
            try {
                InputStream inputStream = getAssets().open("plant.txt");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return json;
        }

    public boolean onOptionsItemSelected(MenuItem item){
        int me=item.getItemId();
        if(me==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }



    }
