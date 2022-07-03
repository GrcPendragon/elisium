package com.testingdevops.elisium;

import com.testingdevops.elisium.controler.ControlerElisium;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Fausto Garcia
 */
public class Elisium extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        VBox root = new VBox();
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("ELISIUM");
        primaryStage.show();
//       try {
//            ControlerElisium controler = new ControlerElisium();
//            controler.run();
//        } catch (IOException err) {
//            System.out.println("Error ocurrido en la entrada/salida de datos.");
//            System.out.println(err);
//        } catch (NullPointerException err) {
//            System.out.println("Error: ");
//            System.out.println(err);
//        } catch (AssertionError err) {
//            System.out.println("Incorrect option.");
//        } catch (Exception ex) {
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
