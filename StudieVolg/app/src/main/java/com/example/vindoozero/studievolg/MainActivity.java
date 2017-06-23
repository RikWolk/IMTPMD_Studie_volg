package com.example.vindoozero.studievolg;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class MainActivity extends AppCompatActivity {

    public int jaar;
    public int periode;


    public Button BtnJaarOverzicht;
    ProgressBar pbJaar1, pbJaar2, pbJaar3, pbJaar4, pbKeuzevakken;
    TextView textbarJaar1, TextbarJaar2, textbarJaar3, textbarJaar4, textbarKeuzevakken;


    public void gaNaarCijfers(){
        BtnJaarOverzicht = (Button)(findViewById(R.id.BtnJaarOverzicht));
        BtnJaarOverzicht.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent jaren = new Intent(MainActivity.this,Jaar_overzicht.class);
                startActivity(jaren);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b = getIntent().getExtras();

        if(b != null){
            jaar = b.getInt("jaar");
            periode = b.getInt("periode");
        }

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query queryRef = ref.orderByChild("ec");







        gaNaarCijfers();

        pbJaar1=(ProgressBar)findViewById(R.id.progressBarJaar1);

        pbJaar1.setProgress(50);

        textbarJaar1= (TextView)findViewById(R.id.textBar1);
        textbarJaar1.setText("30 / 60");










    }
}
