package com.coto.cesar.ejemplos;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    RadioButton rb_female, rb_male;

    EditText et_name, et_age;

    Button btn_done_rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        rb_female = (RadioButton) findViewById(R.id.rb_female);
        rb_male = (RadioButton) findViewById(R.id.rb_male);

        et_name = (EditText) findViewById(R.id.et_Arb_name);
        et_age = (EditText) findViewById(R.id.et_Arb_age);

        btn_done_rb = (Button) findViewById(R.id.btn_done_Arb);
        btn_done_rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Print();
            }
        });


        //Botton  ir atras
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }
    private void Print(){
        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        if( rb_female.isChecked() || rb_male.isChecked()) {
            if (name.length() != 0 && age.length() != 0) {
                if (rb_female.isChecked()) {
                    Toast.makeText(this, "Your name is: " + name + "\n" + "You are " + age + " years old" + "\n" + "And you're female", Toast.LENGTH_SHORT).show();
                } else if (rb_male.isChecked()) {
                    Toast.makeText(this, "Your name is: " + name + "\n" + "You are " + age + " years old" + "\n" + "And you're male", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "please fill in the fields", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "please fill in the fields", Toast.LENGTH_SHORT).show();
        }
    }
}