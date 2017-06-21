package com.example.vindoozero.studievolg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public Button BtnJaarOverzicht;

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
        gaNaarCijfers();
    }
}
