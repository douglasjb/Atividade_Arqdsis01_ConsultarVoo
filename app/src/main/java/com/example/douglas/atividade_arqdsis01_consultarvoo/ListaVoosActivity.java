package com.example.douglas.atividade_arqdsis01_consultarvoo;

/**
 * Created by Douglas on 11/09/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.util.TreeSet;

public class ListaVoosActivity extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voos);

        Especialista especialista = new Especialista();

        Intent intent = getIntent();//pega a mensagem do intent
        String origem = intent.getStringExtra(MainActivity.ORIGEM);
        String destino = intent.getStringExtra(MainActivity.DESTINO);

        TreeSet<Voos> lista = especialista.listarViagens(origem, destino);

        TextView textView = (TextView) findViewById(R.id.txt_lista_voos);//cria o texto da view
        String message = "";
        for(Voos voos:lista){
            message += voos.getNome() + "\n";
        }
        if(message.length() == 0) {
            message = "Nenhuma informação encontrada para o critério escolhido.";
            textView.setLines(3);
        } else {
            textView.setLines(lista.size());
        }
        textView.setText(message);
    }

}