package com.example.ignite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PartiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties);

    ArrayList<Parties> parties = new ArrayList<Parties>();

    parties.add(new Parties(R.drawable.sample_icon, "BJP"));
    parties.add(new Parties(R.drawable.sample_icon, "Congress"));

    PartiesAdapter adapter = new PartiesAdapter(this, parties);

    ListView listView =(ListView) findViewById(R.id.parties);
    listView.setAdapter(adapter);
    }
}
