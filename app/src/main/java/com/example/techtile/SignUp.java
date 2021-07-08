package com.example.techtile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.techtile.Model.RegisterModel;
import com.example.techtile.Utils.Api;


public class SignUp extends AppCompatActivity implements View.OnClickListener, Api.ApiResultListener {
    private EditText username, email, pw;
    private Button signup, facebook, gmail;
    private TextView toLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initUI();
    }

    private void initUI() {
        username = findViewById(R.id.username_edittext);
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


    private void signUp(String username, String email, String password) {
        Api api = new Api(this);
        api.register(new RegisterModel(email,password,username,username));
    }

    @Override
    public void onClick(View v) {
        if (v == signup) {
            if (!username.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !pw.getText().toString().isEmpty()) {
                signUp(username.getText().toString(), email.getText().toString(), pw.getText().toString());
            }
            else {
                Toast.makeText(this, getText(R.string.sign_up_emptyToast), Toast.LENGTH_SHORT).show();
            }
        }
        if (v == toLogin) {
            Intent intent = new Intent(this, LogIn.class);
            startActivity(intent);
            finish();
        }
        if (v == facebook) {
            Toast.makeText(this, getString(R.string.facebookToast), Toast.LENGTH_SHORT).show();
        }
        if (v == gmail) {
            Toast.makeText(this, getString(R.string.gmailToast), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPreExecute() {
        Log.d("TAG", "onPreExecute: ");
    }

    @Override
    public void onPostExecute(String data, boolean isReqSuccess) {
        if(isReqSuccess){
            Intent intent = new Intent(this, LogIn.class);
            Toast.makeText(this, R.string.create_account_toast, Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        }
        else
        {

        }

    }
}