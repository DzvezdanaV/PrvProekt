package com.example.velkovska89.prvproekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.spinnerGuest)
    Spinner spinner;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.viewInvisible)
    View viewInvisible;

    @BindView(R.id.btnUser)
    Button btnUser;

    @BindView(R.id.textGender1)
    TextView textGender1;

    @BindView(R.id.radioGender1)
    RadioGroup radioGender1;

    @BindView(R.id.btnF)
    RadioButton btnF;

    @BindView(R.id.btnM)
    RadioButton btnM;


    @BindView(R.id.female)
    ImageView image;

    @BindView(R.id.nameLastname)
    TextView nameLastname;

    @BindView(R.id.textNet)
    TextView textNet;


    @BindView(R.id.btnNet)
    Button btnNet;

    public User user;


    public ArrayList<User> usersList = new ArrayList<>();
public ArrayAdapter<User> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main3);

        ButterKnife.bind(this);

        user = (User) getIntent().getSerializableExtra("user");
        usersList.add(user);

        adapter = new ArrayAdapter<User>(this, android.R.layout.simple_spinner_item, usersList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                user = usersList.get(i);

                updateData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        radioGender1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (btnF.isChecked()) {
                    image.setImageResource(R.drawable.mujer);
                } else {
                    image.setImageResource(R.drawable.man);
                }

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intendEdit = new Intent(Main3Activity.this, Main2Activity.class);
                intendEdit.putExtra("user", user);

                startActivityForResult(intendEdit, 1001);

            }
        });


        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent buttonUser = new Intent(Main3Activity.this, Main2Activity.class);

                startActivityForResult(buttonUser, 1000);

            }
        });


        btnNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent checkNet = new Intent(Main3Activity.this, Main4Activity.class);

                startActivity(checkNet);
            }
        });

        updateData();
    }

    public void updateData() {
        if (user.getGender()) {
            btnF.setChecked(true);
            image.setImageResource(R.drawable.mujer);
        } else {
            btnM.setChecked(true);
            image.setImageResource(R.drawable.man);
        }

        nameLastname.setText(user.getName() + "\n" + user.getLastname());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1000 && resultCode == RESULT_OK) {
            user = (User) data.getSerializableExtra("user");
            usersList.add(user);
            updateData();
        }
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            user = (User) data.getSerializableExtra("user");
           User userPom = (User) spinner.getSelectedItem();
           userPom.setUserename(user.getUserename());
           userPom.setGender(user.getGender());
           userPom.setName(user.getName());
           userPom.setLastname(user.getLastname());
            adapter.notifyDataSetChanged();
            updateData();
        }

    }
}
