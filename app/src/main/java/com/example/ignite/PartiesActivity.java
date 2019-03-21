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

    final ArrayList<textAndImage> parties = new ArrayList<textAndImage>();

    parties.add(new textAndImage(R.drawable.bjp, "Bharatiya Janata Party"));
    parties.add(new textAndImage(R.drawable.inc, "Indian National Congress"));
    parties.add(new textAndImage(R.drawable.aitmc, "All India Trinamool Congress"));
    parties.add(new textAndImage(R.drawable.bsp, "Bahujan Samaj Party"));
    parties.add(new textAndImage(R.drawable.cpi, "Communist Party of India"));
    parties.add(new textAndImage(R.drawable.cpim, "Communist Party of India (Marxist)"));
    parties.add(new textAndImage(R.drawable.ncp, "Nationalist Congress Party"));

    textAndImageAdapter adapter = new textAndImageAdapter(this, parties);

    ListView listView =(ListView) findViewById(R.id.parties);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            startActivity(new Intent(getApplicationContext(), DetailActivity.class));

            textAndImage temp = parties.get(position);

            Intent intent =new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("type",temp.getContentName());
            startActivity(intent);
        }
    });
    }
}
