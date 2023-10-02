package com.example.easyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_CuponsUtilizados extends AppCompatActivity {

    public String Host="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i = 0;

    TextView cupons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cupons_utilizados);

        cupons = (TextView) findViewById(R.id.cupons_utilizados);
        //ListarCupomUtlz();

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

        findViewById(R.id.back_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_myacc = new Intent(Tela_CuponsUtilizados.this,
                        Tela_MinhaConta.class);
                startActivity(go_myacc);
            }
        });

    }

    public void ListarCupomUtlz(){
        url = Host + "/listarcuponsutlz.php";
        Ion.with(Tela_CuponsUtilizados.this)
                .load(url)
                .setBodyParameter("id_Cliente",Tela_Login.idx)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i=0;i<result.size();i++){
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cupons.setText(retx.get("id_cupom").getAsString());
                        }
                    }
                });
    }
}