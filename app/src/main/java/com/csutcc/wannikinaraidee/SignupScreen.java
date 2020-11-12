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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignupScreen extends AppCompatActivity {
    Button register,facebook,signin;
    FirebaseAuth mAuth;
    String TAG = "LogTestLogin";
    TextInputEditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a02_signup_screen);
        mAuth = FirebaseAuth.getInstance();
        email = (TextInputEditText)findViewById(R.id.input_email_signup);
        password = (TextInputEditText)findViewById(R.id.input_password_signup);

        //LOGIN BUTTON


        register = findViewById(R.id.register_press);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
                Intent intent = new Intent(SignupScreen.this, SigninScreen.class);
                startActivity(intent);
                finish();
                //Toast.makeText(getApplicationContext(),"Register Pressed",Toast.LENGTH_SHORT).show();
            }
        });


        //FACEBOOK BUTTON

        facebook = findViewById(R.id.facebook_press);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Facebook Pressed",Toast.LENGTH_SHORT).show();
            }
        });


        //SIGNUP BUTTON

        signin = findViewById(R.id.signin_press);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupScreen.this, SigninScreen.class);
                startActivity(intent);
                //finish();
                //Toast.makeText(getApplicationContext(),"SignIn Pressed",Toast.LENGTH_SHORT).show();
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
            Toast.makeText(SignupScreen.this, str,
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void signup() {
        mAuth.createUserWithEmailAndPassword(email.toString(), password.toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
