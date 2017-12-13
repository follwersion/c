package dolberg_konstantin.part1;

import java.util.ArrayList;

import untouchable.Bestand_I;
import untouchable.Immobilie_I;

public class Bestand1 extends ArrayList<Immobilie_I> implements Bestand_I {

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
        return String.format("Bestand1 [\n%s]", ausgabe );
    }
}
