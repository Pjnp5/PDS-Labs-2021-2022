package ex11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WSSolver{
    public static void main(String[] args) throws FileNotFoundException {
        
        List<String> linhas = new ArrayList<String>(); // List para guardar as linhas do ficheiro
        List<String> palavras = new ArrayList<String>(); // List para guardar as palavras 
        char[][] sopa; // char de array duplo para guardar a sopa


        if (args.length==0) {
            System.out.println("\n..............Erro..............\nInsira o nome do ficheiro que contem a sopa \n");
            System.out.println("\nUsage: java WSSolver.java 'nome do ficheiro com a sopa'\n");

            System.exit(0);
        }

        BufferedReader ficheiro = new BufferedReader(new FileReader(args[0]));
        try {
            while(ficheiro.ready()){
                String linha = ficheiro.readLine();
                linhas.add(linha);                
            }
            ficheiro.close();
        } catch (IOException e) {
            System.out.println("Falha ao ler ficheiro");
            e.printStackTrace();
        }

        int size = linhas.get(0).length();

        if (size > 40) {
            System.out.println("O puzzle deve ter um tamanho maximo de 40x40");
            System.exit(0);
        }

        sopa = new char[size][size];

        for (int i = 0; i < size; i++) {
            String verifica = linhas.get(i);
            if (verifica.length()!=size) {
                System.out.println("..........Erro..............\nSopa não é quadrada\n");
                System.exit(0);
            }
            for (int j = 0; j < size; j++){
                
                if(!Character.isUpperCase(verifica.charAt(j))){
                    System.out.println("..........Erro..............\nSopa com caracteres minusculos ou que não é quadrada\n");
                    System.exit(0);
                }
                sopa[i][j]=verifica.charAt(j);
            }
        }

        String palavra="";

        //Preencher o array de palavras
        for (int i = size; i < linhas.size(); i++) {
            
            String verifica = linhas.get(i);
            for (int j = 0; j < verifica.length(); j++) {
                if (verifica.charAt(j)==';' || verifica.charAt(j)==' ' || verifica.charAt(j)=='\n') {
                    if (palavra!="") {
                        palavras.add(palavra);
                    }
                    palavra="";
                }
                else{
                    palavra += verifica.charAt(j); 
                }
            }
            if (palavra!="") {
                palavras.add(palavra);
            }
            palavra="";
        }
        //novo array para guardar uma sopa apenas com as palavras encontradas
        char[][] sopa2 = new char[size][size];

        for (int i = 0; i < sopa2.length; i++) {
            for (int j = 0; j < sopa2.length; j++) {
                sopa2[i][j]='.';
            }
        }


        
        //Encontrar as palavras
        System.out.println();
        for (String ps : palavras) {
            for (int i = 0; i < sopa.length; i++) {
                for (int j = 0; j < sopa.length; j++) {
                    if (Character.toString(ps.charAt(0)).equalsIgnoreCase(Character.toString(sopa[i][j]))) {

                        if(right(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                y++;
                                k++;
                            }
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"Right");
                            
                        }
                        else if(left(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                y--;
                                k++;
                            }
            
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"Left");
                        }
                        else if(up(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                x--;
                                k++;
                            }
            
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"Up");
                        }
                        else if(down(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                x++;
                                k++;
                            }
            
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"Down");
                        }
                        else if(UpLeft(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                x--;
                                y--;
                                k++;
                            }
            
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"UpLeft");
                        }
                        else if(UpRight(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                y++;
                                x--;
                                k++;
                            }
            
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"UpRight");
                        }
                        else if(downLeft(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                x++;
                                y--;
                                k++;
                            }
            
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"downLeft");
                        }
                        else if(downRight(ps,sopa,i,j)){
                            int x=i;int y=j;int k=0;
                            int s = ps.length();

                            while (k<s) {
                                sopa2[x][y] = Character.toUpperCase(ps.charAt(k));
                                x++;
                                y++;
                                k++;
                            }
            
                            System.out.printf("%-14s %-5s %-10s %-5s\n", ps, ps.length(),i+1+","+(j+1),"downRight");
                        }
                    }
                }
            }    
        }  

        System.out.println();

        //imprimir a sopa apenas com as palavras encotradas
        for (int k = 0; k < sopa.length; k++) {
            for (int k2 = 0; k2 < sopa.length; k2++) {
                System.out.print( sopa2[k][k2] + " ");
            }
            System.out.println();
        }
        
    }

    //procurar a palavra na direcao right
    public static boolean right(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && jj<sopa.length) {
            palavra2 = palavra2 + sopa[ii][jj];
            jj++;
            i++;
        }
        
        return palavra.equalsIgnoreCase(palavra2);
    }

     //procurar a palavra na direcao left
    public static boolean left(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && jj>=0) {
            palavra2 = palavra2 + sopa[ii][jj];
            jj--;
            i++;
        }
        return palavra.equalsIgnoreCase(palavra2);
    }

     //procurar a palavra na direcao up
    public static boolean up(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && ii>=0) {
            palavra2 = palavra2 + sopa[ii][jj];
            ii--;
            i++;
        }
        
        return palavra.equalsIgnoreCase(palavra2);
    }

     //procurar a palavra na direcao down
    public static boolean down(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && ii<sopa.length) {
            palavra2 = palavra2 + sopa[ii][jj];
            ii++;
            i++;
        }
        
        return palavra.equalsIgnoreCase(palavra2);
    }


     //procurar a palavra na direcao upleft
    public static boolean UpLeft(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && ii>=0 && jj>=0) {
            palavra2 = palavra2 + sopa[ii][jj];
            jj--;
            ii--;
            i++;
        }
        
        return palavra.equalsIgnoreCase(palavra2);
    }

     //procurar a palavra na direcao upRight
    public static boolean UpRight(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && ii>=0 && jj<sopa.length) {
            palavra2 = palavra2 + sopa[ii][jj];
            ii--;
            jj++;
            i++;
        }
        return palavra.equalsIgnoreCase(palavra2);
    }

     //procurar a palavra na direcao downLeft
    public static boolean downLeft(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && jj>=0 && ii<sopa.length) {
            palavra2 = palavra2 + sopa[ii][jj];
            jj--;
            ii++;
            i++;
        }
        
        return palavra.equalsIgnoreCase(palavra2);
    }

     //procurar a palavra na direcao downRight
    public static boolean downRight(String palavra, char [][]  sopa,int x, int y){
        String palavra2="";
        int size = palavra.length();
        int i=0;
        int ii=x;
        int jj=y;
        while (i<size && jj<sopa.length && ii<sopa.length) {
            palavra2 = palavra2 + sopa[ii][jj];
            jj++;
            ii++;
            i++;
        }
        
        return palavra.equalsIgnoreCase(palavra2);
    }

}


