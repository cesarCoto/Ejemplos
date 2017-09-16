package com.coto.cesar.ejemplos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    CheckBox cb_blue,cb_red,cb_green;
    Button btn_done;

    RelativeLayout ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);


        cb_blue =(CheckBox)findViewById(R.id.cb_Acb_blue);
        cb_green =(CheckBox)findViewById(R.id.cb_Acb_green);
        cb_red = (CheckBox)findViewById(R.id.cb_Acb_red);

        ventana = (RelativeLayout)findViewById(R.id.Ac_cb);

        btn_done = (Button) findViewById(R.id.btn_Acb_done);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parse();
            }
        });


    }
    private void parse(){
        if(cb_red.isChecked() && cb_green.isChecked() && cb_blue.isChecked()){
          ventana.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Toast.makeText(this, "Green more Red and Blue make White", Toast.LENGTH_SHORT).show();
        }else if(cb_red.isChecked() && cb_green.isChecked()){
           ventana.setBackgroundColor(Color.parseColor("#FFFF00"));
            Toast.makeText(this, "Gree and Red make Yellow", Toast.LENGTH_SHORT).show();
        }else if(cb_red.isChecked() && cb_blue.isChecked()){
            ventana.setBackgroundColor(Color.parseColor("#FF00FF"));
            Toast.makeText(this, "Red more Blue make Pink", Toast.LENGTH_SHORT).show();
        }else if(cb_green.isChecked() && cb_blue.isChecked()){
           ventana.setBackgroundColor(Color.parseColor("#00FFFF"));
            Toast.makeText(this, "Green more Blue make Sky blue", Toast.LENGTH_SHORT).show();
        }else if(cb_blue.isChecked()){
            ventana.setBackgroundColor(Color.parseColor("#0000FF"));
            Toast.makeText(this, "Color Blue selected", Toast.LENGTH_SHORT).show();
        }else if(cb_green.isChecked()){
           ventana.setBackgroundColor(Color.parseColor("#00FF00"));
            Toast.makeText(this, "Color Green selected", Toast.LENGTH_SHORT).show();
        }else if(cb_red.isChecked()){
           ventana.setBackgroundColor(Color.parseColor("#FF0000"));
            Toast.makeText(this, "Color Red selected", Toast.LENGTH_SHORT).show();
        }else{
            ventana.setBackgroundColor(Color.parseColor("#000000"));
            Toast.makeText(this, "Black", Toast.LENGTH_SHORT).show();
        }
    }
}
