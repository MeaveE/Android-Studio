package com.example.eileenrattigan.lab4lists;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] countries = {"South Africa", "France", "Spain", "Germany", "Finland", "Ireland", "England"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new AdapterX(this, android.R.layout.simple_list_item_1, countries));
        setListAdapter(new AdapterX(this, R.layout.row, countries));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        String selection = l.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), selection, Toast.LENGTH_LONG).show();
    }

    class AdapterX extends ArrayAdapter {
        public AdapterX(Context context, int rowLayoutId, String[] ArrayData) {
            super(context, rowLayoutId, ArrayData);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row;
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.row, parent, false);

            TextView lable = (TextView) row.findViewById(R.id.countries);
            lable.setText(countries[position]);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if(countries[position]=="Ireland") {
                icon.setImageResource(R.drawable.ok);
            } else {
                icon.setImageResource(R.drawable.original);
            }

            return row;
        }
    }
}