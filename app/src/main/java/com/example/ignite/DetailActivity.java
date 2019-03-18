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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView logoImage = (ImageView) findViewById(R.id.logoImage);
        logoImage.setImageResource(R.drawable.sample_icon);




        // Key details
        ArrayList<keyValue> keyvalues = new ArrayList<>();
        keyvalues.add(new keyValue("Abbreviation","BJP"));
        keyvalues.add(new keyValue("President","Amit Shah"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Narendra Modi"));
        keyvalues.add(new keyValue("Founded","6 April 1980"));
        keyvalues.add(new keyValue("Ideology","Hindutva\n" +
                "Hindu nationalism\n" +
                "Integral humanism\n" +
                "National conservatism\n" +
                "Social conservatism\n" +
                "Economic nationalism\n" +
                "Right-wing populism"));
        keyvalues.add(new keyValue("Alliance","National Democratic Alliance (NDA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","271 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","73 / 245"));


        Collections.reverse(keyvalues);
        Iterator<keyValue> it = keyvalues.iterator();
        while (it.hasNext()) {
            keyValue temp = it.next();
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.keyvaluepair, null);

            // fill in any details dynamically here
            TextView key = (TextView) v.findViewById(R.id.key);
            key.setText(temp.getKey());
            TextView value = (TextView) v.findViewById(R.id.value);
            value.setText(temp.getValue());

            // insert into main view
            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.keyValues);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        }

        TextView description = (TextView) findViewById(R.id.description);
        description.setText("BJP is one of the two major political parties in India," +
                " along with the Indian National Congress.[17] As of 2018, it is the " +
                "country's largest political party in terms of representation in the national " +
                "parliament and state assemblies, and it is the world's largest party in terms " +
                "of primary membership. BJP is a right-wing party, and its policy has historically " +
                "reflected Hindu nationalist positions.[11][18] It has close ideological and " +
                "organisational links to the Rashtriya Swayamsevak Sangh.");

        // Key details
        ArrayList<keyValue> contacts = new ArrayList<>();
        contacts.add(new keyValue("facebook","www.facebook.com/bjp"));
        contacts.add(new keyValue("twitter","twitter.com/bjp"));
        contacts.add(new keyValue("website","bjp.com"));


        Collections.reverse(contacts);
        Iterator<keyValue> ite = contacts.iterator();

        while (ite.hasNext()) {
            keyValue temp = ite.next();
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.keyvaluepair, null);

            // fill in any details dynamically here
            TextView key = (TextView) v.findViewById(R.id.key);
            key.setText(temp.getKey());
            TextView value = (TextView) v.findViewById(R.id.value);
            value.setText(temp.getValue());

            // insert into main view
            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.contacts);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        }




    }
}
