package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fororol.db.DbHelper;

public class NuevoPj extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_nuevo_pj);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText = findViewById(R.id.txtNombre);
        button = findViewById(R.id.btnCrear);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbhelper = new DbHelper(NuevoPj.this);
                SQLiteDatabase db = dbhelper.getWritableDatabase();
                //buscar el último id
                int lastId = 0;
                for (int i = 0; i < MainActivity.pjs.size(); i++) {
                    lastId = MainActivity.pjs.get(i).getIdPj();
                }
                //añadir pj
                String query= "SELECT * FROM '"+ DbHelper.TABLE_PJ+"' ";
                if (db.rawQuery(query, null) !=null){
                    ContentValues registro = new ContentValues();
                    registro.put("idpj", lastId+1);
                    registro.put("nombre", editText.getText().toString());
                    registro.put("etapa", "0");
                    db.insert(dbhelper.TABLE_PJ, null, registro);
                }
                Intent intent = new Intent(NuevoPj.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}