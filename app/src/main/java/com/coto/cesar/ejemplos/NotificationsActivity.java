package com.coto.cesar.ejemplos;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import static android.app.TaskStackBuilder.create;

public class NotificationsActivity extends AppCompatActivity {

    Button notificacion_simple,notificacion_grande,notificacion_mensaje,notificacion_imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);


        notificacion_simple = (Button) findViewById(R.id.btn_simple_notification);
        notificacion_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificacionSimple();
            }
        });

        notificacion_grande = (Button)findViewById(R.id.btn_bigtext_notification);
        notificacion_grande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificacionGrande();
            }
        });

        notificacion_imagen = (Button) findViewById(R.id.btn_image_notification);
        notificacion_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificacionImagen();
            }
        });

        notificacion_mensaje = (Button) findViewById(R.id.btn_menssage_notification);
        notificacion_mensaje.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                NotificacionMensaje();
            }
        });


        //Botton  ir atras
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }
    private void NotificacionSimple(){
        //se construye la notificacion
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_grade_black_24dp)
                .setContentTitle(getString(R.string.title_simple_notification))
                .setContentText(getString(R.string.simple_notification_content))
                .setAutoCancel(true);

        //se crea un inten explicito para la actividad de la app

        Intent Nsimple = new Intent(this,NotificationsActivity.class);

        TaskStackBuilder stackBuilder = create(this);

        stackBuilder.addParentStack(NotificationsActivity.class);

        stackBuilder.addNextIntent(Nsimple);

        PendingIntent NsimpleResult = stackBuilder.getPendingIntent(
                0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(NsimpleResult);

        // se notifica
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }
    private void NotificacionGrande(){
        //ICON
        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),R.drawable.ic_grade_black_24dp);
        //Se crea el style
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        //Datos de la notficacion de estilo grande
        bigTextStyle.bigText(getString(R.string.text_example_notification));
        bigTextStyle.setBigContentTitle(getString(R.string.text_notification_simple));
        bigTextStyle.setSummaryText(getString(R.string.Notification_creador));

        //se crea la notificacion
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_grade_black_24dp)
                .setContentTitle(getString(R.string.bigstyle_notification_title))
                .setContentText("This is a big notification")
                .setLargeIcon(icon1)
                .setStyle(bigTextStyle);

        //se optiene el servicio de notificacion

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //se notifica
        notificationManager.notify(1,builder.build());

    }
    @TargetApi(Build.VERSION_CODES.N)
    private void NotificacionImagen(){
        //se crea el style
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(
                BitmapFactory.decodeResource(getResources(),R.drawable.tablet)).build();
        //se optiene el servicio de notificacion

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        // SE CREAN Intents y PentIntents para la notificacion
        Intent intentRes = new Intent(this,NotificationsActivity.class);
        intentRes.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intentRes.FLAG_ACTIVITY_CLEAR_TASK);


            PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) Calendar.getInstance().getTimeInMillis(),intentRes,0);

        //se construye la notificacion
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_grade_black_24dp)
                .setContentTitle(getString(R.string.title_image_notification))
                .setContentText("This is a notification type image")
                .setStyle(bigPictureStyle)
                .addAction(R.mipmap.ic_launcher,"Show activity",pendingIntent);

        //se notifica
        notificationManager.notify(1,builder.build());

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void NotificacionMensaje(){
        //se crea un Intent y penIntent
        Intent intentR = new Intent(this,NotificationsActivity.class);
        TaskStackBuilder stackBuilder = create(this);
        stackBuilder.addParentStack(NotificationsActivity.class);
        stackBuilder.addNextIntent(intentR);

        PendingIntent pendingIntentR = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        PendingIntent pendingIntent = pendingIntentR.getActivity(this, (int) Calendar.getInstance().getTimeInMillis(),intentR,0);

        //se crea el estilo
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        //datos
        inboxStyle.setBigContentTitle("Hi");
        inboxStyle.addLine("What's up?");
        inboxStyle.addLine("How you feel today?");
        inboxStyle.addLine("What do yo do?");
        inboxStyle.addLine("How old are you?");
        inboxStyle.setSummaryText("2+");

        //se construye la notificacion
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_grade_black_24dp)
                .setContentTitle("Inbox style notification")
                .setContentText("This is a notification style inbox")
                .setStyle(inboxStyle)
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher,"Cesar Coto",pendingIntent);

        // se instancia
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        // se notifica
        notificationManager.notify(1,builder.build());


    }

}
