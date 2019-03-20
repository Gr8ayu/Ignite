package com.example.ignite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        Button registerButton = (Button) findViewById(R.id.RegisterButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateCredentials();


            }
        });

    }

    public void loginActivity(View v){
        Intent i = new Intent(Register.this, Login.class);
        startActivity(i);
    }
    public void loginActivity(){
        Intent i = new Intent(Register.this, Login.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(Register.this, MainActivity.class);
            startActivity(i);
        }
    }

    private void validateCredentials(){
        EditText emailView = (EditText) findViewById(R.id.emailId);
        EditText passwordView = (EditText) findViewById(R.id.password);


        String email = emailView.getText().toString().trim();
        String password = passwordView.getText().toString().trim();



        if(email.isEmpty()){
            emailView.setError("Email Required");
            Toast.makeText(getApplicationContext(),"Email Required",Toast.LENGTH_SHORT).show();
            emailView.requestFocus();
            return;
        }

        if(! Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailView.setError("Invalid Email Address");
            emailView.requestFocus();
            return;
        }

        if(password.isEmpty()){
            emailView.setError("Email Required");
            Toast.makeText(getApplicationContext(),"Password Required",Toast.LENGTH_SHORT).show();
            emailView.requestFocus();
            return;
        }
        if(password.length()<6){
            passwordView.setError("minimum 6 character required");
            passwordView.requestFocus();
            return;
        }

        // Creating new User With Email and password
        progressDialog.setMessage("Registering User.");
        progressDialog.show();
        createUser(email,password);





    }

    protected void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.hide();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("RegisterActivity", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            startActivity(new Intent(Register.this, MainActivity.class));



                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Register.this, Register.class);
                            startActivity(i);
                        }

                        // ...
                    }
                });

    }
}


