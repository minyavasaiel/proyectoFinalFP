package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fororol.db.DbHelper;

public class Build extends AppCompatActivity {
    private Spinner vigor, poder, destreza, carisma, voluntad, percepcion, inteligencia;
    private Spinner etapa, atletismo, pelea, esquivar, latrocinio, sigilo, volar, coordinacion, intimidacion, oratoria, seducir, subterfugio, duelo, pociones, rituales, arte, estilo, frialdad, alerta, consciencia, empatia, iniciativa, investigacion, adivinacion, arcanismo, callejeo, culturaM, culturaMu, herbologia, magizoologia, medicina, politica, supervivencia;
    private Button bactualiar;
    private TextView titulo;
    //private ArrayList arrayVigor = new ArrayList<Vigor>();
    public static int idEscogido =0;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
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
       titulo = findViewById(R.id.titulo);
       etapa = findViewById(R.id.etapa);

       titulo.setText("Ficha de "+MainActivity.nombrePj);


       //poner los datos de la base de datos y arrays Modelo
        DbHelper dbHelper = new DbHelper(getApplicationContext()); //Build.this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_VIGOR+"' WHERE idv= '"+idEscogido+"' ", null);
        if (fila.moveToFirst()) {
            vigor.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            atletismo.setSelection(reversoHabilidad(fila.getInt(2)));
            pelea.setSelection(reversoHabilidad(fila.getInt(3)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_DEX+"' WHERE idd= '" +idEscogido+ "' ", null);
        if (fila.moveToFirst()) {
            destreza.setSelection(fila.getInt(1));
            esquivar.setSelection(reversoHabilidad(fila.getInt(2)));
            latrocinio.setSelection(reversoHabilidad(fila.getInt(3)));
            sigilo.setSelection(reversoHabilidad(fila.getInt(4)));
            volar.setSelection(reversoHabilidad(fila.getInt(5)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_CARISMA+"' WHERE idc= '" +idEscogido+ "' ", null);
        if (fila.moveToFirst()) {
            carisma.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            coordinacion.setSelection(reversoHabilidad(fila.getInt(2)));
            intimidacion.setSelection(reversoHabilidad(fila.getInt(3)));
            oratoria.setSelection(reversoHabilidad(fila.getInt(4)));
            seducir.setSelection(reversoHabilidad(fila.getInt(5)));
            subterfugio.setSelection(reversoHabilidad(fila.getInt(6)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_PODER+"' WHERE idp= '" + idEscogido+"' ", null);
        if (fila.moveToFirst()) {
            poder.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            duelo.setSelection(reversoHabilidad(fila.getInt(2)));
            pociones.setSelection(reversoHabilidad(fila.getInt(3)));
            rituales.setSelection(reversoHabilidad(fila.getInt(4)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_VOLUNTAD+"' WHERE idvo= ' "+idEscogido+" '", null);
        if (fila.moveToFirst()) {
            voluntad.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            arte.setSelection(reversoHabilidad(fila.getInt(2)));
            estilo.setSelection(reversoHabilidad(fila.getInt(3)));
            frialdad.setSelection(reversoHabilidad(fila.getInt(4)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_PERCEPCION+"' WHERE idpe= ' "+idEscogido+" '", null);
        if (fila.moveToFirst()) {
            percepcion.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            alerta.setSelection(reversoHabilidad(fila.getInt(2)));
            consciencia.setSelection(reversoHabilidad(fila.getInt(3)));
            empatia.setSelection(reversoHabilidad(fila.getInt(4)));
            iniciativa.setSelection(reversoHabilidad(fila.getInt(5)));
            investigacion.setSelection(reversoHabilidad(fila.getInt(6)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_INTELIGENCIA+"' WHERE idi= '"+ idEscogido+" '", null);
        if (fila.moveToFirst()) {
            inteligencia.setSelection(fila.getInt(1));
            adivinacion.setSelection(reversoHabilidad(fila.getInt(2)));
            arcanismo.setSelection(reversoHabilidad(fila.getInt(3)));
            callejeo.setSelection(reversoHabilidad(fila.getInt(4)));
            culturaM.setSelection(reversoHabilidad(fila.getInt(5)));
            culturaMu.setSelection(reversoHabilidad(fila.getInt(6)));
            herbologia.setSelection(reversoHabilidad(fila.getInt(7)));
            magizoologia.setSelection(reversoHabilidad(fila.getInt(8)));
            medicina.setSelection(reversoHabilidad(fila.getInt(9)));
            politica.setSelection(reversoHabilidad(fila.getInt(10)));
            supervivencia.setSelection(reversoHabilidad(fila.getInt(11)));
        }

        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_PJ+"' WHERE idpj= '"+ idEscogido+" '", null);
        if (fila.moveToFirst()) {
            etapa.setSelection(reversoEtapa(fila.getString(2)));
        }
        db.close();


        bactualiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(getApplicationContext()); //Build.this
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM "+DbHelper.TABLE_VIGOR+ " WHERE idv= "+idEscogido, null);
                if (cursor.moveToNext()) {
                    update();
                } else {
                    insert();
                }
                db.close();
            }
        });
    }

    public void insert(){
        DbHelper dbHelper = new DbHelper(getApplicationContext()); //Build.this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        boolean comprobador1= false, comprobador2 = false, comprobador3=false, comprobador4= false, comprobador5 = false, comprobador6= false, comprobador7= false, comprobador8=false;
                String query= "SELECT * FROM '"+DbHelper.TABLE_VIGOR+"' ";
                if (db.rawQuery(query, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idv", idEscogido);
                    registro.put("vigor", Integer.parseInt(vigor.getSelectedItem().toString()));
                    registro.put("atletismo",metodoConversorHabilidad(atletismo.getSelectedItem().toString()) );
                    registro.put("pelea", metodoConversorHabilidad(pelea.getSelectedItem().toString()));
                    System.out.println("Atletismo: "+metodoConversorHabilidad(atletismo.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_VIGOR, null, registro);
                    comprobador1 = true;
                }
               String query2= "SELECT * FROM '"+DbHelper.TABLE_DEX+"' ";
                if (db.rawQuery(query2, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idd", idEscogido);
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
                    registro.put("idc", idEscogido);
                    registro.put("carisma", Integer.parseInt(carisma.getSelectedItem().toString()));
                    registro.put("coordinacion", metodoConversorHabilidad(coordinacion.getSelectedItem().toString()));
                    registro.put("intimidacion", metodoConversorHabilidad(intimidacion.getSelectedItem().toString()));
                    registro.put("oratoria", metodoConversorHabilidad(oratoria.getSelectedItem().toString()));
                    registro.put("seducir", metodoConversorHabilidad(seducir.getSelectedItem().toString()));
                    registro.put("subterfugio", metodoConversorHabilidad(subterfugio.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_CARISMA, null, registro);
                    comprobador3 = true;
                }
                String query4= "SELECT * FROM '"+DbHelper.TABLE_PODER+"' ";
                if (db.rawQuery(query4, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idp", idEscogido);
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
                    registro.put("idvo", idEscogido);
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
                    registro.put("idpe", idEscogido);
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
                    registro.put("idi", idEscogido);
                    registro.put("inteligencia", Integer.parseInt(inteligencia.getSelectedItem().toString()));
                    registro.put("adivinacion", metodoConversorHabilidad(adivinacion.getSelectedItem().toString()));
                    registro.put("arcanismo", metodoConversorHabilidad(arcanismo.getSelectedItem().toString()));
                    registro.put("callejeo", metodoConversorHabilidad(callejeo.getSelectedItem().toString()));
                    registro.put("culturaMagia", metodoConversorHabilidad(culturaM.getSelectedItem().toString()));
                    registro.put("culturaMuggle", metodoConversorHabilidad(culturaMu.getSelectedItem().toString()));
                    registro.put("herbologia", metodoConversorHabilidad(herbologia.getSelectedItem().toString()));
                    registro.put("magizoologia", metodoConversorHabilidad(magizoologia.getSelectedItem().toString()));
                    registro.put("medicina", metodoConversorHabilidad(medicina.getSelectedItem().toString()));
                    registro.put("politica", metodoConversorHabilidad(politica.getSelectedItem().toString()));
                    registro.put("supervivencia", metodoConversorHabilidad(supervivencia.getSelectedItem().toString()));
                    db.insert(dbHelper.TABLE_INTELIGENCIA, null, registro);
                    comprobador7 = true;
                }
        //actualizar etapa
        String updateetapa = etapa.getSelectedItem().toString();
        ContentValues registro8 = new ContentValues();
        registro8.put("etapa", updateetapa);
        int cantidad8 = db.update(DbHelper.TABLE_PJ, registro8, "idpj= "+idEscogido, null);
                if (comprobador1 && comprobador2 && comprobador3 && comprobador4 && comprobador5 && comprobador6 && comprobador7 && cantidad8==1){
                    Toast.makeText(getApplicationContext(), "Datos insertados correctamente.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Datos insertados correctamente.", Toast.LENGTH_LONG).show();
                }
        db.close();
    }

    public void update(){
        DbHelper dbHelper2 = new DbHelper(getApplicationContext()); //Build.this
        SQLiteDatabase db2 = dbHelper2.getWritableDatabase();
        //actualizar vigor
        int updateVigor = Integer.parseInt(vigor.getSelectedItem().toString());
        int updateAtle = metodoConversorHabilidad(atletismo.getSelectedItem().toString());
        int updatePelea =metodoConversorHabilidad(pelea.getSelectedItem().toString());

        ContentValues registro = new ContentValues();
        registro.put("vigor", updateVigor);
        registro.put("atletismo", updateAtle);
        registro.put("pelea", updatePelea);

        int cantidad = db2.update(DbHelper.TABLE_VIGOR, registro, "idv= "+idEscogido, null);

        //actualizar destreza
        int updatedex = Integer.parseInt(destreza.getSelectedItem().toString());
        int updateesq = metodoConversorHabilidad(esquivar.getSelectedItem().toString());
        int updatelatrocinio = metodoConversorHabilidad(latrocinio.getSelectedItem().toString());
        int updatesigilo = metodoConversorHabilidad(sigilo.getSelectedItem().toString());
        int updatevolar= metodoConversorHabilidad(volar.getSelectedItem().toString());

        ContentValues registro2 = new ContentValues();
        registro2.put("destreza", updatedex);
        registro2.put("esquivar", updateesq);
        registro2.put("latrocinio", updatelatrocinio);
        registro2.put("sigilo", updatesigilo);
        registro2.put("volar", updatevolar);

        int cantidad2 = db2.update(DbHelper.TABLE_DEX, registro2, "idd= "+idEscogido, null);

        //actualizar carisma
        int updatecar = Integer.parseInt(carisma.getSelectedItem().toString());
        int updatecoor= metodoConversorHabilidad(coordinacion.getSelectedItem().toString());
        int updateint = metodoConversorHabilidad(intimidacion.getSelectedItem().toString());
        int updateora = metodoConversorHabilidad(oratoria.getSelectedItem().toString());
        int updateseducir = metodoConversorHabilidad(seducir.getSelectedItem().toString());
        int updatesubt = metodoConversorHabilidad(subterfugio.getSelectedItem().toString());

        ContentValues registro3 = new ContentValues();
        registro3.put("carisma", updatecar);
        registro3.put("coordinacion", updatecoor);
        registro3.put("intimidacion", updateint);
        registro3.put("oratoria", updateora);
        registro3.put("seducir", updateseducir);
        registro3.put("subterfugio", updatesubt);

        int cantidad3 = db2.update(DbHelper.TABLE_CARISMA, registro3, "idc= "+idEscogido, null);

        //actualizar poder
        int updatepoder = Integer.parseInt(poder.getSelectedItem().toString());
        int updateduelo= metodoConversorHabilidad(duelo.getSelectedItem().toString());
        int updatepociones = metodoConversorHabilidad(pociones.getSelectedItem().toString());
        int updaterituales = metodoConversorHabilidad(rituales.getSelectedItem().toString());

        ContentValues registro4 = new ContentValues();
        registro4.put("poder", updatepoder);
        registro4.put("duelo", updateduelo);
        registro4.put("pociones", updatepociones);
        registro4.put("rituales", updaterituales);

        int cantidad4 = db2.update(DbHelper.TABLE_PODER, registro4, "idp= "+idEscogido, null);

        //actualizar voluntad
        int updatevol = Integer.parseInt(voluntad.getSelectedItem().toString());
        int updatearte = metodoConversorHabilidad(arte.getSelectedItem().toString());
        int updateestilo = metodoConversorHabilidad(estilo.getSelectedItem().toString());
        int updatefrialdad = metodoConversorHabilidad(frialdad.getSelectedItem().toString());

        ContentValues registro5 = new ContentValues();
        registro5.put("voluntad", updatevol);
        registro5.put("arte", updatearte);
        registro5.put("estilo", updateestilo);
        registro5.put("frialdad", updatefrialdad);

        int cantidad5 = db2.update(DbHelper.TABLE_VOLUNTAD, registro5, "idvo= "+idEscogido, null);

        //actualizar percecpción
        int updateper = Integer.parseInt(percepcion.getSelectedItem().toString());
        int updatealerta = metodoConversorHabilidad(alerta.getSelectedItem().toString());
        int updateConsciencia = metodoConversorHabilidad(consciencia.getSelectedItem().toString());
        int updateEmpatia = metodoConversorHabilidad(empatia.getSelectedItem().toString());
        int updateiniciativa = metodoConversorHabilidad(iniciativa.getSelectedItem().toString());
        int updateInvestigacion = metodoConversorHabilidad(investigacion.getSelectedItem().toString());

        ContentValues registro6 = new ContentValues();
        registro6.put("percepcion", updateper);
        registro6.put("alerta", updatealerta);
        registro6.put("consciencia", updateConsciencia);
        registro6.put("empatia", updateEmpatia);
        registro6.put("iniciativa", updateiniciativa);
        registro6.put("investigacion", updateInvestigacion);

        int cantidad6 = db2.update(DbHelper.TABLE_PERCEPCION, registro6, "idpe= "+idEscogido, null);

        //actualizar inteligencia
        int updateinte = Integer.parseInt(inteligencia.getSelectedItem().toString());
        int updateAdivina = metodoConversorHabilidad(adivinacion.getSelectedItem().toString());
        int updatearcanismo = metodoConversorHabilidad(arcanismo.getSelectedItem().toString());
        int updateCallejeo = metodoConversorHabilidad(callejeo.getSelectedItem().toString());
        int updateculturaMagia = metodoConversorHabilidad(culturaM.getSelectedItem().toString());
        int updateculturaMuggle = metodoConversorHabilidad(culturaMu.getSelectedItem().toString());
        int updateHerbologia = metodoConversorHabilidad(herbologia.getSelectedItem().toString());
        int updateMagZoo = metodoConversorHabilidad(magizoologia.getSelectedItem().toString());
        int updateMedicina = metodoConversorHabilidad(medicina.getSelectedItem().toString());
        int updatePolitica = metodoConversorHabilidad(politica.getSelectedItem().toString());
        int updateSupervivencia = metodoConversorHabilidad(supervivencia.getSelectedItem().toString());

        ContentValues registro7 = new ContentValues();
        registro7.put("inteligencia", updateinte);
        registro7.put("adivinacion", updateAdivina);
        registro7.put("arcanismo", updatearcanismo);
        registro7.put("callejeo", updateCallejeo);
        registro7.put("culturaMagia", updateculturaMagia);
        registro7.put("culturaMuggle", updateculturaMuggle);
        registro7.put("herbologia", updateHerbologia);
        registro7.put("magizoologia", updateMagZoo);
        registro7.put("medicina", updateMedicina);
        registro7.put("politica", updatePolitica);
        registro7.put("supervivencia", updateSupervivencia);

        int cantidad7 = db2.update(DbHelper.TABLE_INTELIGENCIA, registro7, "idi= "+idEscogido, null);

        //actualizar etapa
        String updateetapa = etapa.getSelectedItem().toString();
        ContentValues registro8 = new ContentValues();
        registro8.put("etapa", updateetapa);
        int cantidad8 = db2.update(DbHelper.TABLE_PJ, registro8, "idpj= "+idEscogido, null);

        db2.close();

        if ( cantidad==1 && cantidad2 == 1 && cantidad3 == 1 && cantidad4 == 1 && cantidad5 == 1 && cantidad6 == 1 && cantidad7 == 1 && cantidad8 == 1){
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

    public int reversoHabilidad (int datoTabla) {
        if (datoTabla == 0) {
            return 0;
        }else if (datoTabla == 1) {
            return 1;
        } else if (datoTabla == 2){
            return 2;
        } else if (datoTabla == 4){
            return 3;
        } else if (datoTabla == 7){
            return 4;
        } else{
            return -1;
        }
    }

    public int reversoEtapa (String datoTabla) {
        if (datoTabla.equals("Infante")) {
            return 1;
        } else if (datoTabla.equals("Adolescente")) {
            return 2;
        } else if (datoTabla.equals("Joven")){
            return 3;
        } else if (datoTabla.equals("Adulto")){
            return 4;
        } else if (datoTabla.equals("Experimentado")) {
            return 5;
        } else if (datoTabla.equals("Veterano")){
            return 6;
        } else if (datoTabla==null){
            return 0;
        } else {
            return -1;
        }
    }

}