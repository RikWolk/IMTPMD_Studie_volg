package com.example.vindoozero.studievolg;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vindoozero.studievolg.Periodes.classPeriodes;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListViewer extends AppCompatActivity {

    public int jaar;
    public int periode;
    public double result;
    public ArrayList<classPeriodes> list = new ArrayList<classPeriodes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaar1_cijfers);

        // hier word de bundle die uit periode_overzicht komt uitgepakt,
        // uit het pakket komen de variabele Jaar en Periode.
        Bundle b = getIntent().getExtras();

        if(b != null){
            jaar = b.getInt("jaar");
            periode = b.getInt("periode");
        }

        // Hier word een referentie naar de database (FireBase) in een variabele gedaan,
        // vervolgens wordt hier een query op afgevuurd die de vakken pakt met de desbetreffende Jaar en Periode (Zie Bundle)
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        final Query query = ref.orderByChild("j_p").equalTo(jaar + "_" + periode);
        ListView lv = (ListView) findViewById(R.id.J1Periode1);

        // Hier worden de verschillende entries uit de database binnen de adapter gekoppeld...
        final FirebaseListAdapter mAdapter = new FirebaseListAdapter<classPeriodes>(this, classPeriodes.class, android.R.layout.simple_list_item_1, query){
            @Override
            protected void populateView(View v, classPeriodes model, int position) {
                String vakNaam = model.toString();
                list.add(model);



                // Wanneer de item GEEN keuzevak is, else -> maak item onzichtbaar (JE ZIET NOG WEL EEN PLACEHOLDER)
                if (!model.isKeuzevak()){

                    // Wanneer vak is gehaald -> Groen, als cijfer onder 5.5 -> rood
                    if(model.isGehaald()){
                        v.setBackgroundColor(Color.GREEN);
                    }
                    else if (model.getCijfer() < 5.5) {
                        v.setBackgroundColor(Color.RED);
                    }

                    ((TextView) v.findViewById(android.R.id.text1)).setText(vakNaam);

                } else {
                   v.setVisibility(View.GONE);
                }
            }
        };

        // ...Om de adapter uiteindelijk aan de lijst te koppelen.
        // ook worden de items hier clickable gemaakt.
        lv.setAdapter(mAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                result = 0;
                boolean geklikt = false;

                // HIER GAAT HIJ NU FOUT. de item waar het cijfer wordt ingevoerd kan aangepast worden. dat is niet de bedoeling
                if (!list.get(position).isGehaald() && geklikt == false){
                    getDialog(mAdapter, position);
                    geklikt = true;
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
                    Toast.makeText(ListViewer.this, "Vul een getal binnen de 1.0 en 10.0 in.",
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

}
