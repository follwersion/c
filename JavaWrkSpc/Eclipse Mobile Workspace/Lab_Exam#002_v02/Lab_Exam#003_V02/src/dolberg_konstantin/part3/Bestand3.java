package dolberg_konstantin.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import untouchable.Bestand_I;
import untouchable.Immobilie_I;

public class Bestand3 extends ArrayList<Immobilie_I> implements Bestand_I {

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
        return String.format("Bestand3 [\n%s]", ausgabe );
    }
    
    public boolean remove(Immobilie_I immo) throws NonExistingPropertyException3 {
        if (!this.contains(immo)) {
            throw new NonExistingPropertyException3();
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
    
    public void orderByPri() {
        ArrayList<Immobilie_I> sortAngebote = new ArrayList<Immobilie_I>(){
                       
                public String toString() {
                    StringBuilder ausgabe = new StringBuilder();
                    for (Immobilie_I immo : this) { 
                        ausgabe.append(immo).append("\n");
                    }
                    return String.format("SortAngebote[\n%s]", ausgabe);
            }
        };
        for (Immobilie_I immo : this) {
            if (((Immobilie3) immo).getStatus().equals(Status3.ANGEBOT)) {
                sortAngebote.add(immo);
            }
        }
        Collections.sort(sortAngebote, new Comparator<Immobilie_I>() {
            public int compare(Immobilie_I o1, Immobilie_I o2) {
                return ((Integer)o1.getPreis()).compareTo((Integer)o2.getPreis());
            }      
        });
        System.out.println(sortAngebote);
    }
    
    public void orderByAdr() {
        ArrayList<Immobilie_I> sortAngebote = new ArrayList<Immobilie_I>() {

            public String toString() {
                StringBuilder ausgabe = new StringBuilder();
                for (Immobilie_I immo : this) {
                    ausgabe.append(immo).append("\n");
                }
                return String.format("SortAngebote[\n%s]", ausgabe);
            }
        };
        for (Immobilie_I immo : this) {
            if (((Immobilie3) immo).getStatus().equals(Status3.ANGEBOT)) {
                sortAngebote.add(immo);
            }
        }
        Collections.sort(sortAngebote, new Comparator<Immobilie_I>() {
            public int compare(Immobilie_I o1, Immobilie_I o2) {
                return o1.getAdresse().toString().compareTo(o2
                        .getAdresse().toString());
            }
        });
        System.out.println(sortAngebote);
    }

    // geht nicht wenn ort und preis gleich sind (wegen TreeMap - gleicher Key)
//    public void orderedBy1Loc2Pri() {
//        TreeMap<String, Immobilie3> locPriSort = new TreeMap<String, Immobilie3>();
//        for (Immobilie_I immo : this) {
//            if(((Immobilie3) immo).getStatus().equals(Status3.ANGEBOT)){
//            String s = ""+immo.getAdresse().getOrt()+""+immo.getPreis();
//            locPriSort.put(s, (Immobilie3) immo);
//            }
//        }
//        for (String i : locPriSort.keySet()) {
//            System.out.println(locPriSort.get(i));
//        }
//    }
    
    public void orderByLoc2Pri() {
        ArrayList<Immobilie_I> sortAngebote = new ArrayList<Immobilie_I>(){

            public String toString() {
                StringBuilder ausgabe = new StringBuilder();
                for (Immobilie_I immo : this) {
                    ausgabe.append(immo).append("\n");
                }
                return String.format("SortAngebote[\n%s]", ausgabe);
            }
            
        };
        for (Immobilie_I immo : this) {
            if (((Immobilie3) immo).getStatus().equals(Status3.ANGEBOT)) {
                sortAngebote.add(immo);
            }
        }
        Collections.sort(sortAngebote, new Comparator<Immobilie_I>() {
            public int compare(Immobilie_I o1, Immobilie_I o2) {
                return o1.getAdresse().getOrt().compareTo(o2
                        .getAdresse().getOrt())== 0 ? ((Integer)o1.getPreis()).compareTo((Integer)o2.getPreis()) : o1.getAdresse().getOrt().compareTo(o2
                                .getAdresse().getOrt());
            }
        });
        System.out.println(sortAngebote);
        
        
    }
}