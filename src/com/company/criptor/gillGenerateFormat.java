    package com.company.criptor;

            import java.io.File;                        import java.io.FileInputStream;
            import java.io.FileOutputStream;

            import java.util.Random;

    public class gillGenerateFormat {

        private FileInputStream inputStream = null;                 private String fileName = "";
        private FileOutputStream outputStream = null;               private File fileManager;
        private String fileFormat;                                  private String fileDir;
        private File fileOuputDir;

        public gillGenerateFormat (String fileDir) {

            this.fileDir = new  File(fileDir).getName();
            fileManager = new File(fileDir);

            fileOuputDir = new File(new File(fileDir).getParent() + "\\criptor-" + new Random().nextInt(10000) +  ".gill");

            try{
                System.out.println("Creando archivo ...");
                inputStream = new FileInputStream(fileDir);
                outputStream = new FileOutputStream(fileOuputDir);
                generateFile();
                System.out.println(fileOuputDir);
            } catch (Exception e) { System.err.println("Error " + e); }

        }

        private void generateFile () throws Exception {
            int line;

            String format = "#format=." + getFileFormat();
            String name = "#file.name=" + getFileName_() + "(1)";
            outputStream.write(format.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.write(name.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.write("#file.mode=pv".getBytes());
            outputStream.write("\n".getBytes());
            while ((line = inputStream.read()) != -1) { outputStream.write(line); }
            outputStream.close();
            inputStream.close();
            System.out.println("Se a creado el archivo .gill");
        }

        public String getFileName_ () {
            for (int x = 0; x<fileDir.length(); x++) {
                if (fileDir.charAt(x) != '.') {
                    fileName = fileName + fileDir.charAt(x);
                } else {break;}
            }
            return fileName;
        }

        public String getFileFormat () {
            String fileFormat_ = "" , fileFormatSalida = "";
            for (int x = fileDir.length() - 1; x>0; x--) {
                if (fileDir.charAt(x) != '.') {
                    fileFormat_ = fileFormat_ + fileDir.charAt(x);
                } else { break; }
            }
            for (int x = fileFormat_.length() - 1; x>=0; x--) { fileFormatSalida = fileFormatSalida + fileFormat_.charAt(x); }
            return fileFormatSalida;
        }

        public String getFileDir () {
            return fileOuputDir.getPath();
        }

    }