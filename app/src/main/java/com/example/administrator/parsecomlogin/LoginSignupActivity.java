package com.example.administrator.parsecomlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginSignupActivity extends AppCompatActivity {

    Button loginButton;
    Button registerButton;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.login);
        registerButton = (Button) findViewById(R.id.register);

        // 로그인 버튼 클릭시
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 입력한 string 값 받아옴
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                // user가 db에 있나 확인
                ParseUser.logInInBackground(usernametxt, passwordtxt, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        //유저가 있으면
                        if(user != null) {

                            // welcome 으로 이동
                            Intent intent = new Intent(LoginSignupActivity.this, WelcomeActivity.class);
                            startActivity(intent);
                            finish();

                            // 유저가 없으면
                        } else {
                            Toast.makeText(getApplicationContext(), "this user doesnot exist. plz signup", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // 레지스터 버튼 눌렀을때
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginSignupActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();


            }
        });


    }


}
