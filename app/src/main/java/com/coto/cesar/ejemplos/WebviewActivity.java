package com.coto.cesar.ejemplos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebviewActivity extends AppCompatActivity {

    Button btn_ir_maker_robot, btn_buscar_pagina, btn_maps;

    EditText etx_example1, etx_example2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        btn_ir_maker_robot = (Button) findViewById(R.id.btn_web_ir);

        btn_ir_maker_robot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAMakeRobots();
            }
        });

        btn_buscar_pagina = (Button) findViewById(R.id.btn_web_buscar);

        btn_buscar_pagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarPagina();
            }
        });

        btn_maps = (Button) findViewById(R.id.btn_maps);

        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Launch_maps();
            }
        });

        etx_example1 = (EditText) findViewById(R.id.et_web_example);
        etx_example2 = (EditText) findViewById(R.id.et_web_example2);


        //Botton  ir atras
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }

    private void irAMakeRobots() {
        Intent LaunchMK = new Intent(this, Web_pageActivity.class);
        LaunchMK.putExtra("Pagina", "https://makerobot.000webhostapp.com/");
        startActivity(LaunchMK);
    }

    private void BuscarPagina() {
        String web1 = etx_example1.getText().toString();
        String web2 = etx_example2.getText().toString();


        if (web1.length() != 0 && web2.length() == 0) {
            Intent LaunchPag1 = new Intent(this, Web_pageActivity.class);
            LaunchPag1.putExtra("Pagina", web1);
            startActivity(LaunchPag1);
        } else if (web2.length() != 0 && web1.length() == 0) {
            Intent Launchpag2 = new Intent(this, Web_pageActivity.class);
            Launchpag2.putExtra("Pagina", "https://" + web2);
            startActivity(Launchpag2);
        } else
            Toast.makeText(this, "Please write a some link", Toast.LENGTH_SHORT).show();
    }
    private void Launch_maps(){
        Intent launche_maps = new Intent(Intent.ACTION_VIEW);
        launche_maps.setData(Uri.parse("geo:18.7047471,-95.1843462,721"));
        Intent chooser = Intent.createChooser(launche_maps,"Launch Maps");
        startActivity(chooser);
    }
}