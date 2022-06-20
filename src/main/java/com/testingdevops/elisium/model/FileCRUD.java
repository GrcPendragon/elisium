package com.testingdevops.elisium.model;

import java.io.*;

/**
 *
 * @author Fausto Garcia
 */
public class FileCRUD {

    private final String PATHNAME = "source/PasswordFile.csv";
    private final File file;
    private final BufferedReader readFile;
    private final BufferedWriter writeFile;

    public FileCRUD() throws IOException {
        this.file = new File(PATHNAME);
        System.out.println(file.exists());
        if (!file.exists()) {
            this.writeFile = new BufferedWriter(new FileWriter(file, true));
            System.out.println("Make file in the route -> " + file.getAbsolutePath());
            write("USER_NAME,PASSWORD,REFERENCE");
        } else {
            this.writeFile = new BufferedWriter(new FileWriter(file, true));
        }
        this.readFile = new BufferedReader(new FileReader(file));
    }

    public void read() throws IOException {
        String line = readFile.readLine();
        while (line != null) {
            System.out.println(" -> " + line);
            line = readFile.readLine();
        }
    }

    public final void write(String register) throws IOException {
        writeFile.write(register);
        writeFile.newLine();
        writeFile.flush();
    }
}
