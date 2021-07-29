
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main{
    public static void main(String[] args) {
        File fSource=new File("C:\\Users\\OMINKOUA\\Desktop\\bb.txt");
        File fDestination=new File("C:\\Users\\OMINKOUA\\Desktop\\Dossier\\bb.txt");        
        StandardCopyOption operationAtomique=StandardCopyOption.ATOMIC_MOVE;
        StandardCopyOption remplacerSiExiste=StandardCopyOption.REPLACE_EXISTING;
        try{
            Files.move(fSource.toPath(), fDestination.toPath(),remplacerSiExiste);
        } catch(IOException ex){
            System.out.println(String.valueOf(ex));
        }
    }
}
