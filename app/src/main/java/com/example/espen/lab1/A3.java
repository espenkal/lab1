package com.example.espen.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A3 extends AppCompatActivity {

    Button start;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        //variables
        start =  findViewById(R.id.B3);
        editText =  findViewById(R.id.T2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                String editTextValue = editText.getText().toString();
                returnIntent.putExtra("WORD", editTextValue);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
    //pressing the back button will go to the second activity
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(A3.this, A2.class));
        finish();

    }
}
