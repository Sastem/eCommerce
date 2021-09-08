package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.doranco.ecommerceapp.adapters.PanierAdapter;
import com.doranco.ecommerceapp.adapters.PatissAdapter;
import com.doranco.ecommerceapp.bean.Gateau;

import java.util.ArrayList;
import java.util.List;

public class PanierActivity extends AppCompatActivity {

    Button btn_validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier_activity);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_cupcake);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Liste des items
        List<Gateau> gateauxAchete = new ArrayList<>();

        //get List view
        ListView gateauAcheteListView = findViewById(R.id.recycler_panier);

        gateauAcheteListView.setAdapter(new PanierAdapter(this, gateauxAchete));

        this.btn_validate = findViewById(R.id.btn_confirmcart);

        btn_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LastActivity.class);
                startActivity(intent);
            }
        });
    }
}