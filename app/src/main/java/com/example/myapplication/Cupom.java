package com.example.myapplication;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.IonContext;

public class Cupom {

    // public String Host="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i = 0;

    private static Integer Image_cup;
    private static String Cod_cup;
    private String Nome_cup;
    private String Desc_cup;
    private String Validade_cup;
    private String Valor_cup;

    public Cupom(Context context,
                 Integer image_cup,
                 String cod_cup,
                 String nome_cup,
                 String desc_cup,
                 String validade_cup,
                 String valor_cup){
        Cod_cup = cod_cup;
        Image_cup = image_cup;
        Nome_cup = nome_cup;
        Desc_cup = desc_cup;
        Validade_cup = validade_cup;
        Valor_cup = valor_cup;
    }

    public Integer getImage_cup() {
        return Image_cup;
    }

    public void setImage_cup(Integer image_cup) {
        Image_cup = image_cup;
    }

    public String getCod_cup() {
        return Cod_cup;
    }

    public void setCod_cup(String cod_cup) {
        Cod_cup = cod_cup;
    }

    public String getNome_cup() {
        return Nome_cup;
    }

    public void setNome_cup(String nome_cup) {
        Nome_cup = nome_cup;
    }

    public String getDesc_cup() {
        return Desc_cup;
    }

    public void setDesc_cup(String desc_cup) {
        Desc_cup = desc_cup;
    }

    public String getValidade_cup() {
        return Validade_cup;
    }

    public void setValidade_cup(String validade_cup) {
        Validade_cup = validade_cup;
    }

    public String getValor_cup() {
        return Valor_cup;
    }

    public void setValor_cup(String valor_cup) {
        Valor_cup = valor_cup;
    }

}
