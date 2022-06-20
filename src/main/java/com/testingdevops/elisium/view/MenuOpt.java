package com.testingdevops.elisium.view;

import java.util.*;

/**
 *
 * @author Fausto Garcia
 */
public class MenuOpt {

    private Scanner keyboard;
    private String pass;
    private int length;
    private int opt;
    private String username;
    private String reference;

    public MenuOpt() {
        this.keyboard = new Scanner(System.in);
    }

    public String getPass() {
        return pass;
    }

    private void setPass(String pass) {
        this.pass = pass;
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }
    
    public int getOpt() {
        return opt;
    }

    private void setOpt(int opt) {
        this.opt = opt;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getReference() {
        return reference;
    }

    private void setReference(String reference) {
        this.reference = reference;
    }
    
    public void menu() throws Exception{
        System.out.print("""
                                     Select type password to generate:
                                      1) Code PIN (4 digits).
                                      2) Code PIN with variable length.
                                      3) Password alphanumeric.
                                      4) Password alphanumeric with variable length.
                                      5) Password alphanumeric with special characters.
                                      6) Password alphanumeric with variable length and special characters.
                                     Option -> """);
        setOpt(keyboard.nextInt());
    }
    
    public void passLength()throws Exception{
        System.out.print("Insert length -> ");
        setLength(keyboard.nextInt());
    }
    
    public void optPIN(String pin){
        System.out.println("Your new PIN code is -> " + pin);
        setPass(pin);
    }

    public void optPassword(String pass){
        System.out.println("Your new passwod is -> " + pass);
        setPass(pass);
    }
    
    public boolean isSave(){
        System.out.print("Do you want save the password/PIN? (yes/no) -> ");
        if (keyboard.next().toUpperCase().contains("YES")) {
                System.out.print("Insert usarname to assign the password -> ");
                setUsername(keyboard.next());
                System.out.print("Insert the reference to the password -> ");
                setReference(keyboard.next());
                return true;
            }else return false;
    }
}
