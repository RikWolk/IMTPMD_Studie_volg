package com.example.vindoozero.studievolg;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class JaarKeuzevakkenCijfers extends AppCompatActivity {

    ListView listView = null;
    Button toevoegen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaar_keuzevakken_cijfers);

        listView = new ListView(this);
        String[] items = {"Facebook", "Twitter", "Yotuube"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textitem, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewGroup vg = (ViewGroup) view;
                TextView txt = (TextView) vg.findViewById(R.id.textitem);

            }
        });



    }

        public void showDialogListView(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(JaarKeuzevakkenCijfers.this);
            builder.setCancelable(true);
            builder.setPositiveButton("Ok", null);
            builder.setView(listView);
            AlertDialog dialog = builder.create();
            dialog.show();

        }




}
