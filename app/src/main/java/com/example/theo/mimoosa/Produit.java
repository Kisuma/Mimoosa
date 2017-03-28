package com.example.theo.mimoosa;

/**
 * Created by théo on 27/03/2017.
 */

public class Produit{
     private int idproduit;
    private String name;
    private String description;
    // private String repas;

    public Produit(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.idproduit = idproduit;
    }
/*
    public String getRepas() {
        return repas;
    }*/
}
