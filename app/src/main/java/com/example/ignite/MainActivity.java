package com.example.ignite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Parties> list =new ArrayList<Parties>();
        list.add(new Parties( R.drawable.election2019,"Election 2019"));
        list.add(new Parties( R.drawable.leaders,"Leaders"));
        list.add(new Parties( R.drawable.parties, "Political Parties"));

        for (final Parties temp : list) {
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.list, null);

            RelativeLayout rel = (RelativeLayout) v.findViewById(R.id.selectMenu);
            rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(temp.getPartyName() == "Election 2019"){
                        Toast.makeText(getApplicationContext(),temp.getPartyName(),Toast.LENGTH_SHORT).show();
                    }
                    else if(temp.getPartyName() == "Leaders"){
                        Toast.makeText(getApplicationContext(),temp.getPartyName(),Toast.LENGTH_SHORT).show();
                    }
                    else if(temp.getPartyName() == "Political Parties"){
                        startActivity(new Intent(getApplicationContext(), PartiesActivity.class));
                    }
                }
            });

            // fill in any details dynamically here
            TextView textView = (TextView) v.findViewById(R.id.mainListText);
            textView.setText(temp.getPartyName());
            ImageView imageView = (ImageView) v.findViewById(R.id.mainListImage);
            imageView.setImageResource(temp.getImageResourceId());

            // insert into main view
            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.mainList);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        }




    }
}

