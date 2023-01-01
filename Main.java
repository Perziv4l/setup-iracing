import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {


        //Récupération de la saison et de la semaine des setups
        String s = (String)JOptionPane.showInputDialog(
        null,
        "Completer :\n \"Sous Forme S5W10\"",
        "Nom Sous dossier",
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        "S?W?");

        //Récupération du nom du fournisseur du setup
        String setup = (String)JOptionPane.showInputDialog(
                null,
                "Veuillez rentrer le fournisseur de setup",
                "Nom du setup",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "VRS/CRAIG/IRS");

        //Saison et semaine en majuscule
        s = s.toUpperCase();

        BufferedReader reader = null;
        String line = null;

        //Récupération de la zone où se trouve le dossier iRacing et donnée
        try {
            reader = new BufferedReader(new FileReader("config.txt"));
            line = reader.readLine();
            System.out.println(line);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        //Répertoire de stock des setups d'un fournisseur
        File repertoire = new File(line+"Donnée");
        System.out.println(repertoire);

        //Liste tous les setups du stock
        String liste[] = repertoire.list();


        // ** Création d'un hashmap pour savoir quelles setups correspondent à quelle voiture ? **
        HashMap<String,String> hmap = new HashMap<String,String>();

        // Tous les regex permettant de différencier les voitures
        hmap.put(".*p217.*",  "dallarap217");
        hmap.put(".*lmp2.*",  "dallarap217");
        hmap.put(".*m8.*",  "bmwm8gte");
        hmap.put(".*bmwgte.*",  "bmwm8gte");
        hmap.put(".*ARA_BMW.*ESS.*",  "bmwm8gte");
        hmap.put(".*c8.*",  "c8rvettegte");
        hmap.put(".*corvettegte.*",  "c8rvettegte");
        hmap.put(".*488gte.*",  "ferrari488gte");
        hmap.put(".*ferrarigte.*",  "ferrari488gte");
        hmap.put(".*FEFE.*ESS.*",  "ferrari488gte");
        hmap.put(".*ess.*f.*gt.*",  "fordgt2017");
        hmap.put(".*fordgte.*",  "fordgt2017");
        hmap.put(".*fordgt2017.*",  "fordgt2017");
        hmap.put(".*rsr.*",  "porsche991rsr");
        hmap.put(".*porschegte.*",  "porsche991rsr");
        hmap.put(".*r8.*",  "audir8gt3");
        hmap.put(".*audi_gts.*",  "audir8gt3");
        hmap.put(".*VRS.*VSS.*AudiR8.*",  "audir8gt3");
        hmap.put(".*irs.*audi.*",  "audir8gt3");
        hmap.put(".*488gt3.*", "ferrarievogt3");
        hmap.put(".*488evo.*", "ferrarievogt3");
        hmap.put(".*ferrarievogt3.*", "ferrarievogt3");
        hmap.put(".*ferrari_gts.*", "ferrarievogt3");
        hmap.put(".*GT_Sprint.*Ferrari.*", "ferrarievogt3");
        hmap.put(".*ferrarigt3.*", "ferrarievogt3");
        hmap.put(".*FEFE.*VRSGT.*", "ferrarievogt3");
        hmap.put(".*m4gt3.*", "bmwm4gt3");
        hmap.put(".*m4\\.driver.*", "bmwm4gt3");
        hmap.put(".*bmwgt3.*",  "bmwm4gt3");
        hmap.put(".*Bmw_M4_GT3.*",  "bmwm4gt3");
        hmap.put(".*bmw.driver.*",  "bmwm4gt3");
        hmap.put(".*lambo.*",  "lamborghinievogt3");
        hmap.put(".*huracanevogt3.*",  "lamborghinievogt3");
        hmap.put(".*huracan.*",  "lamborghinievogt3");
        hmap.put(".*mp4[^3].*",  "mclarenmp4");
        hmap.put(".*mp430.*",  "mclarenmp430");
        hmap.put(".*McLaren.GT4.*",  "mclaren570sgt4");
        hmap.put(".*mclaren_gts.*",  "mclarenmp4");
        hmap.put(".*VSS-Mclaren.*",  "mclarenmp4");
        hmap.put(".*mclarengt3.*",  "mclarenmp4");
        hmap.put(".*MCLAREN_BASPLUS.*",  "mclarenmp4");
        hmap.put(".*IMSA_AL.*",  "mclarenmp4");
        hmap.put(".*macca.*",  "mclarenmp4");
        hmap.put(".*mclaren.driver.*",  "mclarenmp4");
        hmap.put(".*[^(VSS)].*mclaren[^(.driver)|^(gt3)|^(_gts)].*",  "mclaren570sgt4");
        hmap.put(".*ARA_MACCA.*",  "mclaren570sgt4");
        hmap.put(".*AMG.*Evo.*",  "mercedesamgevogt3");
        hmap.put(".*PG_AMG.*",  "mercedesamgevogt3");
        hmap.put(".*MercEvo.*",  "mercedesamgevogt3");
        hmap.put(".*[^(CTMP_)]MERCOS.*",  "mercedesamgevogt3");
        hmap.put(".*Mercedes_GTS.*",  "mercedesamgevogt3");
        hmap.put(".*AMG2020.*",  "mercedesamgevogt3");
        hmap.put(".*MercedesGT3.*",  "mercedesamgevogt3");
        hmap.put(".*AMGGT3.*",  "mercedesamgevogt3");
        hmap.put(".*MERCOS__VRS.*",  "mercedesamgevogt3");
        hmap.put(".*IMSA_MERCOS.*",  "mercedesamgevogt3");
        hmap.put(".*W13.*",  "mercedesw13");
        hmap.put(".*MercGT4.*",  "mercedesamggt4");
        hmap.put(".*MercedesGT4.*",  "mercedesamggt4");
        hmap.put(".*CTMP_MERCOS.*",  "mercedesamggt4");
        hmap.put(".*GT4.*_Merc_.*",  "mercedesamggt4");
        hmap.put(".*AMGGT4.*",  "mercedesamggt4");
        hmap.put(".*VRS.*VSS.*FordGT.*",  "fordgt gt3");
        hmap.put(".*911rs.*",  "porsche911rgt3");
        hmap.put(".*PORS.*HE.*VRS.*",  "porsche911rgt3");
        hmap.put(".*gt3r.*",  "porsche911rgt3");
        hmap.put(".*porsche.*gt3.*",  "porsche911rgt3");
        hmap.put(".*911gt3.*",  "porsche911rgt3");
        hmap.put(".*gt3r.*",  "porsche911rgt3");
        hmap.put(".*Porsche_Cup.*",  "porsche992cup");
        hmap.put(".*PorscheCup.*",  "porsche992cup");
        hmap.put(".*tcr.*","audirs3lms");
        hmap.put(".*rs3.*","audirs3lms");
        hmap.put(".*bmwm4gt4.*","bmwm4gt4");
        hmap.put(".*IMPC.*M4.*","bmwm4gt4");
        hmap.put(".*BMW.GT4.*","bmwm4gt4");
        hmap.put(".*bmwgt4.*","bmwm4gt4");
        hmap.put(".*m4gt4.*","bmwm4gt4");
        hmap.put(".*GT4.*M4.*","bmwm4gt4");
        hmap.put(".*570.*","mclaren570sgt4");
        hmap.put(".*mclarengt4.*","mclaren570sgt4");
        hmap.put(".*mclaren-rb.*","mclaren570sgt4");
        hmap.put(".*718.*","porsche718gt4");
        hmap.put(".*Porsche.GT4.*","porsche718gt4");
        hmap.put(".*porschegt4.*","porsche718gt4");
        hmap.put(".*CTMP_PORSCHE.*","porsche718gt4");
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
        hmap.put(".*Elantra.*","hyundaielantracn7");
        hmap.put(".*IRS.*HYUNDAI.*","hyundaielantracn7");
        hmap.put(".*Civic.*","hondacivictyper");
        hmap.put(".*992.*","porsche992cup");
        hmap.put(".*PCUP.*","porsche992cup");
        hmap.put(".*AudiGT3.*","audir8gt3");
        hmap.put(".*Vantage.*","amvantagegt4");
        hmap.put(".*Aston.*GT4.*","amvantagegt4");
        hmap.put(".*ASTON.*","amvantagegt4");
        hmap.put(".*AMV8.*","amvantagegt4");
        hmap.put(".*Veloster.*","hyundaivelostern");
        hmap.put(".*VELOSTER.*","hyundaivelostern");
        hmap.put(".*MercedesF1.*", "mercedesw12");
        hmap.put(".*IR04.*","formulair04");
        hmap.put(".*F4.*","formulair04");
        hmap.put(".*SCB.*", "stockcarbrasil corolla");
        hmap.put(".*STOCK CAR BRASIL", "stockcarbrasil corolla");
        hmap.put(".*BMW-LMDh.*", "bmwlmdh");
        hmap.put(".*BMW_LMDH.*", "bmwlmdh");
        hmap.put(".*bmwLMDh.*", "bmwlmdh");
        hmap.put(".*MHV8.*", "bmwlmdh");

        //Pour chaque setup check si il y a un pattern correspondant puis déclenche la méthode déplaçant les setups de place
        for(String i:liste){
            for(String key:hmap.keySet()){
                if(check_pattern(key, i)) remplissage(line,hmap.get(key), s, i,setup);
            }   
        }       
    }


    /**
     * méthode permettant de déplacer les setups au bon endroit
     * @param basepath chemin de base
     * @param destinationDirName nom de la voiture du setup
     * @param week saison et semaine du setup
     * @param fileName fichier
     * @param setup nom du fournisseur de setup
     */
    public static void remplissage(String basepath, String destinationDirName, String week,String fileName,String setup){

        BufferedReader reader = null;
        // variable qui permet de mettre vers quelle équipe les setups vont
        String garage61 = "\\Garage 61 - V10R esport\\";


        // Chemin complet pour accéder au bon fichier
        File sourceFile = new File(basepath+"Donnée\\"+fileName);

        try{
            //Chemin de création du dossier
            Path path = Paths.get(basepath+"iRacing\\setups\\"+destinationDirName+garage61+week+"\\"+setup);
            Files.createDirectories(path);

            //Chemin de direction du fichier
            File destinationFile = new File(basepath+"iRacing\\setups\\"+destinationDirName+garage61+week+"\\"+setup+"\\"+fileName);
            System.out.println(destinationFile);
            StandardCopyOption operationAtomique = StandardCopyOption.ATOMIC_MOVE;
            StandardCopyOption remplacerSiExiste = StandardCopyOption.REPLACE_EXISTING;
            //Déplacement du setup
            Files.move(sourceFile.toPath(), destinationFile.toPath(),remplacerSiExiste);

            
        }catch(IOException ex){
            System.out.println("Attention path non correct"+ex.getMessage());
        }
    }

    /**
     * Méthode de test d'un regex
     * @param regex test d'un regex pour savoir à qui appartient le setup
     * @param i chaine de caractère testé
     * @return vrai ou faux en fonction
     */
    public static boolean check_pattern(String regex,String i){
        Pattern p;
        Matcher m;
        
        p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        m = p.matcher(i);
        return(m.find());
    }
}
