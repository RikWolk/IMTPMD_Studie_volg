package com.example.vindoozero.studievolg;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vindoozero.studievolg.Periodes.classPeriodes;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    public int jaar;
    public int periode;

    public int ecJaar1 = 0;
    public int ecJaar2 = 0;
    public int ecJaar3 = 0;
    public int ecJaar4 = 0;


    public Button BtnJaarOverzicht;
    ProgressBar pbJaar1, pbJaar2, pbJaar3, pbJaar4, pbKeuzevakken;
    TextView textbarJaar1, textbarJaar2, textbarJaar3, textbarJaar4, textbarKeuzevakken;


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

    public void useQuery(Query query, final int jaarEC){
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (jaarEC == 1){
                    classPeriodes data = dataSnapshot.getValue(classPeriodes.class);

                    if (data.isGehaald()){
                        ecJaar1 += data.getEc();
                    }
                } else if (jaarEC == 2){
                    classPeriodes data = dataSnapshot.getValue(classPeriodes.class);

                    if (data.isGehaald()){
                        ecJaar2 += data.getEc();
                    }
                } else if (jaarEC == 3){
                    classPeriodes data = dataSnapshot.getValue(classPeriodes.class);

                    if (data.isGehaald()){
                        ecJaar3 += data.getEc();
                    }
                } else if (jaarEC == 4){
                    classPeriodes data = dataSnapshot.getValue(classPeriodes.class);

                    if (data.isGehaald()){
                        ecJaar4 += data.getEc();
                    }
                }
                Log.i("na de query 1", String.valueOf(ecJaar1));
                Log.i("na de query 2", String.valueOf(ecJaar2));
                Log.i("na de query 3", String.valueOf(ecJaar3));
                Log.i("na de query 4", String.valueOf(ecJaar4));

                fillBar();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void fillBar(){

        int EcJaar1 = Integer.valueOf(ecJaar1);

        pbJaar1=(ProgressBar)findViewById(R.id.progressBarJaar1);

        //Hier moet het maximaal aanpunten van dat jaar ingevuld worden.
        pbJaar1.setMax(60);

        //Hier moet het behaalde aantal punten ingevoerd worden
        pbJaar1.setProgress(EcJaar1);

        textbarJaar1= (TextView)findViewById(R.id.textBar1);

        //Hier moetzen ze beide ingevoerd worden om zo duidelijk het proces te zien
        textbarJaar1.setText(EcJaar1 + " / 60 EC");



        //jaar 2
        int EcJaar2 = Integer.valueOf(ecJaar2);

        pbJaar2=(ProgressBar)findViewById(R.id.progressBarJaar2);
        pbJaar2.setMax(60);
        pbJaar2.setProgress(EcJaar2);
        textbarJaar2= (TextView)findViewById(R.id.textBar2);
        textbarJaar2.setText(EcJaar2 + " / 60");

        //jaar 3
        int EcJaar3 = Integer.valueOf(ecJaar3);

        pbJaar3=(ProgressBar)findViewById(R.id.progressBarJaar3);
        pbJaar3.setMax(60);
        pbJaar3.setProgress(EcJaar3);
        textbarJaar3= (TextView)findViewById(R.id.textBar3);
        textbarJaar3.setText(EcJaar3 + " / 60");


        //jaar 4
        int EcJaar4 = Integer.valueOf(ecJaar2);

        pbJaar4=(ProgressBar)findViewById(R.id.progressBarJaar4);
        pbJaar4.setMax(60);
        pbJaar4.setProgress(EcJaar4);
        textbarJaar4= (TextView)findViewById(R.id.textBar4);
        textbarJaar4.setText(EcJaar4 + " / 60");


        //Keuze vakken

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
        Query queryRef1 = ref.orderByChild("jaar").equalTo(1);
        Query queryRef2 = ref.orderByChild("jaar").equalTo(2);
        Query queryRef3 = ref.orderByChild("jaar").equalTo(3);
        Query queryRef4 = ref.orderByChild("jaar").equalTo(4);

        useQuery(queryRef1, 1);
        useQuery(queryRef2, 2);
        useQuery(queryRef3, 3);
        useQuery(queryRef4, 4);

        gaNaarCijfers();



        Log.i("HOEVEEL IS EC1", String.valueOf(ecJaar1));
        Log.i("HOEVEEL IS EC2", String.valueOf(ecJaar2));
        Log.i("HOEVEEL IS EC3", String.valueOf(ecJaar3));
        Log.i("HOEVEEL IS EC4", String.valueOf(ecJaar4));





    }
}