package com.example.marceljulian.pilihpilihid;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailSmartphoneActivity extends AppCompatActivity {
    private TextView txvMerkHpdet, txvTypedet, txvRamdet, txvOsdet, txvLayardet, txvCpudet, txvBateraidet, txvKameradet, txvChipset, txvGpu, txvKameraDpn, txvInternal;
    private ImageView gambarhpDet;
    private DatabaseReference databaseHp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_smartphone);

        txvMerkHpdet = (TextView)findViewById(R.id.txvMerkHpdet);
        txvTypedet = (TextView)findViewById(R.id.txvTypeHpdet);
        txvRamdet = (TextView)findViewById(R.id.txvTypeRamdet);
        txvOsdet = (TextView)findViewById(R.id.txvTypeOsdet);
        txvLayardet = (TextView)findViewById(R.id.txvTypeLayardet);
        txvCpudet = (TextView)findViewById(R.id.txvTypeCpudet);
        txvBateraidet = (TextView)findViewById(R.id.txvTypeBateraidet);
        txvKameradet = (TextView)findViewById(R.id.txvTypeKameradet);
        gambarhpDet = (ImageView)findViewById(R.id.gambarHpdet);
        txvChipset = (TextView)findViewById(R.id.chipset);
        txvGpu = (TextView)findViewById(R.id.txvgpu);
        txvKameraDpn = (TextView)findViewById(R.id.txvkameraDpn);
        txvInternal = (TextView)findViewById(R.id.txvinternal);
        showHp();
    }

    private void showHp(){
        Intent intent = getIntent();
        final String type = intent.getStringExtra("type");
        databaseHp = FirebaseDatabase.getInstance().getReference("smartphone");
        Query query = databaseHp.orderByChild("type").equalTo(type);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot smartphoneSnapshot : dataSnapshot.getChildren()) {
                        if (smartphoneSnapshot!=null) {
                            txvMerkHpdet.setText(smartphoneSnapshot.getValue(Smartphone.class).getMerk());
                            txvTypedet.setText(smartphoneSnapshot.getValue(Smartphone.class).getType());
                            txvRamdet.setText(smartphoneSnapshot.getValue(Smartphone.class).getRam());
                            txvOsdet.setText(smartphoneSnapshot.getValue(Smartphone.class).getOs());
                            txvLayardet.setText(smartphoneSnapshot.getValue(Smartphone.class).getLayar());
                            txvCpudet.setText(smartphoneSnapshot.getValue(Smartphone.class).getCpu());
                            txvBateraidet.setText(smartphoneSnapshot.getValue(Smartphone.class).getBaterai());
                            txvKameradet.setText(smartphoneSnapshot.getValue(Smartphone.class).getKamera());
                            txvChipset.setText(smartphoneSnapshot.getValue(Smartphone.class).getChipset());
                            txvInternal.setText(smartphoneSnapshot.getValue(Smartphone.class).getInternal());
                            txvGpu.setText(smartphoneSnapshot.getValue(Smartphone.class).getGpu());
                            txvKameraDpn.setText(smartphoneSnapshot.getValue(Smartphone.class).getKameradpn());
                            Picasso.get().load(smartphoneSnapshot.getValue(Smartphone.class).getGambarHpUrl()).into(gambarhpDet);
                        }
                    }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });
    }
}
