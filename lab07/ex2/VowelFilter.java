package lab07.ex2;

public class VowelFilter extends TextReaderDecorator{

    public VowelFilter(TextProcessorInterface interno) {
        super(interno);
    }

    public boolean hasNext() {
        if (super.hasNext()) return true; else return false;
    }

    public String next(){
        String line = super.next();
        line = line.replaceAll("[aeiouAEIOU]", "");
        return line;
    }
    
}
