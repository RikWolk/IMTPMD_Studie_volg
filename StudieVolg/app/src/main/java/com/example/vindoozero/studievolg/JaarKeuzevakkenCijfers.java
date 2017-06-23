package com.example.vindoozero.studievolg;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vindoozero.studievolg.Periodes.classPeriodes;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class JaarKeuzevakkenCijfers extends AppCompatActivity {

    int counter = 0;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaar_keuzevakken_cijfers);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query query = ref.orderByChild("keuzevak").equalTo(true);

        ListView lv = (ListView) findViewById(R.id.keuzevakList);

        // Hier worden de verschillende entries uit de database binnen de adapter gekoppeld...
        final FirebaseListAdapter mAdapter = new FirebaseListAdapter<classPeriodes>(this, classPeriodes.class, android.R.layout.simple_list_item_1, query){
            @Override
            protected void populateView(View v, classPeriodes model, int position) {
                String vakNaam = model.toString();
                ((TextView) v.findViewById(android.R.id.text1)).setText(vakNaam);

                // Wanneer vak is gehaald -> Groen, als cijfer onder 5.5 -> rood
                if(model.isGehaald()){
                    v.setBackgroundColor(Color.GREEN);
                }
                else if (model.getCijfer() < 5.5) {
                    v.setBackgroundColor(Color.RED);
                }
            }
        };

        lv.setAdapter(mAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            result = 0;
            if (counter < 4){
                getDialog(mAdapter, position);
                counter++;
                Log.i("result", String.valueOf(counter));
            }
            else{
                Toast.makeText(JaarKeuzevakkenCijfers.this, "Er zijn al 4 keuzevakken ingevoerd",
                        Toast.LENGTH_LONG).show();
            }
            }
        });
    }

    // Hier staat de functie die de alert Dialog creeërt
    public void getDialog(final FirebaseListAdapter mAdapter, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Voer cijfer in");


        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        input.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        builder.setView(input);


        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

//              // Hier wordt de input (cijfer) die de gebruiker invoerd gebruikt om de cijfer + resultaat weer te uploaden via de functie calculateResult

                result = Double.parseDouble(input.getText().toString());

                if(result > 10.0 || result < 1.0){
                    Toast.makeText(JaarKeuzevakkenCijfers.this, "Vul een getal binnen de 1.0 en 10.0 in.",
                            Toast.LENGTH_LONG).show();
                }


                else{
                    calculateResult(mAdapter, position, result);
                }


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    // Dit is een functie die automatisch de cijfer upload naar de database (+ gehaald true : false)
    public void calculateResult(FirebaseListAdapter mAdapter, int position, double res){
        if (res < 5.5){
            mAdapter.getRef(position).child("gehaald").setValue(false);
            mAdapter.getRef(position).child("cijfer").setValue(result);
        }
        else if (res >= 5.5){
            mAdapter.getRef(position).child("gehaald").setValue(true);
            mAdapter.getRef(position).child("cijfer").setValue(result);
        }

    }


//        listView = new ListView(this);
//        String[] items = {"Facebook", "Twitter", "Yotuube"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textitem, items);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ViewGroup vg = (ViewGroup) view;
//                TextView txt = (TextView) vg.findViewById(R.id.textitem);
//
//            }
//        });

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

//        public void showDialogListView(View view){
//            AlertDialog.Builder builder = new AlertDialog.Builder(JaarKeuzevakkenCijfers.this);
//            builder.setCancelable(true);
//            builder.setPositiveButton("Ok", null);
//            builder.setView(listView);
//            AlertDialog dialog = builder.create();
//            dialog.show();
//
//        }

}
