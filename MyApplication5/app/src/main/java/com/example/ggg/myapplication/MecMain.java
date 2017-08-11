package com.example.ggg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MecMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mec_main);
    }
    public void Logout(View view){
        startActivity(new Intent(this,MainActivity.class));

    }
    public void Onedit(View view){
        startActivity(new Intent(this,Editprofile.class));

    }
}
