package com.example.vindoozero.studievolg;

import android.graphics.Color;
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

import com.example.vindoozero.studievolg.Periodes.classPeriodes;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

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

//        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//        final Query query = ref.orderByChild("keuzevak").equalTo(true);
//        ListView lv = (ListView) findViewById(R.id.J1Periode1);
//
//        final FirebaseListAdapter mAdapter = new FirebaseListAdapter<classPeriodes>(this, classPeriodes.class, android.R.layout.simple_list_item_1, query){
//            @Override
//            protected void populateView(View v, classPeriodes model, int position) {
//                String naam = model.getNaam();
//                ((TextView) v.findViewById(android.R.id.text1)).setText(naam);
//            }
//        };
//
//        listView.setAdapter(mAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ViewGroup vg = (ViewGroup) view;
//                TextView txt = (TextView) vg.findViewById(R.id.textitem);
//            }
//        });
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
