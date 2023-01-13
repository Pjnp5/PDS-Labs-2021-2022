public class JGaloBehaviour implements JGaloInterface {

    private boolean isPlayerOne = true; //Flag for who is playing at the moment. True for X, False for O
    private char[][] grid = new char[3][3]; //A 3x3 bidimensional char array. A white space array means empty, X and O means taken.
    private int playCount = 0; //The number of plays made so far. Used to determine when there are no more moves to make.
    private char winner = ' '; //The char of the winner. White space means draw.

    //Fills the grid with ' ' to make it empty.
    private void FillGrid(){
        for(int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++) {
                grid[y][x] = ' ';
            }
        }
    }

    //Creates a default game
    public JGaloBehaviour(){
        FillGrid();
    }

    //Creates a game with a preference for who plays first
    public JGaloBehaviour(char c){
        FillGrid();
        if(c == 'X' || c == 'O')
            isPlayerOne = c == 'X';
    }

    @Override
    //Returns the character of the player that is currently playing.
    public char getActualPlayer() {
        return isPlayerOne ? 'X' : 'O';
    }

    @Override
    //Makes a move. Returns weather it is possible or not.
    public boolean setJogada(int y, int x) {

        //You can't make a move to a tile that is already been set.
        if(grid[y-1][x-1] != ' ')
            //Not possible
            return false;

        //Marks the tile chosen as the player's
        grid[y-1][x-1] = getActualPlayer();

        //After the move is done, see if a winner has been decided.
        FindWinner();
        
        //Makes it the turn of the other player
        isPlayerOne = !isPlayerOne;

        //Increases the number of players.
        playCount++;
        
        return true;
    }

    //Driver for the winner finding algorithim.
    private void FindWinner(){
        //We run this twice...
        for (int i = 0; i < 2; i++) {
            //First for the X player, then for the O.
            char c = i == 0 ? 'X' : 'O';     
            
            //Loop through every position in the matrix...
            for (int _y = 0; _y < 2; _y++) {
                for (int _x = 0; _x < 2; _x++) {

                    //Try to find a three char occurence starting from that possition.
                    if(FindThreeInARow(_x, _y, c, 0, 0 ,0)){
                        //If a solution is found, flag that the game ended.
                        this.winner = c;
                        return;
                    }

                }
            }
        }
    }

    //Recursive function for finding three occorrunces of a char in a row. Could be easily tweaked to handle a matrix of any size.
    private boolean FindThreeInARow(int x, int y, char c, int count, int xDir, int yDir){

        //Stop searching if the position is out of bounds or if the char at the spot is not an occurrance.
        if(x < 0 || x > 2 || y < 0 || y > 2 || grid[y][x] != c)
            return false;

        //If we are yet to find a first occurance...
        if(count == 0){
            //Go through each of the 8 directions...
            for (int _y = 0; _y < 2; _y++) {
                for (int _x = 0; _x < 2; _x++) {
                    if(_x == 0 && _y == 0)
                        continue;

                    //Try to find an occurance from there.
                    if(FindThreeInARow(x + _x, y + _y, c, count + 1, _x, _y))
                        return true;
                }
            }
            return false;
        }
        //If it's no the first occurance...
        else{
            //If two occurances has been found plus this one, then we found a winner.
            if(count == 2){
                return true;
            }
            else{
                //Another occurance has been found, lets try finding another.
                return FindThreeInARow(x + xDir, y + yDir, c, count + 1, xDir, yDir);        
            }
        }
    }

    //Returns true if there are no more moves to be made or if a winner has been chosen.
    @Override
    public boolean isFinished() {
        return playCount == 9 || winner != ' ';
    }

    //Getter.
    @Override
    public char checkResult() {
        return winner;
    }

}