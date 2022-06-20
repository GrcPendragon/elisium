package com.testingdevops.elisium;

import com.testingdevops.elisium.controler.ControlerElisium;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fausto Garcia
 */
public class Elisium {
    
    public static void main(String[] args) {
        try{
        ControlerElisium controler = new ControlerElisium();
        controler.run();
        }catch (IOException err) {
            System.out.println("Error ocurrido en la entrada/salida de datos.");
            System.out.println(err);
        } catch (NullPointerException err) {
            System.out.println("Error: ");
            System.out.println(err);
        } catch (AssertionError err) {
            System.out.println("Incorrect option.");
        } catch (Exception ex) {
            Logger.getLogger(Elisium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
