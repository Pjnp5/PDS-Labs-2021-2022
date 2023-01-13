package lab07.ex2;

public class CapitalizationFilter extends TextReaderDecorator{
    private int WordsRead;
    private String[] LineWords;

    public CapitalizationFilter(TextProcessorInterface interno) {
        super(interno);
    }

    public boolean hasNext() {
        if (super.hasNext()) return true; 
        else if (this.LineWords!= null && this.WordsRead < this.LineWords.length) return true;
        else return false;
    }

    public String next(){
        if (this.LineWords != null && this.WordsRead < this.LineWords.length) {
            this.WordsRead++;
            String word = this.LineWords[this.WordsRead - 1];
            word = String.valueOf(Character.toUpperCase(word.charAt(0))) + word.substring(1, word.length()-1).toLowerCase() + String.valueOf(Character.toUpperCase(word.charAt(word.length()-1)));
            return word;
        } else if (super.hasNext()) {
            this.LineWords = super.next().split(" ");
            this.WordsRead = 1;
            String word = this.LineWords[this.WordsRead - 1];
            if(word.length() > 1){
                word = String.valueOf(Character.toUpperCase(word.charAt(0))) + word.substring(1, word.length()-1).toLowerCase() + String.valueOf(Character.toUpperCase(word.charAt(word.length()-1)));
            }
            else word.toUpperCase();
            
            return word;
        } else {
            return null;
        }
    }
}
