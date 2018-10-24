package com.example.marceljulian.pilihpilihid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class PilihSmartphoneActivity extends AppCompatActivity {
    Spinner dropMenuHp;
    private DatabaseReference currentUserDb;
    private Button btnPindah;
    private TextView coba;
    private String smartphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_smartphone);

        ArrayAdapter<CharSequence> adapter;

        dropMenuHp = (Spinner)findViewById(R.id.pilihHp);
        btnPindah = (Button)findViewById(R.id.btnPindah);

        adapter = ArrayAdapter.createFromResource(this, R.array.smartphone, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropMenuHp.setAdapter(adapter);

        dropMenuHp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Toast.makeText(getBaseContext(), "Anda memilih "+ parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                smartphone = parent.getSelectedItem().toString();
                //coba.setText(smartphone);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PilihSmartphoneActivity.this, ShowPilihanActivity.class);
                intent.putExtra("smartphone", smartphone);
                startActivity(intent);
                //finish();
            }
        });
    }
}
