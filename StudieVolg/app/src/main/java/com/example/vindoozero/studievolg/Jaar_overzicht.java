package com.example.vindoozero.studievolg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jaar_overzicht extends AppCompatActivity {


    public Button btnJaar1;
    public Button btnJaar2;
    public Button btnJaar3;
    public Button btnJaar4;
    public Button btnKeuzeVakken;



    //Ga naar jaar 1 Cijfers
    public void gaNaarJaar1(){
        btnJaar1 = (Button)(findViewById(R.id.btnJaar1));
        btnJaar1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent jaar1cijfers = new Intent(Jaar_overzicht.this,Jaar1Cijfers.class);
                startActivity(jaar1cijfers);
            }
        });
    }

    //Ga naar jaar 2 Cijfers
    public void gaNaarJaar2(){
        btnJaar2 = (Button)(findViewById(R.id.btnJaar2));
        btnJaar2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent jaar2cijfers = new Intent(Jaar_overzicht.this,Jaar2Cijfers.class);
                startActivity(jaar2cijfers);
            }
        });
    }

    //Ga naar jaar 3 Cijfers
    public void gaNaarJaar3(){
        btnJaar3 = (Button)(findViewById(R.id.btnJaar3));
        btnJaar3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent jaar3cijfers = new Intent(Jaar_overzicht.this,Jaar3Cijfers.class);
                startActivity(jaar3cijfers);
            }
        });
    }

    //Ga naar jaar 4 Cijfers
    public void gaNaarJaar4(){
        btnJaar4 = (Button)(findViewById(R.id.btnJaar4));
        btnJaar4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent jaar4cijfers = new Intent(Jaar_overzicht.this,Jaar4Cijfers.class);
                startActivity(jaar4cijfers);
            }
        });
    }

    //Ga naar keuzevakken cijfers
    public void gaNaarKeuzevakken(){
        btnKeuzeVakken = (Button)(findViewById(R.id.btnKeuzeVakken));
        btnKeuzeVakken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent jaarKeuzevakkenCijfers = new Intent(Jaar_overzicht.this,JaarKeuzevakkenCijfers.class);
                startActivity(jaarKeuzevakkenCijfers);
            }
        });
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaar_overzicht);
        gaNaarJaar1();
        gaNaarJaar2();
        gaNaarJaar3();
        gaNaarJaar4();
        gaNaarKeuzevakken();




    }
}
