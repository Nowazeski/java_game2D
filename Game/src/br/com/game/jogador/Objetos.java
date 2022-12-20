package br.com.game.jogador;

import javax.swing.*;
import java.awt.*;

public class Objetos {

    private int posX;
    private int posY;
    private int largura = 48;
    private int altura = 48;
    private Image imagemObjeto;
    private String nomeObj;
    private String cena;
    private Rectangle areaSolida;
    private boolean visivel;

    public Objetos(int x, int y, String cena, String nome) {
        this.posX = x;
        this.posY = y;
        this.nomeObj = nome;
        this.cena = cena;

        ImageIcon icon;
        String caminho = "";
        if (this.nomeObj == "chave") {
            caminho = "resources/objects/" + this.nomeObj + ".png";
        } else if (this.nomeObj == "moeda") {
            caminho = "resources/objects/" + this.nomeObj + ".png";
        }

        icon = new ImageIcon(caminho);
        this.imagemObjeto = icon.getImage();
        this.visivel = Boolean.TRUE;

        this.areaSolida = new Rectangle();
        this.areaSolida.x = this.posX + 10;
        this.areaSolida.y = this.posY + 12;
        this.areaSolida.width = this.largura - 17;
        this.areaSolida.height = this.altura - 25;
    }

    public void desenhar(Graphics2D desenho){
        if (this.visivel) {
            desenho.setColor(new Color(255, 255, 255, 0));
            desenho.fillRect(this.areaSolida.x, this.areaSolida.y, this.areaSolida.width, this.areaSolida.height);
            desenho.drawImage(this.imagemObjeto, this.posX, this.posY, this.largura, this.altura, null);
        }
    }

    public String getCena() {
        return this.cena;
    }

    public boolean isVisivel() {
        return this.visivel;
    }

    public Rectangle getAreaSolida() {
        return this.areaSolida;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public String getNomeObj() {
        return this.nomeObj;
    }

}
