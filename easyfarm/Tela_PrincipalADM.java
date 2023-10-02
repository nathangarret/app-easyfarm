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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_PrincipalADM extends AppCompatActivity {

    public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i = 0;
    Dialog mdialog;

    EditText titulo1;
    EditText desc1;
    EditText datavalid1;
    EditText cupom1;
    Button reedem_btn_adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_adm);

        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.nav_Home);
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

        mdialog = new Dialog(this);
        findViewById(R.id.trocar_cupom1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mdialog.setContentView(R.layout.popup1_adm);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();
                ListarPopUp1();

                titulo1 = (EditText) mdialog.findViewById(R.id.tit_cupom_adm);
                desc1 = (EditText) mdialog.findViewById(R.id.desc_cupom_adm);
                datavalid1 = (EditText) mdialog.findViewById(R.id.expirasse_coupom_adm);
                cupom1 = (EditText) mdialog.findViewById(R.id.cupom_adm);

                reedem_btn_adm = (Button) mdialog.findViewById(R.id.reedem_btn_adm);
                reedem_btn_adm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlterarCupom();
                    }
                });

            }
        });

        findViewById(R.id.trocar_cupom2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mdialog.setContentView(R.layout.popup2_adm);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

            }
        });

        findViewById(R.id.trocar_cupom3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mdialog.setContentView(R.layout.popup3_adm);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

            }
        });

        findViewById(R.id.trocar_cupom4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mdialog.setContentView(R.layout.popup4_adm);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

            }
        });

        findViewById(R.id.trocar_cupom5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mdialog.setContentView(R.layout.popup5_adm);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

            }
        });

        findViewById(R.id.trocar_cupom6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mdialog.setContentView(R.layout.popup6_adm);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

            }
        });
    }

    public void ListarPopUp1(){
        url = Host + "/listarcupom.php";
        Ion.with(Tela_PrincipalADM.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i=0;i<result.size();i++){
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cupom1.setText(retx.get("cod_cupom").getAsString());
                            titulo1.setText(retx.get("nome_cupom").getAsString());
                            desc1.setText(retx.get("desc_cupom").getAsString());
                            datavalid1.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });

    }

    public void AlterarCupom(){
        url = Host + "/editarcupom_popup1.php";
        Ion.with(Tela_PrincipalADM.this)
                .load(url)
                .setBodyParameter("cod_cupom",cupom1.getText().toString())
                .setBodyParameter("nome_cupom", titulo1.getText().toString())
                .setBodyParameter("desc_cupom", desc1.getText().toString())
                .setBodyParameter("validade_cupom", datavalid1.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")){
                            Toast.makeText(getApplicationContext(),
                                    "Cupom Alterado no Sistema! :)",
                                    Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro de Alteração",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}