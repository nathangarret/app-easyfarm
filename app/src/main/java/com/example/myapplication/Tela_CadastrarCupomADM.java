package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class Tela_CadastrarCupomADM extends AppCompatActivity {

    // public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;

    EditText cod_cup;
    EditText nom_cup;
    EditText desc_cup;
    EditText vali_cup;
    EditText valor_cup;

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_cupom_adm);

        cod_cup = (EditText) findViewById(R.id.codcupom_adm);
        nom_cup = (EditText) findViewById(R.id.nomecupom_adm);
        desc_cup = (EditText) findViewById(R.id.desccupom_adm);
        vali_cup = (EditText) findViewById(R.id.validcupom_adm);
        valor_cup = (EditText) findViewById(R.id.valorcupom_adm);

        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.nav_MyAccount);
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

        findViewById(R.id.back_cupons).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_todoscupons = new Intent(Tela_CadastrarCupomADM.this,Tela_DadosClienteADM.class);
                startActivity(go_todoscupons);
             }
        });

        findViewById(R.id.cadastrarcupom_adm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InserirCupomADM();
            }
        });

    }

    public void InserirCupomADM(){
        /*
        url = Host + "/inserircupomADM.php";
        Ion.with (Tela_CadastrarCupomADM.this)
                .load(url)
                .setBodyParameter("cod_cupom", cod_cup.getText().toString())
                .setBodyParameter("nome_cupom",nom_cup.getText().toString())
                .setBodyParameter("desc_cupom", desc_cup.getText().toString())
                .setBodyParameter("validade_cupom",vali_cup.getText().toString())
                .setBodyParameter("valor_cupom",valor_cup.getText().toString())
                .setBodyParameter("id_adm",Tela_Login.idx_ADM)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_CadastrarCupomADM.this);
                            builder.setTitle("Cadastrar Cupom");
                            builder.setTitle("Cupom cadastrado com successo :)");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        } else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_CadastrarCupomADM.this);
                            builder.setTitle("Aviso Cupom");
                            builder.setTitle("Erro ao cadastrar cupom :( ");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                });
         */
    }
}