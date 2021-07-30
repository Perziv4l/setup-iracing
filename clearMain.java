import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class clearMain {
    
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
        File repertoire = new File(line+"\\iRacing\\setups\\");
        String liste[] = repertoire.list();      

        for(String x:liste){
            File path = new File(line+"\\iRacing\\setups\\"+x+"\\Garage 61 - Team Rabbit Racing\\");
            System.out.println(path);
	        if( path.exists() ) {
	            File[] files = path.listFiles();
	            for(int i=0; i<files.length; i++) {
	                files[i].delete();
	            }
	        }else{
                System.out.println("path n'existe pas");
            }
        }
    }
}
