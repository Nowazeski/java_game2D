package br.com.game.mapas;
import br.com.game.configs.PosicoesEnum;

import java.awt.*;
import javax.swing.*;

public class Moldura extends JFrame{

	public Moldura(){
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		Painel P1 =  new Painel(PosicoesEnum.CENTRO);
		this.add(P1,BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setExtendedState(EXIT_ON_CLOSE);
		this.setAlwaysOnTop(Boolean.TRUE);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
}
