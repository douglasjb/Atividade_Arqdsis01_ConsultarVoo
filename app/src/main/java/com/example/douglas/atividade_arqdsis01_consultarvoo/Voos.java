package com.example.douglas.atividade_arqdsis01_consultarvoo;

/**
 * Created by Douglas on 11/09/2015.
 */
public class Voos {
    private String nome;
    private String origem;
    private String destino;
    private String imagem;
    private double preco;
    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Voos(String nome, String origem, String destino, String imagem, double preco) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.imagem = imagem;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public double getPreco() {return preco;}

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }


    public String toString() {
        return "com.example.douglas.consultavoos{" +
                "nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                ", preco='" + preco + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }

    public int compareTo(Voos voos) {
        if (nome.equals(voos.getNome())
                && origem.equals(voos.getOrigem())
                && destino.equals(voos.getDestino())) {
            return 0;
        }
        return this.getNome().compareTo(voos.getNome());
    }
}
