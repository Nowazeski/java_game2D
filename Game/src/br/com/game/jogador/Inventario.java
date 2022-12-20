package br.com.game.jogador;

public class Inventario {
    String nomeObjeto;
    int qtdeObjeto;

    public Inventario(String nome) {
        this.nomeObjeto = nome;
        this.qtdeObjeto = 0;
    }

    public int getQtdeObjeto() {
        return this.qtdeObjeto;
    }

    public String getNomeObjeto() {
        return this.nomeObjeto;
    }
}
