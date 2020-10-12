package prjConversions;

import java.util.ArrayList;

public class Saisi {

    private int nombre;
    private ArrayList<Conv> convs = new ArrayList<Conv>();

    public Saisi() {};

    public void setNombre(int n) {
        this.nombre = n;
        for(Conv c : convs) {
            c.calc(this.nombre);
        }
    }

    public void add(Conv c) {
        convs.add(c);
    }
}
