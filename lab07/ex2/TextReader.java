package lab07.ex2;

import java.io.File;
import java.util.Scanner;

public class TextReader implements TextProcessorInterface{

    private File file;
    private int line_number;

    public TextReader(String filePath) {
        try {
            this.file = new File(filePath);
            this.line_number = 0;
        } catch (Exception e) {
            this.file = null;
            this.line_number = 0;
            System.out.println("[ERROR] The file was not found, it was set to null.");
        }
    }

    @Override
    public boolean hasNext() {

        if (this.file == null) {
            System.out.println("[ERROR] The file is null, please set it using setFile(fileName).");
            return false;
        }

        try {            
            Scanner sc = new Scanner(file);

            for (int i = 0; i < this.line_number; i++) {
                // ler até onde estamos
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                sc.close();
                return true;
            }

        sc.close();

        return false;

        } catch (Exception e) {
            System.out.println("[ERROR] Unable to read the file.");;
            return false;
        }
        
    }

    @Override
    public String next() {
        if (!this.hasNext()) {
            return null;
        }

        try {            
            Scanner sc = new Scanner(file);

            for (int i = 0; i < this.line_number; i++) {
                // ler até onde estamos
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                this.line_number++;
                sc.close();
                return line;
            }

            sc.close();
            return null;

        } catch (Exception e) {
            System.out.println("[ERROR] Unable to read the file.");;
            return null;
        }
    }
}

