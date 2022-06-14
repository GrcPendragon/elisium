package com.testingdevops.elisium;

import java.util.Random;

/**
 *
 * @author Fausto Garcia
 */
public class Password {

    private final String NUMBER = "0123456789";
    private final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String SPECIAL = "$@#Ññ";
    private final int PIN_LENGHT = 4;
    private final int PASS_LENGHT = 8;
    private final StringBuilder pass;
    private final Random roulette;

    /**
     * Este constructor asigna a memoria los objetos Ramdom y la cada pass
     */
    public Password() {
        roulette = new Random();
        this.pass = new StringBuilder();
    }

    /**
     * Este metodo genera una cadena de 4 digitos numericos.
     *
     * @return retorna una cadena con el codigo PIN generado
     */
    public String getPin() {
        for (int i = 0; i < PIN_LENGHT; i++) {
            this.pass.append(getNumber());
        }
        return this.pass.toString();
    }

    /**
     * Este metodo genera una cadena de digitos variables, segun los pasados por
     * parametros.
     *
     * @param pin_Length
     * @return retorna una cadena con el codigo PIN generado.
     */
    public String getPin(int pin_Length) {
        for (int i = 0; i < pin_Length; i++) {
            this.pass.append(getNumber());
        }
        return this.pass.toString();
    }

    /**
     * Este metodo genera una password con una longitud de 8 caracteres
     * alfanumericos
     *
     * @return retorna una cadena con la password de 8 caracteres.
     */
    public String getPassword() {
        int opt;
        for (int i = 0; i < PASS_LENGHT; i++) {
            opt = roulette.nextInt(1, 3);
            switch (opt) {
                case 1 ->
                    this.pass.append(getNumber());
                case 2 ->
                    this.pass.append(getLowercase());
                case 3 ->
                    this.pass.append(getUppercase());
                default ->
                    throw new AssertionError();
            }
        }
        return this.pass.toString();
    }

    public String getPasswordSpecial() {
        int opt;
        for (int i = 0; i < PASS_LENGHT; i++) {
            opt = roulette.nextInt(1, 4);
            switch (opt) {
                case 1 ->
                    this.pass.append(getNumber());
                case 2 ->
                    this.pass.append(getLowercase());
                case 3 ->
                    this.pass.append(getUppercase());
                case 4 ->
                    this.pass.append(getSpecial());
                default ->
                    throw new AssertionError();
            }
        }
        return this.pass.toString();
    }

    /**
     * Este metodo genera una password con una longitud variable, alfanumerica.
     *
     * @param pass_Lenght
     * @return retorna una cadena con la password generada.
     */
    public String getPassword(int pass_Lenght) {
        int opt;
        for (int i = 0; i < pass_Lenght; i++) {
            opt = roulette.nextInt(1, 3);
            switch (opt) {
                case 1 ->
                    this.pass.append(getNumber());
                case 2 ->
                    this.pass.append(getLowercase());
                case 3 ->
                    this.pass.append(getUppercase());
                default ->
                    throw new AssertionError();
            }
        }
        return this.pass.toString();
    }

    public String getPasswordSpecial(int pass_Lenght) {
        int opt;
        for (int i = 0; i < pass_Lenght; i++) {
            opt = roulette.nextInt(1, 4);
            switch (opt) {
                case 1 ->
                    this.pass.append(getNumber());
                case 2 ->
                    this.pass.append(getLowercase());
                case 3 ->
                    this.pass.append(getUppercase());
                case 4 ->
                    this.pass.append(getSpecial());
                default ->
                    throw new AssertionError();
            }
        }
        return this.pass.toString();
    }

    private char getNumber() {
        return NUMBER.charAt(roulette.nextInt(1, 10));
    }

    private char getLowercase() {
        return LOWERCASE.charAt(roulette.nextInt(1, 26));
    }

    private char getUppercase() {
        return UPPERCASE.charAt(roulette.nextInt(1, 26));
    }

    private char getSpecial() {
        return SPECIAL.charAt(roulette.nextInt(1, 26));
    }
}
