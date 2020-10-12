package prjStationMeteo;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;

public class AffichageStatistiques implements Affichage {

    private StationMeteo station;

    public AffichageStatistiques(StationMeteo s) {
        this.station = s;
    }

    @Override
    public String getTexte() {
        return "Températures min/max/moy : "
                + this.getMin() + "°C / "
                + this.getMax() + "°C / "
                + this.getMoy() + "°C";
    }

    public String getMin() {
        ArrayList<Integer> liste = this.station.getTemperature();
        int minValue = liste.get(0);
        for(int i=0; i < liste.size(); i++) {
            if(liste.get(i) < minValue) {
                minValue = liste.get(i);
            }
        }
        return Integer.toString(minValue);
    }
    public String getMax() {
        ArrayList<Integer> liste = this.station.getTemperature();
        int maxValue = liste.get(0);
        for(int i=0; i < liste.size(); i++) {
            if(liste.get(i) > maxValue) {
                maxValue = liste.get(i);
            }
        }
        return Integer.toString(maxValue);
    }
    public String getMoy() {
        ArrayList<Integer> liste = this.station.getTemperature();
        int moyValue = 0;
        for(int i=0; i < liste.size(); i++) {
            moyValue += liste.get(i);
        }
        moyValue = moyValue / liste.size();
        return Integer.toString(moyValue);
    }
}
