package com.creative.myspinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    // Spinner drop down elements
    String[] categories = { "Automobile", "Computers", "Travel" };
    int[] categoryIcons = { R.drawable.car, R.drawable.computer, R.drawable.travel };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        Spinner spinner = findViewById(R.id.spinner);
        Spinner customSpinner = findViewById(R.id.custom_spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String item = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(adapterView.getContext(), "Selected:" + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                Toast.makeText(adapterView.getContext(), "Selected:" + categories[pos], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        // Adapter for custom spinner
        CustomAdapter customDataAdapter = new CustomAdapter(getApplicationContext(), categoryIcons, categories);

        // Spinner
        // Drop down layout style - list view with radio buttion
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Attach data adapter to spinner
        spinner.setAdapter(dataAdapter);

        // Custom Spinner
        customSpinner.setAdapter(customDataAdapter);
    }
}
