package br.com.game.gameloop;

import br.com.game.jogador.Colisao;
import br.com.game.jogador.EscutadorTeclado;
import br.com.game.jogador.EscutadorTecladoWASD;
import br.com.game.mapas.Painel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop implements Runnable, ActionListener {

    public static final int FPS = 60;
    private Timer controleDoTempoDoJogo;
    private long contadorDePrints;
    private Thread gameLoop;
    private Painel tela;
    private EscutadorTeclado escutadorTeclado;
    private EscutadorTecladoWASD escutadorTecladoWASD;
    private Colisao colisao;

    public GameLoop(Painel tela, EscutadorTeclado escutadorTeclado, EscutadorTecladoWASD escutadorTecladoWASD) {
        this.tela = tela;
        this.escutadorTeclado = escutadorTeclado;
        this.escutadorTecladoWASD = escutadorTecladoWASD;
        this.gameLoop = new Thread(this);
        this.gameLoop.start();
        this.colisao = new Colisao();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.contadorDePrints = 0;
    }

    @Override
    public void run() {
        this.controleDoTempoDoJogo = new Timer(1000, this);
        this.controleDoTempoDoJogo.start();
        this.contadorDePrints = 0;
        double frameRate = 1000 / FPS;
        double tempoDecorrido = 0;
        long tempoUltimaMedidaLoop = System.currentTimeMillis();
        long tempoAtualDoLoop;

        while(this.gameLoop.isAlive()) {
            tempoAtualDoLoop = System.currentTimeMillis();
            tempoDecorrido = tempoDecorrido + (tempoAtualDoLoop - tempoUltimaMedidaLoop) / frameRate;
            tempoUltimaMedidaLoop = tempoAtualDoLoop;

            if (tempoDecorrido >= 1) {

                String direcao = "cima";
                if (escutadorTeclado.isMovePraBaixo()) direcao = "cima";
                if (escutadorTeclado.isMovePraBaixo()) direcao = "baixo";
                if (escutadorTeclado.isMovePraDir()) direcao = "direita";
                if (escutadorTeclado.isMovePraEsq()) direcao = "esquerda";

                boolean bateu = colisao.verificarColisao(this.tela.getCenario(), this.tela.getPlayer(), this.tela.getPlayer2(), direcao);

                if (!bateu) {
                    this.tela.getPlayer().atualizarPosicao(escutadorTeclado);

                    for (int num_obj = 0; num_obj < this.tela.getObj().length; num_obj++) {
                        if (this.tela.getObj()[num_obj].isVisivel()) {
                            if (this.tela.getObj()[num_obj].getCena() == this.tela.getCenario().getCenaValida()) {
                                boolean bateuEmObj = colisao.verificarColisao(this.tela.getPlayer().getAreaSolida(), this.tela.getObj()[num_obj].getAreaSolida());

                                if (bateuEmObj) {
                                    this.tela.getObj()[num_obj].setVisivel(Boolean.FALSE);
                                    this.tela.getPlayer().capturarObjeto(this.tela.getObj()[num_obj].getNomeObj());
                                    System.out.println("número da chaves: " + this.tela.getPlayer().getInventario()[0].getQtdeObjeto());
                                    System.out.println("número da moedas: " + this.tela.getPlayer().getInventario()[1].getQtdeObjeto());
                                }
                            }
                        }
                    }
                }

                String p2direcao = "p2cima";
                if (escutadorTecladoWASD.isMovePraBaixo()) p2direcao = "p2cima";
                if (escutadorTecladoWASD.isMovePraBaixo()) p2direcao = "p2baixo";
                if (escutadorTecladoWASD.isMovePraDir()) p2direcao = "p2direita";
                if (escutadorTecladoWASD.isMovePraEsq()) p2direcao = "p2esquerda";

                boolean p2bateu = colisao.verificarColisao(this.tela.getCenario(), this.tela.getPlayer2(), this.tela.getPlayer(), p2direcao);

                if (!p2bateu) {
                    this.tela.getPlayer2().atualizarPosicao(escutadorTecladoWASD);

                    for (int num_obj = 0; num_obj < this.tela.getObj().length; num_obj++) {
                        if (this.tela.getObj()[num_obj].isVisivel()) {
                            if (this.tela.getObj()[num_obj].getCena() == this.tela.getCenario().getCenaValida()) {
                                boolean bateuEmObj = colisao.verificarColisao(this.tela.getPlayer2().getAreaSolida(), this.tela.getObj()[num_obj].getAreaSolida());

                                if (bateuEmObj) {
                                    this.tela.getObj()[num_obj].setVisivel(Boolean.FALSE);
                                    this.tela.getPlayer2().capturarObjeto(this.tela.getObj()[num_obj].getNomeObj());
                                    System.out.println("número da chaves: " + this.tela.getPlayer2().getInventario()[0].getQtdeObjeto());
                                    System.out.println("número da moedas: " + this.tela.getPlayer2().getInventario()[1].getQtdeObjeto());
                                }
                            }
                        }
                    }
                }

                this.contadorDePrints++;
                this.tela.repaint();
                tempoDecorrido = 0;
            }
        }
    }
}
