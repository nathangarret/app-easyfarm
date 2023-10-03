package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class Tela_Registrar extends AppCompatActivity{

    // public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;

    //  Tentar inserir no BD prm16
    //  Inserir uma img no Emulador

    public static EditText nome;
    public static EditText nome2;
    public static EditText cpf;
    public static EditText fone;
    public static EditText dtanasc;
    String txtcpf;
    Calendar calendar;
    // Colocar setinha de transição

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_register);

        cpf = (EditText) findViewById(R.id.cpf_cadastro);
        txtcpf = cpf.getText().toString();
        cpf.requestFocus();

        nome = (EditText) findViewById(R.id.first_cadastro);
        nome2 = (EditText) findViewById(R.id.second_cadastro);
        fone = (EditText) findViewById(R.id.fone_cadastro);
        dtanasc = (EditText) findViewById(R.id.nasc_cadastro);

        findViewById(R.id.txt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Registrar.this,Tela_Login.class);
                startActivity(it);
            }
        });

        findViewById(R.id.cads1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cpf.equals("")){
                    cpf.requestFocus();
                }
                else if(nome.equals("")){
                    cpf.requestFocus();
                }
                else if(nome2.equals("")){
                    nome2.requestFocus();
                }
                else if(fone.equals("")){
                    fone.requestFocus();
                }
                else if(dtanasc.equals("")){
                    dtanasc.requestFocus();
                }
                if(!ValidarCPF.isCPF(cpf.getText().toString())){
                    Toast.makeText(Tela_Registrar.this,
                            "Cpf Inválido",
                            Toast.LENGTH_SHORT).show();
                }
                else if (!cpf.equals("") && ValidarCPF.isCPF(cpf.getText().toString()) &&
                        !nome.equals("") && !nome2.equals("") && !fone.equals("") &&
                        !fone.equals("") && !dtanasc.equals("")){

                        Intent go_login = new Intent(Tela_Registrar.this,
                                Tela_Registrar2.class);
                        startActivity(go_login);
                    }
                }
            });
    }


}