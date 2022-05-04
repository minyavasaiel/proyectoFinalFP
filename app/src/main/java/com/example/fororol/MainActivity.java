package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fororol.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    private String url = "https://hp-avada-kedavra.foroactivo.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DbHelper dbhelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        if (db !=null){
            Toast.makeText(this, "Base de datos cargada", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Error al con la base de datos", Toast.LENGTH_LONG).show();
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
        if(id ==R.id.foro){
            Uri uri= Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (id == R.id.magiaid){
            Intent i = new Intent(MainActivity.this, Build.class);
            startActivity(i);
        } else if (id == R.id.calculadoraid){
            Intent i = new Intent(MainActivity.this, Calculadora.class);
            startActivity(i);
        }  else if (id ==R.id.salir) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}