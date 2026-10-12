import java.util.*;

public class Scoala {
    private Map<String, Clasa> clase = new HashMap<>();
    private Map<String, Activitate> activitati = new HashMap<>();


    public void adaugaActivitate(String nume, ProfesorCoordonator prof) {
        if (!activitati.containsKey(nume)) {
            activitati.put(nume, new Activitate(nume, prof));
            System.out.println("Activitatea '" + nume + "' a fost adaugata.");
        } else {
            System.out.println("Activitatea exista deja!");
        }
    }

    public void eliminaActivitate(String nume) {
        Activitate act = activitati.remove(nume);
        if (act != null) {

            for (Elev e : act.getGrup()) {
                e.eliminaActivitate(nume);
            }
            System.out.println("Activitatea '" + nume + "' a fost eliminata.");
        }
    }


    public void inscrieElevLaActivitate(Elev elev, String numeActivitate) {
        Activitate act = activitati.get(numeActivitate);
        if (act != null) {
            act.adaugaElev(elev);
            elev.adaugaActivitate(numeActivitate);
            System.out.println(elev.getNume() + " a fost inscris la " + numeActivitate);
        } else {
            System.out.println("Activitatea '" + numeActivitate + "' nu exist");
        }
    }

    public void retrageElevDeLaActivitate(Elev elev, String numeActivitate) {
        Activitate act = activitati.get(numeActivitate);
        if (act != null) {
            act.eliminaElev(elev);
            elev.eliminaActivitate(numeActivitate);
            System.out.println(elev.getNume() + " s-a retras de la " + numeActivitate);
        }
    }


    public void afiseazaTopActivitati() {
        System.out.println("\n--- Top Activitati  ---");


        List<Activitate> listaActivitati = new ArrayList<>(activitati.values());
        listaActivitati.sort((a1, a2) -> Integer.compare(a2.getGrup().size(), a1.getGrup().size()));

        for (int i = 0; i < listaActivitati.size(); i++) {
            Activitate act = listaActivitati.get(i);
            System.out.println((i + 1) + ". " + act.getNumeActivitate() +
                    " (Prof. " + act.getCoordonator().getNume() + ") - " +
                    act.getGrup().size() + " elevi");
        }
    }


    public void afiseazaEleviActivi() {

        Set<Elev> eleviUnici = new HashSet<>();
        for (Activitate act : activitati.values()) {
            eleviUnici.addAll(act.getGrup());
        }
        System.out.println("\nNumar total de elevi implicati in cel putin o activitate: " + eleviUnici.size());
    }
}