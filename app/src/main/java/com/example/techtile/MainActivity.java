package com.example.techtile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText email, pw;
    private Button signup, facebook,gmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }
    private void initUI(){
        email = findViewById(R.id.mail_edittext);
        pw = findViewById(R.id.password_edittext);
        signup = findViewById(R.id.button);
        facebook = findViewById(R.id.facebook_register_button);
        gmail = findViewById(R.id.gmail_register_button);
        signup.setOnClickListener(this);
        facebook.setOnClickListener(this );
        gmail.setOnClickListener(this);
    }
    private void login( String email, String password){

    }
    @Override
    public void onClick(View v) {
        if(v==signup){
            if(!email.getText().toString().isEmpty() && !pw.getText().toString().isEmpty()) {
                login(email.getText().toString(),pw.getText().toString());
                Intent intent = new Intent(this, Details.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this,getText(R.string.emptyToast),Toast.LENGTH_SHORT).show();
            }
        }
        if(v==facebook){
            Toast.makeText(this, getString(R.string.facebookToast), Toast.LENGTH_SHORT).show();
        }
            if(v==gmail){
Toast.makeText(this,getString(R.string.gmailToast),Toast.LENGTH_SHORT).show();
            }
    }
}