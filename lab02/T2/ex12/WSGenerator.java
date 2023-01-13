
package ex12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;


public class WSGenerator {

    private List<String> linhas = new ArrayList<String>(); // list of lines that contains words
    private List<String> palavras = new ArrayList<String>(); //list of words
    Dictionary<String,Boolean> palas = new Hashtable<String,Boolean>(); //dicionario of string-words and boolean-if the word has added to puzzle  (word : boolean)
    private String nomeFicheiroDeSaida;
    private int dimensao; //size of the puzzle
    private char[][] sopa; // the puzzle

    public WSGenerator(String nomeDoFicheiro,int dimensao,String nomeFicheiroDeSaida) throws FileNotFoundException{ //
        this.sopa = new char[dimensao][dimensao];
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                this.sopa[i][j] = '.';
            }
        }
        this.dimensao = dimensao;
        this.nomeFicheiroDeSaida = nomeFicheiroDeSaida;
        
        //Ler ficheiro
        try {
            BufferedReader ficheiro = new BufferedReader(new FileReader(nomeDoFicheiro));
            while(ficheiro.ready()){
                String linha = ficheiro.readLine();
                this.linhas.add(linha);                
            }
            ficheiro.close();
        } catch (Exception e) {
            System.out.println("Falha ao ler ficheiro");
        }

        
        carregarPalavras();// load the words to List palavras and dictionary palas
        gerarPuzzle(dimensao); // generate the puzzle
        toFile(); // print the puzzle and words to the file destination
    
    }

    public void gerarPuzzle(int dimensao){
        Random rand = new Random();

       
        String direcoes[] = {"up","down","left","right","upRight","upLeft","downLeft","downRight"};
        
        int i = 0;

        for (String word : palavras) {
            List<String> direcoesVerificadas = new ArrayList<String>(); ;
            while(!palas.get(word) && i<dimensao*1000){

                i++;
                String direcao = direcoes[rand.nextInt(8)];
                if(!direcoesVerificadas.contains(direcao)){
                    direcoesVerificadas.add(direcao);
                    verifica(direcao,word);
                }
                    
            }
        }
        
        for (int j = 0; j < dimensao; j++) {
            for (int j2 = 0; j2 < dimensao; j2++) {
                if (sopa[j][j2] == '.') {
                    char c = (char) ('a' + rand.nextInt(26));
                    sopa[j][j2] = Character.toUpperCase(c);
                }
            }
        }
    }

    public boolean verifica(String direcao,String palavra){
        Random rand = new Random();int low;int high;int x;int y;int k;int l;
        boolean colocada = false;
        boolean coloca;
        switch (direcao) {
            case "up":
                low = palavra.length()-1;
                high = dimensao-1;
                x = (int) (Math.random() * (high - low)) + low;
                y = rand.nextInt(dimensao-1);
                coloca = true;

                for (int i = x; i > x-palavra.length(); i--) {
                    if (sopa[i][y] != '.') {
                        coloca = false;
                    }
                }
                if (coloca) {
                    int j=0;
                    for (int i = x; i > x-palavra.length(); i--) {
                        sopa[i][y] = Character.toUpperCase(palavra.charAt(j));
                        j++;
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                }
                break;
            case "down":
                low = 0;
                high = dimensao - palavra.length()-1;
                x = (int) (Math.random() * (high - low)) + low;
                y = rand.nextInt(dimensao-1);

                coloca = true;

                for (int i = x; i < x+palavra.length(); i++) {
                    if (sopa[i][y] != '.') {
                        coloca = false;
                    }
                }
                if (coloca) {
                    int j=0;
                    for (int i = x; i < x+palavra.length(); i++) {
                        sopa[i][y] = Character.toUpperCase(palavra.charAt(j));
                        j++;
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                    
                }
                break;
            case "right":
                
                low = 0;
                high = dimensao - palavra.length();
                x = rand.nextInt(dimensao-1);
                y = (int) (Math.random() * (high - low)) + low;
                
                coloca = true;

                for (int i = y; i < y+palavra.length(); i++) {
                    if (sopa[x][i] != '.') {
                        coloca = false;
                    }
                }
                if (coloca) {
                    int j=0;
                    for (int i = y; i < y+palavra.length(); i++) {
                        sopa[x][i] = Character.toUpperCase(palavra.charAt(j));
                        j++;
                        //System.out.println(i);
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                }

                
                break;
            
            case "left":
                
                
            
                low = palavra.length()-1;
                high = dimensao;

                x = rand.nextInt(dimensao-1);
                y =  (int) (Math.random() * (high - low)) + low;
               
                coloca = true;

                for (int i = y; i > y-palavra.length(); i--) {
                    if (sopa[x][i] != '.') {
                        coloca = false;
                    }
                }
                if (coloca) {
                    int j=0;
                    for (int i = y; i > y-palavra.length(); i--) {
                        sopa[x][i] = Character.toUpperCase(palavra.charAt(j));
                        j++;
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                }

                
                break;
            
            case "upRight":

                low = palavra.length()-1;
                high = dimensao-1;
                x = (int) (Math.random() * (high - low)) + low;

                low = 0;
                high = dimensao - palavra.length();
                y = (int) (Math.random() * (high - low)) + low;

                coloca = true;

                k=x;l=y;

                for (int i = 0; i < palavra.length(); i++) {
                    if (sopa[k][l] != '.') {
                        coloca = false;
                    }
                    k--;
                    l++;
                }
                if (coloca) {
                    int j=0;k=x;l=y;
                    for (int i = 0; i < palavra.length(); i++) {
                        sopa[k][l] = Character.toUpperCase(palavra.charAt(j));
                        k--;
                        l++;
                        j++;
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                }
                break;
            
            case "upLeft":

                low = palavra.length()-1;
                high = dimensao-1;
                x = (int) (Math.random() * (high - low)) + low;
                y = (int) (Math.random() * (high - low)) + low;

                coloca = true;

                k=x;l=y;

                for (int i = 0; i < palavra.length(); i++) {
                    if (sopa[k][l] != '.') {
                        coloca = false;
                    }
                    k--;
                    l--;
                }
                if (coloca) {
                    int j=0;k=x;l=y;
                    for (int i = 0; i < palavra.length(); i++) {
                        sopa[k][l] = Character.toUpperCase(palavra.charAt(j));
                        k--;
                        l--;
                        j++;
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                }

                
                break;

            case "downLeft":
                
                low = 0;
                high = dimensao - palavra.length()-1;
                x = (int) (Math.random() * (high - low)) + low;

                low = palavra.length()-1;
                high = dimensao-1;
                y = (int) (Math.random() * (high - low)) + low;

                coloca = true;
                k=x;l=y;

                for (int i = 0; i < palavra.length(); i++) {
                    if (sopa[k][l] != '.') {
                        coloca = false;
                    }
                    k++;
                    l--;
                }
                if (coloca) {
                    int j=0;k=x;l=y;
                    for (int i = 0; i < palavra.length(); i++) {
                        sopa[k][l] = Character.toUpperCase(palavra.charAt(j));
                        k++;
                        l--;
                        j++;
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                }

                
                break;
            
            case "downRight":
                low = 0;
                high = dimensao - palavra.length()-1;
                x = (int) (Math.random() * (high - low)) + low;

                low = 0;
                high = dimensao - palavra.length();
                y = (int) (Math.random() * (high - low)) + low;

                coloca = true;
                k=x;l=y;

                for (int i = 0; i < palavra.length(); i++) {
                    if (sopa[k][l] != '.') {
                        coloca = false;
                    }
                    k++;
                    l++;
                }
                if (coloca) {
                    int j=0;k=x;l=y;
                    for (int i = 0; i < palavra.length(); i++) {
                        sopa[k][l] = Character.toUpperCase(palavra.charAt(j));
                        k++;
                        l++;
                        j++;
                        
                    }
                    colocada = true;
                    palas.put(palavra, true);
                }

                break;
            default:
                break;
        }
    
        return colocada;
    }
    
    public void toFile(){
        String print="";

        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                print += this.sopa[i][j];
            }
            print +="\n";
        }

        Enumeration words = palas.keys();
    
        while (words.hasMoreElements()) {
            String word = (String) words.nextElement();
            if(palas.get(word)){
                print += word + "\n";
            }
            
        }

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(this.nomeFicheiroDeSaida));
            writer.write(print);       
            writer.close();
        } catch (IOException e) {
            System.out.println("Falha ao escrever no ficheiro");
        }

    }

    public void carregarPalavras(){ 
        String palavra="";

        for (int i = 0; i < linhas.size(); i++) {
            String verifica = linhas.get(i);
            for (int j = 0; j < verifica.length(); j++) {
                if (verifica.charAt(j)==';' || verifica.charAt(j)==' ' || verifica.charAt(j)=='\n') {
                    if (palavra!="") {
                        this.palavras.add(palavra);
                        this.palas.put(palavra, false);
                    }
                    palavra="";
                }
                else{
                    palavra += verifica.charAt(j); 
                }
            }
            if (palavra!="") {
                this.palavras.add(palavra);
                this.palas.put(palavra, false);
            }
            palavra="";
        }
    }

    @Override
    public String toString() {

        String print="";

        for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa.length; j++) {
                print += this.sopa[i][j] + " ";
            }
            print +="\n";
        }
        
        return print;
    }
    

    public static void main(String[] args) throws FileNotFoundException {

        int size = 0;
        if (args.length<=4) { // validate args
            System.out.println("\n..............Error..............\n\n Usage:");
            System.out.println("\njava WSGenerator.java -i 'nome do ficheiro com as palavras' -s 'size' -f 'nome do ficheiro de saida' \n");
            System.exit(0);
        }
        
        try {
            size = Integer.parseInt(args[3]); //load size 
        } catch (Exception e) {
            System.out.println("\n..............Error..............\n\n Usage:");
            System.out.println("\njava WSGenerator.java -i 'nome do ficheiro com as palavras' -s 'size' -f 'nome do ficheiro de saida' \n");
            System.exit(0);
        }

        if (size==0) {
            System.out.println("\n..............Error..............\n\n Usage:");
            System.out.println("\njava WSGenerator.java -i 'nome do ficheiro com as palavras' -s 'size' -f 'nome do ficheiro de saida' \n");
            System.exit(0);
        }
       
        WSGenerator newPuzzle = new WSGenerator(args[1], size , args[5]);
        System.out.println(newPuzzle);

        
       
    }
}
