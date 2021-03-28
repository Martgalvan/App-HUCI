package com.example.navigationdrawerfinal.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawerfinal.Entities.Camas;
import com.example.navigationdrawerfinal.Entities.Information;
import com.example.navigationdrawerfinal.R;

import java.util.ArrayList;

public class AdapterPeople extends RecyclerView.Adapter<AdapterPeople.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Camas> modelo;

    //Listener
    private View.OnClickListener listener;

    public AdapterPeople(Context context, ArrayList<Camas> model){
        this.inflater = LayoutInflater.from(context);
        this.modelo = model;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.gridview, parent, false);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String textoinforma = modelo.get(position).getTextoinforma();
        int idimage = modelo.get(position).getIdimage();

        holder.informationtext.setText(textoinforma);
        holder.imageid.setImageResource(idimage);

    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView informationtext;
        ImageView imageid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            informationtext = itemView.findViewById(R.id.textView5);
            imageid = itemView.findViewById(R.id.imageView3);

        }
    }
}
