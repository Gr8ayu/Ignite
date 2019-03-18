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

        ArrayList<imageAndText> list =new ArrayList<imageAndText>();
        list.add(new imageAndText("Election 2019", R.drawable.election2019));
        list.add(new imageAndText("Leaders", R.drawable.leaders));
        list.add(new imageAndText("Political Parties", R.drawable.parties));

        for (final imageAndText temp : list) {
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.list, null);

            RelativeLayout rel = (RelativeLayout) v.findViewById(R.id.selectMenu);
            rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(temp.getText() == "Election 2019"){
                        Toast.makeText(getApplicationContext(),temp.getText(),Toast.LENGTH_SHORT).show();
                    }
                    else if(temp.getText() == "Leaders"){
                        Toast.makeText(getApplicationContext(),temp.getText(),Toast.LENGTH_SHORT).show();
                    }
                    else if(temp.getText() == "Political Parties"){
                        startActivity(new Intent(getApplicationContext(), PartiesActivity.class));
                    }
                }
            });

            // fill in any details dynamically here
            TextView textView = (TextView) v.findViewById(R.id.mainListText);
            textView.setText(temp.getText());
            ImageView imageView = (ImageView) v.findViewById(R.id.mainListImage);
            imageView.setImageResource(temp.getImageID());

            // insert into main view
            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.mainList);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        }




    }
}

