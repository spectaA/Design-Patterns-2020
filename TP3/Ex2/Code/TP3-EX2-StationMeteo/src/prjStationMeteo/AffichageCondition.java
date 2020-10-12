package prjStationMeteo;

import java.util.ArrayList;

public class AffichageCondition implements Affichage {

    private StationMeteo station;

    public AffichageCondition(StationMeteo s) {
        this.station = s;
    }

    @Override
    public String getTexte() {
        ArrayList<Integer> temp = this.station.getTemperature();
        ArrayList<Integer> humi = this.station.getHumidite();
        return "Température : " + temp.get(temp.size() - 1) + "°C"
                + " - Humidité : " + humi.get(humi.size() - 1) + "%";
    }
}
