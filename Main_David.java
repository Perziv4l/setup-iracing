import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.HashMap;

public class Main_David{
    public static void main(String[] args) {

        String s = (String)JOptionPane.showInputDialog(
        null,
        "Completer :\n \"Sous Forme S5W10\"",
        "Nom Sous dossier",
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        "S?W?");

        s = s.toUpperCase();

        BufferedReader reader = null;
        String line = null;


        line = "C:\\Users\\david\\OneDrive\\Documents\\";
        System.out.println(line);

        File repertoire = new File(line+"Donnée");
        System.out.println(repertoire);

        String liste[] = repertoire.list();

        HashMap<String,String> hmap = new HashMap<String,String>();
        
        hmap.put(".*[^i]r18.*",  "audir18");
        hmap.put(".*audir18.*",  "audir18");
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
        hmap.put(".*irs.*audi.*",  "audir8gt3");
        hmap.put(".*488gt3.*", "ferrarievogt3");
        hmap.put(".*488evo.*", "ferrarievogt3");
        hmap.put(".*ferrarievogt3.*", "ferrarievogt3");
        hmap.put(".*ferrari_gts.*", "ferrarievogt3");
        hmap.put(".*ferrarigt3.*", "ferrarievogt3");
        hmap.put(".*m4gt3.*", "bmwm4gt3");
        hmap.put(".*m4\\.driver.*", "bmwm4gt3");
        hmap.put(".*bmwgt3.*",  "bmwm4gt3");
        hmap.put(".*bmw.driver.*",  "bmwm4gt3");
        hmap.put(".*lambo.*",  "lamborghinievogt3");
        hmap.put(".*huracanevogt3.*",  "lamborghinievogt3");
        hmap.put(".*huracan.*",  "lamborghinievogt3");
        hmap.put(".*mp4[^3].*",  "mclarenmp4");
        hmap.put(".*mp430.*",  "mclarenmp430");
        hmap.put(".*mclaren_gts.*",  "mclarenmp4");
        hmap.put(".*mclarengt3.*",  "mclarenmp4");
        hmap.put(".*macca.*",  "mclarenmp4");
        hmap.put(".*mclaren.driver.*",  "mclarenmp4");
        hmap.put(".*mclaren[^(.driver)|^(gt3)|^(_gts)].*",  "mclaren570sgt4");
        hmap.put(".*amg.*",  "mercedesamggt3");
        hmap.put(".*Amg.*",  "mercedesamggt3");
        hmap.put(".*merc.*",  "mercedesamggt3");
        hmap.put(".*vss.*",  "fordgt gt3");
        hmap.put(".*911rs.*",  "porsche911rgt3");
        hmap.put(".*gt3r.*",  "porsche911rgt3");
        hmap.put(".*porsche.*gt3.*",  "porsche911rgt3");
        hmap.put(".*911gt3.*",  "porsche911rgt3");
        hmap.put(".*gt3r.*",  "porsche911rgt3");
        hmap.put(".*cup.*",  "porsche992cup");
        hmap.put(".*tcr.*","audirs3lms");
        hmap.put(".*rs3.*","audirs3lms");
        hmap.put(".*bmwm4gt4.*","bmwm4gt4");
        hmap.put(".*bmwgt4.*","bmwm4gt4");
        hmap.put(".*m4gt4.*","bmwm4gt4");
        hmap.put(".*570.*","mclaren570sgt4");
        hmap.put(".*mclarengt4.*","mclaren570sgt4");
        hmap.put(".*mclaren-rb.*","mclaren570sgt4");
        hmap.put(".*718.*","porsche718gt4");
        hmap.put(".*porschegt4.*","porsche718gt4");
        hmap.put(".*cayman.*","porsche718gt4");
        hmap.put(".*fr2.*","formularenault20");
        hmap.put(".*formularenault20.*","formularenault20");
        hmap.put(".*formularenault_20.*","formularenault20");
        hmap.put(".*fr3.*5.*","formularenault35");
        hmap.put(".*formularenault_35.*","formularenault35");
        hmap.put(".*formularenault35.*","formularenault35");
        hmap.put(".*f3.*","dallaraf3");
        hmap.put(".*f1.*","mclarenmp430");
        hmap.put(".*pm18.*","indypropm18");
        hmap.put(".*i.*p.*2000.*","indypropm18");
        hmap.put(".*IP2k.*","indypropm18");
        hmap.put(".*ir01.*","dallarair01");
        hmap.put(".*dallara_formula.*","dallarair01");
        hmap.put(".*oval.*","dallarair18");
        hmap.put(".*ir18.*","dallarair18");
        hmap.put(".*indy.*","dallarair18");
        hmap.put(".*skippy.*","rt2000");
        hmap.put(".*rt2000.*","rt2000");
        hmap.put(".*mustang.*","stockcars fordmustang2019");
        hmap.put(".*toyota.*","stockcars toyotacamry");
        hmap.put(".*camaro.*","stockcars camarozl12018");
        hmap.put(".*sti.*","subaruwrxsti");
        hmap.put(".*beetle.*","vwbeetlegrc");
        hmap.put(".*fiesta.*","fordfiestarswrc"); 

        for(String i:liste){
            for(String key:hmap.keySet()){
                if(check_pattern(key, i)) remplissage(line,hmap.get(key), s, i);
            }   
        }       
    }

    public static void remplissage(String basepath, String destinationDirName, String week,String fileName){

        BufferedReader reader = null;

        File sourceFile = new File(basepath+"Donnée\\"+fileName);
        
        try{
            String[] nomSetup = {"PDS","VRS","IRS","MAJOR","CRAIG","APEX"};
            for(String h:nomSetup){
                Path path = Paths.get(basepath+"iRacing\\setups\\"+destinationDirName+"\\Garage 61 - Team Rabbit Racing\\"+week+"\\"+h);
                Files.createDirectories(path);
            }

            HashMap<String,String> hmapNom = new HashMap<String,String>();
        
            hmapNom.put("^IRS.*",  "IRS");
            hmapNom.put("^VRS.*",  "VRS");
            hmapNom.put("^PDS.*",  "PDS");
            hmapNom.put(".*DRIVE.*",  "MAJOR");
            hmapNom.put("^2... .*",  "MAJOR");
            hmapNom.put("^2...\\..*",  "MAJOR");
            hmapNom.put("^2...-.*[^(DRIVE)].*",  "CRAIG");
            hmapNom.put("^[^(2)|^(PDS)|^(VRS)].*_.*[^(DRIVE)].*",  "APEX");
            hmapNom.put("^2..._.*[^(DRIVE)].*",  "MAJOR");
            hmapNom.put("^[^(PDS)|^(VRS)|^(2)](.*_.*){3}$",  "APEX");
            hmapNom.put("^[^(PDS)|^(VRS)|^(2)](.* .*){3}$",  "APEX");
            

            boolean touch = false;
            for(String key:hmapNom.keySet()){
                if(check_pattern(key, fileName)){
                    File destinationFile = new File(basepath+"iRacing\\setups\\"+destinationDirName+"\\Garage 61 - Team Rabbit Racing\\"+week+"\\"+hmapNom.get(key)+"\\"+fileName);
                    System.out.println(destinationFile);
                    StandardCopyOption operationAtomique = StandardCopyOption.ATOMIC_MOVE;
                    StandardCopyOption remplacerSiExiste = StandardCopyOption.REPLACE_EXISTING;
                    Files.move(sourceFile.toPath(), destinationFile.toPath(),remplacerSiExiste);
                    touch = true;
                }
            }

            if(!touch){
                File destinationFile = new File(basepath+"iRacing\\setups\\"+destinationDirName+"\\Garage 61 - Team Rabbit Racing\\"+week+"\\"+fileName);
                System.out.println(destinationFile);
                StandardCopyOption remplacerSiExiste = StandardCopyOption.REPLACE_EXISTING;
                Files.move(sourceFile.toPath(), destinationFile.toPath(),remplacerSiExiste);
            }
            
        }catch(IOException ex){
            System.out.println("Attention path non correct"+ex.getMessage());
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
