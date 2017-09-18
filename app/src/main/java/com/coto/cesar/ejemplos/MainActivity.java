package com.coto.cesar.ejemplos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_mail =(TextView) findViewById(R.id.tv_correo);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void mandar_mail(View v){
        Intent mail = new Intent(Intent.ACTION_SEND);

        mail.setType("message/rfo822");
        mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"cesar.cotobvb@gmail.com"});
        mail.putExtra(Intent.EXTRA_SUBJECT,"Hellow Cesar");
        mail.putExtra(Intent.EXTRA_TEXT,"");
        startActivity(Intent.createChooser(mail,"Select aplication"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_checkbox) {
            // inicirar activiadad de checkbox
            Intent Acheckbox = new Intent(this,CheckboxActivity.class);
            startActivity(Acheckbox);

        } else if (id == R.id.nav_control_spinner) {
            //iniciar actividad de control spinner

        } else if (id == R.id.nav_radio_button) {
            //iniciar actividad de radio button
            Intent AcRadioButton = new Intent(this,RadioButtonActivity.class);
            startActivity(AcRadioButton);

        } else if (id == R.id.nav_list_view) {
            //inicar actividad listview

        } else if (id == R.id.nav_images) {
            //inicar activiada images

        } else if (id == R.id.nav_logging) {
            //inicar actividad logging

        } else if (id == R.id.nav_audio) {
            //inicar actividad audio
            Intent audio = new Intent(this,AudioActivity.class);
            startActivity(audio);

        } else if (id == R.id.nav_web_view) {
            //inicar actividad webview
            Intent web = new Intent(this,WebviewActivity.class);
            startActivity(web);

        } else if (id == R.id.nav_notifications) {
            //inicar actividad notificaciones
            Intent Acnotifications = new Intent(this,NotificationsActivity.class);
            startActivity(Acnotifications);

        }else if (id == R.id.nav_cardview) {
            //inicar actividad CardView
            Intent Accardview = new Intent(this,CardViewActivity.class);
            startActivity(Accardview);
        }else if (id == R.id.nav_database) {
            //inicar actividad Database
            Intent databse = new Intent(this,DatabaseActivity.class);
            startActivity(databse);
        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}