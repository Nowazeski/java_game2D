package br.com.game.mapas;

import java.awt.*;

public class TileMap {

    Tile pecaDoCenario;

    int[][] cenarioValido;
    Cenarios cenarios;
    String cenaValida;
    public TileMap(){
        this.cenarios = new Cenarios();
        this.cenarioValido = this.cenarios.getCenarioTopEsq();
        this.cenaValida = "TE";
        this.pecaDoCenario = new Tile();
    }

    public void desenhar(Graphics2D mapa) {
        int pecaDaMatriz;

        for (int col = 0; col < cenarioValido[0].length; col++) {
            for (int row = 0; row < cenarioValido.length; row++) {
                pecaDaMatriz = cenarioValido[row][col];
                this.pecaDoCenario.carregarPecaDaMatriz(pecaDaMatriz);
                this.pecaDoCenario.desenhar(mapa, row, col);
            }
        }
    }

    public Tile getPecaDoCenario() {
        return this.pecaDoCenario;
    }

    public int[][] getCenarioValido() {
        return this.cenarioValido;
    }

    public String getCenaValida() {
        return this.cenaValida;
    }

    public void setCenaValida(String cenaValida) {
        this.cenaValida = cenaValida;
        switch (this.cenaValida) {
            case "BE":
                this.cenarioValido = this.cenarios.getCenarioBasEsq();
                break;
            case "BD":
                this.cenarioValido = this.cenarios.getCenarioBasDir();
                break;
            case "TE":
                this.cenarioValido = this.cenarios.getCenarioTopEsq();
                break;
            case "TD":
                this.cenarioValido = this.cenarios.getCenarioTopDir();
                break;
        }
    }

    public Cenarios getCenarios() {
        return this.cenarios;
    }

    public void carregarPortaAberta() {
        this.cenarios.criarCenariosDePortaAberta();
        this.cenarioValido = this.cenarios.getCenarioTopEsq();
    }
}
