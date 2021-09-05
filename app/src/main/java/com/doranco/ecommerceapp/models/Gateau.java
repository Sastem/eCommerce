package com.doranco.ecommerceapp.models;

public class Gateau {
    private String nom, description, mnemonic;
    private double prix;

    public Gateau(String nom, String mnemonic,String description, double prix) {
        this.nom = nom;
        this.mnemonic = mnemonic;
        this.description = description;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
}
