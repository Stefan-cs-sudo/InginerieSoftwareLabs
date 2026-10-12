public class Main {
    public static void main(String[] args) {
        Scoala scoala = new Scoala();

        ProfesorCoordonator profInfo = new ProfesorCoordonator("Ionescu");
        ProfesorCoordonator profSport = new ProfesorCoordonator("Popescu");

        Elev e1 = new Elev("Andrei", Gen.Masculin);
        Elev e2 = new Elev("Maria", Gen.Feminin);
        Elev e3 = new Elev("Victor", Gen.Nespecificat);


        scoala.adaugaActivitate("Programare", profInfo);
        scoala.adaugaActivitate("Fotbal", profSport);
        scoala.adaugaActivitate("Cor", new ProfesorCoordonator("Georgescu"));

        System.out.println("-----------------");


        scoala.inscrieElevLaActivitate(e1, "Programare");
        scoala.inscrieElevLaActivitate(e1, "Fotbal");
        scoala.inscrieElevLaActivitate(e2, "Programare");
        scoala.inscrieElevLaActivitate(e3, "Fotbal");


        scoala.inscrieElevLaActivitate(e1, "Fotbal");


        scoala.afiseazaTopActivitati();


        scoala.afiseazaEleviActivi();

        System.out.println("-----------------");


        scoala.retrageElevDeLaActivitate(e1, "Programare");
        scoala.afiseazaTopActivitati();
    }
}