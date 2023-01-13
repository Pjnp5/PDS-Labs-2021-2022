package lab11.ex5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Visitor visitor = null;    

        if (args.length <= 0){
            System.out.println("You need to input arguments! Here how to proceed:");
            System.out.println("Directory size:");
            System.out.println("java lab11.ex5.Main FilePath");
            System.out.println("Directory size with subdirectories size:");
            System.out.println("java lab11.ex5.Main FilePath -r");
            System.exit(0);
        }

        if (args.length == 1){ visitor = new Visitor(args[0], false); } 
        
        else if (args.length == 2) {

            if (args[1].equals("-r")) { visitor = new Visitor(args[0], true); } 
            
            else {usage();}
        } 
        
        else {usage();}

        System.out.println("Total: "+ visitor.file_size() +" KB");
}

    private static void usage() {
        System.out.println("You need to input arguments! Here how to proceed:");
        System.out.println("Directory size:");
        System.out.println("java lab11.ex5.Main FilePath");
        System.out.println("Directory size with subdirectories size:");
        System.out.println("java lab11.ex5.Main FilePath -r");
        System.exit(0);
    }
}
