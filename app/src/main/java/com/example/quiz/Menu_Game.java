package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Menu_Game extends AppCompatActivity {
    CardView indo,mtk,hewan,buah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__game);

        indo  = findViewById(R.id.indo);
        mtk   = findViewById(R.id.mtk);
        hewan = findViewById(R.id.hewan);
        buah  = findViewById(R.id.buah);


        indo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ndo = new Intent(Menu_Game.this,Indo.class);
                startActivity(ndo);
            }
        });

        hewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wan = new Intent(Menu_Game.this,Hewan.class);
                startActivity(wan);
            }
        });
        buah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buah = new Intent(Menu_Game.this,Buah.class);
                startActivity(buah);
            }
        });
        mtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mtk = new Intent(Menu_Game.this,Mtk.class);
                startActivity(mtk);
            }
        });
    }
}
