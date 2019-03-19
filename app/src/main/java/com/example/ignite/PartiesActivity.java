package com.example.ignite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PartiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties);

    ArrayList<textAndImage> parties = new ArrayList<textAndImage>();

    parties.add(new textAndImage(R.drawable.sample_icon, "Bharatiya Janata Party"));
    parties.add(new textAndImage(R.drawable.sample_icon, "Indian National Congress"));
    parties.add(new textAndImage(R.drawable.sample_icon, "All India Trinamool Congress"));
    parties.add(new textAndImage(R.drawable.sample_icon, "Bahujan Samaj Party"));
    parties.add(new textAndImage(R.drawable.sample_icon, "Communist Party of India"));
    parties.add(new textAndImage(R.drawable.sample_icon, "Communist Party of India (Marxist)"));
    parties.add(new textAndImage(R.drawable.sample_icon, "Nationalist Congress Party"));

    textAndImageAdapter adapter = new textAndImageAdapter(this, parties);

    ListView listView =(ListView) findViewById(R.id.parties);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            startActivity(new Intent(getApplicationContext(), DetailActivity.class));
        }
    });
    }
}
