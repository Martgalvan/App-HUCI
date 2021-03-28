package com.example.navigationdrawerfinal.Fragments;

import android.app.Person;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawerfinal.Entities.Information;
import com.example.navigationdrawerfinal.R;

public class DetalleInfo extends Fragment {
    TextView nombreDetalle;
    ImageView imagenDetalle;
    TextView infoText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalle_info_fragment,container,false);
        //recibir el objeto
        nombreDetalle = view.findViewById(R.id.title);
        imagenDetalle = view.findViewById(R.id.imagenDetalle);
        infoText = view.findViewById(R.id.actual_info);

        //Crear objeto Bundle para recibir el objeto enviado
        Bundle objetoPersona = getArguments();
        Information information = null;

        //validar si existen argumentos
        if(objetoPersona != null){
            information = (Information) objetoPersona.getSerializable("objeto");
            if(information.getNombre()=="Ingreso en UCI"){
                //Establecer los datos en las vistas

                nombreDetalle.setText(information.getNombre());
                imagenDetalle.setImageResource(information.getImageid());
                infoText.setText("Su familiar ha ingresado en la Unidad de Cuidados Intensivos porque precisa vigilancia o tratamientos específicos. Esto supone el empleo de diversos moonitores que permiten vigilar continuamente la situación del paciente y de otros aparatos que pueden sustituir la función de alguno de los órganos afectados por la enfermedad.\n\n" +
                        "El paciente ingresado en la UCI es atendido por médicos especialistas en Medicina Intensiva, personal de enfermería experto y otro personal de apoyo, que garantiza una asistencia continuada las 24 horas del día.\n\n" +
                        "Dependiendo de su nivel de gravedad, su familiar puede ser ingresado en la UCI o en la URPA, o ser trasladado entre ambas unidades, siempre atendido por el personal de Medicina Intensiva y manteniendo los mismos horarios y normas. \n\n" +
                        "Por las características especiales del paciente crítico, el diseño y las normas de funcionamiento de la UCI son distintas a otras plantas de hospitalización.");

            }
            if(information.getNombre()=="Horarios Visitas"){
                //Establecer los datos en las vistas

                nombreDetalle.setText(information.getNombre());
                imagenDetalle.setImageResource(information.getImageid());
                infoText.setText("Las visitas en la UCI estan permitidas en dos periodos:\n" +
                        "-Entre las 11 y 14 horas\n"+"-Entre las 18 y 21 horas\n\n"+
                        "De 13 a 14 y de 18 a 19 horas podrán pasar a la UCI hasta cuatro personas, en turnos de dos. Durante el resto del tiempo solo podrá acceder una persona.\n\n"+ "Estos horarios podrán ser odificados en función de las necesidades de los pacientes.\n\n"+
                        "En lo momentos en los que haya un ingreso en la unidad, le pediremos que espere en la sala de espera\n\n"+"No se recomienda la entrada de niños a la UCI.");

            }
            if(information.getNombre()=="Información a familiares"){
                //Establecer los datos en las vistas

                nombreDetalle.setText(information.getNombre());
                imagenDetalle.setImageResource(information.getImageid());
                infoText.setText("El personal que atiende a su familiar le ofrecerá periódicamente información sobre su evolución:\n\n"
                +"• En el momento del ingreso.\n"+"• Entre las 8 y 8.30 de la mañana, el enfermero responsable del paciente realizará una llamada al familiar, para aportar información general sobre su estado. En ningún caso se dará información médica por teléfono ni se atenderán llamadas externas.\n" +
                        "• El médico responsable del paciente les inormar´todas las mañanas alrededor de las 13 horas. Por fvor, pregunte todo lo que necesite y no se quede con dudas.\n\n"+
                        "Si le resulta imposible recibir la información médica n ese horario, consulte con el personal las posibles alternativas.\n\n"+
                        "No olvide dejar, en el momento del ingreso, un teléfono de contacto, siempre operativo, a la enfermera responsable del paciente.");

            }
            if(information.getNombre()=="¿Cómo puedo colaborar?"){
                //Establecer los datos en las vistas

                nombreDetalle.setText(information.getNombre());
                imagenDetalle.setImageResource(information.getImageid());
                infoText.setText("* Informe al personal si su familiar usa gafas, audífonos, prótesis dentales o aparatos de terapia respiratoria domiciliaria. Le solicitaremo que los traiga cuando sea necesario. \n\n" +
                        "* Antes de entrar a la UCI, asegurese de silenciar su teléfono móvil. Evite usarlo dentro de la UCI. \n\n" +
                        "* Al entrar y salir, realice una correcta higiene de manos según le indique el personal. \n\n" +
                        "* Algunos pacientes se encuentran bajo aislamiento preventivo, para evitar la posible transmisión de infecciones a oros enfermos. SI es el caso de su familiar, utilice bata y guantes según se le indique.\n\n" +
                        "* Para preservar la privacidad de los pacientes, manténgase en le box de su familiar (marcado en el suelo con líneas amarillas) y no deambule por la UCI.\n\n" +
                        "* Durante la visita, mantenga un tono de voz calmado y evite ruidos innecesarios. \n\n" +
                        "* No manipule los distintos dispositivos, vías y apartos. Si el paciente requiere muñequeras, no las retire sin preuntar a su enfermero.\n\n" +
                        "* Es posible que escuche o vea alarmas en el monitor de su familiar. El personal le alertará si hay algún problema. En caso contrario no debe preocuparse.\n\n" +
                        "* Hable con su familiar si lo desea. Independientemente de su estado, resultará beneficioso para él. \n\n" +
                        "* No traiga bebida o comida a su familiar sin conssultar con el personal que le atiende.\n\n" +
                        "* Si su familiar ha firmado un documento de Instrucciones Previas, comuníqueselo al personal que le atiende.\n\n" +
                        "* Si desea asistecia religiosa, comuíqueselo al personal de la UCI.\n\n" +
                        "* Por favor, siga siempre las indicaciones del personal de la unidad. GRACIAS.");

            }
            if(information.getNombre()=="Síndrome Post-UCI"){
                //Establecer los datos en las vistas

                nombreDetalle.setText(information.getNombre());
                imagenDetalle.setImageResource(information.getImageid());
                infoText.setText("Entre el 25 y el 50% de los pacientes que han sufrido una enfermedad crítica y un ingreso prolongado en UCI pueden presentar al alta diversas secuelas englobadas en el llamado síndrome postUCI.\n\n"+
                        "Constituyen síntomas frecuentes y que, en general, se recuperan completamente en un tiempo más o menos largo:\n"+
                        "• Debilidad muscular, pérdida de masa muscular y déficit en la movilidad fina (dedos de las manos...).\n"+ "• Dificultad para concentrarse.\n" +
                        "• Fatiga persistente o con esfuerzos menores a lo habitual.\n" + "• Problemas para conciliar el sueño y presencia de pesadillas, en ocasiones rememorando circunstancias del ingreso.\n"+
                        "• Dolores musculoesqueléticos.\n"+ "• Ansiedad y ánimo depresivo.\n\n"+ "Tras un ingreso en la UCI, también los familiares más cercanos pueden sufrir síntomas de ansiedad, depresión y trastornos del sueño.\n\n"+
                        "La mayoría de los síntomas desaparecerán en semanas, aunque cierto nivel de debilidad muscular, ánimo decaído y alteraciones del sueño pueden permanecer por más tiempo. Busque ayuda si considera que su ánimo es excesivamente bajo o si esta situación se prolonga durante demasiado tiempo.");

            }
            if(information.getNombre()=="Signos de Alerta"){
                //Establecer los datos en las vistas

                nombreDetalle.setText(information.getNombre());
                imagenDetalle.setImageResource(information.getImageid());
                infoText.setText("Debe solicitar ayuda médica siempre que el paciente presente alguno de los siguientes signos de alerta:\n\n"+
                        "- Problemas neurológicos que aparecen o empeoran tras el alta.\n"+"- Problemas con los dispositivos (obstrucción de cánulas de traqueostomía, sangrado...).\n"+
                "- Signos de infección o dificultad respiratoria.\n"+"- Aparición de úlceras en pacientes inmovilizados.\n" +
                                "- Trastornos psicológicos que aparecen tras el alta.\n"+
                                "- Ánimo excesivamente decaído o que se prolonga en el tiempo.\n" + "- Dificultad prolongada para conciliar el sueño.\n"+
                "Y ante cualquier problema de salud que le resulte preocupante.");

            }



        }



        return view;
    }
}
