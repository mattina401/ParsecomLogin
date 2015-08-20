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
import com.parse.SignUpCallback;


public class LoginSignupActivity extends AppCompatActivity {

    Button loginButton;
    Button signupButton;
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
        signupButton = (Button) findViewById(R.id.signup);

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

        // 사인업 버튼 눌렀을때
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                // 아무것도 입력 안됬을때
                if(usernametxt.equals("") && passwordtxt.equals("")) {
                    Toast.makeText(getApplicationContext(), "plz complete the sign up form", Toast.LENGTH_SHORT).show();

                // 입력됨
                } else {

                    // db에 저장
                    ParseUser user = new ParseUser();
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);
                    user.signUpInBackground(new SignUpCallback() {

                        // 다 끝나고
                        @Override
                        public void done(ParseException e) {

                            // 에러 없으면
                            if(e == null) {
                                Toast.makeText(getApplicationContext(), "successfully signed up", Toast.LENGTH_SHORT).show();

                            // 에러 있을때
                            } else {
                                Toast.makeText(getApplicationContext(), "sign up error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }


}
