package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Buah extends AppCompatActivity {
    TextView Nanya;
    RadioGroup Group;
    RadioButton A2, B2, C2, D2;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] Tanya = new String[]{
            "1. Kulit nya Hijau Dalemnya merah manis rasanya apakah itu?",
            "2. Luarnya Keras dan bisa membuat luka Dalamnya empuk dan manis  ?",
            "3. Luarnya kuning dalamnya putih buah apakah itu ?",
            "4. Buah Yang Berambut",
            "5. Buah apa yang kaya "
    };

    String[] Jawab = new String[]{
            "Semangka", "durian", "jambu", "salah semua yg di atas",
            "Durian", "Semangka", "Kelapa", "Melon",
            "Pisang", "jeruk", "klengkeng", "Jambu",
            "Rambutan", "papaya ", "Semangka ", "Jambu",
            "srikaya", "Sirsak", "Jambu", "Mangga",


    };
    String[] JawabanYGBenar = new String[]{
            "Semangka",
            "Duren",
            "Pisang",
            "Rambutan",
            "srikaya",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah);

        Group =  findViewById(R.id.Group);

        Nanya =  findViewById(R.id.Nanya);

        A2 =  findViewById(R.id.A2);

        B2 =  findViewById(R.id.B2);

        C2 =  findViewById(R.id.C2);

        D2 =  findViewById(R.id.D2);

        Nanya.setText(Tanya[nomor]);
        A2.setText(Jawab[0]);
        B2.setText(Jawab[1]);
        C2.setText(Jawab[2]);
        D2.setText(Jawab[3]);

        Group.check(0);
        benar = 0;
        salah = 0;

    }


    public void next(View view) {
        if (A2.isChecked() || B2.isChecked() || C2.isChecked() || D2.isChecked()) {
            RadioButton Jawaban =  findViewById(Group.getCheckedRadioButtonId());
            String Ambil_Jawaban = Jawaban.getText().toString();
            Group.check(0);
            if (Ambil_Jawaban.equalsIgnoreCase(JawabanYGBenar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < Tanya.length) {
                Nanya.setText(Tanya[nomor]);
                A2.setText(Jawab[(nomor * 4) + 0]);
                B2.setText(Jawab[(nomor * 4) + 1]);
                C2.setText(Jawab[(nomor * 4) + 2]);
                D2.setText(Jawab[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent ok = new Intent(getApplicationContext(), HasilKuis.class);
                ok.putExtra("key","indo");
                ok.putExtra("hasil",hasil);
                startActivity(ok);

            }


        }
        else {
            Toast.makeText(this, "Pilih Jawaban dahulu", Toast.LENGTH_SHORT).show();
        }
    }

}
