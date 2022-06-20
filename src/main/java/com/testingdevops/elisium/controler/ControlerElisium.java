package com.testingdevops.elisium.controler;

import com.testingdevops.elisium.model.GenertePassword;
import com.testingdevops.elisium.model.FileCRUD;
import com.testingdevops.elisium.model.UserInfo;
import com.testingdevops.elisium.view.MenuOpt;
import java.io.IOException;

/**
 *
 * @author Fausto Garcia
 */
public class ControlerElisium {
    
    private final GenertePassword pass;
    private final FileCRUD file;
    private final UserInfo userInfo;
    private final MenuOpt view;
    
    public ControlerElisium() throws IOException{
        pass = new GenertePassword();
        file = new FileCRUD();
        userInfo = new UserInfo();
        view = new MenuOpt();
    }
    
    public void run() throws Exception {
        view.menu();

        switch (view.getOpt()) {
            case 1 -> {
                view.optPIN(pass.getPin());
            }
            case 2 -> {
                view.passLength();
                view.optPIN(pass.getPin(view.getLength()));
            }
            case 3 -> {
                view.optPassword(pass.getPassword());
            }
            case 4 -> {
                view.passLength();
                view.optPassword(pass.getPassword(view.getLength()));
            }
            case 5 -> {
                view.optPassword(pass.getPasswordSpecial());
            }
            case 6 -> {
                view.passLength();
                view.optPassword(pass.getPasswordSpecial(view.getLength()));
            }
            default ->
                throw new AssertionError();
        }

        if (view.isSave()) {
            userInfo.setPassword(view.getPass());
            userInfo.setUsername(view.getUsername());
            userInfo.setReference(view.getReference());
            file.write(userInfo.toString());
            file.read();
        }

    }
}
