package com.example.fororol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Escoger extends AppCompatActivity {
    Button bpj1, bpj2, bpj3, bpj4, bpj5, bpj6, bpj7;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bpj1 = findViewById(R.id.bpj1);
        bpj2 = findViewById(R.id.bpj2);
        bpj3 = findViewById(R.id.bpj3);
        bpj4 = findViewById(R.id.bpj4);
        bpj5 = findViewById(R.id.bpj5);
        bpj6 = findViewById(R.id.bpj6);
        bpj7 = findViewById(R.id.bpj7);

        bpj1.setEnabled(false);
        bpj2.setEnabled(false);
        bpj3.setEnabled(false);
        bpj4.setEnabled(false);
        bpj5.setEnabled(false);
        bpj6.setEnabled(false);
        bpj7.setEnabled(false);

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
            }

        }

        bpj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=1;
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bpj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=2;
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=3;
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=4;
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=5;
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=6;
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        }    );

        bpj7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Build.idEscogido=7;
                Intent intent = new Intent(Escoger.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}