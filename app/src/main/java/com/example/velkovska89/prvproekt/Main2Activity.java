package com.example.velkovska89.prvproekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.userDetails)
    TextView userDetails;


    @BindView(R.id.name)
    EditText name;


    @BindView(R.id.lastName)
    EditText lastName;

    @BindView(R.id.username)
    EditText username;


    @BindView(R.id.textGender)
    TextView textGender;

    @BindView(R.id.radioGender)
    RadioGroup radioGender;

    @BindView(R.id.genderF)
    RadioButton genderF;

    @BindView(R.id.genderM)
    RadioButton genderM;

    @BindView(R.id.btnNext)
    Button btnNext;

    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        ButterKnife.bind(this);

        user = new User();

        if (getIntent().hasExtra("user")) {
            user = (User) getIntent().getSerializableExtra("user");
name.setText(user.getName());
lastName.setText(user.getLastname());
username.setText(user.getUserename());
            if (user.getGender()) {
                genderF.setChecked(true);

            } else {
                genderM.setChecked(true);

            }
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent next1 = new Intent(Main2Activity.this, Main3Activity.class);

                user.setName(name.getText().toString());
                user.setLastname(lastName.getText().toString());
                user.setUserename(username.getText().toString());

                if (genderF.isChecked())
                    user.setGender(true);
                else
                    user.setGender(false);


                next1.putExtra("user",user);

                if(getIntent().hasExtra("login"))
                startActivity(next1);
                else{

                    setResult(RESULT_OK, next1);
                    finish();
                }
            }
        });
    }

}
