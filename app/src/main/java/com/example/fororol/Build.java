package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.ContextParams;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fororol.db.DbHelper;
import com.example.fororol.modelo.Vigor;

import java.util.ArrayList;

public class Build extends AppCompatActivity {
    private Spinner vigor, poder, destreza, carisma, voluntad, percepcion, inteligencia;
    private Spinner atletismo, pelea, esquivar, latrocinio, sigilo, volar, coordinacion, intimidacion, oratoria, seducir, subterfugio, duelo, pociones, rituales, arte, estilo, frialdad, alerta, consciencia, empatia, iniciativa, investigacion, adivinacion, arcanismo, callejeo, culturaM, culturaMu, herbologia, magizoologia, medicina, politica, supervivencia;
    private Button bactualiar;
    private ArrayList arrayVigor = new ArrayList<Vigor>();

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
       iniciativa= findViewById(R.id.iniciativa);
       investigacion= findViewById(R.id.investigacion);

       inteligencia=findViewById(R.id.inteligencia);
       adivinacion = findViewById(R.id.adivinacion);
       arcanismo = findViewById(R.id.arcanismo);
       callejeo=findViewById(R.id.callejeo);
       culturaM= findViewById(R.id.culturaMag);
       culturaMu = findViewById(R.id.culturaMug);
       herbologia= findViewById(R.id.herbologia);
       magizoologia= findViewById(R.id.magizoologia);
       medicina = findViewById(R.id.medicina);
       politica = findViewById(R.id.politica);
       supervivencia = findViewById(R.id.supervivencia);

       bactualiar = findViewById(R.id.bactualizar);

       //poner los datos de la base de datos
        DbHelper dbHelper = new DbHelper(getApplicationContext()); //Build.this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_VIGOR+"' ", null);
        if (fila.moveToFirst()) {
            vigor.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            atletismo.setSelection(fila.getInt(2));
            pelea.setSelection(fila.getInt(3));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_DEX+"' ", null);
        if (fila.moveToFirst()) {
            destreza.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            esquivar.setSelection(fila.getInt(2));
            latrocinio.setSelection(fila.getInt(3));
            oratoria.setSelection( fila.getInt(4));
            volar.setSelection(fila.getInt(5));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_CARISMA+"' ", null);
        if (fila.moveToFirst()) {
            carisma.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            coordinacion.setSelection(fila.getInt(2));
            intimidacion.setSelection(fila.getInt(3));
            sigilo.setSelection( fila.getInt(4));
            seducir.setSelection(fila.getInt(5));
            subterfugio.setSelection(fila.getInt(6));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_PODER+"' ", null);
        if (fila.moveToFirst()) {
            poder.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            duelo.setSelection(fila.getInt(2));
            pociones.setSelection(fila.getInt(3));
            rituales.setSelection( fila.getInt(4));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_VOLUNTAD+"' ", null);
        if (fila.moveToFirst()) {
            voluntad.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            arte.setSelection(fila.getInt(2));
            estilo.setSelection(fila.getInt(3));
            frialdad.setSelection( fila.getInt(4));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_PERCEPCION+"' ", null);
        if (fila.moveToFirst()) {
            percepcion.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            alerta.setSelection(fila.getInt(2));
            consciencia.setSelection(fila.getInt(3));
            empatia.setSelection( fila.getInt(4));
            iniciativa.setSelection(fila.getInt(5));
            investigacion.setSelection(fila.getInt(6));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_INTELIGENCIA+"' ", null);
        if (fila.moveToFirst()) {
            inteligencia.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            adivinacion.setSelection(fila.getInt(2));
            arcanismo.setSelection(fila.getInt(3));
            callejeo.setSelection( fila.getInt(4));
            culturaM.setSelection(fila.getInt(5));
            culturaMu.setSelection(fila.getInt(6));
            herbologia.setSelection(fila.getInt(7));
            magizoologia.setSelection(fila.getInt(8));
            medicina.setSelection(fila.getInt(9));
            politica.setSelection(fila.getInt(10));
            supervivencia.setSelection(fila.getInt(11));
        }
        db.close();


        bactualiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FALTA LA COMPROBACIÓN SI INSERT O UPDATE
                DbHelper dbHelper = new DbHelper(getApplicationContext()); //Build.this
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM "+DbHelper.TABLE_VIGOR+ " WHERE idv= "+1, null);
                if (cursor.moveToNext()) {
                    update();
                } else {
                    insert();
                }
            }
        });
    }

    public void insert(){
        DbHelper dbHelper = new DbHelper(getApplicationContext()); //Build.this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        boolean comprobador1= false, comprobador2 = false, comprobador3=false, comprobador4= false, comprobador5 = false, comprobador6= false, comprobador7= false;
                String query= "SELECT * FROM '"+DbHelper.TABLE_VIGOR+"' ";
                if (db.rawQuery(query, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idv", 1);
                    registro.put("vigor", Integer.parseInt(vigor.getSelectedItem().toString()));
                    registro.put("atletismo",metodoConversorHabilidad(atletismo.getSelectedItem().toString()) );
                    registro.put("pelea", metodoConversorHabilidad(pelea.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_VIGOR, null, registro);
                    comprobador1 = true;
                }
               String query2= "SELECT * FROM '"+DbHelper.TABLE_DEX+"' ";
                if (db.rawQuery(query2, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idd", 1);
                    registro.put("destreza", Integer.parseInt(destreza.getSelectedItem().toString()));
                    registro.put("esquivar", metodoConversorHabilidad(esquivar.getSelectedItem().toString()));
                    registro.put("sigilo", metodoConversorHabilidad(sigilo.getSelectedItem().toString()));
                    registro.put("latrocinio", metodoConversorHabilidad(latrocinio.getSelectedItem().toString()));
                    registro.put("volar", metodoConversorHabilidad(volar.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_DEX, null, registro);
                    comprobador2 = true;
                }
                String query3= "SELECT * FROM '"+DbHelper.TABLE_CARISMA+"' ";
                if (db.rawQuery(query3, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idc", 1);
                    registro.put("carisma", Integer.parseInt(carisma.getSelectedItem().toString()));
                    registro.put("coordinacion", metodoConversorHabilidad(coordinacion.getSelectedItem().toString()));
                    registro.put("intimidacion", metodoConversorHabilidad(intimidacion.getSelectedItem().toString()));
                    registro.put("oratoria", metodoConversorHabilidad(oratoria.getSelectedItem().toString()));
                    registro.put("seducir", metodoConversorHabilidad(seducir.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_CARISMA, null, registro);
                    comprobador3 = true;
                }
                String query4= "SELECT * FROM '"+DbHelper.TABLE_PODER+"' ";
                if (db.rawQuery(query4, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idp", 1);
                    registro.put("poder", Integer.parseInt(poder.getSelectedItem().toString()));
                    registro.put("duelo", metodoConversorHabilidad(duelo.getSelectedItem().toString()));
                    registro.put("pociones", metodoConversorHabilidad(pociones.getSelectedItem().toString()));
                    registro.put("rituales", metodoConversorHabilidad(rituales.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_PODER, null, registro);
                    comprobador4 = true;
                }
                String query5= "SELECT * FROM '"+DbHelper.TABLE_VOLUNTAD+"' ";
                if (db.rawQuery(query5, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idvo", 1);
                    registro.put("voluntad", Integer.parseInt(voluntad.getSelectedItem().toString()));
                    registro.put("arte", metodoConversorHabilidad(arte.getSelectedItem().toString()));
                    registro.put("estilo", metodoConversorHabilidad(estilo.getSelectedItem().toString()));
                    registro.put("frialdad", metodoConversorHabilidad(frialdad.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_VOLUNTAD, null, registro);
                    comprobador5 = true;
                }
                String query6= "SELECT * FROM '"+DbHelper.TABLE_PERCEPCION+"' ";
                if (db.rawQuery(query6, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idpe", 1);
                    registro.put("percepcion", Integer.parseInt(percepcion.getSelectedItem().toString()));
                    registro.put("alerta", metodoConversorHabilidad(alerta.getSelectedItem().toString()));
                    registro.put("consciencia", metodoConversorHabilidad(consciencia.getSelectedItem().toString()));
                    registro.put("empatia", metodoConversorHabilidad(empatia.getSelectedItem().toString()));
                    registro.put("iniciativa", metodoConversorHabilidad(iniciativa.getSelectedItem().toString()));
                    registro.put("investigacion", metodoConversorHabilidad(investigacion.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_PERCEPCION, null, registro);
                    comprobador6 = true;
                }
                String query7= "SELECT * FROM '"+DbHelper.TABLE_INTELIGENCIA+"' ";
                if (db.rawQuery(query7, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idi", 1);
                    registro.put("inteligencia", Integer.parseInt(percepcion.getSelectedItem().toString()));
                    registro.put("adivinacion", metodoConversorHabilidad(alerta.getSelectedItem().toString()));
                    registro.put("arcanismo", metodoConversorHabilidad(consciencia.getSelectedItem().toString()));
                    registro.put("callejeo", metodoConversorHabilidad(empatia.getSelectedItem().toString()));
                    registro.put("culturaMagia", metodoConversorHabilidad(iniciativa.getSelectedItem().toString()));
                    registro.put("culturaMuggle", metodoConversorHabilidad(investigacion.getSelectedItem().toString()));
                    registro.put("herbologia", metodoConversorHabilidad(investigacion.getSelectedItem().toString()));
                    registro.put("magizoologia", metodoConversorHabilidad(investigacion.getSelectedItem().toString()));
                    registro.put("medicina", metodoConversorHabilidad(investigacion.getSelectedItem().toString()));
                    registro.put("politica", metodoConversorHabilidad(investigacion.getSelectedItem().toString()));
                    registro.put("supervivencia", metodoConversorHabilidad(investigacion.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_INTELIGENCIA, null, registro);
                    comprobador7 = true;
                }
                if (comprobador1 && comprobador2 && comprobador3 && comprobador4 && comprobador5 && comprobador6 && comprobador7) {
                    Toast.makeText(getApplicationContext(), "Datos actualizados correctamente.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Datos insertados correctamente.", Toast.LENGTH_LONG).show();
                }
        db.close();
    }

    public void update(){
        DbHelper dbHelper2 = new DbHelper(getApplicationContext()); //Build.this
        SQLiteDatabase db2 = dbHelper2.getWritableDatabase();
        int updateVigor = Integer.parseInt(vigor.getSelectedItem().toString());
        int updateAtle = metodoConversorHabilidad(atletismo.getSelectedItem().toString());
        int updatePelea =metodoConversorHabilidad(pelea.getSelectedItem().toString());

        ContentValues registro = new ContentValues();
        registro.put("vigor", updateVigor);
        registro.put("atletismo", updateAtle);
        registro.put("pelea", updatePelea);

        int cantidad = db2.update(DbHelper.TABLE_VIGOR, registro, "idv= "+1, null);
        db2.close();

        if (cantidad == 1){
            Toast.makeText(this, "Ficha actualizada correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error: ficha no actualizada", Toast.LENGTH_LONG).show();
        }
    }

    public int metodoConversorHabilidad (String datoSpinner) {
        if (datoSpinner.equals("Desentrenado (+0)")) {
            return 0;
        }else if (datoSpinner.equals("Novato (+1)")) {
            return 1;
        } else if (datoSpinner.equals("Competente (+2)")){
           return 2;
        } else if (datoSpinner.equals("Experto (+4)")){
            return 4;
        } else if (datoSpinner.equals("Maestro (+7)")){
            return 7;
        } else{
            return -1;
        }
    }


}