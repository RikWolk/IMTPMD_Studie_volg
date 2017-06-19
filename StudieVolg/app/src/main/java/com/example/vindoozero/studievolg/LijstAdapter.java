package com.example.vindoozero.studievolg;

/**
 * Created by VindooZero on 19-6-2017.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class LijstAdapter extends ArrayAdapter<String> {

    public LijstAdapter(Context context, String[] periode1, String[] vakInfo) {
        super(context, R.layout.lijst, periode1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater lijstInflater = LayoutInflater.from(getContext());
        View customView = lijstInflater.inflate(R.layout.lijst, parent, false);

        String vakNaam = getItem(position);
        String vakEC = getItem(position);
        TextView lijstvakNaam = (TextView) customView.findViewById(R.id.vakNaam);
        TextView lijstvakEC = (TextView) customView.findViewById(R.id.vakEC);

        lijstvakNaam.setText(vakNaam);
        lijstvakEC.setText(vakEC);

        return customView;

    }
}
