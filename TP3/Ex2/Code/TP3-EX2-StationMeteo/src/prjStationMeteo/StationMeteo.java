package prjStationMeteo;

import java.util.ArrayList;

public class StationMeteo {

    private ArrayList<Affichage> observateurs = new ArrayList<Affichage>();
    private ArrayList<Integer> temperature = new ArrayList<Integer>();
    private ArrayList<Integer> humidite = new ArrayList<Integer>();

    public void addObservateur(Affichage a) {
        observateurs.add(a);
    }

    public void addDonnees(int temp, int humi) {
        this.temperature.add(temp);
        this.humidite.add(humi);
        String msg = new String();
        for(Affichage a : observateurs) {
            msg += " >> " +  a.getTexte();
        }
        System.out.println(msg);
    }

    public ArrayList<Integer> getHumidite() {
        return humidite;
    }

    public ArrayList<Integer> getTemperature() {
        return temperature;
    }
}
