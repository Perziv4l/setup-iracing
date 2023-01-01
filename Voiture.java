import java.util.ArrayList;

public class Voiture {

    private String nom;
    private ArrayList<String> regex;

    public Voiture(String nom) {
        this.nom = nom;
        this.regex = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
