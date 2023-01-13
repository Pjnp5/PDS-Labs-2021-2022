package lab11.ex5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class Visitor {
    private boolean recursive;
    private Path _path;
    long file_size = 0;


    public Visitor(String p,boolean rec) {
        this._path = Paths.get(p);
        this.recursive = rec;
    }

    public long file_size() throws IOException{
        Files.walkFileTree(this._path, new SimpleFileVisitor<Path>(){
            
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException{
                String[] path = (""+file).split("/");
                String[] root = ("" + _path).split("/");
                
                String dirname = path[path.length-2];
                String root_name = path[path.length-1];
                
                if (!dirname.equals(root[root.length-1])) {
                    if (recursive){
                        root_name = dirname + "/" + root_name;
                    }
                    else
                        return FileVisitResult.CONTINUE;
                }                
                file_size += attributes.size();
                System.out.println("\t"+root_name + " - " + attributes.size() + " KB");
                   
                return FileVisitResult.CONTINUE;

            }

        });

        return file_size;
    }
}
