package com.example.crud.Adapter;

import com.example.crud.Model.dataModel;
import com.example.crud.R;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterData extends RecyclerView.Adapter<adapterData.holderData>{
    private Context ctx;
    private List<dataModel> lisMhs;

    public adapterData(Context ctx, List<dataModel> lisMhs) {
        this.ctx = ctx;
        this.lisMhs = lisMhs;
    }

    @NonNull
    @Override
    public holderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        holderData holder = new holderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holderData holder, int position) {
        dataModel dm = lisMhs.get(position);
        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNama.setText(String.valueOf(dm.getNama()));
        holder.tvNim.setText(String.valueOf(dm.getNim()));
        holder.tvAngkatan.setText(String.valueOf(dm.getAngkatan()));
    }

    @Override
    public int getItemCount() {
        return lisMhs.size();
    }

    public class holderData extends RecyclerView.ViewHolder{
        TextView tvId, tvNama, tvNim, tvAngkatan;

        public holderData(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvw_id);
            tvNama = itemView.findViewById(R.id.tvw_nama);
            tvNim = itemView.findViewById(R.id.tvw_nim);
            tvAngkatan = itemView.findViewById(R.id.tvw_angkatan);

        }
    }
}
