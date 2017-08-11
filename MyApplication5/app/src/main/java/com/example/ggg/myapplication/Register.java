package com.example.ggg.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText usernameR, passwordR, phonenumber, firstname, lastname, garagename, address;
    Button btn_reg;
    AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameR = (EditText) findViewById(R.id.et_username);
        passwordR = (EditText) findViewById(R.id.et_password);
        phonenumber = (EditText) findViewById(R.id.et_phone);
        firstname = (EditText) findViewById(R.id.et_first);
        lastname = (EditText) findViewById(R.id.et_lastname);
        garagename = (EditText) findViewById(R.id.et_garage);
        address = (EditText) findViewById(R.id.et_address);
        btn_reg = (Button) findViewById(R.id.resbt);


    }
    public void Backtolog(View view){
        startActivity(new Intent(this,MainActivity.class));

    }
    public void OnReg(View view){
        final String st_usernameR = usernameR.getText().toString();
        String st_passwordR = passwordR.getText().toString();
        String st_phonenumber = phonenumber.getText().toString();
        String st_firstname = firstname.getText().toString();
        String st_lastname = lastname.getText().toString();
        String st_garagename = garagename.getText().toString();
        String st_address = address.getText().toString();

        btn_reg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {



                // Check for empty data in the form
                if (usernameR.getText().toString().equals("")||
                        passwordR.getText().toString().equals("")||
                        phonenumber.getText().toString().equals("")||
                        firstname.getText().toString().equals("")|
                        lastname.getText().toString().equals("")||
                        garagename.getText().toString().equals("")||
                        address.getText().toString().equals("")) {

                    builder = new AlertDialog.Builder(Register.this);
                    builder.setTitle("Some thing went wrong..");
                    builder.setMessage("Please fill all the field");
                    builder.setPositiveButton("Ok",new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    BackgroundWorker backgroundWorker = new BackgroundWorker(Register.this);
                    backgroundWorker.execute("register", usernameR.getText().toString(), passwordR.getText().toString()
                            , phonenumber.getText().toString(),firstname.getText().toString()
                            ,lastname.getText().toString(),garagename.getText().toString(),address.getText().toString());




                }

            }


        });



    }
}
