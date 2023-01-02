import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Main{

    public static void main(String[] args) {

        ArrayList<Voiture> listeVoitures = new ArrayList<Voiture>();
        configuration(listeVoitures);


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
        String[] liste = repertoire.list();


        for(String setups:liste){
            String pathVoiture = getpathVoiture(setups,listeVoitures);
            if(pathVoiture!=null){
                remplissage(line,pathVoiture,s,setups,setup);
            }
        }


    }

    private static String getpathVoiture(String setups, ArrayList<Voiture> listeVoitures) {

        for(Voiture voiture:listeVoitures){
            for(String regex:voiture.getListRegex()){
                if(check_pattern(regex,setups)){
                    return voiture.getNomVoiture();
                }
            }
        }
        return null;
    }


    private static void configuration(ArrayList<Voiture> listeVoiture) {
        // Création d'un parseur JSON
        Gson gson = new GsonBuilder().create();

        // Lecture du fichier JSON
        try (InputStream in = JsonParser.class.getResourceAsStream("/configuration.json");
             InputStreamReader reader = new InputStreamReader(in)) {
            // Parsing du JSON en objet Java
            List<Object> data = gson.fromJson(new JsonReader(reader), List.class);

            // Accès aux éléments du tableau
            for (Object item : data) {
                // Conversion de l'élément en objet Map
                Map<String, Object> itemMap = (Map<String, Object>) item;

                String name = (String) itemMap.get("nomVoiture");
                ArrayList<String> listRegex = (ArrayList<String>) itemMap.get("regex");

                Voiture nouvVoiture = new Voiture(name,listRegex);
                listeVoiture.add(nouvVoiture);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
