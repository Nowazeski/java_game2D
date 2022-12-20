package br.com.game.jogador;

import br.com.game.configs.TeclasEnum;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscutadorTeclado implements KeyListener {

    private boolean movePraBaixo, movePraCima, movePraEsq, movePraDir;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        TeclasEnum tecla = TeclasEnum.getPorKeyCode(e.getKeyCode());

        if (tecla != null) {
            switch (tecla) {
                case ESQUERDA:
                    this.movePraEsq = Boolean.TRUE;
                    break;
                case CIMA:
                    this.movePraCima = Boolean.TRUE;
                    break;
                case DIREITA:
                    this.movePraDir = Boolean.TRUE;
                    break;
                case BAIXO:
                    this.movePraBaixo = Boolean.TRUE;
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        TeclasEnum tecla = TeclasEnum.getPorKeyCode(e.getKeyCode());

        if (tecla != null) {
            switch (tecla) {
                case ESQUERDA:
                    this.movePraEsq = Boolean.FALSE;
                    break;
                case CIMA:
                    this.movePraCima = Boolean.FALSE;
                    break;
                case DIREITA:
                    this.movePraDir = Boolean.FALSE;
                    break;
                case BAIXO:
                    this.movePraBaixo = Boolean.FALSE;
                    break;
            }
        }
    }

    public boolean isMovePraBaixo() {
        return movePraBaixo;
    }

    public boolean isMovePraCima() {
        return movePraCima;
    }

    public boolean isMovePraEsq() {
        return movePraEsq;
    }

    public boolean isMovePraDir() {
        return movePraDir;
    }
}
