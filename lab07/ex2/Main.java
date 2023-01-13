package lab07.ex2;

public class Main {
    public static void main(String[] args) {
        TextProcessorInterface reader = new TextReader("lab07/ex2/file.txt");
        while (reader.hasNext()) {
            System.out.println(reader.next());
            System.out.println("---------------------------");
        }
        TextProcessorInterface reader_filter = new TermFilter(new TextReader("lab07/ex2/file.txt"));
        int limit = 0;
        while (reader_filter.hasNext() && limit < 20) {
            limit++;
            System.out.println(reader_filter.next());
            System.out.println("---------------------------");
        }
        System.out.println("--------------------------------------------------");
        TextProcessorInterface normalization_filter = new NormalizationFilter(new TermFilter(new TextReader("lab07/ex2/file.txt")));
        while (normalization_filter.hasNext()) {
            System.out.println(normalization_filter.next());
            System.out.println("---------------------------");
        }
        System.out.println("--------------------------------------------------");
        TextProcessorInterface capitalization_filter = new CapitalizationFilter(new NormalizationFilter(new TermFilter(new TextReader("lab07/ex2/file.txt"))));
        limit = 0;
        while (capitalization_filter.hasNext() && limit < 20) {
            limit++;
            System.out.println(capitalization_filter.next());
            System.out.println("---------------------------");
        }
        TextProcessorInterface vowel_filter = new VowelFilter(new CapitalizationFilter(new NormalizationFilter(new TermFilter(new TextReader("lab07/ex2/file.txt")))));
        while (vowel_filter.hasNext()) {
            System.out.println(vowel_filter.next());
            System.out.println("---------------------------");
        }
    }
}
