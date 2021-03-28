package com.example.navigationdrawerfinal.Entities;

import java.io.Serializable;

public class Information implements Serializable {
    private String nombre;
    private String informationtext;
    private int imageid;


    public Information(){

    }
    public Information(String nombre, String informationtext, int imageid) {
        this.nombre = nombre;
        this.informationtext = informationtext;
        this.imageid = imageid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformationtext() {
        return informationtext;
    }

    public void setInformationtext(String information) {
        this.informationtext = information;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
