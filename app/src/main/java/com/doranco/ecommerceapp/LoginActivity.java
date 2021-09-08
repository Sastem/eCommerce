package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.doranco.ecommerceapp.bean.Utilisateur;
import com.doranco.ecommerceapp.models.MyDataBase;

public class LoginActivity extends AppCompatActivity {

    private TextView txt_Create;
    private EditText et_login, et_pass;
    private Button btn_cnx;
    private MyDataBase db;
    private LoginActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.db = new MyDataBase(this);

        this.activity = this;

        this.et_login = findViewById(R.id.edit_login);
        this.et_pass = findViewById(R.id.edit_password);
        this.txt_Create = findViewById(R.id.txt_create_account);
        this.btn_cnx = findViewById(R.id.btn_connexion);

        txt_Create.setMovementMethod(LinkMovementMethod.getInstance());
        txt_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_cnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_login.getText().toString().isEmpty() && !et_pass.getText().toString().isEmpty() && seConnecter()) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else if (et_login.getText().toString().isEmpty() || et_pass.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(activity, "Merci de remplir les deux champs !", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(activity, "Login ou Mot de passe incorrect(s). Merci de créer un compte si vous en avez pas !", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

    public boolean seConnecter() {
        Utilisateur utilisateur = new Utilisateur();
        if (et_login.getText().toString().contains("@")) {
            utilisateur = db.getUtilisateurByEmail(et_login.getText().toString());
            if (utilisateur != null && utilisateur.getPassword().equals(et_pass.getText().toString())) {
                return true;
            }
        }
        utilisateur = db.getUtilisateurByTelephone(et_login.getText().toString());
        if (utilisateur != null && utilisateur.getPassword().equals(et_pass.getText().toString())) {
            return true;
        }
        return false;

    }

}