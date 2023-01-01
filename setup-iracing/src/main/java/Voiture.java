import java.util.ArrayList;

public class Voiture {

    private String nomVoiture;

    private ArrayList<String> listRegex;

    public Voiture(String nomVoiture, ArrayList<String> listRegex) {
        this.nomVoiture = nomVoiture;
        this.listRegex = listRegex;
    }

    public String getNomVoiture() {
        return nomVoiture;
    }

    public void setNomVoiture(String nomVoiture) {
        this.nomVoiture = nomVoiture;
    }

    public ArrayList<String> getListRegex() {
        return listRegex;
    }

    public void setListRegex(ArrayList<String> listRegex) {
        this.listRegex = listRegex;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "nomVoiture='" + nomVoiture + '\'' +
                ", listRegex=" + listRegex +
                '}';
    }
}
