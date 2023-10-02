package com.example.easyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tela_MinhaContaADM extends AppCompatActivity {

    Dialog mdialog;
    ImageView btn_sairficar;
    ImageView btn_sair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_minha_conta_adm);

        findViewById(R.id.dados_cadastraisADM).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dadosADM = new Intent(Tela_MinhaContaADM.this,Tela_DadosClienteADM.class);
                startActivity(dadosADM);
            }
        });

        mdialog = new Dialog(this);
        findViewById(R.id.sairADM).setOnClickListener(new View.OnClickListener() {
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
                        Intent sair = new Intent(Tela_MinhaContaADM.this,Tela_Login.class);
                        startActivity(sair);
                    }
                });

                btn_sairficar = (ImageView) mdialog.findViewById(R.id.btn_sairficar);
                btn_sairficar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent ficar = new Intent(Tela_MinhaContaADM.this,Tela_MinhaContaADM.class);
                        startActivity(ficar);
                    }
                });
            }
        });

        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.nav_MyAccount);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_Home:
                        startActivity(new Intent(getApplicationContext(),
                                Tela_PrincipalADM.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_Coupons:
                        startActivity(new Intent(getApplicationContext(),
                                Tela_TodosCuponsADM.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_MyAccount:
                        startActivity(new Intent(getApplicationContext(),
                                Tela_MinhaContaADM.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}