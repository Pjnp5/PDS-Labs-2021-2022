import java.util.*;
import java.io.*;
public class WSGenerator {
    public static FileWriter outputFile;
    public static void main(String[] args) throws IOException {
        int i = 0;
        int size=0;
        String inputF="", outputF=""; // input and output file inserted by the user
        List<String> listWords = new ArrayList<String>(); //lkist with words each by position
        List<String> outp2p = new ArrayList<String>(); //list with key solution words for the output
        if(args.length == 0){ //check if the arguments were inserted 
            System.out.println("Error: No input arguments.\n Args:\n   -i <input-file>\n   -s <word-soup-size>\n   -o <output-file> [default:'sopa.txt']");
            System.exit(0);
        }
        if(!Arrays.stream(args).anyMatch("-i"::equals)){ //check if the input file was inserted
            System.err.println("Error: Input file is mandatory!");
            System.exit(0);
        }
        if(!Arrays.stream(args).anyMatch("-s"::equals)){ //check if the size of the soup was inserted 
            System.err.println("Error: Soup size is mandatory!");
            System.exit(0);
        }
        for (String a : args) {
            switch (a) {
                case "-i": //read the input file
                    i++;
                    if (args[i] == "-o" || args[i] == "-s"){
                        System.err.println("Error: Please define a valid input file.");
                        System.exit(0);
                    }
                    inputF = args[i];
                    break;

                case "-s": //read the soup size
                    i++;
                    if (args[i] == "-o"){
                        System.err.println("Error: Please define a valid size.");
                        System.exit(0);
                    }
                    size = Integer.parseInt(args[i]);
                    break;

                case "-o": //read the output file
                    i++;
                    outputF = args[i];
                    break;

                default:
                    i++;
                    break;
            }
        }
        if(outputF.isEmpty()){ // if the user did not insert a output file, create one using the number in the input file
            String FileNumber = args[1].replaceAll("[^0-9]", "");
            File file  = new File("sopa" + FileNumber + ".txt");
            file.createNewFile();
            outputFile = new FileWriter(file);
        }else{//if the user insert one, create the output file with that name 
            File file  = new File(outputF);
            file.createNewFile();
            outputFile = new FileWriter(file);
        }

        String [][] twoDarray = new String[size][size]; //create a 2D array 
        for (int r = 0; r < twoDarray.length; r++){
            for (int c = 0; c < twoDarray[r].length; c++){
                twoDarray[r][c] = " "; //Fill in the 2D array with empty spaces
            }
        }
        try {
            File myObj = new File(inputF); //scan the input file 
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                outp2p.add(line);
                if (line.isEmpty()){ //check if it has empty lines
                    System.out.println("The file can't have empty lines!");
                    System.exit(1);
                }
                String[] line2 = line.split("[, ; ]"); //split each line of the file by spaces , "," and ;
                for (String str : line2) { //save each word in a array 
                    listWords.add(str.toUpperCase());
                }

            }


            myReader.close();

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); // char array with all letters in the alphabeth
        for(String word: listWords){// first place the solving words in the 2Darray randomly
            placeWordB(alphabet,twoDarray, word, size); // call the function to place each word
        }

        for (int c = 0; c < twoDarray.length; c++){
            for (int r = 0; r < twoDarray[c].length; r++){
                if(twoDarray[c][r].equals(" ")){ //if there is empty spaces(not filled with the solution words), filled them with randon characters
                    int rand = getRandomNumberInRange(0,25);
                    twoDarray[c][r] = String.valueOf(alphabet[rand]);



                }
            }
            
        }
        for (int c = 0; c < twoDarray.length; c++){
            for (int r = 0; r < twoDarray[c].length; r++){
                System.out.print(twoDarray[c][r]);//print the 2Darray
                outputFile.write(twoDarray[c][r]);//save the 2Darray 
            }
            System.out.println();
            outputFile.write("\n");
        }
        
        for (String a : outp2p){
            System.out.println(a);// print the Words to be found
            outputFile.write(a);//save in the file the Words to be found
            outputFile.write("\n");
        }

        outputFile.close();
    }

    //function that return a random number between min and max
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public static boolean placeWordB(char[] alphabet, String[][] twoDarray, String word, int size ){
        int[] x = { -1, -1, -1,  0,  0, 1, 1, 1 };
        int[] y = { -1, 0,   1, -1,  1, -1, 0, 1 };

        int len = word.length(); //word lenght
        int dir = getRandomNumberInRange(0, 7); //random direction
        int col = getRandomNumberInRange(0, size - 1); //random col
        int row = getRandomNumberInRange(0, size - 1); //random row 


        //the function checkifinBound, returns false if the word fits in the puzzle  and if it will overright a 
        //  already placed on, if it returns false it will generate new random numbers and call the function again 
        //  until returns true  
        while (checkIfInBoundB(word, size, dir, col, row, len, twoDarray) == false){ 
            dir = getRandomNumberInRange(0, 7);
            col = getRandomNumberInRange(0, size - 1);
            row = getRandomNumberInRange(0, size - 1);
            checkIfInBoundB(word, size, dir, col, row, len, twoDarray);

        }

        int m;
        //if checkIfinBound returns true, it will write the word in the 2D array 
        twoDarray[col][row] = String.valueOf(word.charAt(0));
        int newr = row + x[dir];
        int newc = col + y[dir];
            for (m = 1; m < len; m++)  {
                twoDarray[newc][newr] = String.valueOf(word.charAt(m));
                newr += x[dir];

                newc += y[dir];
            }
        return true;
    }
    public static boolean checkIfInBoundB( String word, int size, int dir, int col, int row, int len, String[][] twoDarray ){
        int[] x = { -1, -1, -1,  0,  0, 1, 1, 1 };
        int[] y = { -1, 0,   1, -1,  1, -1, 0, 1 };
        int n;
        int m;
        int newrB = row + x[dir];
        int newcB = col + y[dir];

        //returns false if its out of bound    
        for (m = 1; m < len; m++)  {

            if (newrB >= size || newrB < 0 || newcB >= size || newcB < 0 ){ //break if out of bound
                return false;
            }
            newrB += x[dir];

            newcB += y[dir];
        }



        int newr = row + x[dir];
        int newc = col + y[dir];
        //check if the space is diferent than 0 and if the char is diferent returns false fot the first lettter of the word
        if(!twoDarray[col][row].equals(" ") && word.charAt(0) != twoDarray[col][row].charAt(0)){
            return false;
        }
         //check if the space is diferent than 0 and if the char is diferent returns false fot the rest of the word letters
        for (n = 1; n < len; n++)  {
            //check if it is out of bound 
            if (newrB >= size || newrB < 0 || newcB >= size || newcB < 0 ){ //break if out of bound
                return false;
            }
            if(!twoDarray[newc][newr].equals(" ") && word.charAt(n) != twoDarray[newc][newr].charAt(0)){
                return false;
            }
            newr = newr + x[dir];
            newc = newc + y[dir];
        }
        return true;
    }

}



