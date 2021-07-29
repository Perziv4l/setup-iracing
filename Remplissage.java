import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Remplissage {

    public void remplissage(String dossier,String file){
        File fSource=new File("C:\\Users\\OMINKOUA\\Desktop\\Donnée\\"+file);
        File fDestination=new File("C:\\Users\\OMINKOUA\\Desktop\\Dossier\\"+dossier+"\\"+file);
        System.out.println(fDestination);        
        StandardCopyOption operationAtomique=StandardCopyOption.ATOMIC_MOVE;
        StandardCopyOption remplacerSiExiste=StandardCopyOption.REPLACE_EXISTING;
        try{
            Files.move(fSource.toPath(), fDestination.toPath(),remplacerSiExiste);
        } catch(IOException ex){
             System.out.println(String.valueOf(ex));
        }
    }

    public boolean pattern(String regex,String i){
        Pattern p;
        Matcher m;
        
        p=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        m = p.matcher(i);
        return(m.find());
    }
}
