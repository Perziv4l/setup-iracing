import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

        for(String i:liste){
            
            Remplissage test = new Remplissage();
            HashMap<String,String> hmap = new HashMap<String,String>();
            hmap.put(".*r18.*",  "audir18");
            hmap.put(".*audilmp1.*",  "audir18");
            hmap.put(".*919.*",  "porschelmp1");
            hmap.put(".*porschelmp1.*",  "porschelmp1");
            hmap.put(".*p217.*",  "dallara p217");
            hmap.put(".*lmp2.*",  "dallara p217");
            hmap.put(".*m8.*",  "bmwm8gte");
            hmap.put(".*bmwgte.*",  "bmwm8gte");
            hmap.put(".*c8.*",  "corvettegte");
            hmap.put(".*corvettegte.*",  "corvettegte");
            hmap.put(".*488gte.*",  "ferrari488gte");
            hmap.put(".*ferrarigte.*",  "ferrari488gte");
            hmap.put(".*ess.*f.*gt.*",  "fordgte");
            hmap.put(".*fordgte.*",  "fordgte");
            hmap.put(".*fordgt2017.*",  "fordgte");
            hmap.put(".*rsr.*",  "porschersr");
            hmap.put(".*porschegte.*",  "porschersr");
            hmap.put(".*r8.*",  "audir8");
            hmap.put(".*audi_gts.*",  "audir8");
            hmap.put(".*488gt3.*", "ferrari");
            hmap.put(".*ferrari_gts.*", "ferrari");
            hmap.put(".*m4gt3.*", "bmwm4gt3");
            hmap.put(".*bmwgt3.*",  "bmwm4gt3");
            hmap.put(".*lambo.*",  "lamborghinievogt3");
            hmap.put(".*mp4.*",  "mclarenmp4");
            hmap.put(".*mclaren_gts.*",  "mclarenmp4");
            hmap.put(".*mclarengt3.*",  "mclarenmp4");
            hmap.put(".*macca.*",  "mclarenmp4");
            hmap.put(".*amg.*",  "mercedesamg");
            hmap.put(".*merc.*",  "mercedesamg");
            hmap.put(".*911rs.*",  "porschegt3r");
            hmap.put(".*gt3r.*",  "porschegt3r");
            hmap.put(".*porsche.*gt3.*",  "porschegt3r");
            hmap.put(".*911gt3.*",  "porschegt3r");
            hmap.put(".*gt3r.*",  "porschegt3r");
            hmap.put(".*cup.*",  "911cup");
            
            for(String yol:hmap.keySet()){
                if(test.pattern(yol, i)){
                    test.remplissage(hmap.get(yol), i);
                }
            }   
        }       
    }
}
