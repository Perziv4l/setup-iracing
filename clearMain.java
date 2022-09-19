import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class clearMain {

    /**
     * Essai d'un programme permettant de tout enlever dans les dossiers partagé
     * @param args
     */
    public static void main(String[] args) {

        //boite de dialogue permettant une sécurité afin de ne pas tout supprimer par erreur
        int retour = JOptionPane.showConfirmDialog(null,
             "Etes vous sur de vouloir supprimer tous les setups ?", 
             "Delete automatique",
             JOptionPane.YES_NO_OPTION);
        if (retour == JOptionPane.YES_OPTION){
            BufferedReader reader = null;
            String line = null;
            try {
                //regarde le fichier de configuration et prend le chemin de "base"
                reader = new BufferedReader(new FileReader("config.txt"));
                line = reader.readLine();
                System.out.println(line);
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            // Prend toutes les voitures possible du dossier setups
            File repertoire = new File(line+"\\iRacing\\setups\\");
            String liste[] = repertoire.list();

            // Petite liste permettant de choisir quelle saison et quelle semaine nous voulons supprimer
            String[] listeWeek = {"S3W12","S4W1","S4W2","S4W3","S4W4","S4W5","S4W6","S4W7","S4W8","S4W9","S4W10","S4W11","S4W12"};


            // boucle les voitures
            for(String x:liste){
                System.out.println(x);
                //boucle la liste de saison/semaine
                for(String y:listeWeek){
                    File path = new File(line+"\\iRacing\\setups\\"+x+"\\Garage 61 - Team Rabbit Racing\\"+y);
                    System.out.println(path);
                    //check si le chemin existe
                    if( path.exists() ) {
                        //liste les fichiers à l'intérieur
                        File[] files = path.listFiles();
                        //boucle sur les fichiers
                        for(int i=0; i<files.length; i++) {
                            //suppression des fichiers
                            files[i].delete();
                        }
                        //suppresion du dossier
                        path.delete();
                    }else{
                        System.out.println("path n'existe pas");
                    }
                }
                
            }
            JOptionPane.showMessageDialog(null,"Vous avez supprimer tous les setups de Garage61", "Delete Automatique", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Vous avez abandonner le delete automatique", "Delete Automatique", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
