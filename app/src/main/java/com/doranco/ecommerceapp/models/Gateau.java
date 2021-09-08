package com.doranco.ecommerceapp.models;

public class Gateau {
    private String nom, description, mnemonic,type;
    private double prix;
    private Integer id;
    private Double stock;

    public Gateau(Integer id, String type, String nom, double prix, Double stock) {
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }


    public Gateau(String nom, String mnemonic, String description, double prix) {
        this.nom = nom;
        this.mnemonic = mnemonic;
        this.description = description;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
