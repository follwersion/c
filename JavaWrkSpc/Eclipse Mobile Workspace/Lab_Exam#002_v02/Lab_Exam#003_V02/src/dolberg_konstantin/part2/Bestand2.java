package dolberg_konstantin.part2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import untouchable.Bestand_I;
import untouchable.Immobilie_I;

public class Bestand2 extends ArrayList<Immobilie_I> implements Bestand_I {

    private static final long serialVersionUID = -7321084163345983529L;

    public void printAll() {
        System.out.print("(");
        for (Immobilie_I immo : this) {
            System.out.println(immo);
        }
        System.out.print(")\n");
    }

    public String toString() {
        StringBuilder ausgabe = new StringBuilder();
        for (Immobilie_I immo : this) {
            ausgabe.append(immo).append("\n");
        }
        return String.format("Bestand2 [\n%s]", ausgabe );
    }
    
    public boolean remove(Immobilie_I immo) throws NonExistingPropertyException2 {
        if (!this.contains(immo)) {
            throw new NonExistingPropertyException2();
        }
        return super.remove(immo);
    }
    
    public Set<Immobilie_I> searchLoc(String ort) {
        //Die toString vom HashSet-Objekt überschreiben damit die Ausgabe untereinander erfolgt
        Set<Immobilie_I> locSet = new HashSet<Immobilie_I>() {
            private static final long serialVersionUID = -2317364746256392122L;

            public String toString() {
                StringBuilder ausgabe = new StringBuilder();
                for (Immobilie_I immo : this) { // this vom HashSet
                    ausgabe.append(immo).append("\n");
                }
                return String.format("Set [\n%s]", ausgabe);
            }
        };
        for (Immobilie_I immo : this) {
            if (immo.getAdresse().getOrt().equals(ort)) {
                locSet.add(immo);
            }
        }
        if (locSet.size() < 1) {
            System.out.println("-Keinen entsprechenden Ort gefunden!-\n");
        }
        return locSet;
    }

    public boolean add(Immobilie_I e) {
        if (this.contains(e)) {
            System.out.println("-Doppelte Immobilie wurde nicht geadded!-\n");
            return false;
        } else {
            return super.add(e);
        }
    }
}