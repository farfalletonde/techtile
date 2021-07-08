package com.example.techtile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    private EditText email, pw;
    private Button logIn, facebook, gmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI() {
        email = findViewById(R.id.login_mail_edittext);
        pw = findViewById(R.id.login_password_edittext);
        logIn = findViewById(R.id.login_button);
        facebook = findViewById(R.id.login_facebook_register_button);
        gmail = findViewById(R.id.login_gmail_register_button);
        logIn.setOnClickListener(this);
        facebook.setOnClickListener(this);
        gmail.setOnClickListener(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        this.getSupportActionBar().hide();
    }

    private void LogIn(String email, String password) {

    }

    public void onClick(View v) {
        if (v == logIn) {
            if (!email.getText().toString().isEmpty() && !pw.getText().toString().isEmpty()) {
                LogIn(email.getText().toString(), pw.getText().toString());
                Intent intent = new Intent(this, Details.class);
                Toast.makeText(this, R.string.login_toast, Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, getText(R.string.emptyToast), Toast.LENGTH_SHORT).show();
            }
        }
    }
}