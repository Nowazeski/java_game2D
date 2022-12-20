package br.com.game.mapas;

import br.com.game.configs.PosicoesEnum;
import br.com.game.gameloop.GameLoop;
import br.com.game.gameloop.SpriteLoop;
import br.com.game.jogador.*;

import java.awt.*;
import javax.swing.*;

import java.awt.Color;

public class Painel extends JPanel {
	private Painel PPainel;
	private Jogador player = new Jogador(100,100,48,48);

	private Jogador player2 = new Jogador(150, 150, 48, 48);
	int PosX,PosY;
	PosicoesEnum posicao;
	private GameLoop gameLoop;

	private EscutadorTeclado escutadorTeclado;
	private EscutadorTecladoWASD escutadorTecladoWASD;
	private SpriteLoop spriteLoop;
	private TileMap cenario;
	private Objetos[] obj;

	Painel(PosicoesEnum posicao) {
		this.posicao = posicao;
		this.obj = new Objetos[2];
		this.obj[0] = new Objetos(200, 200, "TE", "chave");
		this.obj[1] = new Objetos(300, 400, "BD", "moeda");
		this.cenario = new TileMap();
		this.escutadorTeclado = new EscutadorTeclado();
		this.escutadorTecladoWASD = new EscutadorTecladoWASD();
		this.setFocusable(Boolean.TRUE);
		this.addKeyListener(this.escutadorTeclado);
		this.addKeyListener(this.escutadorTecladoWASD);
		this.setPreferredSize(new Dimension(768,480));
		this.setBackground(new Color(0,0,0));
		this.setFocusable(true);
		this.gameLoop = new GameLoop(this, this.escutadorTeclado, this.escutadorTecladoWASD);

		spriteLoop = new SpriteLoop(this, escutadorTeclado, escutadorTecladoWASD);
		spriteLoop.start();
	}

	@Override
	public void paintComponent(Graphics mapa){
		super.paintComponent(mapa);

		Graphics2D gMapa = (Graphics2D) mapa;
		this.cenario.desenhar(gMapa);
		this.player.desenhar(gMapa);
		this.player2.desenhar(gMapa);

		if (this.cenario.getCenaValida() == "TE") {
			for (int i = 0; i < this.obj.length; i++) {
				if (obj[i].getCena() == "TE") {
					obj[i].desenhar((Graphics2D) mapa);
				}
			}
		}else if (this.cenario.getCenaValida() == "BD") {
			for (int i = 0; i < this.obj.length; i++) {
				if (obj[i].getCena() == "BD") {
					obj[i].desenhar((Graphics2D) mapa);
				}
			}
		}else if (this.cenario.getCenaValida() == "TD") {
			for (int i = 0; i < this.obj.length; i++) {
				if (obj[i].getCena() == "TD") {
					obj[i].desenhar((Graphics2D) mapa);
				}
			}
		}
		else if (this.cenario.getCenaValida() == "BE") {
			for (int i = 0; i < this.obj.length; i++) {
				if (obj[i].getCena() == "BE") {
					obj[i].desenhar((Graphics2D) mapa);
				}
			}
		}


	}

	Painel(PosicoesEnum posicao, Painel PP) {
		this(posicao);
		this.PPainel = PP;
	}


	public Jogador getPlayer() {
		return this.player;
	}

	public Jogador getPlayer2() {
		return this.player2;
	}

	public TileMap getCenario() {
		return this.cenario;
	}

	public Objetos[] getObj() {
		return this.obj;
	}
}
