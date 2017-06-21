package com.example.vindoozero.studievolg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vindoozero.studievolg.Periodes.classPeriodes;
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
    final ArrayList<classPeriodes> list = new ArrayList<classPeriodes>();

//    public Query getQuery(int jaar, int periode, DatabaseReference ref){
//        Query query;
//        if (jaar == 1){
//            if (periode == 1){
//                query = ref.orderByChild("j_p").equalTo(jaar + "_" + periode);
//                return query;
//            }
//            if (periode == 2){
//                query = ref.orderByChild("j_p").equalTo("1_2");
//                return query;
//            }
//            if (periode == 3){
//                query = ref.orderByChild("j_p").equalTo("1_3");
//                return query;
//            }
//            if (periode == 4){
//                query = ref.orderByChild("j_p").equalTo("1_4");
//                return query;
//            }
//        }
//        if (jaar == 2){
//            if (periode == 1){
//                query = ref.orderByChild("j_p").equalTo("1_1");
//                return query;
//            }
//            if (periode == 2){
//                query = ref.orderByChild("j_p").equalTo("1_2");
//                return query;
//            }
//            if (periode == 3){
//                query = ref.orderByChild("j_p").equalTo("1_3");
//                return query;
//            }
//            if (periode == 4){
//                query = ref.orderByChild("j_p").equalTo("1_4");
//                return query;
//            }
//        }
//        if (jaar == 1){
//            if (periode == 1){
//                query = ref.orderByChild("j_p").equalTo("1_1");
//                return query;
//            }
//            if (periode == 2){
//                query = ref.orderByChild("j_p").equalTo("1_2");
//                return query;
//            }
//            if (periode == 3){
//                query = ref.orderByChild("j_p").equalTo("1_3");
//                return query;
//            }
//            if (periode == 4){
//                query = ref.orderByChild("j_p").equalTo("1_4");
//                return query;
//            }
//        }
//        if (jaar == 1){
//            if (periode == 1){
//                query = ref.orderByChild("j_p").equalTo("1_1");
//                return query;
//            }
//            if (periode == 2){
//                query = ref.orderByChild("j_p").equalTo("1_2");
//                return query;
//            }
//            if (periode == 3){
//                query = ref.orderByChild("j_p").equalTo("1_3");
//                return query;
//            }
//            if (periode == 4){
//                query = ref.orderByChild("j_p").equalTo("1_4");
//                return query;
//            }
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaar1_cijfers);

        Bundle b = getIntent().getExtras();

        if(b != null){
            jaar = b.getInt("jaar");
            periode = b.getInt("periode");
            Log.i("testen JAAR", String.valueOf(jaar));
            Log.i("testen PERIODE", String.valueOf(periode));
        }


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query query = ref.orderByChild("j_p").equalTo(jaar + "_" + periode);
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot vakken : dataSnapshot.getChildren()){
                    classPeriodes test = vakken.getValue(classPeriodes.class);
                    Log.i("testen", String.valueOf(test));
                    list.add(test);
                }
                fillList(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            public void fillList(ArrayList<classPeriodes> list){
                ListAdapter periode1Adapter = new ArrayAdapter<classPeriodes>(ListViewer.this, android.R.layout.simple_list_item_1, list);

                ListView J1Periode1 = (ListView) findViewById(R.id.J1Periode1);
                J1Periode1.setAdapter(periode1Adapter);

                J1Periode1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String periode1Beschrijving = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(ListViewer.this, periode1Beschrijving, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
