package com.example.administrator.parsecomlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;


public class MainActivity extends AppCompatActivity {

    //onCreate - 안드로이드의 생성자 역할. activity가 만들어지기 이전 맨처음 1번만 실행.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check user is anonymous or not
        if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {

            //intent - 하나의 Activity에서 다른 Activity를 호출할때 사용
           Intent intent = new Intent(MainActivity.this, LoginSignupActivity.class);
           startActivity(intent);
           finish();
        } else {

            // if user is not anonymous, get current user
            ParseUser currentUser = ParseUser.getCurrentUser();

            // current user is not null
            if(currentUser != null) {

                // move to welcomeActivity
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            } else {

                // if current user is null, move to LoginSignupActivity
                Intent intent = new Intent(MainActivity.this, LoginSignupActivity.class);
                startActivity(intent);
                finish();

            }
        }


    }


}
