package com.example.navigationdrawerfinal.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawerfinal.Entities.Information;
import com.example.navigationdrawerfinal.R;

import java.util.ArrayList;

public class AdapterInfo extends RecyclerView.Adapter<AdapterInfo.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Information> model;

    //Listener
    private View.OnClickListener listener;

    public AdapterInfo(Context context, ArrayList<Information> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_information, parent, false);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre= model.get(position).getNombre();
        String informationtext =model.get(position).getInformationtext();
        int imageid = model.get(position).getImageid();

        holder.nombre.setText(nombre);
        holder.informationtext.setText(informationtext);
        holder.imageid.setImageResource(imageid);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,informationtext;
        ImageView imageid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_info);
            informationtext = itemView.findViewById(R.id.texto_dentro);
            imageid = itemView.findViewById(R.id.imagenInfo);

        }
    }
}
