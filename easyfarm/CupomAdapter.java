package com.example.easyfarm;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Arrays;

public class CupomAdapter extends RecyclerView.Adapter<CupomAdapter.ViewHolder>{

    public String Host ="http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    int i = 0;

    String url_site = "http://tccefarm.sslblindado.com";
    Cupom[] cupoms;
    Context context;

    public CupomAdapter(Cupom[] cupom, Context activity) {
        this.cupoms = cupom;
        this.context = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_cupons,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Cupom cupom = cupoms[position];
        holder.cod_cup.setText(cupom.getCod_cup());
        holder.nome_cup.setText(cupom.getNome_cup());
        holder.desc_cup.setText(cupom.getDesc_cup());
        holder.validade_cup.setText(cupom.getValidade_cup());
        holder.valor_cup.setText(cupom.getValor_cup());
        holder.imageView.setImageResource(R.drawable.logo_branca);
    }

    @Override
    public int getItemCount() {
        return cupoms.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView cod_cup;
        TextView nome_cup;
        TextView desc_cup;
        TextView validade_cup;
        TextView valor_cup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_imgcup);
            cod_cup = itemView.findViewById(R.id.card_codcup);
            nome_cup = itemView.findViewById(R.id.card_nomecup);
            desc_cup = itemView.findViewById(R.id.card_desccup);
            validade_cup = itemView.findViewById(R.id.card_validadecup);
            valor_cup = itemView.findViewById(R.id.card_valorcup);
        }
    }

    public void clicked_btn(String str) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url_site));
        context.startActivity(intent);
    }
}
