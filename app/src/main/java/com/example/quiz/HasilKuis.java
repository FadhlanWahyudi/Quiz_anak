package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HasilKuis extends Activity {

    String Kunci,Hasil;

    @Override
    protected void onCreate(Bundle  savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        TextView nilai = findViewById(R.id.nilai);
        TextView total = findViewById(R.id.hasil);
        Kunci = getIntent().getStringExtra("key");
        Hasil = getIntent().getStringExtra("hasil");
                getSupportActionBar().setDisplayShowHomeEnabled(true);


        if (Kunci.equals("indo")) {
            nilai.setText("Benar :" + Indo.benar + "\nSalah :"+Indo.salah);
            total.setText("" + Indo.hasil);
        }else if (Kunci.equals("hewan")) {
            nilai.setText("Benar : " + Hewan.benar1 + "\nSalah : "+Hewan.salah1);
            total.setText("" + Hewan.hasil1);
        }


    }

    public void ulang(View view){
        if (Kunci.equals("indo")) {
            Intent i = new Intent(getApplicationContext(), Indo.class);
            startActivity(i);
        }
        else if (Kunci.equals("hewan")) {
            Intent a = new Intent(getApplicationContext(), Hewan.class);
            startActivity(a);
        }

    }

    public void ganti(View view){
        Intent o = new Intent(HasilKuis.this,Menu_Game.class);
        startActivity(o);
        finish();
    }


}
