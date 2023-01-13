package lab07.ex2;

public class TextReaderDecorator implements TextProcessorInterface{

    private TextProcessorInterface interno;

    public TextReaderDecorator(TextProcessorInterface interno) {
        this.interno = interno;
    }

    @Override
    public boolean hasNext() {
        return interno.hasNext();
    }

    @Override
    public String next() {
        return interno.next();
    }
}
