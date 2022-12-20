package br.com.game.mapas;

import javax.swing.*;
import java.awt.*;

public class Tile {

	private int posX, posY;
    private final int largura = 48, altura = 48;
    private Image imgAtual;

    private Image imgGrass, imgSand, imgWall, imgWater;
    private Image imgWhite, imgGray;

    private Image imgDoorOpen, imgDoorClose;
    private boolean colisao;

    public Tile() {
        this.carregarImagensTiles();
    }

    public void desenhar(Graphics2D mapa, int linha, int coluna) {
        this.posX = coluna * this.largura;
        this.posY = linha * this.altura;
        mapa.drawImage(this.imgAtual, this.posX, this.posY, this.largura, this.altura, null);
    }

    private void carregarImagensTiles() {
        ImageIcon icon;
        icon = new ImageIcon("resources/tiles/grass1.png");
        this.imgGrass = icon.getImage();

        icon = new ImageIcon("resources/tiles/sand1.png");
        this.imgSand = icon.getImage();

        icon = new ImageIcon("resources/tiles/water1.png");
        this.imgWater = icon.getImage();

        icon = new ImageIcon("resources/tiles/wall1.png");
        this.imgWall = icon.getImage();

        icon = new ImageIcon("resources/tiles/white.png");
        this.imgWhite = icon.getImage();

        icon = new ImageIcon("resources/tiles/gray.png");
        this.imgGray = icon.getImage();

        icon = new ImageIcon("resources/tiles/gray.png");
        this.imgGray = icon.getImage();

        icon = new ImageIcon("resources/tiles/door_aberta.png");
        this.imgDoorOpen = icon.getImage();

        icon = new ImageIcon("resources/tiles/door_fechada.png");
        this.imgDoorClose = icon.getImage();
    }

    public void carregarPecaDaMatriz(int valorDaPeca) {
        if (valorDaPeca == 0) {
            this.imgAtual = this.imgWall;
            this.colisao = Boolean.TRUE;
        }
        if (valorDaPeca == 1) {
            this.imgAtual = this.imgSand;
            this.colisao = Boolean.FALSE;
        }
        if (valorDaPeca == 2) {
            this.imgAtual = this.imgWater;
            this.colisao = Boolean.TRUE;
        }
        if (valorDaPeca == 3) {
            this.imgAtual = this.imgGrass;
            this.colisao = Boolean.FALSE;
        }
        if (valorDaPeca == 4) {
            this.imgAtual = this.imgWhite;
            this.colisao = Boolean.FALSE;
        }
        if (valorDaPeca == 5){
            this.imgAtual = this.imgGray;
            this.colisao = Boolean.TRUE;
        }
        if (valorDaPeca == 6) {
            this.imgAtual = this.imgDoorClose;
            this.colisao = Boolean.TRUE;
        }
        if (valorDaPeca == 7) {
            this.imgAtual = this.imgDoorOpen;
            this.colisao = Boolean.FALSE;
        }
    }

    public boolean isColisao() {
        return this.colisao;
    }

    public void setColisao(boolean colisao) {
        this.colisao = colisao;
    }
}
