package com.example.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_TodosCupons extends AppCompatActivity {

    // public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i = 0;
    static String id_cup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_todos_cupons);

        Cupom[] cupoms = new Cupom[]{
                new Cupom(Tela_TodosCupons.this,
                        R.drawable.logo_branca,
                        "UYHNQ34M",
                        "Cupom Easy Farm",
                        "Este cupom irá descontar R$9 reais da sua compra.",
                        "2022-07-22",
                        "09.00"),
                new Cupom(Tela_TodosCupons.this,
                        R.drawable.logo_branca,
                        "KDWIAJDI",
                        "Cupom Easy Farm",
                        "Este cupom irá descontar R$8 reais da sua compra.",
                        "2022-07-22",
                        "08.00"),
                new Cupom(Tela_TodosCupons.this,
                        R.drawable.logo_branca,
                        "5492NDWC",
                        "Cupom Easy Farm",
                        "Este cupom irá descontar R$7 reais da sua compra.",
                        "2022-07-22",
                        "07.00"),
                new Cupom(Tela_TodosCupons.this,
                        R.drawable.logo_branca,
                        "MWIUH382",
                        "Cupom Easy Farm",
                        "Este cupom irá descontar R$6 reais da sua compra.",
                        "2022-07-22",
                        "06.00"),
                new Cupom(Tela_TodosCupons.this,
                        R.drawable.logo_branca,
                        "IDNJDUW2",
                        "Cupom Easy Farm",
                        "Este cupom irá descontar R$4 reais da sua compra.",
                        "2022-07-22",
                        "04.00"),
                new Cupom(Tela_TodosCupons.this,
                        R.drawable.logo_branca,
                        "KDWIOANU",
                        "Cupom Easy Farm",
                        "Este cupom irá descontar R$3 reais da sua compra.",
                        "2022-07-22",
                        "03.00")};

        RecyclerView view1 = findViewById(R.id.recyclerview);
        view1.setHasFixedSize(true);
        view1.setLayoutManager(new LinearLayoutManager(Tela_TodosCupons.this));

        CupomAdapter cupomAdapter = new CupomAdapter(cupoms,Tela_TodosCupons.this);
        view1.setAdapter(cupomAdapter);

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
    }
}