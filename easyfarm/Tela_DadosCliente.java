package com.example.easyfarm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_DadosCliente extends AppCompatActivity {

    public String Host="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;

    Dialog mdialog;
    ImageView btn_encerrarconta;
    ImageView btn_cancelarconta;

    public TextView nome;
    public TextView email;
    public TextView senha;
    public TextView cpf;
    public TextView telefone;
    public TextView dtanasc;
    public TextView sobrenome;
    public TextView nome_cli;
    public String email_cli;

    public Button editar_nome;
    public Button editar_sobrenome;
    public Button editar_fone;
    public Button editar_senha;

    public EditText nome_edit;
    public EditText email_edit;
    public EditText senha_edit;
    public EditText cpf_edit;
    public EditText telefone_edit;
    public EditText dtanasc_edit;
    public EditText sobrenome_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dados_cliente);
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

        // ListarDadosCliente();
        cpf = (TextView) findViewById(R.id.cpf_dados);
        nome = (TextView) findViewById(R.id.nome_dados);
        sobrenome = (TextView) findViewById(R.id.sobrenome_dados);
        telefone = (TextView) findViewById(R.id.fone_dados);
        email = (TextView) findViewById(R.id.email_dados);
        senha = (TextView) findViewById(R.id.senha_dados);
        dtanasc = (TextView) findViewById(R.id.nasc_dados);

        mdialog = new Dialog(this);
        findViewById(R.id.encerrar_conta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup_encerrarconta); // Layout popup
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_encerrarconta = (ImageView) mdialog.findViewById(R.id.btn_encerrarconta);
                btn_encerrarconta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ApagarConta();
                    }
                });

                btn_cancelarconta = (ImageView) mdialog.findViewById(R.id.btn_cancelarconta);
                btn_cancelarconta.setOnClickListener(   new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(Tela_DadosCliente.this, Tela_DadosCliente.class);
                        startActivity(it);
                    }
                });
            }
        });


        findViewById(R.id.back_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_dados = new Intent(Tela_DadosCliente.this,Tela_MinhaConta.class);
                startActivity(back_dados);
            }
        });

        findViewById(R.id.cpf_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.activity_tela_dados_cpf);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                cpf_edit = (EditText) mdialog.findViewById(R.id.cpf_editar);
                cpf_edit.setText(Tela_Login.cpfx);
            }
        });

        findViewById(R.id.nome_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.activity_tela_dados_nome);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                nome_edit = (EditText) mdialog.findViewById(R.id.nome_editar);
                nome_edit.setText(Tela_Login.firstnomex);

                editar_nome = (Button) mdialog.findViewById(R.id.editar_nome);
                editar_nome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlterarNome();
                    }
                });
                // ListarNome();
            }
        });


        findViewById(R.id.sobrenome_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.activity_tela_dados_sobrenome);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                sobrenome_edit = (EditText) mdialog.findViewById(R.id.sobrenome_editar);
                sobrenome_edit.setText(Tela_Login.lastnomex);

                editar_sobrenome = (Button) mdialog.findViewById(R.id.editar_sobrenome);
                editar_sobrenome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlterarSobreNome();
                    }
                });
                // ListarSobrenome();
            }
        });


        findViewById(R.id.email_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.activity_tela_dados_email);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                email_edit = (EditText) mdialog.findViewById(R.id.email_editar);
                email_edit.setText(Tela_Login.emailx);
            }
        });

        findViewById(R.id.senha_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.activity_tela_dados_senha);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                senha_edit = (EditText) mdialog.findViewById(R.id.senha_editar);
                senha_edit.setText(Tela_Login.senhax);

                editar_senha = (Button) mdialog.findViewById(R.id.editar_senha);
                editar_senha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlterarSenha();
                    }
                });
                // ListarSenha();
            }
        });

        findViewById(R.id.fone_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.activity_tela_dados_fone);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                telefone_edit = (EditText) mdialog.findViewById(R.id.fone_editar);
                telefone_edit.setText(Tela_Login.fonex);

                editar_fone = (Button) mdialog.findViewById(R.id.editar_fone);
                editar_fone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlterarFone();
                    }
                });
                // ListarFone();
            }
        });

        findViewById(R.id.nasc_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.activity_tela_dados_dta_nasc);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                dtanasc_edit = (EditText) mdialog.findViewById(R.id.dtanasc_editar);
                dtanasc_edit.setText(Tela_Login.nascx);
            }
        });
    }

    public void AlterarNome(){
        url = Host + "/alterarnome.php";
        Ion.with(Tela_DadosCliente.this)
                .load(url)
                .setBodyParameter("id_Cliente",Tela_Login.idx)
                .setBodyParameter("firstNome_Cliente", nome_edit.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Alteração de Nome");
                            builder.setTitle("Seu nome foi alterado com successo :)");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Aviso Alteração de Nome");
                            builder.setTitle("Erro ao alterar nome :( ");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                });
    }

    public void AlterarSobreNome(){
        url = Host + "/alterarsobrenome.php";
        Ion.with(Tela_DadosCliente.this)
                .load(url)
                .setBodyParameter("id_Cliente",Tela_Login.idx)
                .setBodyParameter("lastNome_Cliente", sobrenome_edit.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Alteração de Sobrenome");
                            builder.setTitle("Seu sobrenome foi alterado com successo :)");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Aviso Alteração de Sobrenome");
                            builder.setTitle("Erro ao alterar sobrenome :(");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                });
    }

    public void AlterarFone(){
        url = Host + "/alterartelefone.php";
        Ion.with(Tela_DadosCliente.this)
                .load(url)
                .setBodyParameter("id_Cliente",Tela_Login.idx)
                .setBodyParameter("Fone_Cliente", telefone_edit.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Alteração de Telefone");
                            builder.setTitle("Seu telefone foi alterado com successo :)");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Aviso Alteração de Telefone");
                            builder.setTitle("Erro ao alterar telefone :(");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                });
    }

    public void AlterarSenha(){
        int s = 0;
        url = Host + "/alterarsenha.php";
        Ion.with(Tela_DadosCliente.this)
                .load(url)
                .setBodyParameter("id_Cliente",Tela_Login.idx)
                .setBodyParameter("senha_Cliente", senha_edit.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if (ret.equals("ok")) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Alteração de Senha");
                            builder.setTitle("Sua senha foi alterada com successo :)");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Aviso Alteração de Senha");
                            builder.setTitle("Erro ao alterar senha :(");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                });
    }

    public void ApagarConta(){
        url = Host + "/deletarconta.php";
        Ion.with(Tela_DadosCliente.this)
                .load(url)
                .setBodyParameter("id_Cliente",Tela_Login.idx)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")) {
                            Toast.makeText(getApplicationContext(),
                                    "Conta Apagada do Sistema! :(",
                                    Toast.LENGTH_LONG).show();
                            Intent it = new Intent(Tela_DadosCliente.this, Tela_Login.class);
                            startActivity(it);
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_DadosCliente.this);
                            builder.setTitle("Aviso Apagar Conta");
                            builder.setTitle("Erro ao apagar conta :( ");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                } );
    }
}