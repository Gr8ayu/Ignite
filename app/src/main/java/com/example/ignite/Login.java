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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(Login.this, MainActivity.class));

        }

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateCredentials();
            }
        });

    }

    public void registerActivity(View v){
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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
        progressDialog.setMessage("Logging User.");
        progressDialog.show();
        loginUser(email,password);





    }


    protected void loginUser(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.hide();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("LoginActivity", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(Login.this, MainActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("LoginActivity", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, Login.class));

                        }

                        // ...
                    }
                });

    }

}
