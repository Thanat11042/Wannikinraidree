package com.csutcc.wannikinaraidee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private EditText mConfirmPassword;
    private Button mRegister;
    private Context mContext;
    private UserManager mManager;
    private TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mManager = new UserManager(this);
        mContext = this;
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mConfirmPassword = (EditText) findViewById(R.id.confirm_password);
        mRegister = (Button) findViewById(R.id.button_register);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString().trim().toLowerCase();
                String password = mPassword.getText().toString();
                String confirmPassword = mConfirmPassword.getText().toString();
                if (password.equals(confirmPassword)) {
                    boolean isSuccess = mManager.registerUser(username, password);
                    if (isSuccess) {
                        String message = getString(R.string.register_success);
                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        String message = getString(R.string.register_error_message);
                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    String message = getString(R.string.register_password_error);
                    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                }
            }
        });
        mLogin = (TextView) findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}