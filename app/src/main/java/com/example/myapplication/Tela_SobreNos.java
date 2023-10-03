package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tela_SobreNos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre_nos);

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

        findViewById(R.id.back_nos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_nos = new Intent(Tela_SobreNos.this,Tela_MinhaConta.class);
                startActivity(back_nos);
            }
        });

    }
}