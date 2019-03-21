package com.example.ignite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        ArrayList<textAndImage> list =new ArrayList<textAndImage>();
        list.add(new textAndImage( R.drawable.election2019,"Election 2019"));
        list.add(new textAndImage( R.drawable.leaders,"Leaders"));
        list.add(new textAndImage( R.drawable.parties, "Political Parties"));

        for (final textAndImage temp : list) {
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.list, null);

            RelativeLayout rel = (RelativeLayout) v.findViewById(R.id.selectMenu);


            rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(temp.getContentName() == "Election 2019"){
                        Toast.makeText(getApplicationContext(),temp.getContentName(),Toast.LENGTH_SHORT).show();
                    }
                    else if(temp.getContentName() == "Leaders"){
                        startActivity(new Intent(getApplicationContext(), LeadersActivity.class));
                    }
                    else if(temp.getContentName() == "Political Parties"){
                        startActivity(new Intent(getApplicationContext(), PartiesActivity.class));
                    }
                }
            });

            // fill in any details dynamically here
            TextView textView = (TextView) v.findViewById(R.id.mainListText);
            textView.setText(temp.getContentName());
            ImageView imageView = (ImageView) v.findViewById(R.id.mainListImage);
            imageView.setImageResource(temp.getImageResourceId());

            // insert into main view
            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.mainList);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        }




    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_SHORT).show();
        mAuth.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), Login.class));
        return super.onOptionsItemSelected(item);
    }
}

