package com.jonatasleon.aula06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;

public class AdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        String[] animais = { "Cachorro", "Peixe", "Coelho", "Gato" };

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(AdapterActivity.this, android.R.layout.simple_spinner_item, animais);
        ArrayAdapter<String> adapterListView = new ArrayAdapter<String>(AdapterActivity.this, android.R.layout.simple_list_item_1, animais);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapterSpinner);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapterListView);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(adapterSpinner);
    }
}
