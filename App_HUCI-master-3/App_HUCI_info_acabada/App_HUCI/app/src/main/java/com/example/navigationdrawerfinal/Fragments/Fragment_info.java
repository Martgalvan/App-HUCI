package com.example.navigationdrawerfinal.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawerfinal.Adaptadores.AdapterInfo;
import com.example.navigationdrawerfinal.Entities.Information;
import com.example.navigationdrawerfinal.R;
import com.example.navigationdrawerfinal.iComunicateFragment;

import java.util.ArrayList;

public class Fragment_info extends Fragment{

    AdapterInfo adapterInfo;
    RecyclerView recyclerViewPersonas;
    ArrayList<Information> listaInformation;

    //referencias pra comunicar fragments
    Activity activity;
    iComunicateFragment interfaceComunicateFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment,container,false);
        recyclerViewPersonas = view.findViewById(R.id.recyclerView);
        listaInformation = new ArrayList<>();

        // cargar la lista

        chargeList();

        //mostrar los datos
        showData();
        return view;
    }
    public void chargeList(){
        listaInformation.add(new Information("Ingreso en UCI","Información sobre causas de ingreso en UCI.",R.drawable.ingreso));
        listaInformation.add(new Information("Horarios Visitas","Información extensa sobre horarios y número de personas permitidas en la UCI como visitantes.",R.drawable.reloj));
        listaInformation.add(new Information("Información a familiares","Información sobre cuando reibirá datos sobre la evolución de su familiar. Es necesario dejar un télefono de contacto.",R.drawable.familiares));

        listaInformation.add(new Information("¿Cómo puedo colaborar?","Información sobre distintos datos a facilitar con finalidad de ayudar a los profesionales en el cuidado del paciente.",R.drawable.colaborar));
        listaInformation.add(new Information("Síndrome Post-UCI","Información sobre qué es el síndrome post-UCI y como se presenta.",R.drawable.post_uci));
        listaInformation.add(new Information("Signos de Alerta","Información sobre distintos problemas que pueden ser de alerta.",R.drawable.alerta));

        //añadir todos
    }
    public void showData(){
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext())); //estamos en un fragment
        adapterInfo = new AdapterInfo(getContext(), listaInformation);
        recyclerViewPersonas.setAdapter(adapterInfo);

        adapterInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = listaInformation.get(recyclerViewPersonas.getChildAdapterPosition(view)).getNombre();
                Toast.makeText(getContext(),"Ha seleccionado"+ nombre,Toast.LENGTH_SHORT).show();
                interfaceComunicateFragment.sendPeople(listaInformation.get(recyclerViewPersonas.getChildAdapterPosition((view))));
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicateFragment = (iComunicateFragment) this.activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
