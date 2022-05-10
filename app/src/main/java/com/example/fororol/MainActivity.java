package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fororol.db.DbHelper;
import com.example.fororol.modelo.Pj;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String url = "https://hp-avada-kedavra.foroactivo.com/";
    public static ArrayList<Pj> pjs = new ArrayList<>();
    public static String nombrePj;
    Button btn, btnescoger;
    TextView tvpjEscogido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.bAnhadir);
        btnescoger = (Button) findViewById(R.id.bEscoger);
        tvpjEscogido = (TextView) findViewById(R.id.tvpjEscogido);

        DbHelper dbhelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        if (db != null) {
            Toast.makeText(this, "Base de datos cargada", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error al cargar la base de datos", Toast.LENGTH_LONG).show();
        }
        //Cargar Array de pjs
        cargarPjs();
        comprobarBoton();

        //poner pj escogido
        for (int i = 0; i < pjs.size(); i++) {
            if (pjs.get(i).getIdPj() == Build.idEscogido) {
                nombrePj = pjs.get(i).getNombre();
            }
        }
        if (Build.idEscogido != 0) {
            tvpjEscogido.setText("Estás trabajando con " + nombrePj);
        } else {
            tvpjEscogido.setText("No hay pj escogido.");
        }

        btnescoger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Escoger.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NuevoPj.class);
                startActivity(intent);
            }
        });

    }

    private void comprobarBoton() {
        if (pjs.isEmpty()) {
            btnescoger.setEnabled(false);
        }
        if (pjs.size() == 9) {
            btn.setEnabled(false);
        }
    }

    private void cargarPjs() {
        //meter en modelo PJ
        pjs.clear();
        DbHelper dbhelper = new DbHelper(MainActivity.this);
        SQLiteDatabase dblectura = dbhelper.getReadableDatabase();
        Cursor cursor = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_PJ + "", null);
        if (cursor.moveToFirst()) {
            do {
                int idpj = (cursor.getInt(0));
                String nombre = (cursor.getString(1));
                String etapa = (cursor.getString(2));
                Pj pj = new Pj(idpj, nombre, etapa);
                pjs.add(pj);
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(this, "No hay pjs", Toast.LENGTH_LONG).show();
        }
        for (Pj pj : pjs) {
            System.out.println(pj.toString());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.foro) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (id == R.id.magiaid) {
            if (Build.idEscogido != 0) {
                Intent i = new Intent(MainActivity.this, Build.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "No hay pj escogido", Toast.LENGTH_LONG).show();
            }
        } else if (id == R.id.calculadoraid) {
            if (Build.idEscogido != 0) {
                Intent i = new Intent(MainActivity.this, Calculadora.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "No hay pj escogido", Toast.LENGTH_LONG).show();
            }
        } else if (id == R.id.dados) {
            if (Build.idEscogido != 0) {
                Intent i = new Intent(MainActivity.this, Dados.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "No hay pj escogido", Toast.LENGTH_LONG).show();
            }
        } else if (id == R.id.salir) {
            finishAffinity ();
        }
        return super.onOptionsItemSelected(item);
    }
}