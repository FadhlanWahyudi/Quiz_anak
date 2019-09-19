package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Indo extends AppCompatActivity {
    TextView Nanya;
    RadioGroup Group;
    RadioButton A, B, C, D;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] Tanya = new String[]{
            "1. Negara INDONESIA Dijajah Oleh Negara Jepang Berapa Tahun ?",
            "2. Kota Jakarta Sebelum Berubah Nama Menjadi Kota Jakarta Yang Bukan Adalah ?",
            "3. Negara INDONESIA Merdeka Pada Tanggal ?",
            "4. Presiden Republik INDONESIA Yang Pertama Adalah",
            "5. Lambang Negara INDONESIA"
    };

    String[] Jawab = new String[]{
            "5,4 Tahun", "7,5 Tahun", "10,7 Tahun", "3,5 Tahun",
            "Batavia", "Sunda Kelapa", "Jayakarta", "India - Australia",
            "1947", "1939", "1945", "1950",
            "Soeharto", "SBY", "Soekarno", "B.J.Habiebie",
            "Burung Garuda", "Burung Merak", "Burung Merpati", "Burung Jalak",


    };

    String[] JawabanYGBenar = new String[]{
            "3,5 Tahun",
            "India - Australia",
            "1945",
            "Soekarno",
            "Burung Garuda",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indo);
        Group =  findViewById(R.id.Group);

        Nanya =  findViewById(R.id.Nanya);

        A =  findViewById(R.id.A);

        B =  findViewById(R.id.B);

        C =  findViewById(R.id.C);

        D =  findViewById(R.id.D);

        Nanya.setText(Tanya[nomor]);
        A.setText(Jawab[0]);
        B.setText(Jawab[1]);
        C.setText(Jawab[2]);
        D.setText(Jawab[3]);

        Group.check(0);
        benar = 0;
        salah = 0;

    }


    public void next(View view) {
        if (A.isChecked() || B.isChecked() || C.isChecked() || D.isChecked()) {
            RadioButton Jawaban =  findViewById(Group.getCheckedRadioButtonId());
            String Ambil_Jawaban = Jawaban.getText().toString();
            Group.check(0);
            if (Ambil_Jawaban.equalsIgnoreCase(JawabanYGBenar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < Tanya.length) {
                Nanya.setText(Tanya[nomor]);
                A.setText(Jawab[(nomor * 4) + 0]);
                B.setText(Jawab[(nomor * 4) + 1]);
                C.setText(Jawab[(nomor * 4) + 2]);
                D.setText(Jawab[(nomor * 4) + 3]);

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