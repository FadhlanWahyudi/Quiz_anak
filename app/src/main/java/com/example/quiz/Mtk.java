package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Mtk extends AppCompatActivity {
    TextView Nanya;
    RadioGroup Group;
    RadioButton A, B, C, D;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] Tanya = new String[]{
            "1. 4 + 3 = ....?",
            "2. 5 + 4 = ... ?",
            "3. 6 + 3 = ...?",
            "4. 10 + 0 = ....",
            "5. Lima apel ditambah dua apel sama dengan .... "
    };

    String[] Jawab = new String[]{
            "6", "7", "8", "9",
            "10", "9", "8", "7",
            "12", "11", "8", "9",
            "10", "100 ", "15 ", "9",
            "Satu apel", "Enam apel", "Tujuh apel", "dua apel",


    };
    String[] JawabanYGBenar = new String[]{
            "7",
            "9",
            "9",
            "10",
            "Tujuh apel",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtk);

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
