
    //Class used by the plane
    public class Seat{
        //The position in the matrix
        private int fil, col;

        //Creates a set
        public Seat(int fil, int col){
            this.fil = fil;
            this.col = col;
        }

        //Getters
        public int Fila(){
            return this.fil;
        }       
        public int Coluna(){
            return this.col;
        }

        @Override
        //Returns the seat in the format requested by the guidelines.
        public String toString() {
            return  (this.fil +1) + "" + (char)(65 + this.col);
        }
    }