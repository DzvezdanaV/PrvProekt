package com.example.velkovska89.prvproekt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pilence)
    ImageView pilence;


    @BindView(R.id.btnLogin)
    Button btnLogin;


    @BindView(R.id.guest)
    TextView guest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        String NAPRAVIVGRESHKAaaaaa;


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addUser = new Intent(MainActivity.this, Main2Activity.class);
                addUser.putExtra("login", true);
                startActivity(addUser);


            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addGuest = new Intent(MainActivity.this, Main3Activity.class);
                addGuest.putExtra("user", new User());

                startActivity(addGuest);
                finish();
            }
        });

    }


}
