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

        leaders.add(new textAndImage(R.drawable.namo, "Narendra Modi"));
        leaders.add(new textAndImage(R.drawable.raga, "Rahul Gandhi"));
        leaders.add(new textAndImage(R.drawable.amitshah, "Amit Shah"));
        leaders.add(new textAndImage(R.drawable.mayawati, "Mayavati"));
        leaders.add(new textAndImage(R.drawable.arvind, "Arvind Kejriwal"));
        leaders.add(new textAndImage(R.drawable.lkadavani, "L K Advani"));
        leaders.add(new textAndImage(R.drawable.sushma, "Sushma Swaraj"));
        leaders.add(new textAndImage(R.drawable.sonia, "Sonia Gandhi"));
        leaders.add(new textAndImage(R.drawable.smriti, "Smriti Irani"));

        textAndImageAdapter adapter = new textAndImageAdapter(this, leaders);

        ListView listView =(ListView) findViewById(R.id.leaders);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textAndImage temp = leaders.get(position);
                Intent intent =new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("type",temp.getContentName());
                startActivity(intent);
                Toast.makeText(getApplicationContext(),temp.getContentName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
