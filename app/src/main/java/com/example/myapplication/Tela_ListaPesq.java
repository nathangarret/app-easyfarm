package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tela_ListaPesq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_pesq);

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
                if(id == R.id.nav_Coupons) {
                    startActivity(new Intent(getApplicationContext(),
                            Tela_TodosCuponsADM.class));
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
    }
}