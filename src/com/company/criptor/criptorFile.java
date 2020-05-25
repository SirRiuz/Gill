package com.company.criptor;

import java.io.*;

import java.util.Arrays;
import java.util.Base64;

public class criptorFile {

    private Base64.Encoder cifrate = Base64.getEncoder();
    private OutputStream outputStream;
    private FileInputStream inputStream;

    public criptorFile (String fileDir) throws Exception {
        inputStream = new FileInputStream(fileDir);
        outputStream = cifrate.wrap(new FileOutputStream("C:\\Users\\Mateo Jimenez\\Desktop\\" +"Archivo cifrad" + ".gill"));
        cifrateFile();
    }

    private void cifrateFile () throws Exception {
        int bytes;
        while ((bytes = inputStream.read()) != -1) {
            outputStream.write(bytes);
        }
    }

}