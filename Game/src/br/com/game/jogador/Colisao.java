package br.com.game.jogador;

import br.com.game.mapas.TileMap;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;

public class Colisao {

    private int colEsqX;
    private int colDirX;
    private int rowTopoY;
    private int rowBaseY;
    private boolean temColisao;

    public Colisao() {}

    public boolean verificarColisao(TileMap cenaDoJogo, Jogador player, Jogador player2, String direcao) {
        temColisao = false;
        int bordaEsqX = player.getAreaSolida().x;
        int bordaDirX = player.getAreaSolida().x + (int) player.getAreaSolida().getWidth();
        int bordaTopoY = player.getAreaSolida().y;
        int bordaBaseY = player.getAreaSolida().y + (int) player.getAreaSolida().getHeight();

        this.colEsqX = bordaEsqX / 48;
        this.colDirX = bordaDirX / 48;
        this.rowTopoY = bordaTopoY / 48;
        this.rowBaseY = bordaBaseY / 48;

        if (direcao == "cima" || direcao == "p2cima") {
            int prox_rowTopoY = (bordaTopoY - player.getVelocidade()) / 48;

            if (player.getAreaSolida().y > 0) {
                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[prox_rowTopoY][colEsqX]);

                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }

                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[prox_rowTopoY][colDirX]);
                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }
            } else {
              if (cenaDoJogo.getCenaValida() == "BE") {
                  cenaDoJogo.setCenaValida("TE");
              } else {
                  cenaDoJogo.setCenaValida("TD");
              }

              int alturaCenario = cenaDoJogo.getCenarioValido().length * 48;
              player.setPosY( alturaCenario - (int) player.getAreaSolida().getHeight());
              player2.setPosX(200);
              player2.setPosY(200);
            }

        } else if (direcao == "baixo" || direcao == "p2baixo") {
            int prox_rowBaseY = (bordaBaseY + player.getVelocidade()) / 48;

            if (prox_rowBaseY < cenaDoJogo.getCenarioValido().length) {
                if (player.getInventario()[0].getQtdeObjeto() > 0 &&
                        (cenaDoJogo.getCenarioValido()[prox_rowBaseY][colEsqX] == 6 || cenaDoJogo.getCenarioValido()[prox_rowBaseY][colDirX] == 6)) {
                    cenaDoJogo.carregarPortaAberta();
                    player.getInventario()[0].qtdeObjeto = player.getInventario()[0].qtdeObjeto - 1;
                }

                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[prox_rowBaseY][colEsqX]);

                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }

                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[prox_rowBaseY][colDirX]);
                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }
            } else {
                if (cenaDoJogo.getCenaValida() == "TE") {
                    cenaDoJogo.setCenaValida("BE");
                } else {
                    cenaDoJogo.setCenaValida("BD");
                }
                player.setPosY((int) player.getAreaSolida().getHeight());
                player2.setPosX(200);
                player2.setPosY(200);
            }

        } else if (direcao == "direita" || direcao == "p2direita") {
            int prox_colDirX = (bordaDirX + player.getVelocidade()) / 48;

            if (prox_colDirX < cenaDoJogo.getCenarioValido()[0].length) {
                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[rowBaseY][prox_colDirX]);

                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }

                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[rowTopoY][prox_colDirX]);
                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }
            } else {
                if (cenaDoJogo.getCenaValida() == "TE") {
                    cenaDoJogo.setCenaValida("TD");
                } else {
                    cenaDoJogo.setCenaValida("BD");
                }
                player.setPosX((int) player.getAreaSolida().getWidth());
                player2.setPosX(200);
                player2.setPosY(200);
            }
        } else if (direcao == "esquerda" || direcao == "p2esquerda") {
            int prox_colEsqX = (bordaEsqX - player.getVelocidade()) / 48;

            if (player.getAreaSolida().x < 0) {
                if (cenaDoJogo.getCenaValida() == "TD") {
                    cenaDoJogo.setCenaValida("TE");
                } else {
                    cenaDoJogo.setCenaValida("BE");
                }

                int larguraCenario = cenaDoJogo.getCenarioValido()[0].length * 48;
                player.setPosX( larguraCenario - (int) player.getAreaSolida().getWidth());
                player2.setPosX(200);
                player2.setPosY(200);
            }else {
                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[rowBaseY][prox_colEsqX]);

                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }

                cenaDoJogo.getPecaDoCenario().carregarPecaDaMatriz(cenaDoJogo.getCenarioValido()[rowTopoY][prox_colEsqX]);
                if (cenaDoJogo.getPecaDoCenario().isColisao()) {
                    this.temColisao = Boolean.TRUE;
                }
            }
        }

        return temColisao;
    }

    public boolean verificarColisao(Rectangle sprite1, Rectangle sprite2) {
        boolean retorno = Boolean.FALSE;
        if (sprite1.intersects(sprite2)){
            retorno = Boolean.TRUE;
        }

        return retorno;
    }

}
