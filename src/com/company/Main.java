package com.company;

        import com.company.criptor.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //gillGenerateFormat gillObject =  new gillGenerateFormat("C:\\Users\\Mateo Jimenez\\Desktop\\java gif.gif");
        //new criptorFile(gillObject.getFileDir());

        decodeFile decodeFile = new decodeFile("C:\\Users\\Mateo Jimenez\\Desktop\\Archivo cifrad.gill");
        unCriptor unCriptor =  new unCriptor(decodeFile.getDirOuput());
    }
}

