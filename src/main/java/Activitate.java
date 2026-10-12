import java.util.HashSet;
import java.util.Set;

public class Activitate {
    private String numeActivitate;
    private ProfesorCoordonator coordonator;
    private Set<Elev> grup;

    public Activitate(String numeActivitate, ProfesorCoordonator coordonator) {
        this.numeActivitate = numeActivitate;
        this.coordonator = coordonator;
        this.grup = new HashSet<>();
    }

    public String getNumeActivitate() { return numeActivitate; }
    public ProfesorCoordonator getCoordonator() { return coordonator; }
    public Set<Elev> getGrup() { return grup; }

    public void adaugaElev(Elev e) {
        grup.add(e);
    }

    public void eliminaElev(Elev e) {
        grup.remove(e);
    }
}