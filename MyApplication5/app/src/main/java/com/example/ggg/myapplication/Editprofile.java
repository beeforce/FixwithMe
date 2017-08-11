package com.example.ggg.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Editprofile extends AppCompatActivity {

    EditText usernameE,  phonenumberE, firstnameE, lastnameE, garagenameE, addressE;
    Button btn_edit;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        usernameE = (EditText)findViewById(R.id.edUsername);
        phonenumberE = (EditText) findViewById(R.id.edphone);
        firstnameE = (EditText) findViewById(R.id.edFirst);
        lastnameE = (EditText) findViewById(R.id.edLast);
        garagenameE = (EditText) findViewById(R.id.edGarage);
        addressE = (EditText) findViewById(R.id.edAddress);
        btn_edit = (Button) findViewById(R.id.edbt);
    }

    public void OnEdit(View view){
        final String st_usernameR = usernameE.getText().toString();
        String st_phonenumber = phonenumberE.getText().toString();
        String st_firstname = firstnameE.getText().toString();
        String st_lastname = lastnameE.getText().toString();
        String st_garagename = garagenameE.getText().toString();
        String st_address = addressE.getText().toString();

        btn_edit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {



                // Check for empty data in the form
                if (    usernameE.getText().toString().equals("")||
                        phonenumberE.getText().toString().equals("")||
                        firstnameE.getText().toString().equals("")|
                                lastnameE.getText().toString().equals("")||
                        garagenameE.getText().toString().equals("")||
                        addressE.getText().toString().equals("")) {

                    builder = new AlertDialog.Builder(Editprofile.this);
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
                    BackgroundWorker backgroundWorker = new BackgroundWorker(Editprofile.this);
                    backgroundWorker.execute("Editpro", usernameE.getText().toString(),
                            phonenumberE.getText().toString(),firstnameE.getText().toString()
                            ,lastnameE.getText().toString(),garagenameE.getText().toString(),addressE.getText().toString());




                }

            }


        });



    }
}
