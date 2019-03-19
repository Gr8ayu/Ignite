package com.example.ignite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LeadersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaders);

        final ArrayList<textAndImage> leaders = new ArrayList<textAndImage>();

        leaders.add(new textAndImage(R.drawable.sample_icon, "Narendra Modi"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "Rahul Gandhi"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "Amit Shah"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "Mayavati"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "Arvind Kejriwal"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "L K Advani"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "Sushma Swaraj"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "Sonia Gandhi"));
        leaders.add(new textAndImage(R.drawable.sample_icon, "Smriti Irani"));

        textAndImageAdapter adapter = new textAndImageAdapter(this, leaders);

        ListView listView =(ListView) findViewById(R.id.leaders);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textAndImage temp = leaders.get(position);
                Toast.makeText(getApplicationContext(),temp.getContentName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
