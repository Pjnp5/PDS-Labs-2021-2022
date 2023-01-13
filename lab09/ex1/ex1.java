package lab09.ex1;

import java.util.Iterator;
import java.util.ListIterator;

public class ex1 {

    public static void main(String[] args) {
        
        VectorGeneric<Integer> vector = new VectorGeneric<>(); // creating a generic vector
        
        for (int i = 0; i < 15; i++){ vector.addElem(i); } // adding elements

        System.out.println("Using Generic Iterator...");
         
        Iterator<Integer> normalIterator = vector.Iterator();

        while (normalIterator.hasNext()) { System.out.println(normalIterator.next()); }

        
        System.out.print("----------------------------------------------------------------------------------------------------");

        System.out.println("\n\nEmpty List Iterator, index stars at 0");

        ListIterator<Integer> listIterator = vector.ListIterator();

        System.out.println("\nUsing Has Next:");
        while (listIterator.hasNext()) {
            System.out.printf("Next Index %d: Next Element %d\n",listIterator.nextIndex(), listIterator.next());
        }
        
        System.out.println("\nUsing Has Previous:");
        while (listIterator.hasPrevious()) {
            System.out.printf("Previous Index %d: Previous Element %d\n",listIterator.previousIndex(), listIterator.previous());
        }

        
        System.out.print("----------------------------------------------------------------------------------------------------");
        System.out.println("\n\nList Iterator, index does not start at 0");

        ListIterator<Integer> listIterator2 = vector.ListIterator(10);

        // using next (going forward)
        System.out.println("\nUsing Has Next:");
        while (listIterator2.hasNext()) {
            System.out.printf("Next Index %d: Next Element %d\n",listIterator2.nextIndex(), listIterator2.next());
        }
        
        // using previous (going backwards)
        System.out.println("\nUsing Has Previous:");
        while (listIterator2.hasPrevious()) {
            System.out.printf("Previous Index %d: Previous Element %d\n",listIterator2.previousIndex(), listIterator2.previous());
        }
    }
}