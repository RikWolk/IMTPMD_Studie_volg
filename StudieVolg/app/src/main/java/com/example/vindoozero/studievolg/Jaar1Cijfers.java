package com.example.vindoozero.studievolg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Jaar1Cijfers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaar1_cijfers);

        String[] periode1 = {"IARCH", "IIBPM", "ÏHBO", "IOPR1"};
        String[] vakInfo = {"IT Architectuur", "Inleiding informatiemanagement", "Fundamentele HBO-(I)-vaardigheden", "Objectgeoriënteerd programmeren 1"};


        //ListAdapter periode1Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, periode1);
        ListAdapter periode1Adapter = new LijstAdapter(this, periode1, vakInfo);

        ListView J1Periode1 = (ListView) findViewById(R.id.J1Periode1);
        J1Periode1.setAdapter(periode1Adapter);

        J1Periode1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                  //String periode1Beschrijving = vakInfo[position];
                 // String periode1Beschrijving = String.valueOf(parent.getItemAtPosition(position));
                  //Toast.makeText(Jaar1Cijfers.this, periode1Beschrijving, Toast.LENGTH_SHORT).show();

                 }
          }





        );




    }
}
