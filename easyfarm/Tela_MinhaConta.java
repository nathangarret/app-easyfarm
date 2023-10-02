package com.example.easyfarm;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_MinhaConta extends AppCompatActivity {

    public String Host="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i=0;

    ImageView btn_sair;
    ImageView btn_sairficar;

    public TextView nome;
    public TextView email;

    Dialog mdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_my_account);

        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.nav_MyAccount);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_Home:
                        startActivity(new Intent(getApplicationContext(),
                                Tela_Principal.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_Coupons:
                        startActivity(new Intent(getApplicationContext(),
                                Tela_TodosCupons.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_MyAccount:
                        startActivity(new Intent(getApplicationContext(),
                                Tela_MinhaConta.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        findViewById(R.id.me_ajuda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_dadoscli = new Intent(Tela_MinhaConta.this, Tela_MeAjuda.class);
                startActivity(go_dadoscli);
            }
        });

        findViewById(R.id.dados_cadastrais).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_dadoscli = new Intent(Tela_MinhaConta.this,Tela_DadosCliente.class);
                startActivity(go_dadoscli);
            }
        });

        findViewById(R.id.dados_cuponsutil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_dadoscup = new Intent(Tela_MinhaConta.this,Tela_CuponsUtilizados.class);
                startActivity(go_dadoscup);
            }
        });

        findViewById(R.id.sobrenos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_dadoscli = new Intent(Tela_MinhaConta.this,Tela_SobreNos.class);
                startActivity(go_dadoscli);
            }
        });

        mdialog = new Dialog(this);
        findViewById(R.id.sair).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup_sairapp); // Layout popup
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_sair = (ImageView) mdialog.findViewById(R.id.btn_sair);
                btn_sair.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        Intent sair = new Intent(Tela_MinhaConta.this,Tela_Login.class);
                        startActivity(sair);
                    }
                });

                btn_sairficar = (ImageView) mdialog.findViewById(R.id.btn_sairficar);
                btn_sairficar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent ficar = new Intent(Tela_MinhaConta.this,Tela_MinhaConta.class);
                        startActivity(ficar);
                    }
                });
            }
        });
    }
}