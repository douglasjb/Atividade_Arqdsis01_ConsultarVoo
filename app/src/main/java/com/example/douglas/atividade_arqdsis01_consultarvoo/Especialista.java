package com.example.douglas.atividade_arqdsis01_consultarvoo;

/**
 * Created by Douglas on 11/09/2015.
 */
import java.util.ArrayList;
import java.util.TreeSet;

public class Especialista {
    private static final ArrayList<Voos> voos01 = cadastroDeVoos();

    public Especialista() {}

    private Voos buscarNome(String nome) {
        for (Voos voos : voos01) {
            if (nome.equals(voos.getNome())) {
                return voos;
            }
        }
        return null;
    }

    public TreeSet<Voos> listarViagens(String origem, String destino) {
        TreeSet<Voos> viagens = new TreeSet<Voos>();

        if (origem.length() > 0 && destino.length() > 0) {
            viagens = buscarOrigemDestino(origem, destino);
        } else if (origem.length() > 0) {
            viagens = buscarOrigem(origem);
        } else if (destino.length() > 0) {
            viagens = buscarDestino(destino);
        } else {
            viagens = todas();
        }
        return viagens;
    }

    private TreeSet<Voos> buscarOrigem(String origem) {
        TreeSet<Voos> lista = new TreeSet<Voos>();
        for (Voos voos : voos01) {
            if (origem.equals(voos.getOrigem())) {
                lista.add(voos);
            }
        }
        return lista;
    }

    private TreeSet<Voos> buscarDestino(String destino) {
        TreeSet<Voos> lista = new TreeSet<Voos>();
        for (Voos voos : voos01) {
            if (destino.equals(voos.getDestino())) {
                lista.add(voos);
            }
        }
        return lista;
    }

    private TreeSet<Voos> buscarOrigemDestino(String origem, String destino) {
        TreeSet<Voos> lista = new TreeSet<Voos>();
        for (Voos voos : voos01) {
            if (origem.equals(voos.getOrigem())
                    && destino.equals(voos.getDestino())) {
                lista.add(voos);
            }
        }
        return lista;
    }

    private TreeSet<Voos> todas() {
        TreeSet<Voos> lista = new TreeSet<Voos>();
        for (Voos voos : voos01) {
            lista.add(voos);
        }
        return lista;
    }

    private static ArrayList<Voos> cadastroDeVoos() {
        ArrayList<Voos> voos = new ArrayList<Voos>();
        voos.add(new Voos("Voo 001", "Brasil - São Paulo", "Eua - Orlando",  "voo001", 2000.00));
        voos.add(new Voos("Voo 002", "Brasil - Rio de Janeiro", "Africa do Sul - Joanesburgo",  "voo002", 1500.00));
        voos.add(new Voos("Voo 003", "Brasil - São Paulo", "Alemanha - Berlin",  "voo003", 3000.00));
        voos.add(new Voos("Voo 004", "Brasil - Rio de Janeiro", "Argentina - Buenos Aires",  "voo004", 1000.00));
        voos.add(new Voos("Voo 005", "Brasil - Brasilia", "Australia - Sidney",  "voo005", 2400.00));
        voos.add(new Voos("Voo 006", "Brasil - Brasilia", "Canada - Vancouver",  "voo006", 2000.00));
        voos.add(new Voos("Voo 007", "Brasil - Curitiba", "Inglaterra - Londres",  "voo007", 4000.00));
        voos.add(new Voos("Voo 008", "Brasil - Curitiba", "Japão - Toquio",  "voo008", 3200.00));
        voos.add(new Voos("Voo 009", "Brasil - Florianopolis", "Brasil - São Paulo",  "voo009", 800.00));
        voos.add(new Voos("Voo 010", "Brasil - Florianopolis", "Brasil - Rio de Janeiro",  "voo010", 900.00));

        return voos;
    }
}
