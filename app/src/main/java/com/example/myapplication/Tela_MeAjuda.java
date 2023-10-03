package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tela_MeAjuda extends AppCompatActivity {

    public String Host="";
    public String url;
    String urlsite ="https://tccefarm.sslblindado.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

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
                if(id == R.id.nav_MyAccount) {
                    startActivity(new Intent(getApplicationContext(),
                            Tela_MinhaContaADM.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.resgate_cupom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Tela_MeAjuda.this);
                builder.setTitle("Como fazer o resgate do cupom de desconto?");
                builder.setMessage("- Na tela Home ou Cupons" + "\n" +
                        "- Clique em algum card em específico" + "\n" +
                        "- Selecione a opção de ir para o Site" + "\n" +
                        "- Logue com sua conta,abre o carrinho e finalize sua compra");
                builder.setNeutralButton("OK",null);
                builder.show();
                // Intent back_ajuda = new Intent(Tela_MeAjuda.this,Tela_MinhaConta.class);
                //  startActivity(back_ajuda);

            }
        });

        findViewById(R.id.resgate_cupnfunc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Tela_MeAjuda.this);
                builder.setTitle("Por que meu cupom não está resgatando?");
                builder.setMessage("A partir do momento que você finaliza sua compra com um determinado cupom,este cupom não " +
                        "estará mais disponivel para o resgate na sua conta.");
                builder.setNeutralButton("OK",null);
                builder.show();
            }
        });

        findViewById(R.id.resgate_temppedido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Tela_MeAjuda.this);
                builder.setTitle("Quanto tempo leva para o meu pedido chega?");
                builder.setMessage("O seu pedido levará o tempo de chegada de acordo com o envio do vendedor.Todos os vendedores possuem tempo de despacho já indicado na compra do pedido.");
                builder.setNeutralButton("OK",null);
                builder.show();
            }
        });

        findViewById(R.id.resgate_compraaprov).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Tela_MeAjuda.this);
                builder.setTitle("Como sei que a minha compra foi aprovada?");
                builder.setMessage("Se o pagamento foi processado com sucesso, o cliente será conduzido a uma nova página ao receber uma notificação de compra aprovada. O cliente deverá receber a notificação logo após o pagamento com métodos de pagamento automáticos.");
                builder.setNeutralButton("OK",null);
                builder.show();
            }
        });


        findViewById(R.id.resgate_vendaprod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Tela_MeAjuda.this);
                builder.setTitle("Como faço a venda dos meus produtos?");
                builder.setMessage("Abra o site da EasyFarm,ao fazer o cadastro como vendedor, basta o usuário ir na área de vendas e cadastrar seus produtos conforme o andamento que o site solicita. Nosso site permite que os lojistas sejam vendedores e compradores, ocupando posições de destaque na hora da venda.");
                builder.setNeutralButton("OK",null);
                builder.show();
            }
        });

        findViewById(R.id.card_cntt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sup = new Intent(Tela_MeAjuda.this,Tela_Suporte.class);
                startActivity(sup);
            }
        });

        findViewById(R.id.card_work).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Tela_MeAjuda.this);
                builder.setTitle("Trabalhe conosco");
                builder.setMessage("Veja as vagas em aberto na EasyFarm e faça parte da nossa equipe :)");
                builder.setNeutralButton("OK",null);
                builder.show();
            }
        });

        findViewById(R.id.card_site).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_btn(urlsite);
            }
        });

        findViewById(R.id.back_ajuda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_ajuda = new Intent(Tela_MeAjuda.this,Tela_MinhaConta.class);
                startActivity(back_ajuda);
            }
        });

        findViewById(R.id.card_suporte).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent card_suporte = new Intent(Tela_MeAjuda.this,Tela_Suporte.class);
                startActivity(card_suporte);
            }
        });

        /*
        findViewById(R.id.card_perguntasfreq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent card_pergfreq = new Intent(Tela_MeAjuda.this,Tela_PerguntasFreq.class);
                startActivity(card_pergfreq);
            }
        });
        */
    }

    public void clicked_btn(String str){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlsite));
        startActivity(intent);
    }
}