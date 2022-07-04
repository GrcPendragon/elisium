package com.testingdevops.elisium.model;

import java.util.Random;

/**
 *
 * @author Fausto Garcia
 */
public class GenertePassword {
    
    private final String SPECIAL = "$@#Ññ";
    private final int PIN_LENGHT = 4;
    private final int PASS_LENGHT = 8;
    private final StringBuilder pass;
    private final Random roulette;
    /**
     * Inizializa los objetos Ramdom y StringBuilder que seran utilizados para la generacion de password
     * y PIN codes.
     */
    public GenertePassword() {
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
     * @param pin_Length Indica la cantidad de digitos que tendra el PIN code.
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
            opt = roulette.nextInt(3);
            switch (opt) {
                case 0 :
                    this.pass.append(getNumber());
                    break;
                case 1 :
                    this.pass.append(getLowercase());
                    break;
                case 2 :
                    this.pass.append(getUppercase());
                    break;
            }
        }
        return this.pass.toString();
    }

    /**
     * Este metodo genera una password con caracteres especiales y de una longitud fija de 8 caracteres.
     * 
     * @return retorna una cadena con la password generada.
     */
    public String getPasswordSpecial() {
        int opt;
        for (int i = 0; i < PASS_LENGHT; i++) {
            opt = roulette.nextInt(4);
            switch (opt) {
                case 0 :
                    this.pass.append(getNumber());
                    break;
                case 1 :
                    this.pass.append(getLowercase());
                    break;
                case 2 :
                    this.pass.append(getUppercase());
                    break;
                case 3 :
                    this.pass.append(getSpecial());
                    break;
            }
        }
        return this.pass.toString();
    }

    /**
     * Este metodo genera una password con una longitud variable, alfanumerica.
     *
     * @param pass_Lenght Indica la cantidad de caracteres de la password.
     * @return retorna una cadena con la password generada.
     */
    public String getPassword(int pass_Lenght) {
        int opt;
        for (int i = 0; i < pass_Lenght; i++) {
            opt = roulette.nextInt(3);
            switch (opt) {
                case 0 : 
                    this.pass.append(getNumber());
                    break;
                case 1 :
                    this.pass.append(getLowercase());
                    break;
                case 2 :
                    this.pass.append(getUppercase());
                    break;
            }
        }
        return this.pass.toString();
    }

    /**
     * Este metodo genera una password con caracteres especiales pero con una longitud variable.
     *
     * @param pass_Lenght Indica la cantidad de caracteres.
     * @return Retorna una cadena con la password generada.
     */
    public String getPasswordSpecial(int pass_Lenght) {
        int opt;
        for (int i = 0; i < pass_Lenght; i++) {
            opt = roulette.nextInt(4);
            switch (opt) {
                case 0 :
                    this.pass.append(getNumber());
                    break;
                case 1 :
                    this.pass.append(getLowercase());
                    break;
                case 2 :
                    this.pass.append(getUppercase());
                    break;
                case 3 :
                    this.pass.append(getSpecial());
                    break;
            }
        }
        return this.pass.toString();
    }

    /**
     * Este metodo genera un digito, como char, aleatorio.
     * @return Retorna un digito numerico de tipo char.
     */
    private char getNumber() {
        return (char) (48  + roulette.nextInt(58));
    }

    /**
     * Este metodo genera un caracter alfabetico minusculo, como char, aleatorio.
     * 
     * @return Retorna un caracter alfabetico minusculo de tipo char.
     */
    private char getLowercase() {
        return (char) (97 + roulette.nextInt(123));
    }

    /**
     * Este metodo genera un caracter alfabetico mayusculo, como char, aleatorio.
     * 
     * @return Retorna un caracter alfabetico mayusculo de tipo char.
     */
    private char getUppercase() {
        return (char) (65 + roulette.nextInt(91));
    }

    /**
     * Este metodo genera un caracter especial determinado por una cadena, como char, de forma aleatoria.
     * 
     * @return Retorna un caracter especial de tipo char.
     */
    private char getSpecial() {
        return SPECIAL.charAt(1 + roulette.nextInt(SPECIAL.length()+1));
    }
}
