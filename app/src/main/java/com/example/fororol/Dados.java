package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
    private boolean carisma = false, destreza = false, vigor = false, inteligencia = false, percepcion = false, poder = false, voluntad = false;
    private int posicion = 0;
    Button boton;
    TextView tvHeridas, tviniciativa, tvataqueMagico, tvataqueFisico, tvdefensa, tvmovimiento, tvcarrera, tvPAs, tvUmbralHeridas;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        boton = findViewById(R.id.boton);
        tviniciativa = findViewById(R.id.tviniciativa);
        tvataqueMagico = findViewById(R.id.tvataqueMagico);
        tvataqueFisico = findViewById(R.id.tvataqueFisico);
        tvdefensa = findViewById(R.id.tvdefensa);
        tvmovimiento = findViewById(R.id.tmovimiento);
        tvcarrera = findViewById(R.id.tvcarrera);
        tvPAs = findViewById(R.id.tvPAs);
        tvUmbralHeridas = findViewById(R.id.tvUmbralHeridas);
        tvHeridas = findViewById(R.id.tvHeridas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rellenarArrays();

        //conseguir la posición del pj en arrays
        for (int i=0; i<MainActivity.pjs.size(); i++){
            if (MainActivity.pjs.get(i).getIdPj()==Build.idEscogido){
                posicion = i;
            }
        }
        if (carisma && destreza && vigor && inteligencia && percepcion && poder && voluntad) {
            boton.setEnabled(true);
            //atletismo
            int atletismo= arrayVigor.get(posicion).getAtletismo();
            tvmovimiento.setText("Movimento; Vigor: "+arrayVigor.get(posicion).getVigor()+" + Atletismo: "+atletismo+"= "+(arrayVigor.get(posicion).getVigor()+atletismo)+" m.");

            //de carrera (m)
            tvcarrera.setText("Carrera; (Vigor : "+arrayVigor.get(posicion).getVigor()+" + Atletismo: "+atletismo+")*4= "+((arrayVigor.get(posicion).getVigor()+atletismo)*4)+" m.");

            //defensa
            int defensa = arrayDestreza.get(posicion).getDestreza();
            int esquivar = arrayDestreza.get(posicion).getEsquivar();
            tvdefensa.setText("Defensa; 5 + Destreza " + defensa+" + Esquivar: "+esquivar+" = "+(5+defensa+esquivar));

            //Puntos de Aguante (PA): (Base por etapa + Vigor + Voluntad)
            tvPAs.setText("Puntos de aguante; "+paBase(MainActivity.pjs.get(posicion).getEtapa())+" + "+arrayVigor.get(posicion).getVigor()+" + "+arrayVoluntad.get(posicion).getVoluntad()+" = "+(paBase(MainActivity.pjs.get(posicion).getEtapa())+arrayVigor.get(posicion).getVigor()+arrayVoluntad.get(posicion).getVoluntad()));

            //Umbral de Heridas: (Base por etapa + Vigor).
            tvUmbralHeridas.setText("Umbral de Heridas; "+umbralHeridas(MainActivity.pjs.get(posicion).getEtapa())+" + "+arrayVigor.get(posicion).getVigor()+"= "+(umbralHeridas(MainActivity.pjs.get(posicion).getEtapa())+arrayVigor.get(posicion).getVigor()));

            //Heridas: (Base por etapa + Voluntad)
            tvHeridas.setText("Heridas; "+umbralHeridas(MainActivity.pjs.get(posicion).getEtapa())+" + "+arrayVoluntad.get(posicion).getVoluntad()+" = "+(umbralHeridas(MainActivity.pjs.get(posicion).getEtapa())+arrayVoluntad.get(posicion).getVoluntad()));
        } else {
            Toast.makeText(this, "No se ha completado la ficha de personaje", Toast.LENGTH_SHORT).show();
            boton.setEnabled(false);
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dado iniciativa
                int dado = (int) (Math.random() * 10) + 1;
                //percepcion
                int percep= arrayPercepcion.get(posicion).getPercepcion();
                //iniciativa
                int ini= arrayPercepcion.get(posicion).getIniciativa();
                tviniciativa.setText("Iniciativa; D10: "+dado+" + Percepción: "+percep+" + Iniciativa: "+ini+"= "+(dado+percep+ini));

                //dado ataque mágico
                dado = (int) (Math.random() * 10) + 1;
                //poder
                int poder= arrayPoder.get(posicion).getPoder();
                //duelo
                int duelo= arrayPoder.get(posicion).getDuelo();
                tvataqueMagico.setText("Ataque mágico; D10: "+dado+" + Poder: "+poder+" + Duelo: "+duelo+"= "+(dado+poder+duelo));

                //dado ataque físico
                //dado
                dado = (int) (Math.random() * 10) + 1;
                //vigor
                int vigor= arrayVigor.get(posicion).getVigor();
                //pelea
                int pelea= arrayVigor.get(posicion).getPelea();
                tvataqueFisico.setText("Ataque físico; D10: "+dado+" + Vigor: "+vigor+" + Pelea: "+pelea+"= "+(dado+vigor+pelea));
            }
        });

    }

    private int paBase(String etapa) {
        if (etapa.equals("Infante")) {
            return 8;
        } else if (etapa.equals("Adolescente")) {
            return 12;
        } else if (etapa.equals("Joven")) {
            return 17;
        } else if (etapa.equals("Adulto")) {
            return 17;
        } else if (etapa.equals("Experimentado")) {
            return 12;
        } else if (etapa.equals("Veterano")) {
            return 8;
        } else {
            return 0;
        }
    }

    private int umbralHeridas(String etapa) {
        if (etapa.equals("Infante")) {
            return 1;
        } else if (etapa.equals("Adolescente")) {
            return 2;
        } else if (etapa.equals("Joven")) {
            return 3;
        } else if (etapa.equals("Adulto")) {
            return 3;
        } else if (etapa.equals("Experimentado")) {
            return 2;
        } else if (etapa.equals("Veterano")) {
            return 1;
        } else {
            return 0;
        }
    }

    public void rellenarArrays() {
        //actualizar pjs
        MainActivity.pjs.clear();
        DbHelper dbhelper = new DbHelper(Dados.this);
        SQLiteDatabase dblectura = dbhelper.getReadableDatabase();
        Cursor cursor = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_PJ + "", null);
        if (cursor.moveToFirst()) {
            do {
                int idpj = (cursor.getInt(0));
                String nombre = (cursor.getString(1));
                String etapa = (cursor.getString(2));
                Pj pj = new Pj(idpj, nombre, etapa);
                MainActivity.pjs.add(pj);
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(this, "No hay pjs", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Carisma
        arrayCarisma.clear();
        cursor = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_CARISMA + "", null);
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
            carisma=true;
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
            destreza=true;
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
            vigor=true;
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
            inteligencia=true;
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
            percepcion=true;
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
            poder=true;
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
            voluntad=true;
        } else {
            Toast.makeText(this, "No hay voluntad", Toast.LENGTH_LONG).show();
        }
    }
}