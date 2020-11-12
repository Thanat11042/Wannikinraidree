package com.csutcc.wannikinaraidee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.csutcc.wannikinaraidee.A03_TabMenu.TabMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SigninScreen extends AppCompatActivity {
    Button login,facebook,signup;
    FirebaseAuth mAuth;
    TextInputEditText email,password;
    String TAG = "LogTestLogin";
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a01_signin_screen);
        mAuth = FirebaseAuth.getInstance();
        email = (TextInputEditText)findViewById(R.id.input_email);
        password = (TextInputEditText)findViewById(R.id.input_password);

        //LOGIN BUTTON
        login =(Button)findViewById(R.id.login_press);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signin();
                Intent intent = new Intent(SigninScreen.this, TabMenu.class);
                startActivity(intent);
                finish();
                //Toast.makeText(getApplicationContext(),"Login Pressed",Toast.LENGTH_SHORT).show();
            }
        });


        //FACEBOOK BUTTON

        facebook =(Button)findViewById(R.id.facebook_press);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Facebook Pressed",Toast.LENGTH_SHORT).show();
            }
        });


        //SIGNUP BUTTON

        signup =(Button)findViewById(R.id.signup_press);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SigninScreen.this, SignupScreen.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private void updateUI(FirebaseUser user) {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
            String str = "name: " + name +
                    "\nemail: " + email +
                    "\nuid: " + uid +
                    "\nphotoUrl: " + photoUrl;
            Toast.makeText(SigninScreen.this, str,
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void signin() {
        mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SigninScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}




