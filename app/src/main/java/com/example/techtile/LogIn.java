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

import com.example.techtile.Model.LoginModel;
import com.example.techtile.Utils.Api;

public class LogIn extends AppCompatActivity implements View.OnClickListener, Api.ApiResultListener {
    private EditText email, pw;
    private Button logIn, facebook, gmail;
    private TextView createAccount;

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
        createAccount = findViewById(R.id.createAccount);
        logIn.setOnClickListener(this);
        facebook.setOnClickListener(this);
        gmail.setOnClickListener(this);
        createAccount.setOnClickListener(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        this.getSupportActionBar().hide();
    }

    private void LogIn(String email, String password) {
        Api api = new Api(this);
        api.login(new LoginModel(email,password));
    }

    public void onClick(View v) {
        if (v == logIn) {
            if (!email.getText().toString().isEmpty() && !pw.getText().toString().isEmpty()) {
                LogIn(email.getText().toString(), pw.getText().toString());

            } else {
                Toast.makeText(this, getText(R.string.login_emptyToast), Toast.LENGTH_SHORT).show();
            }
        }
        if (v == createAccount){
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute(String data, boolean isReqSuccess) {
        if(isReqSuccess){
            Intent intent = new Intent(this, Details.class);
            Toast.makeText(this, R.string.login_toast, Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this,R.string.login_fail,Toast.LENGTH_SHORT).show();
        }
    }
}