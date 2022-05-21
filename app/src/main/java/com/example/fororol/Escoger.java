package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Escoger extends AppCompatActivity {
    Button bpj1, bpj2, bpj3, bpj4, bpj5, bpj6, bpj7, bpj8, bpj9;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_escoger);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bpj1 = findViewById(R.id.bpj1);
        bpj2 = findViewById(R.id.bpj2);
        bpj3 = findViewById(R.id.bpj3);
        bpj4 = findViewById(R.id.bpj4);
        bpj5 = findViewById(R.id.bpj5);
        bpj6 = findViewById(R.id.bpj6);
        bpj7 = findViewById(R.id.bpj7);
        bpj8 = findViewById(R.id.bpj8);
        bpj9 = findViewById(R.id.bpj9);

        bpj1.setEnabled(false);
        bpj2.setEnabled(false);
        bpj3.setEnabled(false);
        bpj4.setEnabled(false);
        bpj5.setEnabled(false);
        bpj6.setEnabled(false);
        bpj7.setEnabled(false);
        bpj8.setEnabled(false);
        bpj9.setEnabled(false);

        for (int i = 0; i < MainActivity.pjs.size(); i++) {
            if (i == 0) {
                bpj1.setEnabled(true);
                bpj1.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 1) {
                bpj2.setEnabled(true);
                bpj2.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 2) {
                bpj3.setEnabled(true);
                bpj3.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 3) {
                bpj4.setEnabled(true);
                bpj4.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 4) {
                bpj5.setEnabled(true);
                bpj5.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 5) {
                bpj6.setEnabled(true);
                bpj6.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 6) {
                bpj7.setEnabled(true);
                bpj7.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 7) {
                bpj8.setEnabled(true);
                bpj8.setText(MainActivity.pjs.get(i).getNombre());
            } else if (i == 8) {
                bpj9.setEnabled(true);
                bpj9.setText(MainActivity.pjs.get(i).getNombre());
            }

        }

        bpj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(0).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bpj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(1).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(2).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(3).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(4).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(5).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(6).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bpj8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(7).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bpj9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=MainActivity.pjs.get(8).getIdPj();
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}