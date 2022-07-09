package com.testingdevops.elisium.controller;

import com.testingdevops.elisium.model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ElisiumMainController implements Initializable {

    //Variables y Objetos Globales
    private final GenertePassword pass;
    private final FileCRUD file;
    private final UserInfo userInfo;
    private String genertor;
    @FXML
    private Label lblGenerate, lblNumberChar;
    @FXML
    private Button btnGenerate, btnCopy, btnPIN, btnPINVar, btnPass, btnPassVar, btnPassSpecial, btnPassSpecialVar, btnSave;
    @FXML
    private TextField txtGenerate, txtDigit, txtUsername, txtWeb, txtReference;

    public ElisiumMainController() throws IOException {
        pass = new GenertePassword();
        file = new FileCRUD();
        userInfo = new UserInfo();
    }

    public void setVisible(boolean show) {
        lblGenerate.setVisible(show);
        txtGenerate.setVisible(show);
        btnGenerate.setVisible(show);
        btnCopy.setVisible(show);
        btnSave.setVisible(show);
    }

    public void setDisable(boolean enable) {
        txtUsername.setDisable(enable);
        txtWeb.setDisable(enable);
        txtReference.setDisable(enable);
        btnSave.setDisable(enable);
    }

    public void setUserData() {
        btnPIN.setUserData("PIN code");
        btnPINVar.setUserData("Pin code variable");
        btnPass.setUserData("Password");
        btnPassVar.setUserData("Password variable");
        btnPassSpecial.setUserData("Password special");
        btnPassSpecialVar.setUserData("Password special variable");
    }

    @FXML
    public void onClickGenerator(MouseEvent event) {
        setVisible(true);
        genertor = ((Node) event.getSource()).getUserData().toString();
        lblGenerate.setText(genertor + " generator");
        txtGenerate.setPromptText("Your " + genertor);
        if (genertor.toUpperCase().contains("VARIABLE")) {
            lblNumberChar.setVisible(true);
            txtDigit.setVisible(true);
        }else{
            lblNumberChar.setVisible(false);
            txtDigit.setVisible(false);
        }
    }

    @FXML
    public void onClickGenerate(MouseEvent event) {
        txtGenerate.clear();
        setDisable(false);
        switch (genertor) {
            case "PIN code":
                txtGenerate.setText(pass.getPin());
                break;
            case "Pin code variable":
                if (!txtDigit.getText().isEmpty()) {
                    txtGenerate.setText(pass.getPin(Integer.parseInt(txtDigit.getText())));
                }
                break;
            case "Password":
                txtGenerate.setText(pass.getPassword());
                break;
            case "Password variable":
                txtGenerate.setText(pass.getPassword(0));
                break;
            case "Password special":
                txtGenerate.setText(pass.getPasswordSpecial());
                break;
            case "Password special variable":
                txtGenerate.setText(pass.getPasswordSpecial(0));
                break;
            default:
                throw new AssertionError();
        }
    }

    @FXML
    public void onClickCopy(MouseEvent event) {
        txtGenerate.selectAll();
        txtGenerate.copy();
    }

    @FXML
    public void onKeyTypeIsNumber(KeyEvent event) {
        if (!Character.isDigit(event.getCharacter().charAt(0))) {
            txtDigit.deletePreviousChar();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setVisible(false);
        setDisable(true);
        lblNumberChar.setVisible(false);
        txtDigit.setVisible(false);
        setUserData();
    }
}
