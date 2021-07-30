import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) {

        BufferedReader reader = null;
        String line = null;

        try {
            reader = new BufferedReader(new FileReader("config.txt"));
            line = reader.readLine();
            System.out.println(line);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        File repertoire = new File(line+"Donnée");
        System.out.println(repertoire);

        String liste[] = repertoire.list();

        HashMap<String,String> hmap = new HashMap<String,String>();
        
        hmap.put(".*r18.*",  "audir18");
        hmap.put(".*audilmp1.*",  "audir18");
        hmap.put(".*919.*",  "porsche919");
        hmap.put(".*porschelmp1.*",  "porsche919");
        hmap.put(".*p217.*",  "dallarap217");
        hmap.put(".*lmp2.*",  "dallarap217");
        hmap.put(".*m8.*",  "bmwm8gte");
        hmap.put(".*bmwgte.*",  "bmwm8gte");
        hmap.put(".*c8.*",  "c8rvettegte");
        hmap.put(".*corvettegte.*",  "c8rvettegte");
        hmap.put(".*488gte.*",  "ferrari488gte");
        hmap.put(".*ferrarigte.*",  "ferrari488gte");
        hmap.put(".*ess.*f.*gt.*",  "fordgt2017");
        hmap.put(".*fordgte.*",  "fordgt2017");
        hmap.put(".*fordgt2017.*",  "fordgt2017");
        hmap.put(".*rsr.*",  "porsche991rsr");
        hmap.put(".*porschegte.*",  "porsche991rsr");
        hmap.put(".*r8.*",  "audir8gt3");
        hmap.put(".*audi_gts.*",  "audir8gt3");
        hmap.put(".*488gt3.*", "ferrari488gt3");
        hmap.put(".*ferrari_gts.*", "ferrari488gt3");
        hmap.put(".*m4gt3.*", "bmwm4gt3");
        hmap.put(".*bmwgt3.*",  "bmwm4gt3");
        hmap.put(".*lambo.*",  "lamborghinievogt3");
        hmap.put(".*mp4.*",  "mclarenmp4");
        hmap.put(".*mclaren_gts.*",  "mclarenmp4");
        hmap.put(".*mclarengt3.*",  "mclarenmp4");
        hmap.put(".*macca.*",  "mclarenmp4");
        hmap.put(".*amg.*",  "mercedesamggt3");
        hmap.put(".*merc.*",  "mercedesamggt3");
        hmap.put(".*911rs.*",  "porsche911rgt3");
        hmap.put(".*gt3r.*",  "porsche911rgt3");
        hmap.put(".*porsche.*gt3.*",  "porsche911rgt3");
        hmap.put(".*911gt3.*",  "porsche911rgt3");
        hmap.put(".*gt3r.*",  "porsche911rgt3");
        hmap.put(".*cup.*",  "porsche911cup");   

        for(String i:liste){
            for(String key:hmap.keySet()){
                if(check_pattern(key, i)) remplissage(line,hmap.get(key), i);
            }   
        }       
    }

    public static void remplissage(String basepath, String destinationDirName, String fileName){

        BufferedReader reader = null;

        File sourceFile = new File(basepath+"Donnée\\"+fileName);
        File destinationFile = new File(basepath+"iRacing\\setups\\"+destinationDirName+"\\Garage 61 - Team Rabbit Racing\\"+fileName);
        System.out.println(destinationFile);        

        StandardCopyOption operationAtomique = StandardCopyOption.ATOMIC_MOVE;
        StandardCopyOption remplacerSiExiste = StandardCopyOption.REPLACE_EXISTING;

        try{
            Files.move(sourceFile.toPath(), destinationFile.toPath(),remplacerSiExiste);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static boolean check_pattern(String regex,String i){
        Pattern p;
        Matcher m;
        
        p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        m = p.matcher(i);
        return(m.find());
    }
}
