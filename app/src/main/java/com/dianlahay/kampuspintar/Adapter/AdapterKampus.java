package com.dianlahay.kampuspintar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dianlahay.kampuspintar.Database;
import com.dianlahay.kampuspintar.DetailUniv;
import com.dianlahay.kampuspintar.R;
import com.dianlahay.kampuspintar.model.UniversitasModel;

import java.util.ArrayList;
import java.util.List;


public class AdapterKampus extends RecyclerView.Adapter<AdapterKampus.ViewHolder> {
    private Database db;
    private Context context;
    private List<UniversitasModel> univer;

    public AdapterKampus(Context context) {
        this.context = context;
        this.univer = new ArrayList<>();
    }

    public void setUniver(List<UniversitasModel> univer) {
        this.univer = univer;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_universitas, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        final Integer[] kampus = {R.drawable.itb, R.drawable.ugm, R.drawable.ipb, R.drawable.its, R.drawable.ui};

        final UniversitasModel universitasModel = univer.get(i);
        viewHolder.tvNama.setText(universitasModel.getNamaUniversitas());
        viewHolder.tvAkreditas.setText(universitasModel.getAkreditas());
        viewHolder.tvStatus.setText(universitasModel.getStatus());

        final int a = i;
        final int idx = universitasModel.getId();
        viewHolder.ivlogo.setImageResource(kampus[idx-1]);

        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final UniversitasModel kampus = univer.get(a);
                Intent intent = new Intent(context, DetailUniv.class);
                intent.putExtra("nama", kampus.getNamaUniversitas());
                intent.putExtra("akreditas", kampus.getAkreditas());
                intent.putExtra("status", kampus.getStatus());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return univer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvNama, tvAkreditas, tvStatus;
        ImageView ivlogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItem = itemView.findViewById(R.id.cv_item);
            tvNama = itemView.findViewById(R.id.tv_title);
            tvAkreditas = itemView.findViewById(R.id.tv_akreditas);
            tvStatus = itemView.findViewById(R.id.tv_status);
            ivlogo = itemView.findViewById(R.id.logo);


        }
    }
}
