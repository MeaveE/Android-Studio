package com.example.eileenrattigan.wish_app;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button lamp = findViewById(R.id.button);
        lamp.setVisibility(View.VISIBLE);

        final ImageView geni = findViewById(R.id.imageView2);
        geni.setVisibility(View.GONE);

        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lamp.setVisibility(View.GONE);
                geni.setVisibility(View.VISIBLE);

                getResponce();

            }
        });

    }

    public void getResponce()
    {
        int random = new Random().nextInt(10)+1;
        System.out.println(random);
        switch(random){
            case 1:
                if(random>=8 && random<=10 ){
                    Toast.makeText(getApplicationContext(),"your wish will come true!",
                            Toast.LENGTH_LONG).show();
                }
            case 2:
                if(random>=6 && random<=8){
                    Toast.makeText(getApplicationContext(),"your wish will come true with time",
                            Toast.LENGTH_LONG).show();
                }
            case 3:
                if(random>=4 && random<=6){
                    Toast.makeText(getApplicationContext(),"maybe keep wishing for it",
                            Toast.LENGTH_LONG).show();
                }
            case 4:
                if(random>=4 && random<=0){
                    Toast.makeText(getApplicationContext(),"your wish will not come true this time but keep wishing",
                            Toast.LENGTH_LONG).show();
                }
                default:
                    Toast.makeText(getApplicationContext(),"the answer is unclear try again later",
                        Toast.LENGTH_LONG).show();
        }
    }

}
