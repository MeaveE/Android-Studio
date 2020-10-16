package com.example.eileenrattigan.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {//implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);


        //button1.setOnClickListener(new View.OnClickListener() {
          /*  @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Snap shot",
                        Toast.LENGTH_LONG).show();
            }
        });  */

        Button button2 = findViewById(R.id.button2);


       // button2.setOnClickListener(new View.OnClickListener() {
          /*  @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Jazz hands",
                        Toast.LENGTH_LONG).show();
            }
        });*/
    }


    public void showToast(View v){
        Toast.makeText(getApplicationContext(),"Poison apple cider",
                Toast.LENGTH_LONG).show();
    }

    public void playToast(View v){
        Toast.makeText(getApplicationContext(),"Sugar Cubes!",
                Toast.LENGTH_LONG).show();
    }
    //@Override

   /* public void onClick(View v){
        if(v.getId() == R.id.button1)
        Toast.makeText(getApplicationContext(),"Button1 is clicked",
               Toast.LENGTH_LONG).show();
        else{
            Toast.makeText(getApplicationContext(),"Button2 here",
                    Toast.LENGTH_LONG).show();
        }

    }*/


}
