package com.meena.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class SpicesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spices_list);
        //back
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //json
        String json = getJsonString();
        String name="";
        ListView lv = findViewById(R.id.spicesList);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray events = jsonObject.getJSONArray("spice");

            String plant[] = new String[events.length()];
            for(int i =0; i<events.length();i++){
                JSONObject a = (JSONObject)events.getJSONObject(i);
                plant[i] = a.getString("name");
                name = name +a.getString("name")+"\n";
            }
            ArrayAdapter aa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,plant);
            lv.setAdapter(aa);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SpicesList.this, SpicesDes.class);
                intent.putExtra("pos",String.valueOf(position));
                startActivity(intent);
            }
        });
    }

    String getJsonString(){
        String json = null;
        try {
            InputStream inputStream = getAssets().open("spices.txt");
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
