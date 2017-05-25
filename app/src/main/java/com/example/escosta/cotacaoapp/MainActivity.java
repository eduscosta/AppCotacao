package com.example.escosta.cotacaoapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.escosta.cotacaoapp.databinding.ActivityMainBinding;
import com.example.escosta.cotacaoapp.model.Value;
import com.example.escosta.cotacaoapp.model.moedas.ARS;
import com.example.escosta.cotacaoapp.model.moedas.BTC;
import com.example.escosta.cotacaoapp.model.moedas.EUR;
import com.example.escosta.cotacaoapp.model.moedas.GBP;
import com.example.escosta.cotacaoapp.model.moedas.USD;
import com.example.escosta.cotacaoapp.services.MyService;
import com.example.escosta.cotacaoapp.utils.NetworkHelper;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://api.promasters.net.br/cotacao/v1/valores";

    private boolean networkOk;

    ActivityMainBinding binding;

    String nome;
    float valor;
    int ultimaConsulta;
    String fonte;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Value dataItems = (Value) intent
                    .getParcelableExtra(MyService.MY_SERVICE_PAYLOAD);

            USD dolar = dataItems.getValores().getUSD();
            EUR euro = dataItems.getValores().getEUR();
            BTC bitcoin = dataItems.getValores().getBTC();
            GBP libra = dataItems.getValores().getGBP();
            ARS peso = dataItems.getValores().getARS();

            binding.setEuro(euro);
            binding.setDolar(dolar);
            binding.setLibra(libra);
            binding.setPeso(peso);
            binding.setBitcoin(bitcoin);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(MyService.MY_SERVICE_MESSAGE));

        networkOk = NetworkHelper.hasNetworkAccess(this);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mBroadcastReceiver);
    }

    public void runClickHandler(View view) {

        if (networkOk) {
            Intent intent = new Intent(this, MyService.class);
            intent.setData(Uri.parse(JSON_URL));
            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }
}
