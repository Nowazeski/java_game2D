package br.com.game.gameloop;

import br.com.game.jogador.EscutadorTeclado;
import br.com.game.jogador.EscutadorTecladoWASD;
import br.com.game.mapas.Painel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpriteLoop extends Thread implements Runnable, ActionListener {
    private static final int FPS = 10;
    Timer controleDoTempo;
    long contadorDeFPS;
    Painel cenaDoJogo;
    EscutadorTeclado escutadorTeclado;
    EscutadorTecladoWASD escutadorTecladoWASD;

    public SpriteLoop(Painel cenaDoJogo, EscutadorTeclado escutadorTeclado, EscutadorTecladoWASD escutadorTecladoWASD) {
        this.cenaDoJogo = cenaDoJogo;
        this.escutadorTeclado = escutadorTeclado;
        this.escutadorTecladoWASD = escutadorTecladoWASD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.contadorDeFPS = 0;
    }

    @Override
    public void run() {
        this.contadorDeFPS = 0;
        this.controleDoTempo = new Timer(1000, this);
        this.controleDoTempo.start();
        double frameRate = 1000000000/FPS;
        double tempoDecorrido = 0;
        long tempoUltimaMedidaDoLoop = System.nanoTime();
        long tempoAtualDoLoop;

        while (this.isAlive()) {
            tempoAtualDoLoop = System.nanoTime();
            tempoDecorrido = tempoAtualDoLoop + (tempoAtualDoLoop - tempoUltimaMedidaDoLoop) / frameRate;
            tempoUltimaMedidaDoLoop = tempoAtualDoLoop;

            if (tempoDecorrido >= 1) {
                this.cenaDoJogo.getPlayer().atualizarSprite(this.escutadorTeclado);
                this.cenaDoJogo.getPlayer2().atualizarSprite(this.escutadorTecladoWASD);
                this.contadorDeFPS++;
                tempoDecorrido = 0;
            }
        }
    }
}
