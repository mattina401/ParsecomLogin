package com.example.administrator.parsecomlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class RegisterActivity extends ActionBarActivity {



    Button signupButton;
    Button cancelButton;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = (EditText) findViewById(R.id.regname);
        password = (EditText) findViewById(R.id.regpassword);

        signupButton = (Button) findViewById(R.id.regsignup);
        cancelButton = (Button) findViewById(R.id.regcancel);


        // �������� ��ư ��������
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                // �ƹ��͵� �Է� �ȉ�����
                if (usernametxt.equals("") && passwordtxt.equals("")) {
                    Toast.makeText(getApplicationContext(), "plz complete the sign up form", Toast.LENGTH_SHORT).show();

                    // �Էµ�
                } else {

                    // db�� ����
                    ParseUser user = new ParseUser();
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);
                    user.signUpInBackground(new SignUpCallback() {

                        // �� ������
                        @Override
                        public void done(ParseException e) {

                            // ���� ������
                            if (e == null) {
                                Toast.makeText(getApplicationContext(), "successfully signed up", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                                startActivity(intent);
                                finish();


                                // ���� ������
                            } else {
                                Toast.makeText(getApplicationContext(), "sign up error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginSignupActivity.class);
                startActivity(intent);
                finish();
            }


        });


    }

}
