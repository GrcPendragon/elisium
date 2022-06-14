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

    public Password() {
        roulette = new Random();
        this.pass = new  StringBuilder();
    }
    
    public String getPin() {
        for (int i = 0; i < PIN_LENGHT; i++) {
            this.pass.append(getNumber());
        }
        return this.pass.toString();
    }
    
    public String getPin(int pin_Length){
        for (int i = 0; i < pin_Length; i++) {
            this.pass.append(getNumber());
        }
        return this.pass.toString();
    }
    
    public String getPassword (){
        int opt;
        for (int i = 0; i < PASS_LENGHT; i++) {
            opt = roulette.nextInt(1,3);
            switch (opt) {
                case 1 -> this.pass.append(getNumber());
                case 2 -> this.pass.append(getLowercase());
                case 3 -> this.pass.append(getUppercase());
                default -> throw new AssertionError();
            }
        }
        return this.pass.toString();
    }
    
    public String getPassword (int pass_Lenght){
        int opt;
        for (int i = 0; i < pass_Lenght; i++) {
            opt = roulette.nextInt(1, 3);
            switch (opt) {
                case 1 -> this.pass.append(getNumber());
                case 2 -> this.pass.append(getLowercase());
                case 3 -> this.pass.append(getUppercase());
                default -> throw new AssertionError();
            }
        }
        return this.pass.toString();
    }
    
    public char getNumber() {
        return NUMBER.charAt(roulette.nextInt(1, 10));
    }

    public char getLowercase() {
        return LOWERCASE.charAt(roulette.nextInt(1, 26));
    }

    public char getUppercase() {
        return UPPERCASE.charAt(roulette.nextInt(1, 26));
    }

    public char getSpecial() {
        return SPECIAL.charAt(roulette.nextInt(1, 26));
    }
}