package prjStationMeteo;

public class Client {
    public static void main(String[] args) {
        StationMeteo sm=new StationMeteo();
        AffichageCondition ac=new AffichageCondition(sm);
        AffichageStatistiques as=new AffichageStatistiques(sm);
        sm.addObservateur(ac);
        sm.addObservateur(as);
        sm.addDonnees(20, 50);
        sm.addDonnees(25, 65);
        sm.addDonnees(27, 70);
    }
}