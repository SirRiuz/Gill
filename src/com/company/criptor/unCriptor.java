package com.company.criptor;

    import java.io.*;               import com.company.exeptios.*;

public class unCriptor {

    private FileOutputStream outputStream;                      private FileInputStream inputStream;
    private String fileDir;                                     private static String fileMode_;
    private static String fileName_;                            private static String fileFormat_;

    public unCriptor (String fileDir) {

        try {
            this.fileDir = fileDir;
            if (!fileDir.endsWith(".gill")) { throw  new extensionExeption("No puedes desencriptar un archivo que no a sido encriptado ..."); }
            getName();
            outputStream = new FileOutputStream("C:\\Users\\Mateo Jimenez\\Desktop\\" + fileName_ + fileFormat_);
            inputStream = new FileInputStream(fileDir);
            unCriptor();
        } catch (Exception e) { System.out.println("Error : " + e); }
    }

    private void unCriptor () throws Exception{
        int line = 0 , bitye;
        String formatFile = "#format=" + fileFormat_ ;
        String fileNameFile = "#file.name=" + fileName_;
        String modeFile = "#file.mode=" + fileMode_;
        System.out.println(formatFile);
        System.out.println(fileNameFile);
        System.out.println(modeFile);

        while ((bitye=inputStream.read()) !=-1) {
            if (line> formatFile.getBytes().length + fileNameFile.getBytes().length + modeFile.getBytes().length + 2) {
                outputStream.write(bitye);
            }
            line = line + 1;
        }
        outputStream.close();
    }

    private void getName () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.fileDir));
        String line;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            if (lineNumber >= 3) { break; } else {
                if (lineNumber == 0) {
                    fileFormat_ = getItems(line);
                } else if (lineNumber == 1) {
                    fileName_ = getItems(line);
                } else if (lineNumber == 2) {
                    fileMode_ = getItems(line);
                }
            }
            lineNumber++;
        }
        reader.close();
    }

    private String getItems (String line) {
        String lineItem = "";
        String lineOuput = "";
        for (int x = line.length() - 1; x>0; x--) {
            if (line.charAt(x) != '=') {
                lineItem = lineItem + line.charAt(x);
            } else {break;}
        }
        for (int x = lineItem.length() - 1; x>=0; x--) { lineOuput = lineOuput + lineItem.charAt(x); }
        return lineOuput;
    }
}
