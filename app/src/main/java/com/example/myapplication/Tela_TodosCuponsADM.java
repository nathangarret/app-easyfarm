package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_TodosCuponsADM extends AppCompatActivity {

    // public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_todos_cupons_adm);

        /*
        url = Host + "/listarcupom.php";
        Ion.with(Tela_TodosCuponsADM.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size();i++) {
                            Cupom[] cupoms = new Cupom[]{
                                    new Cupom(Tela_TodosCuponsADM.this,
                                            R.drawable.logo_branca,
                                            Tela_TodosCupons.id_cup,
                                            "",
                                            "",
                                            "",
                                            ""),
                                    new Cupom(Tela_TodosCuponsADM.this,
                                            R.drawable.logo_branca,
                                            Tela_TodosCupons.id_cup,
                                            "",
                                            "",
                                            "",
                                            ""),
                                    new Cupom(Tela_TodosCuponsADM.this,
                                            R.drawable.logo_branca,
                                            Tela_TodosCupons.id_cup,
                                            "",
                                            "",
                                            "",
                                            ""),
                                    new Cupom(Tela_TodosCuponsADM.this,
                                            R.drawable.logo_branca,
                                            Tela_TodosCupons.id_cup,
                                            "",
                                            "",
                                            "",
                                            ""),
                                    new Cupom(Tela_TodosCuponsADM.this,
                                            R.drawable.logo_branca,
                                            Tela_TodosCupons.id_cup,
                                            "",
                                            "",
                                            "",
                                            ""),
                                    new Cupom(Tela_TodosCuponsADM.this,
                                            R.drawable.logo_branca,
                                            Tela_TodosCupons.id_cup,
                                            "",
                                            "",
                                            "",
                                            "")};

                            RecyclerView view1 = findViewById(R.id.recyclerview_adm);
                            view1.setHasFixedSize(true);
                            view1.setLayoutManager(new LinearLayoutManager(Tela_TodosCuponsADM.this));

                            CupomAdapter cupomAdapter = new CupomAdapter(cupoms,Tela_TodosCuponsADM.this);
                            view1.setAdapter(cupomAdapter);
                        }
                    }
                });

         */

        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.nav_Coupons);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_Home) {
                    startActivity(new Intent(getApplicationContext(),
                            Tela_PrincipalADM.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                if(id == R.id.nav_Coupons) {
                    startActivity(new Intent(getApplicationContext(),
                            Tela_TodosCuponsADM.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                if(id == R.id.nav_MyAccount) {
                    startActivity(new Intent(getApplicationContext(),
                            Tela_MinhaContaADM.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });

        /*
        findViewById(R.id.editar_cupom1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        findViewById(R.id.apagar_cupom1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
         */

        findViewById(R.id.inserircup_adm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir_cadscupom = new Intent(Tela_TodosCuponsADM.this,
                        Tela_CadastrarCupomADM.class);
                startActivity(ir_cadscupom);
            }
        });
    }
}