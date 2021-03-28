package com.example.navigationdrawerfinal.Entities;

import java.io.Serializable;

public class Camas implements Serializable {
    private String textoinforma;
    private int idimage;


    public Camas(){

    }
    public Camas( String textoinforma, int imageid) {
        this.textoinforma = textoinforma;
        this.idimage = idimage;
    }


    public String getTextoinforma() {
        return textoinforma;
    }

    public void setTextoinforma(String camas) {
        this.textoinforma = camas;
    }

    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int imageid) {
        this.idimage = idimage;
    }
}
