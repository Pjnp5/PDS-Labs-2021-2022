package lab3.ex1;

import java.util.*;

public class JGaloLogic implements JGaloInterface{
    public Character currentPlayer;
    public Character[][] grid = new Character[3][3];
    public int lastLine, lastCol;
    public Character winner;

    // Construtor
    // Default
    public JGaloLogic() {
        this.currentPlayer = 'X';
        Arrays.stream(grid).forEach(a -> Arrays.fill(a, '.'));
    }

    public JGaloLogic(Character player) {
        this.currentPlayer = player;
        Arrays.stream(grid).forEach(a -> Arrays.fill(a, '.'));
    }

    // Métodos da Interface
    public char getActualPlayer(){
        return this.currentPlayer;
    };

    public boolean setJogada(int lin, int col){
        if(this.grid[lin-1][col-1].equals('.')){

            this.grid[lin-1][col-1] = this.currentPlayer;
            this.lastLine = lin-1;
            this.lastCol = col-1;

            return true;
        }
        return false;
    };

    public boolean isFinished(){
        Character simb = this.currentPlayer;
        int col = this.lastCol;
        int lin = this.lastLine;

        if (checkLines(col, simb) || checkCol(lin, simb) || checkDiagonal()){
            this.winner = simb;
            return true;
        }

        for (Character[] line : grid) {
            for (Character el : line) {
                if (el.equals('.')) {
                    if (this.currentPlayer.equals('X')) {
                        this.currentPlayer = 'O';
                    }else{
                        this.currentPlayer = 'X';
                    }

                    return false;
                }
            }
        }

        this.winner = ' ';
        return true;
    };

    public char checkResult(){
        return this.winner;
    };

    // Métodos Auxiliares
    public boolean checkLines(int col, Character simb){
        for(int i = 0; i < 3; i++){
            if (!grid[i][col].equals(simb)){
                return false;
            }
        }

        return true;
    }

    public boolean checkCol(int lin, Character simb){
        for(int i = 0; i < 3; i++){
            if (!grid[lin][i].equals(simb)){
                return false;
            }
        }

        return true;
    }

    public boolean checkDiagonal(){
        if( !grid[0][0].equals('.') ){
            if(grid[1][1].equals(grid[0][0]) && grid[2][2].equals(grid[0][0]) ){
                return true;
            }
        }

        if( !grid[0][2].equals('.') ){
            if(grid[1][1].equals(grid[0][2]) && grid[2][0].equals(grid[0][2]) ){
                return true;
            }
        }
        return false;
    }
}
