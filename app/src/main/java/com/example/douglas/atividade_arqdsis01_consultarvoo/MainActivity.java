package com.example.douglas.atividade_arqdsis01_consultarvoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity{

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    Button btnConsultar;
    String origem, destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        origem = "";
        destino = "";
        btnConsultar = (Button) findViewById(R.id.botao_enviar);
        //spinnerOrigem = (Spinextends ActionBarActivityner) findViewById(R.id.dropdown_origens);
        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origens);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionada());
        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destinos);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionado());
    }

    private class OrigemSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    }

    private class DestinoSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            destino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    }

    // constante static para identificar a mensagem
    public final static String ORIGEM = "br.usjt.ORIGEM";
    public final static String DESTINO = "br.usjt.DESTINO";

    //será chamado quando o usuário clicar em enviar
    public void consultarVoos(View view) {

        String pOrigem = this.origem.equals("Origem")?"":origem;
        String pDestino = this.destino.equals("Destino")?"":destino;

        Intent intent = new Intent(this, ListaVoosActivity.class);;
        intent.putExtra(ORIGEM, pOrigem);
        intent.putExtra(DESTINO, pDestino);
        startActivity(intent);
    }
}
