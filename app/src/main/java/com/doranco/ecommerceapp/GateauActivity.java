package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.doranco.ecommerceapp.adapters.PatissAdapter;
import com.doranco.ecommerceapp.models.Gateau;

import java.util.ArrayList;
import java.util.List;

public class GateauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gateau);

        //Liste des items
        List<Gateau> gateaux = new ArrayList<>();
        gateaux.add(new Gateau("Gâteau multicolore", "multicolore", "Gâteau au chocolat décoré avec des M&M's", 50));
        gateaux.add(new Gateau("Fraisier", "fraisier", "une pâtisserie à base de fraises, de génoise, de crème ", 45));
        gateaux.add(new Gateau("Gâteau chocolat", "chocolat", "une pâtisserie à base de chocolat, de l'intérieur comma à l'extérieur ", 60));
        gateaux.add(new Gateau("Gâteau caramel", "caramel", "Gâteau vanille couvert par une mousse caramel ", 35));
        gateaux.add(new Gateau("Gâteau aux fruits", "fruits", "Gâteau à base de génoise, de crème, décoré avec les fruits aux choix ", 40));

        //get List view
        ListView gateauListView = findViewById(R.id.gateau_list_view);

        gateauListView.setAdapter(new PatissAdapter(this, gateaux));

    }
}