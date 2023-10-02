package com.example.easyfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_EsqueceuSenha extends AppCompatActivity {

    public String Host="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;

    public EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_forget_pass);

        email = (EditText) findViewById(R.id.edit_emailforgot);
        findViewById(R.id.btn_enviaremail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enviar();
            }
        });

        findViewById(R.id.backforget_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backforget_login = new Intent(Tela_EsqueceuSenha.this,Tela_Login.class);
                startActivity(backforget_login);
            }
        });
    }

    public void Enviar(){
        url = Host + "/enviaremail.php";
        Ion.with(Tela_EsqueceuSenha.this)
                .load(url)
                .setBodyParameter("email_Cliente",email.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if (!email.equals("")) {
                            if(ret.equals("ok")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Tela_EsqueceuSenha.this);
                                builder.setTitle("Envio de Email");
                                builder.setTitle("Cheque seu E-mail para a recuperação de senha :)");
                                builder.setNeutralButton("OK",null);
                                builder.show();
                                email.setText("");
                            }
                        }else if(email.equals("")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Tela_EsqueceuSenha.this);
                            builder.setTitle("Aviso de Esqueceu Senha");
                            builder.setTitle("O campo está vázio :(");
                            builder.setNeutralButton("OK",null);
                            builder.show();
                        }
                    }
                });
    }
}