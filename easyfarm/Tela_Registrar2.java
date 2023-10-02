package com.example.easyfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.santalu.maskara.widget.MaskEditText;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class Tela_Registrar2 extends AppCompatActivity {

    public String Host = "http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;

    public static EditText email;
    public static EditText senha;

    public EditText nome;
    public EditText nome2;
    public EditText cpf;

    public MaskEditText fone;
    public EditText dtanasc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registrar2);

        email = (EditText) findViewById(R.id.email_cadastro);
        senha = (EditText) findViewById(R.id.senha_cadastro);
        cpf = (Tela_Registrar.cpf);
        nome = (Tela_Registrar.nome);
        nome2 = (Tela_Registrar.nome2);
        fone = (Tela_Registrar.fone);
        dtanasc = (Tela_Registrar.dtanasc);

        findViewById(R.id.btn_cadastrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cads();
            }
        });

        findViewById(R.id.back_register1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_reg1 = new Intent(Tela_Registrar2.this,Tela_Registrar.class);
                startActivity(go_reg1);
            }
        });
    }

    public void cads(){
        url = Host + "/inserir.php";
        Ion.with (Tela_Registrar2.this)
                .load(url)
                .setBodyParameter("cpf_Cliente", cpf.getText().toString())
                .setBodyParameter("firstNome_Cliente",nome.getText().toString())
                .setBodyParameter("fone_Cliente", fone.getText().toString())
                .setBodyParameter("email_Cliente",email.getText().toString())
                .setBodyParameter("senha_Cliente",senha.getText().toString())
                .setBodyParameter("nasc_Cliente", dtanasc.getText().toString())
                .setBodyParameter("lastNome_Cliente",nome2.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                            if(ret.equals("ok")){
                                Toast.makeText(getApplicationContext(),
                                    "Agora você faze parte da EasyFarm :)",
                                    Toast.LENGTH_LONG).show();
                                    Intent trocar = new Intent(Tela_Registrar2.this,
                                            Tela_Login.class);
                                    startActivity(trocar);
                            } else{
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao Inserir cadastro :(",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}