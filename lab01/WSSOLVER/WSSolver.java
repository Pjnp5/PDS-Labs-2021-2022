import java.util.*;
import java.io.*;



public class WSSolver{
    public static FileWriter outputFile;
    
    public static void main(String[] args) throws IOException {
        String FileNumber = args[0].replaceAll("[^0-9]", "");//extrate number from input file to use it in the output
        if(args.length < 1){ //validation for input file
            System.out.println("Must place a file in the input line. Example:  java WSSolver input.txt");
            System.exit(1);
        }
        //create a new file for the output
        File file  = new File("out" + FileNumber + ".txt");
        file.createNewFile();
        outputFile = new FileWriter(file);

        int maxsize = 40;
        char[][] puzzle2 = new char[maxsize][maxsize];
        
        List<String> puzzle = new ArrayList<String>(); 
        List<String> keyWords = new ArrayList<String>();

        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                
                if (line.isEmpty()){ //check if it has empty lines
                    System.out.println("The file can't have empty lines!");
                    System.exit(1);
                }

                if(line.length() < maxsize && isUpper(line)){ //creating puzzle
                    puzzle.add(line); //add to an array all the lines in the puzzle
                }

                else if(!isUpper(line)){
                    String[] words = line.split(";|\\,|\\ "); //create a arraylist with the keywords to find in the puzzle
                    for(int i=0;i<words.length;i++){
                        if(isAlpha(words[i])){
                            keyWords.add(words[i].toUpperCase());
                        }
                    }
                }
            }

            if(isNotSquare(puzzle)){ //check if the puzzle is a size, as the right meisures
                System.out.println("The map doesn't have the correct size, it isn't a square");
                System.exit(1);
            }

            int sizepuzzle = puzzle.size(); //puzle size

            //create a 2dimentional array with the puzzle
            
            for(int i=0;i<puzzle.size(); i++){
                for(int j=0; j<puzzle.get(i).length() ; j++){
                    puzzle2[j][i] = puzzle.get(i).charAt(j); //each position as one char 
                } 
            }


            String[][] finalA = new String[sizepuzzle][sizepuzzle]; //2Darray with the answer
            for (int r = 0; r < finalA.length; r++){
                for (int c = 0; c < finalA[r].length; c++){
                    finalA[r][c] = ". "; //fill in the answer array  
                    }
            }
            myReader.close();
            for(String a : keyWords){
                //call this function to find each word
                goThroughtGrid(puzzle2, a, sizepuzzle, finalA);
                

            }

            for (int r = 0; r < finalA.length; r++){
                for (int c = 0; c < finalA[r].length; c++){
                    outputFile.write(finalA[r][c]); //write the final answer to a file
                    System.out.print(finalA[r][c]); // print the final answer to a file
                }
                outputFile.write("\n");
                System.out.println();
            }
            
            

            outputFile.close();

        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    public static boolean isUpper(String str) { //check if all the letter are Upper 
        for(int i = 0; i < str.length(); i++){            
            if(!Character.isUpperCase(str.charAt(i))){
                return false;
            }
        }   
        return true;
    }
    public static boolean isAlpha(String str){ //check if is a character
        for(int i = 0; i < str.length(); i++){ 
            if(!Character.isLetter(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

        //check if has the right size
    public static boolean isNotSquare(List<String> puzzle) {
        
        int size = puzzle.size();
        for(int i=0; i<size; i++){
            if(puzzle.get(i).length() != size){
                return true;
            }
        }
        return false;
    }
    //iterate over the grip to find the first letters of the word you are searching
    //example: searching for "Programming" going to find alll the Ps in the grid and call the 
    // function wordFinder on each one to check if you can find the entire word
    public static boolean goThroughtGrid(char[][] puzzle, String word, int size, String[][] finalA){
        for (int row = 0; row < size; row++)  { 
            for (int col = 0; col < size; col++) { 
                if (puzzle[row][col] == word.charAt(0)) {
                    WordFinder(puzzle, size, row, col, word, finalA);
                } 
            } 
        }
        return true;
    }
    
    
    public static void WordFinder(char[][] puzzle, int size, int row, int col, String word, String[][] finalA) {
        int[] x = { -1, -1, -1,  0,  0, 1, 1, 1 };  
        int[] y = { -1, 0,   1, -1,  1, -1, 0, 1 }; 
        String dir = "";
        try {
            int len = word.length(); 
            //going to search in all the eight direction
            for (int direction = 0; direction < 8; direction++) {  //search in all directions 
                switch(direction) {
                    case 0:
                        dir = "UpLeft";
                        break;
                    case 1:
                        dir = "Left";
                        break;
                    case 2:
                        dir = "DownLeft";
                        break;
                    case 3:
                        dir = "Up";
                        break;
                    case 4:
                        dir = "Down";
                        break;
                    case 5:
                        dir = "UpRight";
                        break;
                    case 6:
                        dir = "Right";
                        break;
                    case 7:
                        dir = "DownRight";
                      break;
                  }
                int m;

                //define the next coordinates for the next char 
                int newr = row + x[direction];
                int newc = col + y[direction]; 
                for (m = 1; m < len; m++)  { 
                    if (newr >= size || newr < 0 || newc >= size || newc < 0 ){ //break if out of bound 
                        break; 
                    }
                    // If the letter donst match it breaks
                    if (puzzle[newr][newc] != word.charAt(m)) {
                        break; 
                    }  
                    // continuing moving to the next leter in the same direction
                    newr += x[direction]; 
                    newc += y[direction];
                }  
                
                if (m == len){ //if m as the same size as the word you have found your word 
                    finalA[col][row] = String.valueOf(word.charAt(0)) + " "; //write the first char of the word in the final array
                    int nr = row + x[direction]; 
                    int nc = col + y[direction];
                    for (m = 1; m < len; m++)  {
                        finalA[nc][nr] = String.valueOf(word.charAt(m)) + " "; //write the rest of the word
                        nr += x[direction]; 
                        nc += y[direction];
                    }
                    //requested output to end into the file 
                    outputFile.write(String.format("%-15s\t%3d\t%5d,%2d\t%10s\n", word, word.length(), col + 1,row + 1, dir));
                    System.out.printf("%-15s\t%3d\t%2d,%2d\t%10s%n", word, word.length(), col + 1,row + 1, dir);
                    
                    
                } 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
            }
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }      
    }
    
}

