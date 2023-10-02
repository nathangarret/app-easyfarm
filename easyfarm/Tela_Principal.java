
package com.example.easyfarm;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela_Principal extends AppCompatActivity {

    public String Host = "http://tccefarm.sslblindado.com/app";
    public String url;
    public String ret;
    String url_site = "https://tccefarm.sslblindado.com/";
    int i = 0;

    Button btn_copiar;
    ImageView btn_close;
    EditText cod_desc;
    TextView tit_cup;           // Kabum
    TextView desc_cup;
    TextView validade_cup;

    Button btn_copiar_amz;
    ImageView btn_close_amz;
    EditText cod_desc_amz;      // Amazon
    TextView tit_cup2;
    TextView desc_cup2;
    TextView validade_cup2;

    Button btn_copiar_ads;
    ImageView btn_close_ads;        // Adidas
    EditText cod_desc_ads;
    TextView tit_cup3;
    TextView desc_cup3;
    TextView validade_cup3;

    Button btn_copiar_nk;
    ImageView btn_close_nk;        // Nike
    EditText cod_desc_nk;
    TextView tit_cup4;
    TextView desc_cup4;
    TextView validade_cup4;

    Button btn_copiar_ue;
    ImageView btn_close_ue;        // Uber Eats
    EditText cod_desc_ue;
    TextView tit_cup5;
    TextView desc_cup5;
    TextView validade_cup5;

    Button btn_copiar_trv;
    ImageView btn_close_trv;        // Trivago
    EditText cod_desc_trv;
    TextView tit_cup6;
    TextView desc_cup6;
    TextView validade_cup6;

    Button btn_7;
    EditText cod_7;
    TextView tit_cup7;
    TextView desc_cup7;
    TextView validade_cup7;

    Button btn_8;
    EditText cod_8;
    TextView tit_cup8;
    TextView desc_cup8;
    TextView validade_cup8;

    Button btn_9;
    EditText cod_9;
    TextView tit_cup9;
    TextView desc_cup9;
    TextView validade_cup9;

    Button btn_10;
    EditText cod_10;
    TextView tit_cup10;
    TextView desc_cup10;
    TextView validade_cup10;


    Dialog mdialog;
    ImageView irsite;
    ImageView ficar;

    TextView um;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        um = (TextView) findViewById(R.id.one);

        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.nav_Home);
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


        findViewById(R.id.img_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_todoscup = new Intent(getApplicationContext(), Tela_TodosCupons.class);
                startActivity(go_todoscup);
            }
        });

        mdialog = new Dialog(this);
        findViewById(R.id.desconto_dez).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup1);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_copiar = (Button) mdialog.findViewById(R.id.reedem_btn);

                cod_desc = (EditText) mdialog.findViewById(R.id.cupom);
                // cod_desc.setText();
                cod_desc.setInputType(InputType.TYPE_NULL);

                tit_cup = (TextView) mdialog.findViewById(R.id.tit_cupom);
                // tit_cup.setText();

                desc_cup = (TextView) mdialog.findViewById(R.id.desc_cupom);
                // desc_cup.setText();

                validade_cup = (TextView) mdialog.findViewById(R.id.expirasse_cupom);
                // validade_cup.setText();

                btn_copiar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_desc.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();

                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });

                        // clicked_btn(url);
                    }
                });

                btn_close = (ImageView) mdialog.findViewById(R.id.close_btn);
                btn_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(Tela_Principal.this, Tela_Principal.class);
                        startActivity(it);
                    }
                });
            }
        });

        findViewById(R.id.desconto_quinze).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup2);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_copiar_amz = (Button) mdialog.findViewById(R.id.reedem_btn_amz);

                cod_desc_amz = (EditText) mdialog.findViewById(R.id.coupon_amz);
                cod_desc_amz.setInputType(InputType.TYPE_NULL);

                btn_copiar = (Button) mdialog.findViewById(R.id.reedem_btn);

                tit_cup2 = (TextView) mdialog.findViewById(R.id.tit_cupom2);

                desc_cup2 = (TextView) mdialog.findViewById(R.id.desc_cupom2);

                validade_cup2 = (TextView) mdialog.findViewById(R.id.expirasse_coupom2);


                btn_copiar_amz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_desc_amz.getText().toString());
                        cbm.setPrimaryClip(clip);

                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();

                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });

                btn_close_amz = (ImageView) mdialog.findViewById(R.id.close_btn_amz);
                btn_close_amz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(Tela_Principal.this, Tela_Principal.class);
                        startActivity(it);
                    }
                });
            }
        });

        findViewById(R.id.desconto_vinte).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup3);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_copiar_ads = (Button) mdialog.findViewById(R.id.reedem_btn_ads);

                cod_desc_ads = (EditText) mdialog.findViewById(R.id.coupon_ads);
                cod_desc_ads.setInputType(InputType.TYPE_NULL);

                tit_cup3 = (TextView) mdialog.findViewById(R.id.tit_cupom3);

                desc_cup3 = (TextView) mdialog.findViewById(R.id.desc_cupom3);

                validade_cup3 = (TextView) mdialog.findViewById(R.id.expirasse_coupom3);


                btn_copiar_ads.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_desc_ads.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();

                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });

                btn_close_ads = (ImageView) mdialog.findViewById(R.id.close_btn_ads);
                btn_close_ads.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(Tela_Principal.this, Tela_Principal.class);
                        startActivity(it);
                    }
                });
            }
        });

        findViewById(R.id.vinte5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup4);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_copiar_ue = (Button) mdialog.findViewById(R.id.reedem_btn_ue);

                cod_desc_ue = (EditText) mdialog.findViewById(R.id.coupon_ue);
                cod_desc_ue.setInputType(InputType.TYPE_NULL);

                tit_cup4 = (TextView) mdialog.findViewById(R.id.tit_cupom4);

                desc_cup4 = (TextView) mdialog.findViewById(R.id.desc_cupom4);

                validade_cup4 = (TextView) mdialog.findViewById(R.id.expirasse_coupom4);

                btn_copiar_ue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_desc_ue.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();
                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });

                btn_close_ue = (ImageView) mdialog.findViewById(R.id.close_btn_ue);
                btn_close_ue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(Tela_Principal.this, Tela_Principal.class);
                        startActivity(it);
                    }
                });
            }
        });


        findViewById(R.id.kbm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup5);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_copiar_nk = (Button) mdialog.findViewById(R.id.reedem_btn_nk);
                cod_desc_nk = (EditText) mdialog.findViewById(R.id.coupon_nk);
                cod_desc_nk.setInputType(InputType.TYPE_NULL);

                tit_cup5 = (TextView) mdialog.findViewById(R.id.tit_cupom5);
                desc_cup5 = (TextView) mdialog.findViewById(R.id.desc_cupom5);
                validade_cup5 = (TextView) mdialog.findViewById(R.id.expirasse_coupom5);

                btn_copiar_nk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_desc_nk.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();
                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });
            }
        });

        findViewById(R.id.amazon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup6);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_copiar_trv = (Button) mdialog.findViewById(R.id.reedem_btn_trv);
                cod_desc_trv = (EditText) mdialog.findViewById(R.id.coupon_trv);
                cod_desc_trv.setInputType(InputType.TYPE_NULL);

                tit_cup6 = (TextView) mdialog.findViewById(R.id.tit_cupom6);
                desc_cup6 = (TextView) mdialog.findViewById(R.id.desc_cupom6);
                validade_cup6 = (TextView) mdialog.findViewById(R.id.expirasse_coupom6);

                btn_copiar_trv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_desc_trv.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();
                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });
            }
        });

        findViewById(R.id.adidas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup7);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_7 = (Button) mdialog.findViewById(R.id.reedem_7);
                cod_7 = (EditText) mdialog.findViewById(R.id.coupon7);
                cod_7.setInputType(InputType.TYPE_NULL);

                tit_cup7 = (TextView) mdialog.findViewById(R.id.tit_cupom7);
                desc_cup7 = (TextView) mdialog.findViewById(R.id.desc_cupom7);
                validade_cup7 = (TextView) mdialog.findViewById(R.id.expirasse_coupom7);

                btn_7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_7.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();
                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });
            }
        });

        findViewById(R.id.ubereats).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup8);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_8 = (Button) mdialog.findViewById(R.id.reedem_8);
                cod_8 = (EditText) mdialog.findViewById(R.id.coupon8);
                cod_8.setInputType(InputType.TYPE_NULL);

                tit_cup8 = (TextView) mdialog.findViewById(R.id.tit_cupom8);
                desc_cup8 = (TextView) mdialog.findViewById(R.id.desc_cupom8);
                validade_cup8 = (TextView) mdialog.findViewById(R.id.expirasse_coupom8);

                btn_8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_8.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();
                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });
            }
        });

        findViewById(R.id.nike).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup9);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_9 = (Button) mdialog.findViewById(R.id.reedem_9);
                cod_9 = (EditText) mdialog.findViewById(R.id.coupon9);
                cod_9.setInputType(InputType.TYPE_NULL);

                tit_cup9 = (TextView) mdialog.findViewById(R.id.tit_cupom9);
                desc_cup9 = (TextView) mdialog.findViewById(R.id.desc_cupom9);
                validade_cup9 = (TextView) mdialog.findViewById(R.id.expirasse_coupom9);

                btn_9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_9.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();
                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });
            }
        });

        findViewById(R.id.trivago).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.setContentView(R.layout.popup10);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show();

                btn_10 = (Button) mdialog.findViewById(R.id.reedem_10);
                cod_10 = (EditText) mdialog.findViewById(R.id.coupon10);
                cod_10.setInputType(InputType.TYPE_NULL);

                tit_cup10 = (TextView) mdialog.findViewById(R.id.tit_cupom10);
                desc_cup10 = (TextView) mdialog.findViewById(R.id.desc_cupom10);
                validade_cup10 = (TextView) mdialog.findViewById(R.id.expirasse_coupom10);

                btn_10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cbm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Código", cod_10.getText().toString());
                        cbm.setPrimaryClip(clip);
                        // cod_desc.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                "Código copiado com sucesso ):",
                                Toast.LENGTH_LONG).show();
                        mdialog.setContentView(R.layout.popup_desejasite);
                        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        mdialog.show();

                        irsite = (ImageView) mdialog.findViewById(R.id.img_site);
                        ficar = (ImageView) mdialog.findViewById(R.id.img_ficar);
                        irsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clicked_btn(url);
                            }
                        });

                        ficar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent popup_ficar = new Intent(getApplicationContext(), Tela_Principal.class);
                                startActivity(popup_ficar);
                            }
                        });
                    }
                });
            }
        });

        findViewById(R.id.search_myaccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela_Principal.this, Tela_MinhaConta.class);
                startActivity(it);
            }
        });
    }

    public void clicked_btn(String str) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url_site));
        startActivity(intent);
    }

    public void ListarCupom9() {
        url = Host + "/listarcupom9.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_desc_ue.setText(retx.get("cod_cupom").getAsString());
                            tit_cup4.setText(retx.get("nome_cupom").getAsString());
                            desc_cup4.setText(retx.get("desc_cupom").getAsString());
                            validade_cup4.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCupom7() {
        url = Host + "/listarcupom7.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_desc_ads.setText(retx.get("cod_cupom").getAsString());
                            tit_cup3.setText(retx.get("nome_cupom").getAsString());
                            desc_cup3.setText(retx.get("desc_cupom").getAsString());
                            validade_cup3.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCupom5() {
        url = Host + "/listarcupom5.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_desc_amz.setText(retx.get("cod_cupom").getAsString());
                            tit_cup2.setText(retx.get("nome_cupom").getAsString());
                            desc_cup2.setText(retx.get("desc_cupom").getAsString());
                            validade_cup2.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCupom3() {
        url = Host + "/listarcupom3.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_desc.setText(retx.get("cod_cupom").getAsString());
                            tit_cup.setText(retx.get("nome_cupom").getAsString());
                            desc_cup.setText(retx.get("desc_cupom").getAsString());
                            validade_cup.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCard_1(){
        url = Host + "/listarcupom_popup1.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_desc_nk.setText(retx.get("cod_cupom").getAsString());
                            tit_cup5.setText(retx.get("nome_cupom").getAsString());
                            desc_cup5.setText(retx.get("desc_cupom").getAsString());
                            validade_cup5.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCard_2(){
        url = Host + "/listarcupom_popup2.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_desc_trv.setText(retx.get("cod_cupom").getAsString());
                            tit_cup6.setText(retx.get("nome_cupom").getAsString());
                            desc_cup6.setText(retx.get("desc_cupom").getAsString());
                            validade_cup6.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCard_3(){
        url = Host + "/listarcupom_popup3.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_7.setText(retx.get("cod_cupom").getAsString());
                            tit_cup7.setText(retx.get("nome_cupom").getAsString());
                            desc_cup7.setText(retx.get("desc_cupom").getAsString());
                            validade_cup7.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCard_4(){
        url = Host + "/listarcupom_popup4.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_8.setText(retx.get("cod_cupom").getAsString());
                            tit_cup8.setText(retx.get("nome_cupom").getAsString());
                            desc_cup8.setText(retx.get("desc_cupom").getAsString());
                            validade_cup8.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCard_5(){
        url = Host + "/listarcupom_popup5.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_9.setText(retx.get("cod_cupom").getAsString());
                            tit_cup9.setText(retx.get("nome_cupom").getAsString());
                            desc_cup9.setText(retx.get("desc_cupom").getAsString());
                            validade_cup9.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

    public void ListarCard_6(){
        url = Host + "/listarcupom_popup6.php";
        Ion.with(Tela_Principal.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (i = 0; i < result.size(); i++) {
                            JsonObject retx = result.get(i).getAsJsonObject();
                            cod_10.setText(retx.get("cod_cupom").getAsString());
                            tit_cup10.setText(retx.get("nome_cupom").getAsString());
                            desc_cup10.setText(retx.get("desc_cupom").getAsString());
                            validade_cup10.setText(retx.get("validade_cupom").getAsString());
                        }
                    }
                });
    }

}