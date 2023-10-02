package com.example.easyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tela_Suporte extends AppCompatActivity {

    TextView txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_suporte);
        txtemail = (TextView) findViewById(R.id.txt_email);

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

                    case R.id.nav_MyAccount:
                        startActivity(new Intent(getApplicationContext(),
                                Tela_MinhaConta.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        findViewById(R.id.back_sup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_sup = new Intent(Tela_Suporte.this,Tela_MeAjuda.class);
                startActivity(back_sup);
            }
        });

        findViewById(R.id.email_sup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intz = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                 startActivity(intz);
                //url("https://mail.google.com/mail/u/0/#inbox");
            }
        });

        findViewById(R.id.phone_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = "+55 (11) 95578-3702";
                Uri uri = Uri.parse("tel:" + num);
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        findViewById(R.id.copiar_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Email",txtemail.getText().toString());
                cbm.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(),
                        "Email copiado com sucesso ):",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void url(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}