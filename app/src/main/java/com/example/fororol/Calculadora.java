package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.fororol.modelo.Carisma;
import com.example.fororol.modelo.Destreza;
import com.example.fororol.modelo.Inteligencia;
import com.example.fororol.modelo.Percepcion;
import com.example.fororol.modelo.Pj;
import com.example.fororol.modelo.Poder;
import com.example.fororol.modelo.Vigor;
import com.example.fororol.modelo.Voluntad;

import java.util.ArrayList;

public class Calculadora extends AppCompatActivity {
    private ArrayList<Vigor> arrayDVigor= new ArrayList<>();
    private ArrayList<Destreza> arrayDDestreza= new ArrayList<>();
    private ArrayList<Carisma> arrayDCarisma= new ArrayList<>();
    private ArrayList<Poder> arrayDPoder= new ArrayList<>();
    private ArrayList<Voluntad> arrayDVoluntad= new ArrayList<>();
    private ArrayList<Inteligencia> arrayDInteligencia= new ArrayList<>();
    private ArrayList<Percepcion> arrayDPercepcion= new ArrayList<>();
    private Spinner vigor, poder, destreza, carisma, voluntad, percepcion, inteligencia;
    private Spinner atletismo, pelea, esquivar, latrocinio, sigilo, volar, coordinacion, intimidacion, oratoria, seducir,
            subterfugio, duelo, pociones, rituales, arte, estilo, frialdad, alerta, consciencia, empatia, iniciativa, investigacion,
            adivinacion, arcanismo, callejeo, culturaM, culturaMu, herbologia, magizoologia, medicina, politica, supervivencia;
    private boolean carismaC = false, destrezaC = false, vigorC = false, inteligenciaC = false, percepcionC = false, poderC = false,
            voluntadC = false;
    private boolean carismaCD = false, destrezaCD = false, vigorCD = false, inteligenciaCD = false, percepcionCD = false, poderCD = false,
            voluntadCD = false;
    private Button bcalcular, bguardar;
    private TextView resultado;
    private Build build;
    private Dados dados;
    private int total;
    private int posicion;


    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vigor = findViewById(R.id.vigord);
        poder = findViewById(R.id.poder);
        atletismo =findViewById(R.id.atletismod);
        destreza = findViewById(R.id.destreza);
        carisma = findViewById(R.id.carisma);
        voluntad = findViewById(R.id.voluntad);
        percepcion = findViewById(R.id.percepcion);
        inteligencia =  findViewById(R.id.inteligencia);
        pelea = findViewById(R.id.pelead);
        esquivar = findViewById(R.id.esquivar);
        latrocinio =  findViewById(R.id.latrocinio);
        sigilo = findViewById(R.id.sigilo);
        volar =  findViewById(R.id.volar);
        coordinacion =  findViewById(R.id.coordinacion);
        intimidacion =  findViewById(R.id.intimidacion);
        oratoria =  findViewById(R.id.oratoria);
        seducir = findViewById(R.id.seducir);
        subterfugio = findViewById(R.id.subterfugio);
        duelo = findViewById(R.id.duelo);
        pociones = findViewById(R.id.pociones);
        rituales = findViewById(R.id.rituales);
        arte = findViewById(R.id.arte);
        estilo = findViewById(R.id.estilo);
        frialdad = findViewById(R.id.frialdad);
        alerta = findViewById(R.id.alerta);
        consciencia = findViewById(R.id.consciencia);
        empatia = findViewById(R.id.empatia);
        iniciativa = findViewById(R.id.iniciativa);
        investigacion = findViewById(R.id.investigacion);
        adivinacion = findViewById(R.id.adivinacion);
        arcanismo =findViewById(R.id.arcanismo);
        callejeo = findViewById(R.id.callejeo);
        culturaM = findViewById(R.id.culturaMag);
        culturaMu = findViewById(R.id.culturaMug);
        herbologia = findViewById(R.id.herbologia);
        magizoologia = findViewById(R.id.magizoologia);
        medicina = findViewById(R.id.medicina);
        politica = findViewById(R.id.politica);
        supervivencia = findViewById(R.id.supervivencia);
        bcalcular = findViewById(R.id.bcalcular);
        bguardar = findViewById(R.id.bguardar);
        resultado = findViewById(R.id.resultado);

        //poner los datos de las tablas deseos
        DbHelper dbHelper = new DbHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_VIGORD+"' WHERE idvd= '"+build.idEscogido+"' ", null);
        if (fila.moveToFirst()) {
            vigor.setSelection(fila.getInt(1));
            atletismo.setSelection(reversoHabilidadD(fila.getInt(2)));
            pelea.setSelection(reversoHabilidadD(fila.getInt(3)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_DEXD+"' WHERE iddd= '" +build.idEscogido+ "' ", null);
        if (fila.moveToFirst()) {
            destreza.setSelection(fila.getInt(1));
            esquivar.setSelection(reversoHabilidadD(fila.getInt(2)));
            latrocinio.setSelection(reversoHabilidadD(fila.getInt(3)));
            sigilo.setSelection(reversoHabilidadD(fila.getInt(4)));
            volar.setSelection(reversoHabilidadD(fila.getInt(5)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_CARISMAD+"' WHERE idcd= '" +build.idEscogido+ "' ", null);
        if (fila.moveToFirst()) {
            carisma.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            coordinacion.setSelection(reversoHabilidadD(fila.getInt(2)));
            intimidacion.setSelection(reversoHabilidadD(fila.getInt(3)));
            oratoria.setSelection(reversoHabilidadD(fila.getInt(4)));
           seducir.setSelection(reversoHabilidadD(fila.getInt(5)));
            subterfugio.setSelection(reversoHabilidadD(fila.getInt(6)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_PODERD+"' WHERE idpd= '" + build.idEscogido+"' ", null);
        if (fila.moveToFirst()) {
            poder.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
           duelo.setSelection(reversoHabilidadD(fila.getInt(2)));
           pociones.setSelection(reversoHabilidadD(fila.getInt(3)));
            rituales.setSelection(reversoHabilidadD(fila.getInt(4)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_VOLUNTADD+"' WHERE idvod= ' "+build.idEscogido+" '", null);
        if (fila.moveToFirst()) {
            voluntad.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
          arte.setSelection(reversoHabilidadD(fila.getInt(2)));
            estilo.setSelection(reversoHabilidadD(fila.getInt(3)));
          frialdad.setSelection(reversoHabilidadD(fila.getInt(4)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_PERCEPCIOND+"' WHERE idped= ' "+build.idEscogido+" '", null);
        if (fila.moveToFirst()) {
            percepcion.setSelection(fila.getInt(1)); //la posición coincide con el dato de tabla
            alerta.setSelection(reversoHabilidadD(fila.getInt(2)));
            consciencia.setSelection(reversoHabilidadD(fila.getInt(3)));
            empatia.setSelection(reversoHabilidadD(fila.getInt(4)));
            iniciativa.setSelection(reversoHabilidadD(fila.getInt(5)));
            investigacion.setSelection(reversoHabilidadD(fila.getInt(6)));
        }
        fila = db.rawQuery("SELECT * FROM '"+DbHelper.TABLE_INTELIGENCIAD+"' WHERE idid= '"+ build.idEscogido+" '", null);
        if (fila.moveToFirst()) {
            inteligencia.setSelection(fila.getInt(1));
          adivinacion.setSelection(reversoHabilidadD(fila.getInt(2)));
            arcanismo.setSelection(reversoHabilidadD(fila.getInt(3)));
            callejeo.setSelection(reversoHabilidadD(fila.getInt(4)));
            culturaM.setSelection(reversoHabilidadD(fila.getInt(5)));
            culturaMu.setSelection(reversoHabilidadD(fila.getInt(6)));
            herbologia.setSelection(reversoHabilidadD(fila.getInt(7)));
            magizoologia.setSelection(reversoHabilidadD(fila.getInt(8)));
            medicina.setSelection(reversoHabilidadD(fila.getInt(9)));
            politica.setSelection(reversoHabilidadD(fila.getInt(10)));
            supervivencia.setSelection(reversoHabilidadD(fila.getInt(11)));
        }

        db.close();

        //rellenar
        rellenarArrays();

        bguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM "+DbHelper.TABLE_VIGORD+ " WHERE idvd= "+build.idEscogido, null);
                if (cursor.moveToNext()) {
                    update();
                } else {
                    insert();
                }
                db.close();
            }
        });

        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            for (int i = 0; i < MainActivity.pjs.size(); i++) {
                if (MainActivity.pjs.get(i).getIdPj() == build.idEscogido) {
                    posicion = i;
                }
            }
            calcularVigor();
            calcularDestreza();
            calcularInteligencia();
            calcularPercepcion();
            calcularCarisma();
            calcularVoluntad();
            calcularPoder();
            resultado.setText("" + total);
            }
        });


    }

    private void calcularPoder() {
        if (Dados.arrayPoder.get(posicion).getPoder() < arrayDPoder.get(posicion).getPoder()) {
            if (Dados.arrayPoder.get(posicion).getPoder() == 0) {
                if (arrayDPoder.get(posicion).getPoder() == 1) {
                    total = total + 250;
                } else if (arrayDPoder.get(posicion).getPoder() == 2) {
                    total = total + 550;
                } else if (arrayDPoder.get(posicion).getPoder() == 3) {
                    total = total + 950;
                } else if (arrayDPoder.get(posicion).getPoder() == 4) {
                    total = total + 1500;
                } else if (arrayDPoder.get(posicion).getPoder() == 5) {
                    total = total + 2250;
                } else if (arrayDPoder.get(posicion).getPoder() == 6) {
                    total = total + 3250;
                } else if (arrayDPoder.get(posicion).getPoder() == 7) {
                    total = total + 4550;
                }
            } else if (Dados.arrayPoder.get(posicion).getPoder() == 1) {
                if (arrayDPoder.get(posicion).getPoder() == 2) {
                    total = total + 300;
                } else if (arrayDPoder.get(posicion).getPoder() == 3) {
                    total = total + 700;
                } else if (arrayDPoder.get(posicion).getPoder() == 4) {
                    total = total + 1250;
                } else if (arrayDPoder.get(posicion).getPoder() == 5) {
                    total = total + 2000;
                } else if (arrayDPoder.get(posicion).getPoder() == 6) {
                    total = total + 3000;
                } else if (arrayDPoder.get(posicion).getPoder() == 7) {
                    total = total + 4300;
                }
            } else if (Dados.arrayPoder.get(posicion).getPoder() == 2) {
                if (arrayDPoder.get(posicion).getPoder() == 3) {
                    total = total + 400;
                } else if (arrayDPoder.get(posicion).getPoder() == 4) {
                    total = total + 950;
                } else if (arrayDPoder.get(posicion).getPoder() == 5) {
                    total = total + 1700;
                } else if (arrayDPoder.get(posicion).getPoder() == 6) {
                    total = total + 2700;
                } else if (arrayDPoder.get(posicion).getPoder() == 7) {
                    total = total + 4000;
                }
            } else if (Dados.arrayPoder.get(posicion).getPoder() == 3) {
                if (arrayDPoder.get(posicion).getPoder() == 4) {
                    total = total + 550;
                } else if (arrayDPoder.get(posicion).getPoder() == 5) {
                    total = total + 1300;
                } else if (arrayDPoder.get(posicion).getPoder() == 6) {
                    total = total + 2300;
                } else if (arrayDPoder.get(posicion).getPoder() == 7) {
                    total = total + 3600;
                }
            } else if (Dados.arrayPoder.get(posicion).getPoder() == 4) {
                if (arrayDPoder.get(posicion).getPoder() == 5) {
                    total = total + 750;
                } else if (arrayDPoder.get(posicion).getPoder() == 6) {
                    total = total + 1750;
                } else if (arrayDPoder.get(posicion).getPoder() == 7) {
                    total = total + 3050;
                }
            } else if (Dados.arrayPoder.get(posicion).getPoder() == 5) {
                if (arrayDPoder.get(posicion).getPoder() == 6) {
                    total = total + 1000;
                } else if (arrayDPoder.get(posicion).getPoder() == 7) {
                    total = total + 2300;
                }
            } else if (Dados.arrayPoder.get(posicion).getPoder() == 6) {
                if (arrayDPoder.get(posicion).getPoder() == 7) {
                    total = total + 1600;
                }
            }
        }

        if (Dados.arrayPoder.get(posicion).getDuelo() < arrayDPoder.get(posicion).getDuelo()) {
            if (Dados.arrayPoder.get(posicion).getDuelo() == 0) {
                if (arrayDPoder.get(posicion).getDuelo() == 1) {
                    total = total + 75;
                } else if (arrayDPoder.get(posicion).getDuelo() == 2) {
                    total = total + 225;
                } else if (arrayDPoder.get(posicion).getDuelo() == 4) {
                    total = total + 475;
                } else if (arrayDPoder.get(posicion).getDuelo() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPoder.get(posicion).getDuelo() == 1) {
                if (arrayDPoder.get(posicion).getDuelo() == 2) {
                    total = total + 150;
                } else if (arrayDPoder.get(posicion).getDuelo() == 4) {
                    total = total + 400;
                } else if (arrayDPoder.get(posicion).getDuelo() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPoder.get(posicion).getDuelo() == 2) {
                if (arrayDPoder.get(posicion).getDuelo() == 4) {
                    total = total + 250;
                } else if (arrayDPoder.get(posicion).getDuelo() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPoder.get(posicion).getDuelo() == 4) {
                if (arrayDPoder.get(posicion).getDuelo() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayPoder.get(posicion).getPociones() < arrayDPoder.get(posicion).getPociones()) {
            if (Dados.arrayPoder.get(posicion).getPociones() == 0) {
                if (arrayDPoder.get(posicion).getPociones() == 1) {
                    total = total + 75;
                } else if (arrayDPoder.get(posicion).getPociones() == 2) {
                    total = total + 225;
                } else if (arrayDPoder.get(posicion).getPociones() == 4) {
                    total = total + 475;
                } else if (arrayDPoder.get(posicion).getPociones() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPoder.get(posicion).getPociones() == 1) {
                if (arrayDPoder.get(posicion).getPociones() == 2) {
                    total = total + 150;
                } else if (arrayDPoder.get(posicion).getPociones() == 4) {
                    total = total + 400;
                } else if (arrayDPoder.get(posicion).getPociones() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPoder.get(posicion).getPociones() == 2) {
                if (arrayDPoder.get(posicion).getPociones() == 4) {
                    total = total + 250;
                } else if (arrayDPoder.get(posicion).getPociones() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPoder.get(posicion).getPociones() == 4) {
                if (arrayDPoder.get(posicion).getPociones() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayPoder.get(posicion).getRituales() > arrayDPoder.get(posicion).getRituales()) {
            if (Dados.arrayPoder.get(posicion).getRituales() == 0) {
                if (arrayDPoder.get(posicion).getRituales() == 1) {
                    total = total + 75;
                } else if (arrayDPoder.get(posicion).getRituales() == 2) {
                    total = total + 225;
                } else if (arrayDPoder.get(posicion).getRituales() == 4) {
                    total = total + 475;
                } else if (arrayDPoder.get(posicion).getRituales() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPoder.get(posicion).getRituales() == 1) {
                if (arrayDPoder.get(posicion).getRituales() == 2) {
                    total = total + 150;
                } else if (arrayDPoder.get(posicion).getRituales() == 4) {
                    total = total + 400;
                } else if (arrayDPoder.get(posicion).getRituales() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPoder.get(posicion).getRituales() == 2) {
                if (arrayDPoder.get(posicion).getRituales() == 4) {
                    total = total + 250;
                } else if (arrayDPoder.get(posicion).getRituales() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPoder.get(posicion).getRituales() == 4) {
                if (arrayDPoder.get(posicion).getRituales() == 7) {
                    total = total + 400;
                }
            }
        }
    }

    private void calcularVoluntad() {
        if (Dados.arrayVoluntad.get(posicion).getVoluntad() < arrayDVoluntad.get(posicion).getVoluntad()) {
            if (Dados.arrayVoluntad.get(posicion).getVoluntad() == 0) {
                if (arrayDVoluntad.get(posicion).getVoluntad() == 1) {
                    total = total + 250;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 2) {
                    total = total + 550;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 3) {
                    total = total + 950;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 4) {
                    total = total + 1500;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 5) {
                    total = total + 2250;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 6) {
                    total = total + 3250;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 7) {
                    total = total + 4550;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getVoluntad() == 1) {
                if (arrayDVigor.get(posicion).getVigor() == 2) {
                    total = total + 300;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 3) {
                    total = total + 700;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 4) {
                    total = total + 1250;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 5) {
                    total = total + 2000;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 6) {
                    total = total + 3000;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 7) {
                    total = total + 4300;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getVoluntad() == 2) {
                if (arrayDVoluntad.get(posicion).getVoluntad() == 3) {
                    total = total + 400;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 4) {
                    total = total + 950;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 5) {
                    total = total + 1700;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 6) {
                    total = total + 2700;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 7) {
                    total = total + 4000;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getVoluntad() == 3) {
                if (arrayDVoluntad.get(posicion).getVoluntad() == 4) {
                    total = total + 550;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 5) {
                    total = total + 1300;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 6) {
                    total = total + 2300;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 7) {
                    total = total + 3600;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getVoluntad() == 4) {
                if (arrayDVoluntad.get(posicion).getVoluntad() == 5) {
                    total = total + 750;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 6) {
                    total = total + 1750;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 7) {
                    total = total + 3050;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getVoluntad() == 5) {
                if (arrayDVoluntad.get(posicion).getVoluntad() == 6) {
                    total = total + 1000;
                } else if (arrayDVoluntad.get(posicion).getVoluntad() == 7) {
                    total = total + 2300;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getVoluntad() == 6) {
                if (arrayDVoluntad.get(posicion).getVoluntad() == 7) {
                    total = total + 1600;
                }
            }
        }

        if (Dados.arrayVoluntad.get(posicion).getArte() < arrayDVoluntad.get(posicion).getArte()) {
            if (Dados.arrayVoluntad.get(posicion).getArte() == 0) {
                if (arrayDVoluntad.get(posicion).getArte() == 1) {
                    total = total + 75;
                } else if (arrayDVoluntad.get(posicion).getArte() == 2) {
                    total = total + 225;
                } else if (arrayDVoluntad.get(posicion).getArte() == 4) {
                    total = total + 475;
                } else if (arrayDVoluntad.get(posicion).getArte() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getArte() == 1) {
                if (arrayDVoluntad.get(posicion).getArte() == 2) {
                    total = total + 150;
                } else if (arrayDVoluntad.get(posicion).getArte() == 4) {
                    total = total + 400;
                } else if (arrayDVoluntad.get(posicion).getArte() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getArte() == 2) {
                if (arrayDVoluntad.get(posicion).getArte() == 4) {
                    total = total + 250;
                } else if (arrayDVoluntad.get(posicion).getArte() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getArte() == 4) {
                if (arrayDVoluntad.get(posicion).getArte() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayVoluntad.get(posicion).getEstilo() < arrayDVoluntad.get(posicion).getEstilo()) {
            if (Dados.arrayVoluntad.get(posicion).getEstilo() == 0) {
                if (arrayDVoluntad.get(posicion).getEstilo() == 1) {
                    total = total + 75;
                } else if (arrayDVoluntad.get(posicion).getEstilo() == 2) {
                    total = total + 225;
                } else if (arrayDVoluntad.get(posicion).getEstilo() == 4) {
                    total = total + 475;
                } else if (arrayDVoluntad.get(posicion).getEstilo() == 7) {
                    total = total + 875;
                }
            }  else if (Dados.arrayVoluntad.get(posicion).getEstilo() == 1) {
                if (arrayDVoluntad.get(posicion).getEstilo() == 2) {
                    total = total + 150;
                } else if (arrayDVoluntad.get(posicion).getEstilo() == 4) {
                    total = total + 400;
                } else if (arrayDVoluntad.get(posicion).getEstilo() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getEstilo() == 2) {
                if (arrayDVoluntad.get(posicion).getEstilo() == 4) {
                    total = total + 250;
                } else if (arrayDVoluntad.get(posicion).getEstilo() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getEstilo() == 4) {
                if (arrayDVoluntad.get(posicion).getEstilo() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayVoluntad.get(posicion).getFrialdad() < arrayDVoluntad.get(posicion).getFrialdad()) {
            if (Dados.arrayVoluntad.get(posicion).getFrialdad() == 0) {
                if (arrayDVoluntad.get(posicion).getFrialdad() == 1) {
                    total = total + 75;
                } else if (arrayDVoluntad.get(posicion).getFrialdad() == 2) {
                    total = total + 225;
                } else if (arrayDVoluntad.get(posicion).getFrialdad() == 4) {
                    total = total + 475;
                } else if (arrayDVoluntad.get(posicion).getFrialdad() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getFrialdad() == 1) {
                if (arrayDVoluntad.get(posicion).getFrialdad() == 2) {
                    total = total + 150;
                } else if (arrayDVoluntad.get(posicion).getFrialdad() == 4) {
                    total = total + 400;
                } else if (arrayDVoluntad.get(posicion).getFrialdad() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getFrialdad() == 2) {
                if (arrayDVoluntad.get(posicion).getFrialdad() == 4) {
                    total = total + 250;
                } else if (arrayDVoluntad.get(posicion).getFrialdad() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayVoluntad.get(posicion).getFrialdad() == 4) {
                if (arrayDVoluntad.get(posicion).getFrialdad() == 7) {
                    total = total + 400;
                }
            }
        }

    }

    private void calcularCarisma() {
        if (Dados.arrayCarisma.get(posicion).getCarisma() < arrayDCarisma.get(posicion).getCarisma()) {
            if (Dados.arrayCarisma.get(posicion).getCarisma() == 0) {
                if (arrayDCarisma.get(posicion).getCarisma() == 1) {
                    total = total + 250;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 2) {
                    total = total + 550;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 3) {
                    total = total + 950;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 4) {
                    total = total + 1500;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 5) {
                    total = total + 2250;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 6) {
                    total = total + 3250;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 7) {
                    total = total + 4550;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCarisma() == 1) {
                if (arrayDCarisma.get(posicion).getCarisma() == 2) {
                    total = total + 300;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 3) {
                    total = total + 700;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 4) {
                    total = total + 1250;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 5) {
                    total = total + 2000;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 6) {
                    total = total + 3000;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 7) {
                    total = total + 4300;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCarisma() == 2) {
                if (arrayDCarisma.get(posicion).getCarisma() == 3) {
                    total = total + 400;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 4) {
                    total = total + 950;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 5) {
                    total = total + 1700;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 6) {
                    total = total + 2700;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 7) {
                    total = total + 4000;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCarisma() == 3) {
                if (arrayDCarisma.get(posicion).getCarisma() == 4) {
                    total = total + 550;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 5) {
                    total = total + 1300;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 6) {
                    total = total + 2300;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 7) {
                    total = total + 3600;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCarisma() == 4) {
                if (arrayDCarisma.get(posicion).getCarisma() == 5) {
                    total = total + 750;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 6) {
                    total = total + 1750;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 7) {
                    total = total + 3050;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCarisma() == 5) {
                if (arrayDCarisma.get(posicion).getCarisma() == 6) {
                    total = total + 1000;
                } else if (arrayDCarisma.get(posicion).getCarisma() == 7) {
                    total = total + 2300;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCarisma() == 6) {
                if (arrayDCarisma.get(posicion).getCarisma() == 7) {
                    total = total + 1600;
                }
            }
        }

        if (Dados.arrayCarisma.get(posicion).getCoordinacion() < arrayDCarisma.get(posicion).getCoordinacion()) {
            if (Dados.arrayCarisma.get(posicion).getCoordinacion() == 0) {
                if (arrayDCarisma.get(posicion).getCoordinacion() == 1) {
                    total = total + 75;
                } else if (arrayDCarisma.get(posicion).getCoordinacion() == 2) {
                    total = total + 225;
                } else if (arrayDCarisma.get(posicion).getCoordinacion() == 4) {
                    total = total + 475;
                } else if (arrayDCarisma.get(posicion).getCoordinacion() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCoordinacion() == 1) {
                if (arrayDCarisma.get(posicion).getCoordinacion() == 2) {
                    total = total + 150;
                } else if (arrayDCarisma.get(posicion).getCoordinacion() == 4) {
                    total = total + 400;
                } else if (arrayDCarisma.get(posicion).getCoordinacion() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCoordinacion() == 2) {
                if (arrayDCarisma.get(posicion).getCoordinacion() == 4) {
                    total = total + 550;
                } else if (arrayDCarisma.get(posicion).getCoordinacion() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayCarisma.get(posicion).getCoordinacion() == 4) {
                if (arrayDCarisma.get(posicion).getCoordinacion() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayCarisma.get(posicion).getIntimidacion() < arrayDCarisma.get(posicion).getIntimidacion()) {
            if (Dados.arrayCarisma.get(posicion).getIntimidacion() == 0) {
                if (arrayDCarisma.get(posicion).getIntimidacion() == 1) {
                    total = total + 75;
                } else if (arrayDCarisma.get(posicion).getIntimidacion() == 2) {
                    total = total + 225;
                } else if (arrayDCarisma.get(posicion).getIntimidacion() == 4) {
                    total = total + 475;
                } else if (arrayDCarisma.get(posicion).getIntimidacion() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayCarisma.get(posicion).getIntimidacion() == 1) {
                if (arrayDCarisma.get(posicion).getIntimidacion() == 2) {
                    total = total + 150;
                } else if (arrayDCarisma.get(posicion).getIntimidacion() == 4) {
                    total = total + 400;
                } else if (arrayDCarisma.get(posicion).getIntimidacion() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayCarisma.get(posicion).getIntimidacion() == 2) {
                if (arrayDCarisma.get(posicion).getIntimidacion() == 4) {
                    total = total + 550;
                } else if (arrayDCarisma.get(posicion).getIntimidacion() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayCarisma.get(posicion).getIntimidacion() == 4) {
                if (arrayDCarisma.get(posicion).getIntimidacion() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayCarisma.get(posicion).getOratoria() < arrayDCarisma.get(posicion).getOratoria()) {
            if (Dados.arrayCarisma.get(posicion).getOratoria() == 0) {
                if (arrayDCarisma.get(posicion).getOratoria() == 1) {
                    total = total + 75;
                } else if (arrayDCarisma.get(posicion).getOratoria() == 2) {
                    total = total + 225;
                } else if (arrayDCarisma.get(posicion).getOratoria() == 4) {
                    total = total + 475;
                } else if (arrayDCarisma.get(posicion).getOratoria() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayCarisma.get(posicion).getOratoria() == 1) {
                if (arrayDCarisma.get(posicion).getOratoria() == 2) {
                    total = total + 150;
                } else if (arrayDCarisma.get(posicion).getOratoria() == 4) {
                    total = total + 400;
                } else if (arrayDCarisma.get(posicion).getOratoria() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayCarisma.get(posicion).getOratoria() == 2) {
                if (arrayDCarisma.get(posicion).getOratoria() == 4) {
                    total = total + 550;
                } else if (arrayDCarisma.get(posicion).getOratoria() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayCarisma.get(posicion).getOratoria() == 4) {
                if (arrayDCarisma.get(posicion).getOratoria() == 7) {
                    total = total + 400;
                }
            }
        }

        if ( Dados.arrayCarisma.get(posicion).getSeducir() < arrayDCarisma.get(posicion).getSeducir()){
            if (Dados.arrayCarisma.get(posicion).getSeducir() == 0) {
                if (arrayDCarisma.get(posicion).getSeducir() == 1) {
                    total = total + 75;
                } else if (arrayDCarisma.get(posicion).getSeducir() == 2) {
                    total = total + 225;
                } else if (arrayDCarisma.get(posicion).getSeducir() == 4) {
                    total = total + 475;
                } else if (arrayDCarisma.get(posicion).getSeducir() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayCarisma.get(posicion).getSeducir() == 1) {
                if (arrayDCarisma.get(posicion).getSeducir() == 2) {
                    total = total + 150;
                } else if (arrayDCarisma.get(posicion).getSeducir() == 4) {
                    total = total + 400;
                } else if (arrayDCarisma.get(posicion).getSeducir() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayCarisma.get(posicion).getSeducir() == 2) {
                if (arrayDCarisma.get(posicion).getSeducir() == 4) {
                    total = total + 550;
                } else if (arrayDCarisma.get(posicion).getSeducir() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayCarisma.get(posicion).getSeducir() == 4) {
                if (arrayDCarisma.get(posicion).getSeducir() == 7) {
                    total = total + 400;
                }
            }
        }

        if ( Dados.arrayCarisma.get(posicion).getSubterfugio() < arrayDCarisma.get(posicion).getSubterfugio()){
            if (Dados.arrayCarisma.get(posicion).getSubterfugio() == 0) {
                if (arrayDCarisma.get(posicion).getSubterfugio() == 1) {
                    total = total + 75;
                } else if (arrayDCarisma.get(posicion).getSubterfugio() == 2) {
                    total = total + 225;
                } else if (arrayDCarisma.get(posicion).getSubterfugio() == 4) {
                    total = total + 475;
                } else if (arrayDCarisma.get(posicion).getSubterfugio() == 7) {
                    total = total + 875;
                }
            }   else if (Dados.arrayCarisma.get(posicion).getSubterfugio() == 1) {
                if (arrayDCarisma.get(posicion).getSubterfugio() == 2) {
                    total = total + 150;
                } else if (arrayDCarisma.get(posicion).getSubterfugio() == 4) {
                    total = total + 400;
                } else if (arrayDCarisma.get(posicion).getSubterfugio() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayCarisma.get(posicion).getSubterfugio() == 2) {
                if (arrayDCarisma.get(posicion).getSubterfugio() == 4) {
                    total = total + 550;
                } else if (arrayDCarisma.get(posicion).getSubterfugio() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayCarisma.get(posicion).getSubterfugio() == 4) {
                if (arrayDCarisma.get(posicion).getSubterfugio() == 7) {
                    total = total + 400;
                }
            }
        }
    }

    private void calcularPercepcion() {
        if (Dados.arrayPercepcion.get(posicion).getPercepcion() < arrayDPercepcion.get(posicion).getPercepcion()) {
            if (Dados.arrayPercepcion.get(posicion).getPercepcion() == 0) {
                if (arrayDPercepcion.get(posicion).getPercepcion() == 1) {
                    total = total + 250;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 2) {
                    total = total + 550;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 3) {
                    total = total + 950;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 4) {
                    total = total + 1500;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 5) {
                    total = total + 2250;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 6) {
                    total = total + 3250;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 7) {
                    total = total + 4550;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getPercepcion() == 1) {
                if (arrayDPercepcion.get(posicion).getPercepcion() == 2) {
                    total = total + 300;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 3) {
                    total = total + 700;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 4) {
                    total = total + 1250;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 5) {
                    total = total + 2000;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 6) {
                    total = total + 3000;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 7) {
                    total = total + 4300;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getPercepcion() == 2) {
                if (arrayDPercepcion.get(posicion).getPercepcion() == 3) {
                    total = total + 400;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 4) {
                    total = total + 950;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 5) {
                    total = total + 1700;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 6) {
                    total = total + 2700;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 7) {
                    total = total + 4000;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getPercepcion() == 3) {
                if (arrayDPercepcion.get(posicion).getPercepcion() == 4) {
                    total = total + 550;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 5) {
                    total = total + 1300;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 6) {
                    total = total + 2300;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 7) {
                    total = total + 3600;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getPercepcion() == 4) {
                if (arrayDPercepcion.get(posicion).getPercepcion() == 5) {
                    total = total + 750;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 6) {
                    total = total + 1750;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 7) {
                    total = total + 3050;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getPercepcion() == 5) {
                if (arrayDPercepcion.get(posicion).getPercepcion() == 6) {
                    total = total + 1000;
                } else if (arrayDPercepcion.get(posicion).getPercepcion() == 7) {
                    total = total + 2300;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getPercepcion() == 6) {
                if (arrayDPercepcion.get(posicion).getPercepcion() == 7) {
                    total = total + 1600;
                }
            }
        }

        if (Dados.arrayPercepcion.get(posicion).getAlerta() < arrayDPercepcion.get(posicion).getAlerta()) {
            if (Dados.arrayPercepcion.get(posicion).getAlerta() == 0) {
                if (arrayDPercepcion.get(posicion).getAlerta() == 1) {
                    total = total + 75;
                } else if (arrayDPercepcion.get(posicion).getAlerta() == 2) {
                    total = total + 225;
                } else if (arrayDPercepcion.get(posicion).getAlerta() == 4) {
                    total = total + 475;
                } else if (arrayDPercepcion.get(posicion).getAlerta() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getAlerta() == 1) {
                if (arrayDPercepcion.get(posicion).getAlerta() == 2) {
                    total = total + 150;
                } else if (arrayDPercepcion.get(posicion).getAlerta() == 4) {
                    total = total + 400;
                } else if (arrayDPercepcion.get(posicion).getAlerta() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getAlerta() == 2) {
                if (arrayDPercepcion.get(posicion).getAlerta() == 4) {
                    total = total + 550;
                } else if (arrayDPercepcion.get(posicion).getAlerta() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getAlerta() == 4) {
                if (arrayDPercepcion.get(posicion).getAlerta() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayPercepcion.get(posicion).getConsciencia() > arrayDPercepcion.get(posicion).getConsciencia()) {
            if (Dados.arrayPercepcion.get(posicion).getConsciencia() == 0) {
                if (arrayDPercepcion.get(posicion).getConsciencia() == 1) {
                    total = total + 75;
                } else if (arrayDPercepcion.get(posicion).getConsciencia() == 2) {
                    total = total + 225;
                } else if (arrayDPercepcion.get(posicion).getConsciencia() == 4) {
                    total = total + 475;
                } else if (arrayDPercepcion.get(posicion).getConsciencia() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getConsciencia() == 1) {
                if (arrayDPercepcion.get(posicion).getConsciencia() == 2) {
                    total = total + 150;
                } else if (arrayDPercepcion.get(posicion).getConsciencia() == 4) {
                    total = total + 400;
                } else if (arrayDPercepcion.get(posicion).getConsciencia() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getConsciencia() == 2) {
                if (arrayDPercepcion.get(posicion).getConsciencia() == 4) {
                    total = total + 550;
                } else if (arrayDPercepcion.get(posicion).getConsciencia() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getConsciencia() == 4) {
                if (arrayDPercepcion.get(posicion).getConsciencia() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayPercepcion.get(posicion).getEmpatia() > arrayDPercepcion.get(posicion).getEmpatia()) {
            if (Dados.arrayPercepcion.get(posicion).getEmpatia() == 0) {
                if (arrayDPercepcion.get(posicion).getEmpatia() == 1) {
                    total = total + 75;
                } else if (arrayDPercepcion.get(posicion).getEmpatia() == 2) {
                    total = total + 225;
                } else if (arrayDPercepcion.get(posicion).getEmpatia() == 4) {
                    total = total + 475;
                } else if (arrayDPercepcion.get(posicion).getEmpatia() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getEmpatia() == 1) {
                if (arrayDPercepcion.get(posicion).getEmpatia() == 2) {
                    total = total + 150;
                } else if (arrayDPercepcion.get(posicion).getEmpatia() == 4) {
                    total = total + 400;
                } else if (arrayDPercepcion.get(posicion).getEmpatia() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getEmpatia() == 2) {
                if (arrayDPercepcion.get(posicion).getEmpatia() == 4) {
                    total = total + 550;
                } else if (arrayDPercepcion.get(posicion).getEmpatia() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getEmpatia() == 4) {
                if (arrayDPercepcion.get(posicion).getEmpatia() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayPercepcion.get(posicion).getIniciativa() > arrayDPercepcion.get(posicion).getIniciativa()) {
            if (Dados.arrayPercepcion.get(posicion).getIniciativa() == 0) {
                if (arrayDPercepcion.get(posicion).getIniciativa() == 1) {
                    total = total + 75;
                } else if (arrayDPercepcion.get(posicion).getIniciativa() == 2) {
                    total = total + 225;
                } else if (arrayDPercepcion.get(posicion).getIniciativa() == 4) {
                    total = total + 475;
                } else if (arrayDPercepcion.get(posicion).getIniciativa() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getIniciativa() == 1) {
                if (arrayDPercepcion.get(posicion).getIniciativa() == 2) {
                    total = total + 150;
                } else if (arrayDPercepcion.get(posicion).getIniciativa() == 4) {
                    total = total + 400;
                } else if (arrayDPercepcion.get(posicion).getIniciativa() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getIniciativa() == 2) {
                if (arrayDPercepcion.get(posicion).getIniciativa() == 4) {
                    total = total + 550;
                } else if (arrayDPercepcion.get(posicion).getIniciativa() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getIniciativa() == 4) {
                if (arrayDPercepcion.get(posicion).getIniciativa() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayPercepcion.get(posicion).getInvestigacion() > arrayDPercepcion.get(posicion).getInvestigacion()) {
            if (Dados.arrayPercepcion.get(posicion).getInvestigacion() == 0) {
                if (arrayDPercepcion.get(posicion).getInvestigacion() == 1) {
                    total = total + 75;
                } else if (arrayDPercepcion.get(posicion).getInvestigacion() == 2) {
                    total = total + 225;
                } else if (arrayDPercepcion.get(posicion).getInvestigacion() == 4) {
                    total = total + 475;
                } else if (arrayDPercepcion.get(posicion).getInvestigacion() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getInvestigacion() == 1) {
                if (arrayDPercepcion.get(posicion).getInvestigacion() == 2) {
                    total = total + 150;
                } else if (arrayDPercepcion.get(posicion).getInvestigacion() == 4) {
                    total = total + 400;
                } else if (arrayDPercepcion.get(posicion).getInvestigacion() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getInvestigacion() == 2) {
                if (arrayDPercepcion.get(posicion).getInvestigacion() == 4) {
                    total = total + 550;
                } else if (arrayDPercepcion.get(posicion).getInvestigacion() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayPercepcion.get(posicion).getInvestigacion() == 4) {
                if (arrayDPercepcion.get(posicion).getInvestigacion() == 7) {
                    total = total + 400;
                }
            }
        }
    }

    private void calcularInteligencia() {
        if (Dados.arrayInteligencia.get(posicion).getInteligencia() < arrayDInteligencia.get(posicion).getInteligencia()) {
            if (Dados.arrayInteligencia.get(posicion).getInteligencia() == 0) {
                if (arrayDInteligencia.get(posicion).getInteligencia() == 1) {
                    total = total + 250;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 2) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 3) {
                    total = total + 950;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 4) {
                    total = total + 1500;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 5) {
                    total = total + 2250;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 6) {
                    total = total + 3250;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 7) {
                    total = total + 4550;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getInteligencia() == 1) {
                if (arrayDInteligencia.get(posicion).getInteligencia() == 2) {
                    total = total + 300;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 3) {
                    total = total + 700;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 4) {
                    total = total + 1250;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 5) {
                    total = total + 2000;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 6) {
                    total = total + 3000;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 7) {
                    total = total + 4300;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getInteligencia() == 2) {
                if (arrayDInteligencia.get(posicion).getInteligencia() == 3) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 4) {
                    total = total + 950;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 5) {
                    total = total + 1700;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 6) {
                    total = total + 2700;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 7) {
                    total = total + 4000;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getInteligencia() == 3) {
                if (arrayDInteligencia.get(posicion).getInteligencia() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 5) {
                    total = total + 1300;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 6) {
                    total = total + 2300;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 7) {
                    total = total + 3600;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getInteligencia() == 4) {
                if (arrayDInteligencia.get(posicion).getInteligencia() == 5) {
                    total = total + 750;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 6) {
                    total = total + 1750;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 7) {
                    total = total + 3050;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getInteligencia() == 5) {
                if (arrayDInteligencia.get(posicion).getInteligencia() == 6) {
                    total = total + 1000;
                } else if (arrayDInteligencia.get(posicion).getInteligencia() == 7) {
                    total = total + 2300;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getInteligencia() == 6) {
                if (arrayDInteligencia.get(posicion).getInteligencia() == 7) {
                    total = total + 1600;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getAdivinacion() < arrayDInteligencia.get(posicion).getAdivinacion()) {
            if (Dados.arrayInteligencia.get(posicion).getAdivinacion() == 0) {
                if (arrayDInteligencia.get(posicion).getAdivinacion() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getAdivinacion() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getAdivinacion() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getAdivinacion() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getAdivinacion() == 1) {
                if (arrayDInteligencia.get(posicion).getAdivinacion() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getAdivinacion() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getAdivinacion() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getAdivinacion() == 2) {
                if (arrayDInteligencia.get(posicion).getAdivinacion() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getAdivinacion() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getAdivinacion() == 4) {
                if (arrayDInteligencia.get(posicion).getAdivinacion() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getArcanismo() < arrayDInteligencia.get(posicion).getArcanismo()) {
            if (Dados.arrayInteligencia.get(posicion).getArcanismo() == 0) {
                if (arrayDInteligencia.get(posicion).getArcanismo() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getArcanismo() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getArcanismo() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getArcanismo() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getArcanismo() == 1) {
                if (arrayDInteligencia.get(posicion).getArcanismo() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getArcanismo() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getArcanismo() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getArcanismo() == 2) {
                if (arrayDInteligencia.get(posicion).getArcanismo() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getArcanismo() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getArcanismo() == 4) {
                if (arrayDInteligencia.get(posicion).getArcanismo() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getCallejeo() < arrayDInteligencia.get(posicion).getCallejeo()) {
            if (Dados.arrayInteligencia.get(posicion).getCallejeo() == 0) {
                if (arrayDInteligencia.get(posicion).getCallejeo() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getCallejeo() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getCallejeo() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getCallejeo() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCallejeo() == 1) {
                if (arrayDInteligencia.get(posicion).getCallejeo() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getCallejeo() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getCallejeo() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCallejeo() == 2) {
                if (arrayDInteligencia.get(posicion).getCallejeo() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getCallejeo() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCallejeo() == 4) {
                if (arrayDInteligencia.get(posicion).getCallejeo() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getCulturaMagia() < arrayDInteligencia.get(posicion).getCulturaMagia()) {
            if (Dados.arrayInteligencia.get(posicion).getCulturaMagia() == 0) {
                if (arrayDInteligencia.get(posicion).getCulturaMagia() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getCulturaMagia() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getCulturaMagia() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getCulturaMagia() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCulturaMagia() == 1) {
                if (arrayDInteligencia.get(posicion).getCulturaMagia() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getCulturaMagia() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getCulturaMagia() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCulturaMagia() == 2) {
                if (arrayDInteligencia.get(posicion).getCulturaMagia() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getCulturaMagia() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCulturaMagia() == 4) {
                if (arrayDInteligencia.get(posicion).getCulturaMagia() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getCulturaMuggle() < arrayDInteligencia.get(posicion).getCulturaMuggle()) {
            if (Dados.arrayInteligencia.get(posicion).getCulturaMuggle() == 0) {
                if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 1) {
                    total = total + 75;
                }   else if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCulturaMuggle() == 1) {
                if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCulturaMuggle() == 2) {
                if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getCulturaMuggle() == 4) {
                if (arrayDInteligencia.get(posicion).getCulturaMuggle() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getHerbologia() > arrayDInteligencia.get(posicion).getHerbologia()) {
            if (Dados.arrayInteligencia.get(posicion).getHerbologia() == 0) {
                if (arrayDInteligencia.get(posicion).getHerbologia() == 1) {
                    total = total + 75;
                }  else if (arrayDInteligencia.get(posicion).getHerbologia() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getHerbologia() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getHerbologia() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getHerbologia() == 1) {
                if (arrayDInteligencia.get(posicion).getHerbologia() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getHerbologia() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getHerbologia() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getHerbologia() == 2) {
                if (arrayDInteligencia.get(posicion).getHerbologia() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getHerbologia() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getHerbologia() == 4) {
                if (arrayDInteligencia.get(posicion).getHerbologia() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getMagizoologia() > arrayDInteligencia.get(posicion).getMagizoologia()) {
            if (Dados.arrayInteligencia.get(posicion).getMagizoologia() == 0) {
                if (arrayDInteligencia.get(posicion).getMagizoologia() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getMagizoologia() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getMagizoologia() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getMagizoologia() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getMagizoologia() == 1) {
                if (arrayDInteligencia.get(posicion).getMagizoologia() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getMagizoologia() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getMagizoologia() == 7) {
                    total = total + 800;
                }
            }  else if (Dados.arrayInteligencia.get(posicion).getMagizoologia() == 2) {
                if (arrayDInteligencia.get(posicion).getMagizoologia() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getMagizoologia() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getMagizoologia() == 4) {
                if (arrayDInteligencia.get(posicion).getMagizoologia() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getMedicina() > arrayDInteligencia.get(posicion).getMedicina()) {
            if (Dados.arrayInteligencia.get(posicion).getMedicina() == 0) {
                if (arrayDInteligencia.get(posicion).getMedicina() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getMedicina() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getMedicina() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getMedicina() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getMedicina() == 1) {
                if (arrayDInteligencia.get(posicion).getMedicina() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getMedicina() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getMedicina() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getMedicina() == 2) {
                if (arrayDInteligencia.get(posicion).getMedicina() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getMedicina() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getMedicina() == 4) {
                if (arrayDInteligencia.get(posicion).getMedicina() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getPolitica() > arrayDInteligencia.get(posicion).getPolitica()) {
            if (Dados.arrayInteligencia.get(posicion).getPolitica() == 0) {
                if (arrayDInteligencia.get(posicion).getPolitica() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getPolitica() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getPolitica() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getPolitica() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getPolitica() == 1) {
                if (arrayDInteligencia.get(posicion).getPolitica() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getPolitica() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getPolitica() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getPolitica() == 2) {
                if (arrayDInteligencia.get(posicion).getPolitica() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getPolitica() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getPolitica() == 4) {
                if (arrayDInteligencia.get(posicion).getPolitica() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayInteligencia.get(posicion).getSupervivencia() > arrayDInteligencia.get(posicion).getSupervivencia()) {
            if (Dados.arrayInteligencia.get(posicion).getSupervivencia() == 0) {
                if (arrayDInteligencia.get(posicion).getSupervivencia() == 1) {
                    total = total + 75;
                } else if (arrayDInteligencia.get(posicion).getSupervivencia() == 2) {
                    total = total + 225;
                } else if (arrayDInteligencia.get(posicion).getSupervivencia() == 4) {
                    total = total + 475;
                } else if (arrayDInteligencia.get(posicion).getSupervivencia() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getSupervivencia() == 1) {
                if (arrayDInteligencia.get(posicion).getSupervivencia() == 2) {
                    total = total + 150;
                } else if (arrayDInteligencia.get(posicion).getSupervivencia() == 4) {
                    total = total + 400;
                } else if (arrayDInteligencia.get(posicion).getSupervivencia() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getSupervivencia() == 2) {
                if (arrayDInteligencia.get(posicion).getSupervivencia() == 4) {
                    total = total + 550;
                } else if (arrayDInteligencia.get(posicion).getSupervivencia() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayInteligencia.get(posicion).getSupervivencia() == 4) {
                if (arrayDInteligencia.get(posicion).getSupervivencia() == 7) {
                    total = total + 400;
                }
            }
        }
    }

    private void calcularDestreza() {
        if (Dados.arrayDestreza.get(posicion).getDestreza() < arrayDDestreza.get(posicion).getDestreza()) {
            if (Dados.arrayDestreza.get(posicion).getDestreza() == 0) {
                if (arrayDDestreza.get(posicion).getDestreza() == 1) {
                    total = total + 250;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 2) {
                    total = total + 550;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 3) {
                    total = total + 950;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 4) {
                    total = total + 1500;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 5) {
                    total = total + 2250;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 6) {
                    total = total + 3250;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 7) {
                    total = total + 4550;
                }
            } else if (Dados.arrayDestreza.get(posicion).getDestreza() == 1) {
                if (arrayDDestreza.get(posicion).getDestreza() == 2) {
                    total = total + 300;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 3) {
                    total = total + 700;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 4) {
                    total = total + 1250;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 5) {
                    total = total + 2000;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 6) {
                    total = total + 3000;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 7) {
                    total = total + 4300;
                }
            } else if (Dados.arrayDestreza.get(posicion).getDestreza() == 2) {
                if (arrayDDestreza.get(posicion).getDestreza() == 3) {
                    total = total + 400;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 4) {
                    total = total + 950;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 5) {
                    total = total + 1700;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 6) {
                    total = total + 2700;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 7) {
                    total = total + 4000;
                }
            } else if (Dados.arrayDestreza.get(posicion).getDestreza() == 3) {
                if (arrayDDestreza.get(posicion).getDestreza() == 4) {
                    total = total + 550;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 5) {
                    total = total + 1300;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 6) {
                    total = total + 2300;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 7) {
                    total = total + 3600;
                }
            } else if (Dados.arrayDestreza.get(posicion).getDestreza() == 4) {
                if (arrayDDestreza.get(posicion).getDestreza() == 5) {
                    total = total + 750;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 6) {
                    total = total + 1750;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 7) {
                    total = total + 3050;
                }
            } else if (Dados.arrayDestreza.get(posicion).getDestreza() == 5) {
                if (arrayDDestreza.get(posicion).getDestreza() == 6) {
                    total = total + 1000;
                } else if (arrayDDestreza.get(posicion).getDestreza() == 7) {
                    total = total + 2300;
                }
            } else if (Dados.arrayDestreza.get(posicion).getDestreza() == 6) {
                if (arrayDDestreza.get(posicion).getDestreza() == 7) {
                    total = total + 1600;
                }
            }
        }

        if (Dados.arrayDestreza.get(posicion).getEsquivar() < arrayDDestreza.get(posicion).getEsquivar()) {
            if (Dados.arrayDestreza.get(posicion).getEsquivar() == 0 ){
                if (arrayDDestreza.get(posicion).getEsquivar() == 1) {
                    total = total + 75;
                } else if (arrayDDestreza.get(posicion).getEsquivar() == 2) {
                    total = total + 225;
                } else if (arrayDDestreza.get(posicion).getEsquivar() == 4) {
                    total = total + 475;
                } else if (arrayDDestreza.get(posicion).getEsquivar() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayDestreza.get(posicion).getEsquivar() == 1) {
                if (arrayDDestreza.get(posicion).getEsquivar() == 2) {
                    total = total + 150;
                } else if (arrayDDestreza.get(posicion).getEsquivar() == 4) {
                    total = total + 400;
                } else if (arrayDDestreza.get(posicion).getEsquivar() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayDestreza.get(posicion).getEsquivar() == 2) {
                if (arrayDDestreza.get(posicion).getEsquivar() == 4) {
                    total = total + 550;
                } else if (arrayDDestreza.get(posicion).getEsquivar() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayDestreza.get(posicion).getEsquivar() == 4) {
                if (arrayDDestreza.get(posicion).getEsquivar() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayDestreza.get(posicion).getLatrocinio() > arrayDDestreza.get(posicion).getLatrocinio()) {
            if (Dados.arrayDestreza.get(posicion).getLatrocinio() == 0 ){
                if (arrayDDestreza.get(posicion).getLatrocinio() == 1) {
                    total = total + 75;
                } else if (arrayDDestreza.get(posicion).getLatrocinio() == 2) {
                    total = total + 225;
                } else if (arrayDDestreza.get(posicion).getLatrocinio() == 4) {
                    total = total + 475;
                } else if (arrayDDestreza.get(posicion).getLatrocinio() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayDestreza.get(posicion).getLatrocinio() == 1) {
                if (arrayDDestreza.get(posicion).getLatrocinio() == 2) {
                    total = total + 150;
                } else if (arrayDDestreza.get(posicion).getLatrocinio() == 4) {
                    total = total + 400;
                } else if (arrayDDestreza.get(posicion).getLatrocinio() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayDestreza.get(posicion).getLatrocinio() == 2) {
                if (arrayDDestreza.get(posicion).getLatrocinio() == 4) {
                    total = total + 550;
                } else if (arrayDDestreza.get(posicion).getLatrocinio() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayDestreza.get(posicion).getLatrocinio() == 4) {
                if (arrayDDestreza.get(posicion).getLatrocinio() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayDestreza.get(posicion).getSigilo() > arrayDDestreza.get(posicion).getSigilo()) {
            if (Dados.arrayDestreza.get(posicion).getSigilo() == 0 ){
                if (arrayDDestreza.get(posicion).getSigilo() == 1) {
                    total = total + 75;
                } else if (arrayDDestreza.get(posicion).getSigilo() == 2) {
                    total = total + 225;
                } else if (arrayDDestreza.get(posicion).getSigilo() == 4) {
                    total = total + 475;
                } else if (arrayDDestreza.get(posicion).getSigilo() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayDestreza.get(posicion).getSigilo() == 1) {
                if (arrayDDestreza.get(posicion).getSigilo() == 2) {
                    total = total + 150;
                } else if (arrayDDestreza.get(posicion).getSigilo() == 4) {
                    total = total + 400;
                } else if (arrayDDestreza.get(posicion).getSigilo() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayDestreza.get(posicion).getSigilo() == 2) {
                if (arrayDDestreza.get(posicion).getSigilo() == 4) {
                    total = total + 550;
                } else if (arrayDDestreza.get(posicion).getSigilo() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayDestreza.get(posicion).getSigilo() == 4) {
                if (arrayDDestreza.get(posicion).getSigilo() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayDestreza.get(posicion).getVolar() > arrayDDestreza.get(posicion).getVolar()) {
            if (Dados.arrayDestreza.get(posicion).getVolar() == 0 ){
                if (arrayDDestreza.get(posicion).getVolar() == 1) {
                    total = total + 75;
                } else if (arrayDDestreza.get(posicion).getVolar() == 2) {
                    total = total + 225;
                } else if (arrayDDestreza.get(posicion).getVolar() == 4) {
                    total = total + 475;
                } else if (arrayDDestreza.get(posicion).getVolar() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayDestreza.get(posicion).getVolar() == 1) {
                if (arrayDDestreza.get(posicion).getVolar() == 2) {
                    total = total + 150;
                } else if (arrayDDestreza.get(posicion).getVolar() == 4) {
                    total = total + 400;
                } else if (arrayDDestreza.get(posicion).getVolar() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayDestreza.get(posicion).getVolar() == 2) {
                if (arrayDDestreza.get(posicion).getVolar() == 4) {
                    total = total + 550;
                } else if (arrayDDestreza.get(posicion).getVolar() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayDestreza.get(posicion).getVolar() == 4) {
                if (arrayDDestreza.get(posicion).getVolar() == 7) {
                    total = total + 400;
                }
            }
        }
    }

    private void calcularVigor() {
        if (Dados.arrayVigor.get(posicion).getVigor() < arrayDVigor.get(posicion).getVigor()) {
            if (Dados.arrayVigor.get(posicion).getVigor() == 0) {
                if (arrayDVigor.get(posicion).getVigor() == 1) {
                    total = total + 250;
                } else if (arrayDVigor.get(posicion).getVigor() == 2) {
                    total = total + 550;
                } else if (arrayDVigor.get(posicion).getVigor() == 3) {
                    total = total + 950;
                } else if (arrayDVigor.get(posicion).getVigor() == 4) {
                    total = total + 1500;
                } else if (arrayDVigor.get(posicion).getVigor() == 5) {
                    total = total + 2250;
                } else if (arrayDVigor.get(posicion).getVigor() == 6) {
                    total = total + 3250;
                } else if (arrayDVigor.get(posicion).getVigor() == 7) {
                    total = total + 4550;
                }
            } else if (Dados.arrayVigor.get(posicion).getVigor() == 1) {
                if (arrayDVigor.get(posicion).getVigor() == 2) {
                    total = total + 300;
                } else if (arrayDVigor.get(posicion).getVigor() == 3) {
                    total = total + 700;
                } else if (arrayDVigor.get(posicion).getVigor() == 4) {
                    total = total + 1250;
                } else if (arrayDVigor.get(posicion).getVigor() == 5) {
                    total = total + 2000;
                } else if (arrayDVigor.get(posicion).getVigor() == 6) {
                    total = total + 3000;
                } else if (arrayDVigor.get(posicion).getVigor() == 7) {
                    total = total + 4300;
                }
            } else if (Dados.arrayVigor.get(posicion).getVigor() == 2) {
                if (arrayDVigor.get(posicion).getVigor() == 3) {
                    total = total + 400;
                } else if (arrayDVigor.get(posicion).getVigor() == 4) {
                    total = total + 950;
                } else if (arrayDVigor.get(posicion).getVigor() == 5) {
                    total = total + 1700;
                } else if (arrayDVigor.get(posicion).getVigor() == 6) {
                    total = total + 2700;
                } else if (arrayDVigor.get(posicion).getVigor() == 7) {
                    total = total + 4000;
                }
            } else if (Dados.arrayVigor.get(posicion).getVigor() == 3) {
                if (arrayDVigor.get(posicion).getVigor() == 4) {
                    total = total + 550;
                } else if (arrayDVigor.get(posicion).getVigor() == 5) {
                    total = total + 1300;
                } else if (arrayDVigor.get(posicion).getVigor() == 6) {
                    total = total + 2300;
                } else if (arrayDVigor.get(posicion).getVigor() == 7) {
                    total = total + 3600;
                }
            } else if (Dados.arrayVigor.get(posicion).getVigor() == 4) {
                if (arrayDVigor.get(posicion).getVigor() == 5) {
                    total = total + 750;
                } else if (arrayDVigor.get(posicion).getVigor() == 6) {
                    total = total + 1750;
                } else if (arrayDVigor.get(posicion).getVigor() == 7) {
                    total = total + 3050;
                }
            } else if (Dados.arrayVigor.get(posicion).getVigor() == 5) {
                if (arrayDVigor.get(posicion).getVigor() == 6) {
                    total = total + 1000;
                } else if (arrayDVigor.get(posicion).getVigor() == 7) {
                    total = total + 2300;
                }
            } else if (Dados.arrayVigor.get(posicion).getVigor() == 6) {
                if (arrayDVigor.get(posicion).getVigor() == 7) {
                    total = total + 1600;
                }
            }
        }

        if (Dados.arrayVigor.get(posicion).getAtletismo() < arrayDVigor.get(posicion).getAtletismo()) {
            if (Dados.arrayVigor.get(posicion).getAtletismo() == 0) {
                if (arrayDVigor.get(posicion).getAtletismo() == 1) {
                    total = total + 75;
                } else if (arrayDVigor.get(posicion).getAtletismo() == 2) {
                    total = total + 225;
                } else if (arrayDVigor.get(posicion).getAtletismo() == 4) {
                    total = total + 475;
                } else if (arrayDVigor.get(posicion).getAtletismo() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayVigor.get(posicion).getAtletismo() == 1) {
                if (arrayDVigor.get(posicion).getAtletismo() == 2) {
                    total = total + 150;
                } else if (arrayDVigor.get(posicion).getAtletismo() == 4) {
                    total = total + 400;
                } else if (arrayDVigor.get(posicion).getAtletismo() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayVigor.get(posicion).getAtletismo() == 2) {
                if (arrayDVigor.get(posicion).getAtletismo() == 4) {
                    total = total + 550;
                } else if (arrayDVigor.get(posicion).getAtletismo() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayVigor.get(posicion).getAtletismo() == 4) {
                if (arrayDVigor.get(posicion).getAtletismo() == 7) {
                    total = total + 400;
                }
            }
        }

        if (Dados.arrayVigor.get(posicion).getPelea() < arrayDVigor.get(posicion).getPelea()) {
            if (Dados.arrayVigor.get(posicion).getPelea() == 0) {
                if (arrayDVigor.get(posicion).getPelea() == 1) {
                    total = total + 75;
                } else if (arrayDVigor.get(posicion).getPelea() == 2) {
                    total = total + 225;
                } else if (arrayDVigor.get(posicion).getPelea() == 4) {
                    total = total + 475;
                } else if (arrayDVigor.get(posicion).getPelea() == 7) {
                    total = total + 875;
                }
            } else if (Dados.arrayVigor.get(posicion).getPelea() == 1) {
                if (arrayDVigor.get(posicion).getPelea() == 2) {
                    total = total + 150;
                } else if (arrayDVigor.get(posicion).getPelea() == 4) {
                    total = total + 400;
                } else if (arrayDVigor.get(posicion).getPelea() == 7) {
                    total = total + 800;
                }
            } else if (Dados.arrayVigor.get(posicion).getPelea() == 2) {
                if (arrayDVigor.get(posicion).getPelea() == 4) {
                    total = total + 550;
                } else if (arrayDVigor.get(posicion).getPelea() == 7) {
                    total = total + 650;
                }
            } else if (Dados.arrayVigor.get(posicion).getPelea() == 4) {
                if (arrayDVigor.get(posicion).getPelea() == 7) {
                    total = total + 400;
                }
            }
        }
    }

    private void rellenarArrays() {
        //actualizar pjs
        MainActivity.pjs.clear();
        DbHelper dbhelper = new DbHelper(Calculadora.this);
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
        Dados.arrayCarisma.clear();
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
                Dados.arrayCarisma.add(carismaObjeto);
            } while (cursor.moveToNext());
            carismaC = true;
        } else {
            Toast.makeText(this, "No hay carisma", Toast.LENGTH_LONG).show();
        }

        arrayDCarisma.clear();
        cursor = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_CARISMAD + "", null);
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
                arrayDCarisma.add(carismaObjeto);
            } while (cursor.moveToNext());
            carismaCD = true;
        } else {
            Toast.makeText(this, "No hay carisma en deseos.", Toast.LENGTH_LONG).show();
        }


        //meter en modelo Destreza
        Dados.arrayDestreza.clear();
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
                Dados.arrayDestreza.add(destrezaObjeto);
            } while (cursor1.moveToNext());
            destrezaC = true;
        } else {
            Toast.makeText(this, "No hay destreza", Toast.LENGTH_LONG).show();
        }

        arrayDDestreza.clear();
        cursor1 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_DEXD + "", null);
        if (cursor1.moveToFirst()) {
            do {
                int id = cursor1.getInt(0);
                int dex = cursor1.getInt(1);
                int esquivar = cursor1.getInt(2);
                int latrocinio = cursor1.getInt(3);
                int sigilo = cursor1.getInt(4);
                int volar = cursor1.getInt(5);
                Destreza destrezaObjeto = new Destreza(id, dex, esquivar, latrocinio, sigilo, volar);
                arrayDDestreza.add(destrezaObjeto);
            } while (cursor1.moveToNext());
            destrezaCD = true;
        } else {
            Toast.makeText(this, "No hay destreza en deseos.", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Vigor
        Dados.arrayVigor.clear();
        Cursor cursor2 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_VIGOR + "", null);
        if (cursor2.moveToFirst()) {
            do {
                int id = cursor2.getInt(0);
                int vigor = cursor2.getInt(1);
                int atletismo = cursor2.getInt(2);
                int pelea = cursor2.getInt(3);
                Vigor vigorObjeto = new Vigor(id, vigor, atletismo, pelea);
                dados.arrayVigor.add(vigorObjeto);
            } while (cursor2.moveToNext());
            vigorC = true;
        } else {
            Toast.makeText(this, "No hay vigor", Toast.LENGTH_LONG).show();
        }

        arrayDVigor.clear();
        cursor2 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_VIGORD + "", null);
        if (cursor2.moveToFirst()) {
            do {
                int id = cursor2.getInt(0);
                int vigor = cursor2.getInt(1);
                int atletismo = cursor2.getInt(2);
                int pelea = cursor2.getInt(3);
                Vigor vigorObjeto = new Vigor(id, vigor, atletismo, pelea);
                arrayDVigor.add(vigorObjeto);
            } while (cursor2.moveToNext());
            vigorCD = true;
        } else {
            Toast.makeText(this, "No hay vigor deseado.", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Inteligencia
        Dados.arrayInteligencia.clear();
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
                int herbologia = cursor3.getInt(7);
                int magizoologia = cursor3.getInt(8);
                int medicina = cursor3.getInt(9);
                int politica = cursor3.getInt(10);
                int supervivencia = cursor3.getInt(11);
                Inteligencia inteligenciaObjeto = new Inteligencia(id, inteligencia, adivinacion, arcanismo, callejeo, culturaMagica, culturaMuggle, herbologia, magizoologia, medicina, politica, supervivencia);
                dados.arrayInteligencia.add(inteligenciaObjeto);
            } while (cursor3.moveToNext());
            inteligenciaC = true;
        } else {
            Toast.makeText(this, "No hay inteligencia", Toast.LENGTH_LONG).show();
        }

        arrayDInteligencia.clear();
        cursor3 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_INTELIGENCIAD + "", null);
        if (cursor3.moveToFirst()) {
            do {
                int id = cursor3.getInt(0);
                int inteligencia = cursor3.getInt(1);
                int adivinacion = cursor3.getInt(2);
                int arcanismo = cursor3.getInt(3);
                int callejeo = cursor3.getInt(4);
                int culturaMagica = cursor3.getInt(5);
                int culturaMuggle = cursor3.getInt(6);
                int herbologia = cursor3.getInt(7);
                int magizoologia = cursor3.getInt(8);
                int medicina = cursor3.getInt(9);
                int politica = cursor3.getInt(10);
                int supervivencia = cursor3.getInt(11);
                Inteligencia inteligenciaObjeto = new Inteligencia(id, inteligencia, adivinacion, arcanismo, callejeo, culturaMagica, culturaMuggle, herbologia, magizoologia, medicina, politica, supervivencia);
                arrayDInteligencia.add(inteligenciaObjeto);
            } while (cursor3.moveToNext());
            inteligenciaCD = true;
        } else {
            Toast.makeText(this, "No hay inteligencia deseada.", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Percepcion
        Dados.arrayPercepcion.clear();
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
                dados.arrayPercepcion.add(percepcionObjeto);
            } while (cursor4.moveToNext());
            percepcionC = true;
        } else {
            Toast.makeText(this, "No hay percepcion", Toast.LENGTH_LONG).show();
        }

        arrayDPercepcion.clear();
        cursor4 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_PERCEPCIOND + "", null);
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
                arrayDPercepcion.add(percepcionObjeto);
            } while (cursor4.moveToNext());
            percepcionCD = true;
        } else {
            Toast.makeText(this, "No hay percepción en deseos.", Toast.LENGTH_LONG).show();
        }

        //meter en modelo Poder
        Dados.arrayPoder.clear();
        Cursor cursor5 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_PODER + "", null);
        if (cursor5.moveToFirst()) {
            do {
                int id = cursor5.getInt(0);
                int poder = cursor5.getInt(1);
                int duelo = cursor5.getInt(2);
                int pocion = cursor5.getInt(3);
                int ritual = cursor5.getInt(4);
                Poder poderObjeto = new Poder(id, poder, duelo, pocion, ritual);
                dados.arrayPoder.add(poderObjeto);
            } while (cursor5.moveToNext());
            poderC = true;
        } else {
            Toast.makeText(this, "No hay poder", Toast.LENGTH_LONG).show();
        }

        arrayDPoder.clear();
        cursor5 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_PODERD + "", null);
        if (cursor5.moveToFirst()) {
            do {
                int id = cursor5.getInt(0);
                int poder = cursor5.getInt(1);
                int duelo = cursor5.getInt(2);
                int pocion = cursor5.getInt(3);
                int ritual = cursor5.getInt(4);
                Poder poderObjeto = new Poder(id, poder, duelo, pocion, ritual);
                arrayDPoder.add(poderObjeto);
            } while (cursor5.moveToNext());
            poderCD = true;
        } else {
            Toast.makeText(this, "No hay poder deseado.", Toast.LENGTH_LONG).show();
        }

        //meter modelo Voluntad
        Dados.arrayVoluntad.clear();
        Cursor cursor6 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_VOLUNTAD + "", null);
        if (cursor6.moveToFirst()) {
            do {
                int id = cursor6.getInt(0);
                int voluntad = cursor6.getInt(1);
                int arte = cursor6.getInt(2);
                int estilo = cursor6.getInt(3);
                int frialdad = cursor6.getInt(4);
                Voluntad voluntadObjeto = new Voluntad(id, voluntad, arte, estilo, frialdad);
                Dados.arrayVoluntad.add(voluntadObjeto);
            } while (cursor6.moveToNext());
            voluntadC = true;
        } else {
            Toast.makeText(this, "No hay voluntad", Toast.LENGTH_LONG).show();
        }

        arrayDVoluntad.clear();
        cursor6 = dblectura.rawQuery("SELECT * FROM  " + DbHelper.TABLE_VOLUNTADD + "", null);
        if (cursor6.moveToFirst()) {
            do {
                int id = cursor6.getInt(0);
                int voluntad = cursor6.getInt(1);
                int arte = cursor6.getInt(2);
                int estilo = cursor6.getInt(3);
                int frialdad = cursor6.getInt(4);
                Voluntad voluntadObjeto = new Voluntad(id, voluntad, arte, estilo, frialdad);
                arrayDVoluntad.add(voluntadObjeto);
            } while (cursor6.moveToNext());
            voluntadCD = true;
        } else {
            Toast.makeText(this, "No hay voluntad deseada.", Toast.LENGTH_LONG).show();
        }

        if (poderC && voluntadC && poderCD && voluntadCD && inteligenciaC && inteligenciaCD && destrezaC && destrezaCD
                && carismaC && carismaCD && percepcionC && percepcionCD && vigorC && vigorCD) {
            bcalcular.setEnabled(true);
        } else {
            bcalcular.setEnabled(false);
        }
    }

    public void insert(){
        DbHelper dbHelper = new DbHelper(getApplicationContext()); //Build.this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        boolean comprobador1= false, comprobador2 = false, comprobador3=false, comprobador4= false, comprobador5 = false, comprobador6= false, comprobador7= false, comprobador8=false;
        String query= "SELECT * FROM '"+DbHelper.TABLE_VIGORD+"' ";
        if (db.rawQuery(query, null) !=null){
            ContentValues registro = new ContentValues();
            registro.put("idvd", build.idEscogido);
            registro.put("vigor", Integer.parseInt(vigor.getSelectedItem().toString()));
            registro.put("atletismo",metodoConversorHabilidadD(atletismo.getSelectedItem().toString()) );
            registro.put("pelea", metodoConversorHabilidadD(pelea.getSelectedItem().toString()));
            db.insert(dbHelper.TABLE_VIGORD, null, registro);
            comprobador1 = true;
        }
        String query2= "SELECT * FROM '"+DbHelper.TABLE_DEXD+"' ";
        if (db.rawQuery(query2, null) !=null){
            ContentValues registro = new ContentValues();
            registro.put("iddd", build.idEscogido);
            registro.put("destreza", Integer.parseInt(destreza.getSelectedItem().toString()));
            registro.put("esquivar", metodoConversorHabilidadD(esquivar.getSelectedItem().toString()));
            registro.put("sigilo", metodoConversorHabilidadD(sigilo.getSelectedItem().toString()));
            registro.put("latrocinio", metodoConversorHabilidadD(latrocinio.getSelectedItem().toString()));
            registro.put("volar", metodoConversorHabilidadD(volar.getSelectedItem().toString()));
            db.insert(dbHelper.TABLE_DEXD, null, registro);
            comprobador2 = true;
        }
        String query3= "SELECT * FROM '"+DbHelper.TABLE_CARISMAD+"' ";
        if (db.rawQuery(query3, null) !=null){
            ContentValues registro = new ContentValues();
            registro.put("idcd", build.idEscogido);
            registro.put("carisma", Integer.parseInt(carisma.getSelectedItem().toString()));
            registro.put("coordinacion", metodoConversorHabilidadD(coordinacion.getSelectedItem().toString()));
            registro.put("intimidacion", metodoConversorHabilidadD(intimidacion.getSelectedItem().toString()));
            registro.put("oratoria", metodoConversorHabilidadD(oratoria.getSelectedItem().toString()));
            registro.put("seducir", metodoConversorHabilidadD(seducir.getSelectedItem().toString()));
            registro.put("subterfugio", metodoConversorHabilidadD(subterfugio.getSelectedItem().toString()));
            db.insert(dbHelper.TABLE_CARISMAD, null, registro);
            comprobador3 = true;
        }
        String query4= "SELECT * FROM '"+DbHelper.TABLE_PODERD+"' ";
        if (db.rawQuery(query4, null) !=null){
            ContentValues registro = new ContentValues();
            registro.put("idpd", build.idEscogido);
            registro.put("poder", Integer.parseInt(poder.getSelectedItem().toString()));
            registro.put("duelo", metodoConversorHabilidadD(duelo.getSelectedItem().toString()));
            registro.put("pociones", metodoConversorHabilidadD(pociones.getSelectedItem().toString()));
            registro.put("rituales", metodoConversorHabilidadD(rituales.getSelectedItem().toString()));
            db.insert(dbHelper.TABLE_PODERD, null, registro);
            comprobador4 = true;
        }
        String query5= "SELECT * FROM '"+DbHelper.TABLE_VOLUNTADD+"' ";
        if (db.rawQuery(query5, null) !=null){
            ContentValues registro = new ContentValues();
            registro.put("idvod", build.idEscogido);
            registro.put("voluntad", Integer.parseInt(voluntad.getSelectedItem().toString()));
            registro.put("arte", metodoConversorHabilidadD(arte.getSelectedItem().toString()));
            registro.put("estilo", metodoConversorHabilidadD(estilo.getSelectedItem().toString()));
            registro.put("frialdad", metodoConversorHabilidadD(frialdad.getSelectedItem().toString()));
            db.insert(dbHelper.TABLE_VOLUNTADD, null, registro);
            comprobador5 = true;
        }
        String query6= "SELECT * FROM '"+DbHelper.TABLE_PERCEPCIOND+"' ";
        if (db.rawQuery(query6, null) !=null){
            ContentValues registro = new ContentValues();
            registro.put("idped", build.idEscogido);
            registro.put("percepcion", Integer.parseInt(percepcion.getSelectedItem().toString()));
            registro.put("alerta", metodoConversorHabilidadD(alerta.getSelectedItem().toString()));
            registro.put("consciencia", metodoConversorHabilidadD(consciencia.getSelectedItem().toString()));
            registro.put("empatia", metodoConversorHabilidadD(empatia.getSelectedItem().toString()));
            registro.put("iniciativa", metodoConversorHabilidadD(iniciativa.getSelectedItem().toString()));
            registro.put("investigacion", metodoConversorHabilidadD(investigacion.getSelectedItem().toString()));
            db.insert(dbHelper.TABLE_PERCEPCIOND, null, registro);
            comprobador6 = true;
        }
        String query7= "SELECT * FROM '"+DbHelper.TABLE_INTELIGENCIAD+"' ";
        if (db.rawQuery(query7, null) !=null){
            ContentValues registro = new ContentValues();
            registro.put("idid", build.idEscogido);
            registro.put("inteligencia", Integer.parseInt(inteligencia.getSelectedItem().toString()));
            registro.put("adivinacion", metodoConversorHabilidadD(adivinacion.getSelectedItem().toString()));
            registro.put("arcanismo", metodoConversorHabilidadD(arcanismo.getSelectedItem().toString()));
            registro.put("callejeo", metodoConversorHabilidadD(callejeo.getSelectedItem().toString()));
            registro.put("culturaMagia", metodoConversorHabilidadD(culturaM.getSelectedItem().toString()));
            registro.put("culturaMuggle", metodoConversorHabilidadD(culturaMu.getSelectedItem().toString()));
            registro.put("herbologia", metodoConversorHabilidadD(herbologia.getSelectedItem().toString()));
            registro.put("magizoologia", metodoConversorHabilidadD(magizoologia.getSelectedItem().toString()));
            registro.put("medicina", metodoConversorHabilidadD(medicina.getSelectedItem().toString()));
            registro.put("politica", metodoConversorHabilidadD(politica.getSelectedItem().toString()));
            registro.put("supervivencia", metodoConversorHabilidadD(supervivencia.getSelectedItem().toString()));
            db.insert(dbHelper.TABLE_INTELIGENCIAD, null, registro);
            comprobador7 = true;
        }
        if (comprobador1 && comprobador2 && comprobador3 && comprobador4 && comprobador5 && comprobador6 && comprobador7){
            Toast.makeText(getApplicationContext(), "Datos deseados insertados correctamente.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Datos deseados insertados correctamente.", Toast.LENGTH_LONG).show();
        }
        db.close();
        rellenarArrays();
    }

    public void update(){
        DbHelper dbHelper2 = new DbHelper(getApplicationContext());
        SQLiteDatabase db2 = dbHelper2.getWritableDatabase();
        //actualizar vigor
        int updateVigor = Integer.parseInt(vigor.getSelectedItem().toString());
        int updateAtle = metodoConversorHabilidadD(atletismo.getSelectedItem().toString());
        int updatePelea = metodoConversorHabilidadD(pelea.getSelectedItem().toString());

        ContentValues registro = new ContentValues();
        registro.put("vigor", updateVigor);
        registro.put("atletismo", updateAtle);
        registro.put("pelea", updatePelea);

        int cantidad = db2.update(DbHelper.TABLE_VIGORD, registro, "idvd= "+build.idEscogido, null);

        //actualizar destreza
        int updatedex = Integer.parseInt(destreza.getSelectedItem().toString());
        int updateesq = metodoConversorHabilidadD(esquivar.getSelectedItem().toString());
        int updatelatrocinio = metodoConversorHabilidadD(latrocinio.getSelectedItem().toString());
        int updatesigilo = metodoConversorHabilidadD(sigilo.getSelectedItem().toString());
        int updatevolar= metodoConversorHabilidadD(volar.getSelectedItem().toString());

        ContentValues registro2 = new ContentValues();
        registro2.put("destreza", updatedex);
        registro2.put("esquivar", updateesq);
        registro2.put("latrocinio", updatelatrocinio);
        registro2.put("sigilo", updatesigilo);
        registro2.put("volar", updatevolar);

        int cantidad2 = db2.update(DbHelper.TABLE_DEXD, registro2, "iddd= "+build.idEscogido, null);

        //actualizar carisma
        int updatecar = Integer.parseInt(carisma.getSelectedItem().toString());
        int updatecoor= metodoConversorHabilidadD(coordinacion.getSelectedItem().toString());
        int updateint = metodoConversorHabilidadD(intimidacion.getSelectedItem().toString());
        int updateora = metodoConversorHabilidadD(oratoria.getSelectedItem().toString());
        int updateseducir = metodoConversorHabilidadD(seducir.getSelectedItem().toString());
        int updatesubt = metodoConversorHabilidadD(subterfugio.getSelectedItem().toString());

        ContentValues registro3 = new ContentValues();
        registro3.put("carisma", updatecar);
        registro3.put("coordinacion", updatecoor);
        registro3.put("intimidacion", updateint);
        registro3.put("oratoria", updateora);
        registro3.put("seducir", updateseducir);
        registro3.put("subterfugio", updatesubt);

        int cantidad3 = db2.update(DbHelper.TABLE_CARISMAD, registro3, "idcd= "+build.idEscogido, null);

        //actualizar poder
        int updatepoder = Integer.parseInt(poder.getSelectedItem().toString());
        int updateduelo= metodoConversorHabilidadD(duelo.getSelectedItem().toString());
        int updatepociones = metodoConversorHabilidadD(pociones.getSelectedItem().toString());
        int updaterituales = metodoConversorHabilidadD(rituales.getSelectedItem().toString());

        ContentValues registro4 = new ContentValues();
        registro4.put("poder", updatepoder);
        registro4.put("duelo", updateduelo);
        registro4.put("pociones", updatepociones);
        registro4.put("rituales", updaterituales);

        int cantidad4 = db2.update(DbHelper.TABLE_PODERD, registro4, "idpd= "+build.idEscogido, null);

        //actualizar voluntad
        int updatevol = Integer.parseInt(voluntad.getSelectedItem().toString());
        int updatearte = metodoConversorHabilidadD(arte.getSelectedItem().toString());
        int updateestilo = metodoConversorHabilidadD(estilo.getSelectedItem().toString());
        int updatefrialdad = metodoConversorHabilidadD(frialdad.getSelectedItem().toString());

        ContentValues registro5 = new ContentValues();
        registro5.put("voluntad", updatevol);
        registro5.put("arte", updatearte);
        registro5.put("estilo", updateestilo);
        registro5.put("frialdad", updatefrialdad);

        int cantidad5 = db2.update(DbHelper.TABLE_VOLUNTADD, registro5, "idvod= "+build.idEscogido, null);

        //actualizar percecpción
        int updateper = Integer.parseInt(percepcion.getSelectedItem().toString());
        int updatealerta = metodoConversorHabilidadD(alerta.getSelectedItem().toString());
        int updateConsciencia = metodoConversorHabilidadD(consciencia.getSelectedItem().toString());
        int updateEmpatia = metodoConversorHabilidadD(empatia.getSelectedItem().toString());
        int updateiniciativa = metodoConversorHabilidadD(iniciativa.getSelectedItem().toString());
        int updateInvestigacion = metodoConversorHabilidadD(investigacion.getSelectedItem().toString());

        ContentValues registro6 = new ContentValues();
        registro6.put("percepcion", updateper);
        registro6.put("alerta", updatealerta);
        registro6.put("consciencia", updateConsciencia);
        registro6.put("empatia", updateEmpatia);
        registro6.put("iniciativa", updateiniciativa);
        registro6.put("investigacion", updateInvestigacion);

        int cantidad6 = db2.update(DbHelper.TABLE_PERCEPCIOND, registro6, "idped= "+build.idEscogido, null);

        //actualizar inteligencia
        int updateinte = Integer.parseInt(inteligencia.getSelectedItem().toString());
        int updateAdivina = metodoConversorHabilidadD(adivinacion.getSelectedItem().toString());
        int updatearcanismo = metodoConversorHabilidadD(arcanismo.getSelectedItem().toString());
        int updateCallejeo = metodoConversorHabilidadD(callejeo.getSelectedItem().toString());
        int updateculturaMagia = metodoConversorHabilidadD(culturaM.getSelectedItem().toString());
        int updateculturaMuggle =metodoConversorHabilidadD(culturaMu.getSelectedItem().toString());
        int updateHerbologia = metodoConversorHabilidadD(herbologia.getSelectedItem().toString());
        int updateMagZoo = metodoConversorHabilidadD(magizoologia.getSelectedItem().toString());
        int updateMedicina = metodoConversorHabilidadD(medicina.getSelectedItem().toString());
        int updatePolitica = metodoConversorHabilidadD(politica.getSelectedItem().toString());
        int updateSupervivencia = metodoConversorHabilidadD(supervivencia.getSelectedItem().toString());

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

        int cantidad7 = db2.update(DbHelper.TABLE_INTELIGENCIAD, registro7, "idid= "+build.idEscogido, null);

        db2.close();

        if ( cantidad==1 && cantidad2 == 1 && cantidad3 == 1 && cantidad4 == 1 && cantidad5 == 1 && cantidad6 == 1 && cantidad7 == 1){
            Toast.makeText(this, "Deseos actualizados correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error: deseos no actualizados", Toast.LENGTH_LONG).show();
        }
        rellenarArrays();
    }

    public int metodoConversorHabilidadD (String datoSpinner) {
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

    public int reversoHabilidadD (int datoTabla) {
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

}