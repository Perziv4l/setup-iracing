import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.regex.*;

public class Main{
    public static void main(String[] args) {


        File repertoire = new File("C:\\Users\\OMINKOUA\\Desktop\\Donnée");
        String liste[] = repertoire.list();      

        for(String i:liste){
            

            Pattern p;
            Matcher m;

            p=Pattern.compile(".*488gt3.*",Pattern.CASE_INSENSITIVE);
            m = p.matcher(i);
            if(m.find()){
                Remplissage test = new Remplissage();
                test.remplissage("ferrari", i);
            }
            p=Pattern.compile(".*ferrari_gts.*",Pattern.CASE_INSENSITIVE);
            m = p.matcher(i);
            if(m.find()){
                Remplissage test = new Remplissage();
                test.remplissage("ferrari", i);
            }
            p=Pattern.compile(".*m4gt3.*",Pattern.CASE_INSENSITIVE);
            m = p.matcher(i);
            if(m.find()){
                Remplissage test = new Remplissage();
                test.remplissage("bmwm4gt3", i);
            }
            p=Pattern.compile(".*bmwgt3.*",Pattern.CASE_INSENSITIVE);
            m = p.matcher(i);
            if(m.find()){
                Remplissage test = new Remplissage();
                test.remplissage("bmwm4gt3", i);
            }    
        }
        
    }
}
