package br.com.game.configs;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

public enum TeclasEnum {

    ESQUERDA(37),
    CIMA(38),
    DIREITA(39),
    BAIXO(40),
    P2ESQUERDA(65),
    P2CIMA(87),
    P2DIREITA(68),
    P2BAIXO(83);

    private int keyCode;

    TeclasEnum(int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public static TeclasEnum getPorKeyCode(int keyCode) {
        Optional<TeclasEnum> oTecla =
                Arrays.stream(TeclasEnum.values()).filter(tecla -> tecla.keyCode == keyCode).findFirst();

        return oTecla.orElse(null);
    }
}
