package com.doranco.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView txt_Create;
    Button btn_cnx;
    MediaPlayer helloBuddySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.helloBuddySong = MediaPlayer.create(getApplicationContext(), R.raw.hello_buddy);
        helloBuddySong.start();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_cupcake);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        this.txt_Create = findViewById(R.id.txt_create_account);
        this.btn_cnx = findViewById(R.id.btn_connexion);

        txt_Create.setMovementMethod(LinkMovementMethod.getInstance());
        txt_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_cnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}