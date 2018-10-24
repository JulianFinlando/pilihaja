package com.example.marceljulian.pilihpilihid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowPilihanActivity extends AppCompatActivity {
    private Button btnLihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pilihan);

        btnLihat = (Button)findViewById(R.id.btnLihatSemua);

        Intent intent = getIntent();
        final String smartphone = intent.getStringExtra("smartphone");

        btnLihat.setText("Lihat semua " +smartphone);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowPilihanActivity.this, MainActivity.class);
                intent.putExtra("smartphone", smartphone);
                startActivity(intent);
            }
        });
    }
}
