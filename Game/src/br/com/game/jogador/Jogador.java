package br.com.game.jogador;
import javax.swing.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.*;

public class Jogador extends Rectangle {

	private int posX;
	private int posY;
	private int largura;
	private int altura;
	private Image imagemPlayer;
	private Image imagemD1, imagemR1, imagemL1, imagemU1;
	private Image imagemD2, imagemR2, imagemL2, imagemU2;
	private Image imagemD3, imagemR3, imagemL3, imagemU3;
	private Rectangle areaSolida;
	private int velocidade = 3;
	private Inventario[] inventario;

	public Jogador(int posX, int posY, int largura, int altura){
		this.posX = posX;
		this.posY = posY;
		this.largura = largura;
		this.altura = altura;
		this.carregarImagensDoJogador();
		this.definirValoresAreaSolidaJogador();
	}

	private void carregarImagensDoJogador() {
		ImageIcon icon;
		icon = new ImageIcon("resources/player/down1.png");
		this.imagemPlayer = icon.getImage();

		icon = new ImageIcon("resources/player/down1.png");
		this.imagemD1 = icon.getImage();

		icon = new ImageIcon("resources/player/left1.png");
		this.imagemL1 = icon.getImage();

		icon = new ImageIcon("resources/player/right1.png");
		this.imagemR1 = icon.getImage();

		icon = new ImageIcon("resources/player/up1.png");
		this.imagemU1 = icon.getImage();

		icon = new ImageIcon("resources/player/down2.png");
		this.imagemD2 = icon.getImage();

		icon = new ImageIcon("resources/player/left2.png");
		this.imagemL2 = icon.getImage();

		icon = new ImageIcon("resources/player/right2.png");
		this.imagemR2 = icon.getImage();

		icon = new ImageIcon("resources/player/up2.png");
		this.imagemU2 = icon.getImage();

		icon = new ImageIcon("resources/player/down3.png");
		this.imagemD3 = icon.getImage();

		icon = new ImageIcon("resources/player/left3.png");
		this.imagemL3 = icon.getImage();

		icon = new ImageIcon("resources/player/right3.png");
		this.imagemR3 = icon.getImage();

		icon = new ImageIcon("resources/player/up3.png");
		this.imagemU3 = icon.getImage();

		this.inventario = new Inventario[2];
		this.inventario[0] = new Inventario("chave");
		this.inventario[1] = new Inventario("moeda");
	}

	public void capturarObjeto(String nome) {
		for (int i = 0; i < inventario.length; i++) {
			if (this.inventario[i].nomeObjeto == nome) {
				this.inventario[i].qtdeObjeto++;
				break;
			}
		}
	}


	public void desenhar(Graphics2D desenho){
		desenho.setColor(new Color(255, 255, 255, 0));
		desenho.fillRect(this.areaSolida.x, this.areaSolida.y, this.areaSolida.width, this.areaSolida.height);
		desenho.drawImage(this.imagemPlayer, this.posX, this.posY, this.largura, this.altura, null);
	}

	public void atualizarPosicao(EscutadorTeclado escutadorTeclado) {
		if (escutadorTeclado.isMovePraEsq()) {
			this.posX = this.posX - this.velocidade;
		} else if (escutadorTeclado.isMovePraDir()) {
			this.posX = this.posX + this.velocidade;
		} else if (escutadorTeclado.isMovePraCima()) {
			this.posY = this.posY - this.velocidade;
		} else if (escutadorTeclado.isMovePraBaixo()) {
			this.posY = this.posY + this.velocidade;
		}

		this.areaSolida.x = this.posX + 7;
		this.areaSolida.y = this.posY + this.altura / 2;
	}

	public void atualizarPosicao(EscutadorTecladoWASD escutadorTeclado) {
		if (escutadorTeclado.isMovePraEsq()) {
			this.posX = this.posX - this.velocidade;
		} else if (escutadorTeclado.isMovePraDir()) {
			this.posX = this.posX + this.velocidade;
		} else if (escutadorTeclado.isMovePraCima()) {
			this.posY = this.posY - this.velocidade;
		} else if (escutadorTeclado.isMovePraBaixo()) {
			this.posY = this.posY + this.velocidade;
		}

		this.areaSolida.x = this.posX + 7;
		this.areaSolida.y = this.posY + this.altura / 2;
	}

	public void atualizarSprite(EscutadorTeclado escutadorTeclado) {
		if (escutadorTeclado.isMovePraEsq()) {
			if (this.imagemPlayer == this.imagemL1) {
				this.imagemPlayer = this.imagemL2;
			}else if (this.imagemPlayer == this.imagemL2) {
				this.imagemPlayer = this.imagemL3;
			} else {
				this.imagemPlayer = this.imagemL1;
			}
		} else if (escutadorTeclado.isMovePraDir()) {
			if (this.imagemPlayer == this.imagemR1) {
				this.imagemPlayer = this.imagemR2;
			}else if (this.imagemPlayer == this.imagemR2) {
				this.imagemPlayer = this.imagemR3;
			} else {
				this.imagemPlayer = this.imagemR1;
			}
		} else if (escutadorTeclado.isMovePraCima()) {
			if (this.imagemPlayer == this.imagemU1) {
				this.imagemPlayer = this.imagemU2;
			}else if (this.imagemPlayer == this.imagemU2) {
				this.imagemPlayer = this.imagemU3;
			} else {
				this.imagemPlayer = this.imagemU1;
			}
		} else if (escutadorTeclado.isMovePraBaixo()) {
			if (this.imagemPlayer == this.imagemD1) {
				this.imagemPlayer = this.imagemD2;
			}else if (this.imagemPlayer == this.imagemD2) {
				this.imagemPlayer = this.imagemD3;
			} else {
				this.imagemPlayer = this.imagemD1;
			}
		}
	}

	public void atualizarSprite(EscutadorTecladoWASD escutadorTeclado) {
		if (escutadorTeclado.isMovePraEsq()) {
			if (this.imagemPlayer == this.imagemL1) {
				this.imagemPlayer = this.imagemL2;
			}else if (this.imagemPlayer == this.imagemL2) {
				this.imagemPlayer = this.imagemL3;
			} else {
				this.imagemPlayer = this.imagemL1;
			}
		} else if (escutadorTeclado.isMovePraDir()) {
			if (this.imagemPlayer == this.imagemR1) {
				this.imagemPlayer = this.imagemR2;
			}else if (this.imagemPlayer == this.imagemR2) {
				this.imagemPlayer = this.imagemR3;
			} else {
				this.imagemPlayer = this.imagemR1;
			}
		} else if (escutadorTeclado.isMovePraCima()) {
			if (this.imagemPlayer == this.imagemU1) {
				this.imagemPlayer = this.imagemU2;
			}else if (this.imagemPlayer == this.imagemU2) {
				this.imagemPlayer = this.imagemU3;
			} else {
				this.imagemPlayer = this.imagemU1;
			}
		} else if (escutadorTeclado.isMovePraBaixo()) {
			if (this.imagemPlayer == this.imagemD1) {
				this.imagemPlayer = this.imagemD2;
			}else if (this.imagemPlayer == this.imagemD2) {
				this.imagemPlayer = this.imagemD3;
			} else {
				this.imagemPlayer = this.imagemD1;
			}
		}
	}

	public void definirValoresAreaSolidaJogador() {
		this.areaSolida = new Rectangle();
		this.areaSolida.x = this.posX + 7;
		this.areaSolida.y = this.posY + this.altura / 2;
		this.areaSolida.width = this.largura - 20;
		this.areaSolida.height = this.altura / 2;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Rectangle getAreaSolida() {
		return this.areaSolida;
	}

	public int getVelocidade() {
		return this.velocidade;
	}

	public Inventario[] getInventario() {
		return this.inventario;
	}
}
