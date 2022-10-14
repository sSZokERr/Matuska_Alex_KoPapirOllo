package com.example.matuska_alex_doga;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView elet1, elet2, elet3, eletJ1, eletJ2, eletJ3, playerChose, computerChose, scissors, paper, rock;
    private AlertDialog.Builder builderJatekVege;
    private Random rnd;
    private int eletJatekos, eletGep, draw;
    private TextView dontetlen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChose.setImageResource(R.drawable.rock);
                int machine = rnd.nextInt(4) + 1;
                if (machine == 1){
                    computerChose.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "Dontetlen", Toast.LENGTH_SHORT);
                    draw++;
                    dontetlen.setText("Dontetlenek szam: " + String.valueOf(draw));
                }else if (machine == 2){
                    computerChose.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Vesztettel", Toast.LENGTH_SHORT);
                    eletLevonJatekos();
                }else {
                    computerChose.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Nyertel", Toast.LENGTH_SHORT);
                    eletLevonGep();
                }
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChose.setImageResource(R.drawable.paper);
                int machine = rnd.nextInt(4) + 1;
                if (machine == 1){
                    computerChose.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "Nyertel", Toast.LENGTH_SHORT);
                    eletLevonGep();
                }else if (machine == 2){
                    computerChose.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Dontetlen", Toast.LENGTH_SHORT);
                    draw++;
                    dontetlen.setText("Dontetlenek szam: " + String.valueOf(draw));
                }else {
                    computerChose.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Vesztettel", Toast.LENGTH_SHORT);
                    eletLevonJatekos();
                }
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChose.setImageResource(R.drawable.scissors);
                int machine = rnd.nextInt(4) + 1;
                if (machine == 1){
                    computerChose.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "Vesztettel", Toast.LENGTH_SHORT);
                    eletLevonJatekos();
                }else if (machine == 2){
                    computerChose.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Nyertel", Toast.LENGTH_SHORT);
                    eletLevonGep();
                }else {
                    computerChose.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Dontetlen", Toast.LENGTH_SHORT);
                    draw++;
                    dontetlen.setText("Dontetlenek szam: " + String.valueOf(draw));
                }
            }
        });



    }

    private void init(){
        elet1 = findViewById(R.id.elet1);
        elet2 = findViewById(R.id.elet2);
        elet3 = findViewById(R.id.elet3);
        eletJ1 = findViewById(R.id.elet1);
        eletJ2 = findViewById(R.id.eletG2);
        eletJ3 = findViewById(R.id.eletG3);
        playerChose = findViewById(R.id.playerChose);
        computerChose = findViewById(R.id.computerChose);
        scissors = findViewById(R.id.scissors);
        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        dontetlen = findViewById(R.id.dontetlen);

        rnd = new Random();
        eletJatekos = 3;
        eletGep = 3;
        draw = 0;

        builderJatekVege = new AlertDialog.Builder(MainActivity.this);
        builderJatekVege.setCancelable(false)
                .setTitle("Vesztettel")
                .setMessage("Uj jatek?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                }).create();




    }

    private void ujJatek() {
        eletGep = 3;
        eletJatekos = 3;
        eletJ3.setImageResource(R.drawable.heart2);
        eletJ2.setImageResource(R.drawable.heart2);
        eletJ1.setImageResource(R.drawable.heart2);
        elet3.setImageResource(R.drawable.heart2);
        elet2.setImageResource(R.drawable.heart2);
        elet1.setImageResource(R.drawable.heart2);

    }

    private void eletLevonJatekos(){
        if (eletJatekos == 3){
            eletJ3.setImageResource(R.drawable.heart1);
        }else if (eletJatekos == 2){
            eletJ2.setImageResource(R.drawable.heart1);
        }else{
            eletJ1.setImageResource(R.drawable.heart1);
        }
        eletJatekos--;
        if (eletJatekos == 0){
            builderJatekVege.show();
        }

    }
    private void eletLevonGep(){
        if (eletGep == 3){
            elet3.setImageResource(R.drawable.heart1);
        }else if (eletGep == 2){
            elet2.setImageResource(R.drawable.heart1);
        }else{
            elet1.setImageResource(R.drawable.heart1);
        }
        eletGep--;
        if (eletGep == 0){
            builderJatekVege.setTitle("Nyertel").create();
            builderJatekVege.show();
        }
    }
}