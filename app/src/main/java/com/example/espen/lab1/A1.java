package com.example.espen.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class A1 extends AppCompatActivity {

    Button start;
    TextView text;
    EditText editText;
    ArrayAdapter<CharSequence> adapter;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        start = findViewById(R.id.B1);
        text = findViewById(R.id.act1);
        editText = findViewById(R.id.T1);


        //sends input to A2

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextValue = editText.getText().toString();
                Intent intent = new Intent(A1.this, A2.class);
                intent.putExtra("NAME", editTextValue);
                startActivity(intent);
            }
        });

        //spinner variable

        spinner = findViewById(R.id.spinner1);

        //adapter spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.Options, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        //Sharedpreferences
        final SharedPreferences preferences = getSharedPreferences("lab1", MODE_PRIVATE);
        spinner.setSelection(preferences.getInt("Options", 0));

        // Spinner view
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("Options", i);
                editor.apply();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}

