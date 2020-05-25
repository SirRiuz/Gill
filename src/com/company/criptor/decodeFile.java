package com.company.criptor;

import java.io.*;
import java.util.Base64;

public class decodeFile {

    private Base64.Decoder decoder = Base64.getDecoder();
    private InputStream inputStream;
    private FileOutputStream outputStream;
    private File fileDirOuput;

    public decodeFile (String fileCriptor) throws Exception {
        fileDirOuput = new File("C:\\Users\\Mateo Jimenez\\Desktop\\Salidas22.gill");
        inputStream = decoder.wrap(new FileInputStream(fileCriptor));
        outputStream = new FileOutputStream(fileDirOuput);
        decodeFile();
    }

    private void decodeFile () throws Exception {
        int bytes;
        while ((bytes = inputStream.read()) != -1) {
            outputStream.write(bytes);
        }
        outputStream.close();
        inputStream.close();
    }

    public String getDirOuput () {
        return this.fileDirOuput.getPath();
    }

}
