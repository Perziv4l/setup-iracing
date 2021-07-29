import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Remplissage {

    public void remplissage(String dossier,String file){
        BufferedReader reader = null;
        String line = null;
        try {
            reader = new BufferedReader(new FileReader("config.txt"));
            line = reader.readLine();
            System.out.println(line);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        File fSource=new File(line+"Donnée\\"+file);
        File fDestination=new File(line+"iRacing\\setups\\"+dossier+"\\Garage 61 - Team Rabbit Racing\\"+file);
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
