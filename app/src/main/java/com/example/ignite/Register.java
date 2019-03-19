package com.example.ignite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = (Button) findViewById(R.id.RegisterButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void loginActivity(View v){
        Intent i = new Intent(Register.this, Login.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
