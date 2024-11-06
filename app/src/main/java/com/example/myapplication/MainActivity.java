package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button rzuc_k;
    private Button reset;

    private TextView zapytanie1;
    private TextView zapytanie2;
    private TextView zapytanie3;
    private TextView zapytanie4;
    private TextView zapytanie5;

    private TextView wynik_L;
    private TextView wynik_G;
    private TextView liczba_RZ;
    private int liczba_rzut = 0;
    private int sum = 0;
    private int sum_gry = 0;
    private ArrayList<Integer> wyn_los;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rzuc_k = findViewById(R.id.rollDiceButton);
        reset = findViewById(R.id.resetButton);

        zapytanie1 = findViewById(R.id.dice1);
        zapytanie2 = findViewById(R.id.dice2);
        zapytanie3 = findViewById(R.id.dice3);
        zapytanie4 = findViewById(R.id.dice4);
        zapytanie5 = findViewById(R.id.dice5);

        wynik_L = findViewById(R.id.rollResultText);
        wynik_G = findViewById(R.id.gameResultText);
        liczba_RZ = findViewById(R.id.rollCountText);
        wyn_los = new ArrayList<>();

        rzuc_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liczba_rzut++;
                liczba_RZ.setText("Liczba rzutów: " + liczba_rzut);

                int[] wyniki = new int[5];
                for (int i = 0; i < 5; i++) {
                    wyniki[i] = random.nextInt(6) + 1;
                    sum += wyniki[i];
                }

                zapytanie1.setText(String.valueOf(wyniki[0]));
                zapytanie2.setText(String.valueOf(wyniki[1]));
                zapytanie3.setText(String.valueOf(wyniki[2]));
                zapytanie4.setText(String.valueOf(wyniki[3]));
                zapytanie5.setText(String.valueOf(wyniki[4]));

                wynik_L.setText("Wynik tego losowania: " + sum);
                sum_gry += sum;
                wynik_G.setText("Wynik gry: " + sum_gry);
                sum = 0;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zapytanie1.setText("?");
                zapytanie2.setText("?");
                zapytanie3.setText("?");
                zapytanie4.setText("?");
                zapytanie5.setText("?");
                liczba_rzut = 0;
                liczba_RZ.setText("Liczba rzutów: " + liczba_rzut);
                sum = 0;
                wynik_L.setText("Wynik tego losowania: " + sum);
                sum_gry = 0;
                wynik_G.setText("Wynik gry: " + sum_gry);
            }
        });
    }
}
