package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_Login extends AppCompatActivity {

    // public String Host ="http://tccefarm.sslblindado.com/app";
    // public String Host = "http://efarm.infinityfreeapp.com/app";
     String url_site = "https://tccefarm.sslblindado.com/cadastro1.php";

    public String url;
    public String ret;

    public EditText email;
    public EditText senha;

    public static String idx,emailx, senhax, cpfx, firstnomex, fonex, nascx, lastnomex;

    public static String idx_ADM,emailx_ADM, senhax_ADM,firstnomex_ADM;

    TextView forgetpass;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        email = findViewById(R.id.edit_email_login);
        senha = findViewById(R.id.edit_senha_login);

        findViewById(R.id.btn_sign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // login();
                Intent backforget_login = new Intent(Tela_Login.this,Tela_Principal.class);
                startActivity(backforget_login);
            }
        });

        forgetpass = findViewById(R.id.txt_forgetpass);
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forget = new Intent(Tela_Login.this, Tela_EsqueceuSenha.class);
                startActivity(forget);
            }
        });

        register = findViewById(R.id.txt_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_btn(url_site);
            }
        });
    }

    public void login(){
        /*
        url = Host + "/login.php";
        Ion.with (Tela_Login.this)
                .load(url)
                .setBodyParameter ("email_Cliente", email.getText().toString())
                .setBodyParameter ("senha_Cliente", senha.getText().toString())
                .asJsonObject ()
                .setCallback (new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if(ret.equals("ok")){
                            if (result.get("recebe_us").getAsString().equals("usuario")) {
                                idx = result.get("id_Cliente").getAsString();
                                emailx = result.get("email_Cliente").getAsString();
                                senhax = result.get("senha_Cliente").getAsString();
                                cpfx = result.get("cpf_Cliente").getAsString();
                                firstnomex = result.get("firstNome_Cliente").getAsString();
                                lastnomex = result.get("lastNome_Cliente").getAsString();
                                fonex = result.get("fone_Cliente").getAsString();
                                nascx = result.get("nasc_Cliente").getAsString();
                                Intent trocar = new Intent(Tela_Login.this,
                                        Tela_Principal.class); // Mudar para tela principal
                                startActivity(trocar);
                            }
                            else if(result.get("recebe_us").getAsString().equals("adm")){
                                idx_ADM = result.get("id_adm").getAsString();
                                emailx_ADM = result.get("email_adm").getAsString();
                                senhax_ADM = result.get("senha_adm").getAsString();
                                firstnomex_ADM = result.get("nome_adm").getAsString();
                                Intent trocaradm = new Intent(Tela_Login.this,
                                        Tela_PrincipalADM.class); // Mudar para tela principal
                                startActivity(trocaradm);
                            }
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_Login.this);
                            builder.setTitle("Erro Ao Logar");
                            builder.setTitle("Não existe login ou senha!!! :(");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                            email.setText("");
                            senha.setText("");
                            email.requestFocus();
                        }
                    }
                });
        */
    }

    public void clicked_btn(String str){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url_site));
        startActivity(intent);
    }

}