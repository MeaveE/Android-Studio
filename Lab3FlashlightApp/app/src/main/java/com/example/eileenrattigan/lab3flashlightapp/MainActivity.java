package com.example.eileenrattigan.lab3flashlightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Button button1 = findViewById(R.id.button1);

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"Button1 is clicked",
                Toast.LENGTH_LONG).show();
    }
}
