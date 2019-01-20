package com.meena.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class RemedyDes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedy_des);
        //back
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //JSON
        String aPos = getIntent().getStringExtra("pos");
        int pos = Integer.parseInt(aPos);

        TextView tv1 = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);

        String json = getJsonString();
        String name="",uses1="",uses2="",uses3="";
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray events = jsonObject.getJSONArray("remedy");
            JSONObject a = (JSONObject)events.getJSONObject(pos);

            name= a.getString("name");
            uses1= a.getString("use1");
            uses2= a.getString("use2");
            uses3= a.getString("use3");
            tv1.setText(name);
            tv2.setText(uses1);
            tv3.setText(uses2);
            tv4.setText(uses3);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    String getJsonString(){
        String json = null;
        try {
            InputStream inputStream = getAssets().open("remedies.txt");
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
