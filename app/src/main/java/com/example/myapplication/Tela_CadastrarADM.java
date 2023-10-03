package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_CadastrarADM extends AppCompatActivity {

    // public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;

    EditText txt_nomeadm;
    EditText txt_emailadm;
    EditText txt_senhaadm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_adm);

        txt_nomeadm = (EditText) findViewById(R.id.txt_nomeadm);
        txt_emailadm = (EditText) findViewById(R.id.txt_adm);
        txt_senhaadm = (EditText) findViewById(R.id.txt_senha);

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

        findViewById(R.id.voltar_adm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backforget_login = new Intent(Tela_CadastrarADM.this,Tela_DadosClienteADM.class);
                startActivity(backforget_login);
            }
        });

        findViewById(R.id.cadastrar_adm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InserirCupomADM();
            }
        });

    }

    public void InserirCupomADM(){
        /*
        url = Host + "/inserirADM.php";
        Ion.with (Tela_CadastrarADM.this)
                .load(url)
                .setBodyParameter("nome_adm", txt_nomeadm.getText().toString())
                .setBodyParameter("email_adm", txt_emailadm.getText().toString())
                .setBodyParameter("senha_adm",txt_senhaadm.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_CadastrarADM.this);
                            builder.setTitle("Cadastrar ADM");
                            builder.setTitle("ADM cadastrado com successo :)");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                            txt_nomeadm.setText("");
                            txt_emailadm.setText("");
                            txt_senhaadm.setText("");
                        } else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_CadastrarADM.this);
                            builder.setTitle("Aviso ADM");
                            builder.setTitle("Erro ao cadastrar ADM :(");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                });*/
    }


}