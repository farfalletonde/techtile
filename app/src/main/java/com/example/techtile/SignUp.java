package com.example.techtile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText email, pw;
    private Button signup, facebook, gmail;
    private TextView toLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initUI();
    }

    private void initUI() {
        email = findViewById(R.id.mail_edittext);
        pw = findViewById(R.id.password_edittext);
        signup = findViewById(R.id.button);
        facebook = findViewById(R.id.facebook_register_button);
        gmail = findViewById(R.id.gmail_register_button);
        toLogin = findViewById(R.id.signup_to_login);
        signup.setOnClickListener(this);
        facebook.setOnClickListener(this);
        gmail.setOnClickListener(this);
        toLogin.setOnClickListener(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        this.getSupportActionBar().hide();
    }

    private void signUp(String email, String password) {

    }

    @Override
    public void onClick(View v) {
        if (v == signup) {
            if (!email.getText().toString().isEmpty() && !pw.getText().toString().isEmpty()) {
                signUp(email.getText().toString(), pw.getText().toString());
                Intent intent = new Intent(this, LogIn.class);
                Toast.makeText(this, R.string.create_account_toast, Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, getText(R.string.emptyToast), Toast.LENGTH_SHORT).show();
            }
        }
        if (v == toLogin) {
            Intent intent = new Intent(this, LogIn.class);
            startActivity(intent);
            finish();
        }
        if (v == facebook) {
            Intent intent = new Intent(this, Details.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, getString(R.string.facebookToast), Toast.LENGTH_SHORT).show();
        }
        if (v == gmail) {
            Toast.makeText(this, getString(R.string.gmailToast), Toast.LENGTH_SHORT).show();
        }
    }
}