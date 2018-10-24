package com.example.marceljulian.pilihpilihid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //ListView listViewSmatphone;
    GridView gridSmartphone;
    private String Merk;
    List<Smartphone> smartphoneList;
    private DatabaseReference databaseHp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listViewSmatphone = (ListView)findViewById(R.id.listSmartphone);
        gridSmartphone = (GridView)findViewById(R.id.gridView);
        smartphoneList = new ArrayList<>();

    }

    protected void onStart() {
        Intent intent = getIntent();
        final String smartphone = intent.getStringExtra("smartphone");

        databaseHp = FirebaseDatabase.getInstance().getReference("smartphone");
        Query query = databaseHp.orderByChild("merk").equalTo(smartphone);
        super.onStart();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                smartphoneList.clear();
                for(DataSnapshot smartphoneSnapshot : dataSnapshot.getChildren()){
                    Smartphone smartphone = smartphoneSnapshot.getValue(Smartphone.class);
                    smartphoneList.add(smartphone);

                }
                SmartphoneList adapter = new SmartphoneList(MainActivity.this, smartphoneList);
                gridSmartphone.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
