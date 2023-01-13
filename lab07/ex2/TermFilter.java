package lab07.ex2;

public class TermFilter extends TextReaderDecorator{
    private int WordsRead;
    private String[] LineWords = null;

    public TermFilter(TextProcessorInterface interno) {
        super(interno);
    }

    public boolean hasNext(){
        if (super.hasNext()) return true; 
        else if (this.LineWords!= null && this.WordsRead < this.LineWords.length) return true;
        else return false;
    }

    public String next(){
        if (!this.hasNext()) {
            return null;
        }
        if (this.LineWords != null && this.WordsRead < this.LineWords.length) {
            // vou acabar este paragrafo
            this.WordsRead++;
            return this.LineWords[this.WordsRead - 1];
        }
        else if (super.hasNext()) {
            this.LineWords = super.next().split(" ");
            this.WordsRead = 1;
            return this.LineWords[0];
        } 
        else return null;
    }
    
}
