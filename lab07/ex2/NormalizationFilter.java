package lab07.ex2;

import java.text.Normalizer;

public class NormalizationFilter extends TextReaderDecorator{

    public NormalizationFilter(TextProcessorInterface interno) {
        super(interno);
    }
    
    public boolean hasNext() {
        if (super.hasNext()) return true; else return false;
    }

    public String next(){
        String line = super.next();
        line = Normalizer.normalize(line, Normalizer.Form.NFKD); // All letters go to normal form
        line = line.replaceAll("[^\\p{ASCII}]", ""); // removing all the elements
        line = line.replaceAll("[.!?\\-,]", "");     // we dont want to send
        return line;
    }
}
