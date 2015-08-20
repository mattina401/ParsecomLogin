package com.example.administrator.parsecomlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;


public class WelcomeActivity extends AppCompatActivity {


    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        //get current user
        ParseUser currentUser = ParseUser.getCurrentUser();

        //get string for user
        String struser = currentUser.getUsername().toString();


        // xml에서 아이디 받아와서 글시 입힘
        TextView txtUser = (TextView) findViewById(R.id.txtuser);
        txtUser.setText("you are logged in as" + struser);

        // 로그아웃 버튼 받아옴
        logout = (Button) findViewById(R.id.logout);

        // 받아온 버튼 누르면 하는 행동. 여기서는 로그아웃
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                finish();
            }
        });


    }


}
