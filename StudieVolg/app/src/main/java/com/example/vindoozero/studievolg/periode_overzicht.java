package com.example.vindoozero.studievolg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class periode_overzicht extends AppCompatActivity {

//    final Bundle b = getIntent().getExtras();
//    final int jaar = b.getInt("jaar");
    public Button btnPeriode1;
    public Button btnPeriode2;
    public Button btnPeriode3;
    public Button btnPeriode4;

    public void gaNaarPeriode1(final Bundle b){
        btnPeriode1 = (Button)(findViewById(R.id.btnPeriode1));
        btnPeriode1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent lv = new Intent(periode_overzicht.this,ListViewer.class);
                b.putInt("periode", 1);
                lv.putExtras(b);
                startActivity(lv);
            }
        });
    }

    //Ga naar jaar 2 Cijfers
    public void gaNaarPeriode2(final Bundle b){
        btnPeriode2 = (Button)(findViewById(R.id.btnPeriode2));
        btnPeriode2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent lv = new Intent(periode_overzicht.this,ListViewer.class);
                b.putInt("periode", 2);
                lv.putExtras(b);
                startActivity(lv);
            }
        });
    }

    //Ga naar jaar 3 Cijfers
    public void gaNaarPeriode3(final Bundle b){
        btnPeriode3 = (Button)(findViewById(R.id.btnPeriode3));
        btnPeriode3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent lv = new Intent(periode_overzicht.this,ListViewer.class);
                b.putInt("periode", 3);
                lv.putExtras(b);
                startActivity(lv);
            }
        });
    }

    //Ga naar jaar 4 Cijfers
    public void gaNaarPeriode4(final Bundle b){
        btnPeriode4 = (Button)(findViewById(R.id.btnPeriode4));
        btnPeriode4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent lv = new Intent(periode_overzicht.this,ListViewer.class);
                b.putInt("periode", 4);
                lv.putExtras(b);
                startActivity(lv);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periode_overzicht);

        Bundle b = getIntent().getExtras();
        int jaar = b.getInt("jaar");

        if (b != null){
            Log.i("testen JAAR:", String.valueOf(jaar));
            gaNaarPeriode1(b);
            gaNaarPeriode2(b);
            gaNaarPeriode3(b);
            gaNaarPeriode4(b);
        }
    }
}
