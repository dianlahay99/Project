package com.dianlahay.kampuspintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailUniv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView a,b,c;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_univ);

        a = (TextView)findViewById(R.id.nama);
        b = (TextView)findViewById(R.id.jenis);
        c = (TextView)findViewById(R.id.status);
        Intent i =getIntent();
        String d = i.getStringExtra("nama");
        String e = i.getStringExtra("akreditas");
        String f = i.getStringExtra("status");
        a.setText(d);
        b.setText(e);
        c.setText(f);
    }
}
