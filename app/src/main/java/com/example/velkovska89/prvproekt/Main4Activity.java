package com.example.velkovska89.prvproekt;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main4Activity extends AppCompatActivity {


    @BindView(R.id.btnCheck)
    Button btnCheck;

    @BindView(R.id.internetChecked)
    TextView internetChecked;

    @BindView(R.id.btnBack)
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main4);

        ButterKnife.bind(this);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void showDialog (){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });



        alertDialogBuilder.setTitle("ARE YOU CONNECTED");

        alertDialogBuilder.setMessage("Now you are connected to the internet!");

        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();

    }
}
