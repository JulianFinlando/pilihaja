package com.example.marceljulian.pilihpilihid;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SmartphoneList extends ArrayAdapter<Smartphone> {
    private Activity context;
    Button btnDetail;
    private List<Smartphone> smartphoneList;

    public  SmartphoneList(Activity context, List<Smartphone> smartphoneList){
        super(context, R.layout.list_layout,smartphoneList);
        this.context = context;
        this.smartphoneList = smartphoneList;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView txvMerk = (TextView) listViewItem.findViewById(R.id.txvMerkHp);
        TextView txvType = (TextView) listViewItem.findViewById(R.id.txvTypeHp);
        ImageView gambarHp = (ImageView)listViewItem.findViewById(R.id.gambarHp);
        btnDetail = (Button)listViewItem.findViewById(R.id.btnDetail);
        Smartphone smartphone = smartphoneList.get(position);

        txvMerk.setText(smartphone.getMerk());
        txvType.setText(smartphone.getType());
        /*txvRam.setText("Ram "+smartphone.getRam());
        txvBaterai.setText("Baterai "+smartphone.getBaterai());
        txvCpu.setText("CPU "+smartphone.getCpu());
        txvLayar.setText("Layar "+smartphone.getLayar());
        txvOs.setText("OS "+smartphone.getOs());
        txvKamera.setText("Kamera "+smartphone.getKamera());*/
        Picasso.get().load(smartphone.getGambarHpUrl()).into(gambarHp);

        final String type = smartphone.getType().toString().trim();

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"kontol "+type,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), DetailSmartphoneActivity.class);
                intent.putExtra("type", type);
                context.startActivity(intent);
            }
        });

        return listViewItem;
    }

}
