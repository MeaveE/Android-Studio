package com.example.eileenrattigan.lab1;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView TxtView = findViewById((R.id.TxtView));
        ImageButton playCatMeow = findViewById(R.id.playCatMeow);


        playCatMeow.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View V){
                TxtView.setText("Trick or Treat?");
            }
        });

    }

    }

