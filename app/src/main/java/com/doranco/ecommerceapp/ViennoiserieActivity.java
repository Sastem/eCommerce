package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.doranco.ecommerceapp.adapters.PatissAdapter;
import com.doranco.ecommerceapp.models.Gateau;

import java.util.ArrayList;
import java.util.List;

public class ViennoiserieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viennoiserie);

        //Liste des items
        List<Gateau> viennoiserie = new ArrayList<>();
        viennoiserie.add(new Gateau("Pain au chocolot", "pain_choco", "une viennoiserie constituée d'une pâte levée feuilletée, identique à celle du croissant, rectangulaire et enroulée sur une ou plusieurs barres de chocolat.\n", 1.20));
        viennoiserie.add(new Gateau("Croissant", "croissant", "une viennoiserie constituée d'une pâte levée feuilletée, identique à celle du croissant, rectangulaire et enroulée sur une ou plusieurs barres de chocolat.\n", 1.00));
        viennoiserie.add(new Gateau("Pain aux raisin", "pain_raisin", "une viennoiserie au beurre (13%), à la crème pâtissière (32,5%) et aux raisins secs (10%)\n", 1.30));
        viennoiserie.add(new Gateau("Beignet", "beignet", "Préparation frite composée d'une pâte enrobante et sucrée", 1.25));
        viennoiserie.add(new Gateau("Tartelette à la Ilham", "tartelette", "Faite par Ilham et non pas avec Ilham dedans sinon ce serait du canibalisme !", 99.99));

        //get List view
        ListView viennoiserieListView = findViewById(R.id.viennoiserie_list_view);

        viennoiserieListView.setAdapter(new PatissAdapter(this, viennoiserie));

    }
}