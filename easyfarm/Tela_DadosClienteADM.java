package com.example.easyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_DadosClienteADM extends AppCompatActivity {

    public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i = 0;
    TextView id_adm;
    TextView qntadm_adm;
    TextView qntcuputlz_adm;
    TextView qntvendas_adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dados_cliente_adm);

        id_adm = (TextView) findViewById(R.id.qntcup_adm);
        qntadm_adm = (TextView) findViewById(R.id.qntadm_adm);
        qntcuputlz_adm = (TextView) findViewById(R.id.qntcuputlz_adm);
        qntvendas_adm = (TextView) findViewById(R.id.qntvendas_adm);

        ListarAdm();
        ListarCupomAdm();
        ListarCuponsUtlzAdm();
        ListarQntVendasAdm();

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

        findViewById(R.id.criarcupom_adm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_criarcup = new Intent(Tela_DadosClienteADM.this,Tela_CadastrarCupomADM.class);
                startActivity(go_criarcup);
            }
        });

        findViewById(R.id.add_adm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_addadm = new Intent(Tela_DadosClienteADM.this,Tela_CadastrarADM.class);
                startActivity(go_addadm);
            }
        });
    }

    public void ListarAdm(){
        url = Host + "/listaradm.php";
        Ion.with(Tela_DadosClienteADM.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                            for (i=0;i<result.size();i++){
                            JsonObject retx = result.get(i).getAsJsonObject();
                            id_adm.setText(retx.get("id_adm").getAsString());
                        }
                    }
                });
    }

    public void ListarCupomAdm(){
        url = Host + "/listarcupomadm.php";
        Ion.with(Tela_DadosClienteADM.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i=0;i<result.size();i++){
                            JsonObject retx = result.get(i).getAsJsonObject();
                            qntadm_adm.setText(retx.get("id_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCuponsUtlzAdm(){
        url = Host + "/listarcuponsutlz.php";
        Ion.with(Tela_DadosClienteADM.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i=0;i<result.size();i++){
                            JsonObject retx = result.get(i).getAsJsonObject();
                            qntcuputlz_adm.setText(retx.get("id_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarQntVendasAdm(){
        url = Host + "/listarqntvendas.php";
        Ion.with(Tela_DadosClienteADM.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i=0;i<result.size();i++){
                            JsonObject retx = result.get(i).getAsJsonObject();
                            qntvendas_adm.setText(retx.get("id_Pedido").getAsString());
                        }
                    }
                });
    }
}