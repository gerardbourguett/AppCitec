package com.gerard.curso.citec.objetos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gerard.curso.citec.R;

import java.util.List;

/**
 * Created by laboratorio on 05-03-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ConstructoraViewHolder>{

    List<Constructora> constructoras;

    public Adapter(List<Constructora> constructoras) {
        this.constructoras = constructoras;
    }

    @Override
    public ConstructoraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
       ConstructoraViewHolder holder = new ConstructoraViewHolder(v);
       return holder;
    }

    @Override
    public void onBindViewHolder(ConstructoraViewHolder holder, int position) {
        Constructora cons = constructoras.get(position);
        holder.tv_rut.setText(cons.getRut());
    }

    @Override
    public int getItemCount() {
        return constructoras.size();
    }

    public static class ConstructoraViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_rut;

        public ConstructoraViewHolder(View itemView) {
            super(itemView);
            tv_rut = itemView.findViewById(R.id.tv_Rut);
        }
    }
}
