import java.util.ArrayList;
import java.util.List;

public class Clasa {

    private int capacitate;
    private NumarClasa numar;
    private char litera;
    private List<Elev> elevi;


    public Clasa(int capacitate, NumarClasa numar, char litera, List<Elev> elevi) {
        this.capacitate = capacitate;
        this.numar = numar;
        this.litera = litera;
        this.elevi = (elevi != null) ? elevi : new ArrayList<>();
    }

    public void adaugaElev(Elev elev) {
        if (elevi.size() < capacitate) {
            elevi.add(elev);
        }
    }

    public void eliminaElev(Elev elev) {
        elevi.remove(elev);
    }

    public int getTotalElevi() {
        return elevi.size();
    }


    public List<Elev> getElevi() {
        return elevi;
    }
}