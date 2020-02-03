package com.dianlahay.kampuspintar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dianlahay.kampuspintar.Adapter.AdapterKampus;
import com.dianlahay.kampuspintar.model.UniversitasModel;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private RecyclerView rvList;

    private Database db;
    private AdapterKampus adapter;
    private List<UniversitasModel> univer = new ArrayList<>();

    TextView greetText;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        db = new Database(this);

        rvList = findViewById(R.id.rv_univ);

        adapter = new AdapterKampus(this);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Menu.this, LinearLayoutManager.HORIZONTAL, false
        );
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);


    }


    @Override
    protected void onResume() {
        super.onResume();
        getUnivtast();
    }

    private void getUnivtast() {
        univer = db.getUniv();
        adapter.setUniver(univer);
    }
}