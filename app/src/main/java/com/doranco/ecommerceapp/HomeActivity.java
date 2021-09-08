package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnViennoiserie;
    Button btnPatisserie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_cupcake);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        this.btnPatisserie = findViewById(R.id.btn_patisserie);
        this.btnViennoiserie = findViewById(R.id.btn_viennoiserie);

        btnPatisserie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GateauActivity.class);
                startActivity(intent);
            }
        });

        btnViennoiserie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViennoiserieActivity.class);
                startActivity(intent);
            }
        });



    }
}