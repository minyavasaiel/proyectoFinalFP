package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class Magia extends AppCompatActivity {
    private EditText vigor, atletismo, pelea, destreza, carisma, poder, voluntad, percepcion, inteligencia;
    private EditText esquivar, latrocinio, sigilo, volar, coordinacion, intimidacion, oratoria, seducir, subterfugio, duelo, pociones, rituales, arte, estilo, frialdad, alerta, consciencia, empatia, iniciativa, investigacion, adivinacion, arcanismo, callejeo, culturaM, culturaMu, herbologia, magizoologia, medicina, politica, supervivencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magia);

       vigor= findViewById(R.id.vigor);
       atletismo= findViewById(R.id.atletismo);
       pelea=findViewById(R.id.pelea);
       destreza= findViewById(R.id.destreza);
       esquivar = findViewById(R.id.esquivar);
       latrocinio = findViewById(R.id.latrocinio);
       sigilo= findViewById(R.id.sigilo);
       volar= findViewById(R.id.volar);
       carisma= findViewById(R.id.carisma);
       coordinacion= findViewById(R.id.coordinacion);
       intimidacion= findViewById(R.id.intimidacion);
       oratoria= findViewById(R.id.oratoria);
       seducir= findViewById(R.id.seducir);
       subterfugio= findViewById(R.id.subterfugio);
       poder=findViewById(R.id.poder);
       duelo= findViewById(R.id.duelo);
       pociones=findViewById(R.id.pociones);
       rituales=findViewById(R.id.rituales);
       voluntad= findViewById(R.id.voluntad);
       arte= findViewById(R.id.arte);
       estilo= findViewById(R.id.estilo);
       frialdad=findViewById(R.id.frialdad);
       percepcion=findViewById(R.id.percepcion);
       alerta=findViewById(R.id.alerta);
       consciencia= findViewById(R.id.consciencia);
       empatia= findViewById(R.id.empatia);
       //iniciativa= findViewById(R.id.iniciativa);



        /*SQLiteDatabase myDB = openOrCreateDatabase("pjsforo.db", MODE_PRIVATE, null);
        myDB.execSQL( "CREATE TABLE IF NOT EXISTS pj1Magia (name VARCHAR(200), age INT)" );

        ContentValues row1 = new ContentValues();
        row1.put("name", "Alice");
        row1.put("age", 25);
        myDB.insert("pj1", null, row1);

        Cursor myCursor = myDB.rawQuery("select name, age from pj1", null);
        while(myCursor.moveToNext()) {
            name = myCursor.getString(0);
            age = myCursor.getInt(1);
        }
        myCursor.close();
        myDB.close();
        Log.d("dato", name);*/
        vigor.setText("3");
        atletismo.setText("3");
        pelea.setText("1");

    }
}