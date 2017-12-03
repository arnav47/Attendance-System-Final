package com.example.arnav47.attendance511;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


public class login  extends AppCompatActivity implements AsyncResponse {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etUsername = (EditText)findViewById(R.id.Username);
        etPassword = (EditText)findViewById(R.id.Password);
        btnLogin = (Button)findViewById(R.id.Login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap postData = new HashMap();
                postData.put("Login", "Login");
                postData.put("mobile", "android");
                postData.put("Username", etUsername.getText().toString());
                postData.put("Password", etPassword.getText().toString() );

                PostResponseAsyncTask loginTask =
                        new PostResponseAsyncTask(login.this, postData,
                                login.this);
                loginTask.execute("https://attendance611.000webhostapp.com/login.php");
            }
        });
    }

    @Override
    public void processFinish(String output) {
        Log.wtf("kaushik", output);
//        if(output.equals("success") ){

        if(true)

            Toast.makeText(this, "Login Successfully",
                    Toast.LENGTH_LONG).show();

            startActivity(new Intent(login.this,bleBeacon.class));
        }
//        else
//        {
//            Toast.makeText(this, "try again",
//                    Toast.LENGTH_LONG).show();
//        }

    }
