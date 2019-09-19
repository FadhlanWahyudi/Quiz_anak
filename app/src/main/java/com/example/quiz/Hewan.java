package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Hewan extends AppCompatActivity {
    TextView Ques;
    RadioGroup RG;
    RadioButton A1,B1,C1,D1;
    int nomor = 0;
    public static int hasil1,benar1,salah1;

    String[] ues = new String[] {
            "1. Alat Pernafasan Ikan Adalah ?",
            "2. Mamalia Yaitu hewan yg Beranak dengan Cara ?",
            "3. Hewan Pemakan Daging Disebut ?",
            "4. Hewan Laut Yang mengeluarkan Tinta Jika ia Terancam ?",
            "5. Apa Saja Makanan Jerapah ?"

    };
    String[] wab = new String[] {
            "Paru - Paru","Insang","Trakea","Kulit",
            "Bertelur","Melahirkan","Bertelur & Melahirkan","Benar Semua yang Di Atas",
            "Karnivora","Omnivora","Herbivora","Frugivora",
            "Cumi - Cumi","Ubur - Ubur","Ular Laut","Anjing laut",
            "Dedaunan","Daging","Ikan","Pohon"

    };
    String[] nar = new String[]{
            "Insang",
            "Melahirkan",
            "Karnivora",
            "Cumi - Cumi",
            "Dedaunan"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan);
        Ques = findViewById(R.id.Ques);
        RG   = findViewById(R.id.RG);
        A1   = findViewById(R.id.A1);
        B1   = findViewById(R.id.B1);
        C1   = findViewById(R.id.C1);
        D1   = findViewById(R.id.D1);

        Ques.setText(ues[nomor]);
        A1.setText(wab[0]);
        B1.setText(wab[1]);
        C1.setText(wab[2]);
        D1.setText(wab[3]);

        RG.check(0);
        benar1 = 0;
        salah1 = 0;


    }

    public void Lanjut(View view) {
        if (A1.isChecked() || B1.isChecked() || C1.isChecked() || D1.isChecked() ) {
            RadioButton Jawaban = findViewById(RG.getCheckedRadioButtonId());
            String Get_Jawab    = Jawaban.getText().toString();
            RG.check(0);
            if (Get_Jawab.equalsIgnoreCase(nar[nomor])) benar1++;
            else salah1++;
            nomor++;
            if (nomor < ues.length) {
                Ques.setText(ues[nomor]);
                A1.setText(wab[(nomor * 4) + 0]);
                B1.setText(wab[(nomor * 4) + 1]);
                C1.setText(wab[(nomor * 4) + 2]);
                D1.setText(wab[(nomor * 4) + 3]);

            }else {
                hasil1 = benar1 * 20;
                Intent oc = new Intent (getApplicationContext(), HasilKuis.class);
                oc.putExtra("key","hewan");
                oc.putExtra("hasil",hasil1);
                startActivity(oc);
            }


        }
        else {
            Toast.makeText(this, "pilih jawaban dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}
