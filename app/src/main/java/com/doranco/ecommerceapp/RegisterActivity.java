package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.doranco.ecommerceapp.bean.Utilisateur;
import com.doranco.ecommerceapp.models.MyDataBase;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_nom, et_prenom, et_tel, et_mail, et_pass, et_adresse;
    private Button btn_create;
    private MyDataBase db;
    private Utilisateur utilisateur;
    private RegisterActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_cupcake);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        db = new MyDataBase(this);

        this.activity = activity;

        this.et_nom = findViewById(R.id.input_name);
        this.et_prenom = findViewById(R.id.input_firstname);
        this.et_tel = findViewById(R.id.input_tel);
        this.et_mail = findViewById(R.id.input_mail);
        this.et_pass = findViewById(R.id.input_mdp);
        this.et_adresse = findViewById(R.id.input_adresse);
        this.btn_create = findViewById(R.id.button_creer_compte);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utilisateur = new Utilisateur();
                utilisateur.setNom(et_nom.getText().toString());
                utilisateur.setPrenom(et_prenom.getText().toString());
                utilisateur.setTelephone(et_tel.getText().toString());
                utilisateur.setEmail(et_mail.getText().toString());
                utilisateur.setPassword(et_pass.getText().toString());
                utilisateur.setAdresse(et_adresse.getText().toString());
                if (utilisateur == null){
                    Toast toast = Toast.makeText(activity, "Merci de remplir les champs nécessaires", Toast.LENGTH_LONG);
                    toast.show();
                }
                db.addUtilisateur(utilisateur);
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}