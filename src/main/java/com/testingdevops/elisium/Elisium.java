package com.testingdevops.elisium;

import java.util.Scanner;

/**
 *
 * @author Fausto Garcia
 */
public class Elisium {

    public static void main(String[] args) {
        Password pass = new Password();
        int opt;
        int length;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("""
                         Select type password to generate: 
                          1) Code PIN (4 digits).
                          2) Code PIN with variable length.
                          3) Password alphanumeric.
                          4) Password alphanumeric with variable length.
                         Option -> """);
        opt = keyboard.nextInt();
        switch (opt) {
            case 1 -> {
                System.out.println("Your new PIN is: " + pass.getPin());
            }
            case 2 -> {
                System.out.print("Insert the digits amount to PIN code -> ");
                length = keyboard.nextInt();
                System.out.println("Your new PIN code is: " + pass.getPin(length));
            }
            case 3 -> {
                System.out.println("Your new password is: " + pass.getPassword());
            }
            case 4 -> {
                System.out.print("Insert the characters number to password -> ");
                length = keyboard.nextInt();
                System.out.println("Your new password is: " + pass.getPassword(length));
            }
            default ->
                throw new AssertionError();
        }
    }
}
