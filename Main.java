import java.io.File;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) {


        File repertoire = new File("C:\\Users\\OMINKOUA\\Desktop\\Donnée");
        String liste[] = repertoire.list();      

        for(String i:liste){
            
            Remplissage test = new Remplissage();
            HashMap<String,String> hmap = new HashMap<String,String>();
            hmap.put(".*488gt3.*", "ferrari");
            hmap.put(".*ferrari_gts.*", "ferrari");
            hmap.put(".*m4gt3.*", "bmwm4gt3");
            hmap.put(".*bmwgt3.*",  "bmwm4gt3");
            
            for(String yol:hmap.keySet()){
                if(test.pattern(yol, i)){
                    test.remplissage(hmap.get(yol), i);
                }
            }   
        }
        
    }
}
