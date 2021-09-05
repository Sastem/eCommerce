package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button btnVinoiserie;
    Button btnPatisserie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.btnPatisserie = findViewById(R.id.btn_patisserie);
        this.btnVinoiserie = findViewById(R.id.btn_vinoiserie);

        btnPatisserie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GateauActivity.class);
                startActivity(intent);
            }
        });


    }
}