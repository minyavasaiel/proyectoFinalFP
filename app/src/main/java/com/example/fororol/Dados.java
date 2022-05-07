package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fororol.db.DbHelper;
import com.example.fororol.modelo.Carisma;
import com.example.fororol.modelo.Destreza;
import com.example.fororol.modelo.Inteligencia;
import com.example.fororol.modelo.Percepcion;
import com.example.fororol.modelo.Pj;
import com.example.fororol.modelo.Poder;
import com.example.fororol.modelo.Vigor;
import com.example.fororol.modelo.Voluntad;

import java.util.ArrayList;

public class Dados extends AppCompatActivity {
    public static ArrayList<Carisma> arrayCarisma = new ArrayList<>();
    public static ArrayList<Destreza> arrayDestreza = new ArrayList<>();
    public static ArrayList<Vigor> arrayVigor = new ArrayList<>();
    public static ArrayList<Inteligencia> arrayInteligencia = new ArrayList<>();
    public static ArrayList<Percepcion> arrayPercepcion = new ArrayList<>();
    public static ArrayList<Poder> arrayPoder = new ArrayList<>();
    public static ArrayList<Voluntad> arrayVoluntad = new ArrayList<>();

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rellenarArrays();

        System.out.println("Carisma: " +arrayCarisma.size());
        for (int i = 0; i < arrayCarisma.size(); i++) {
            System.out.println(arrayCarisma.get(i).toString());
        }

        System.out.println("Destreza: " +arrayDestreza.size());
        for (int i = 0; i < arrayDestreza.size(); i++) {
            System.out.println(arrayDestreza.get(i).toString());
        }

        System.out.println("Vigor: " +arrayVigor.size());
        for (int i = 0; i < arrayVigor.size(); i++) {
            System.out.println(arrayVigor.get(i).toString());
        }

        System.out.println("Inteligencia: " +arrayInteligencia.size());
        for (int i = 0; i < arrayInteligencia.size(); i++) {
            System.out.println(arrayInteligencia.get(i).toString());
        }

        System.out.println("Percepcion: " +arrayPercepcion.size());
        for (int i = 0; i < arrayPercepcion.size(); i++) {
            System.out.println(arrayPercepcion.get(i).toString());
        }

        System.out.println("Poder: " +arrayPoder.size());
        for (int i = 0; i < arrayPoder.size(); i++) {
            System.out.println(arrayPoder.get(i).toString());
        }

        System.out.println("Voluntad: " +arrayVoluntad.size());
        for (int i = 0; i < arrayVoluntad.size(); i++) {
            System.out.println(arrayVoluntad.get(i).toString());
        }
    }

    private void rellenarArrays() {
        //meter en modelo Carisma
        arrayCarisma.clear();
        DbHelper dbhelper = new DbHelper(Dados.this);
        SQLiteDatabase dblectura = dbhelper.getReadableDatabase();
        Cursor cursor = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_CARISMA + "", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                int carisma = cursor.getInt(1);
                int coordinacion = cursor.getInt(2);
                int intimidacion = cursor.getInt(3);
                int oratoria = cursor.getInt(4);
                int seducir = cursor.getInt(5);
                int subterfugio = cursor.getInt(6);
                Carisma carismaObjeto = new Carisma(id, carisma, coordinacion, intimidacion, oratoria, seducir, subterfugio);
                arrayCarisma.add(carismaObjeto);
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(this, "No hay carisma", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Destreza
        arrayDestreza.clear();
        Cursor cursor1 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_DEX + "", null);
        if (cursor1.moveToFirst()) {
            do {
                int id = cursor1.getInt(0);
                int dex = cursor1.getInt(1);
                int esquivar = cursor1.getInt(2);
                int latrocinio = cursor1.getInt(3);
                int sigilo = cursor1.getInt(4);
                int volar = cursor1.getInt(5);
                Destreza destrezaObjeto = new Destreza(id, dex, esquivar, latrocinio, sigilo, volar);
                arrayDestreza.add(destrezaObjeto);
            } while (cursor1.moveToNext());
        } else {
            Toast.makeText(this, "No hay destreza", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Vigor
        arrayVigor.clear();
        Cursor cursor2 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_VIGOR + "", null);
        if (cursor2.moveToFirst()) {
            do {
                int id = cursor2.getInt(0);
                int vigor = cursor2.getInt(1);
                int atletismo = cursor2.getInt(2);
                int pelea = cursor2.getInt(3);
                Vigor vigorObjeto = new Vigor(id, vigor, atletismo, pelea);
                arrayVigor.add(vigorObjeto);
            } while (cursor2.moveToNext());
        } else {
            Toast.makeText(this, "No hay vigor", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Inteligencia
        arrayInteligencia.clear();
        Cursor cursor3 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_INTELIGENCIA + "", null);
        if (cursor3.moveToFirst()) {
            do {
                int id = cursor3.getInt(0);
                int inteligencia = cursor3.getInt(1);
                int adivinacion = cursor3.getInt(2);
                int arcanismo = cursor3.getInt(3);
                int callejeo = cursor3.getInt(4);
                int culturaMagica = cursor3.getInt(5);
                int culturaMuggle = cursor3.getInt(6);
                int herbologia  = cursor3.getInt(7);
                int magizoologia = cursor3.getInt(8);
                int medicina = cursor3.getInt(9);
                int politica = cursor3.getInt(10);
                int supervivencia = cursor3.getInt(11);
                Inteligencia inteligenciaObjeto = new Inteligencia(id, inteligencia, adivinacion, arcanismo, callejeo, culturaMagica, culturaMuggle, herbologia, magizoologia, medicina, politica, supervivencia);
                arrayInteligencia.add(inteligenciaObjeto);
            } while (cursor3.moveToNext());
        } else {
            Toast.makeText(this, "No hay inteligencia", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Percepcion
        arrayPercepcion.clear();
        Cursor cursor4 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_PERCEPCION + "", null);
        if (cursor4.moveToFirst()) {
            do {
                int id = cursor4.getInt(0);
                int percepcion = cursor4.getInt(1);
                int alerta = cursor4.getInt(2);
                int conciencia = cursor4.getInt(3);
                int empatia = cursor4.getInt(4);
                int iniciativa = cursor4.getInt(5);
                int investigacion = cursor4.getInt(6);
                Percepcion percepcionObjeto = new Percepcion(id, percepcion, alerta, conciencia, empatia, iniciativa, investigacion);
                arrayPercepcion.add(percepcionObjeto);
            } while (cursor4.moveToNext());
        } else {
            Toast.makeText(this, "No hay percepcion", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Poder
        arrayPoder.clear();
        Cursor cursor5 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_PODER + "", null);
        if (cursor5.moveToFirst()) {
            do {
                int id = cursor5.getInt(0);
                int poder = cursor5.getInt(1);
                int duelo = cursor5.getInt(2);
                int pocion = cursor5.getInt(3);
                int ritual = cursor5.getInt(4);
                Poder poderObjeto = new Poder(id, poder, duelo, pocion, ritual);
                arrayPoder.add(poderObjeto);
            } while (cursor5.moveToNext());
        } else {
            Toast.makeText(this, "No hay poder", Toast.LENGTH_LONG).show();
        }

        //meter modelo Voluntad
        arrayVoluntad.clear();
        Cursor cursor6 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_VOLUNTAD + "", null);
        if (cursor6.moveToFirst()) {
            do {
                int id = cursor6.getInt(0);
                int voluntad = cursor6.getInt(1);
                int arte = cursor6.getInt(2);
                int estilo = cursor6.getInt(3);
                int frialdad = cursor6.getInt(4);
                Voluntad voluntadObjeto = new Voluntad(id, voluntad, arte, estilo, frialdad);
                arrayVoluntad.add(voluntadObjeto);
            } while (cursor6.moveToNext());
        } else {
            Toast.makeText(this, "No hay voluntad", Toast.LENGTH_LONG).show();
        }
    }
}