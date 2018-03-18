package com.example.espen.lab1;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A2 extends AppCompatActivity {

    Button start;
    TextView ShowMessageA1;
    private int REQUEST_CODE=1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        //variables
        start = findViewById(R.id.B2);
        ShowMessageA1 = findViewById(R.id.messagea1);

        //Text from other activities
        ShowMessageA1.setText("Hello "+getIntent().getStringExtra("NAME"));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A2.this, A3.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    //shows input from a3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView resultFromA3 = findViewById(R.id.messagea3);
        if(resultCode == RESULT_OK) {
            resultFromA3.setText("From A3: " + data.getExtras().get("WORD"));
        }
        else if (resultCode == RESULT_CANCELED) {
            resultFromA3.setText("From A3:");
        }
    }

    //Pressing the back button will go to the first activity
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(A2.this, A1.class));
        finish();

    }
}