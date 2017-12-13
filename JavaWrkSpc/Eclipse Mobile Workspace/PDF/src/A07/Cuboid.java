/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A07
 * Kontrolleur:     
 * Datum der Abnahme:   03.12.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr3_v05.pdf
 */
package a07;

import java.util.Arrays;

public class Cuboid implements Field {
    Point[] p;
    double breite = 0;
    double länge = 0;
    double höhe = 0;
    boolean cuboid = false;
    double epsilon = 1.110 * (Math.pow(10, -13));

    // Cuboid Konstruktor
    public Cuboid(Point[] p) {
        this.p = p;
        if (checkAnzahlPoints()) {
            this.checkCuboid();
        }
    }

    // Überprüfung auf legale anzahl eingegebener Punkte
    public boolean checkAnzahlPoints() {
        return p.length == 8 ? true : false;
    }

    // Überprüfung auf gültigen Cuboid
    public boolean checkCuboid() {
        double result = 0;
        double[][] entfernung = new double[8][8];

        int counter = 0;

        // Ermitteln aller Kantenlängen von allen Punkten aus
        for (int i = 0; i < entfernung.length; i++) {
            for (int j = 0; j < entfernung.length; j++) {
                entfernung[i][j] = längen(p[i], p[j]);
            }
        }
        //Sortieren aller Kantenlängen
        for (int k = 0; k < entfernung.length; k++) {
            for (int i = 0; i < entfernung.length - 1; i++) {
                for (int j = i + 1; j < entfernung.length; j++) {
                    if (entfernung[k][i] < entfernung[k][j]) {
                        result = entfernung[k][j];
                        entfernung[k][j] = entfernung[k][i];
                        entfernung[k][i] = result;
                    }
                }
            }
        }
        //Prüfen auf gleiche Länge und zählen der gleichen Kanten
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(entfernung[i][j] - entfernung[i + 1][j]) < epsilon) {
                    counter++;
                }
            }
        }

        // Wählt die richtigen Werte für die nachfolgenden Berechnungen
        if (Math.abs(entfernung[0][6] - entfernung[0][5]) < epsilon
                && Math.abs(entfernung[0][5] - entfernung[0][4]) < epsilon) {
            breite = entfernung[0][6];
            länge = entfernung[0][6];
            höhe = entfernung[0][6];
        } else {
            breite = entfernung[0][3];
            länge = entfernung[0][5];
            höhe = entfernung[0][6];
        }
        cuboid = counter == 56 ? true : false;
        return cuboid;
    }

    public double längen(Point a, Point b) {
        double resu;

        resu = Math
                .sqrt((Math.pow((a.getX() - b.getX()), 2) + (Math.pow(
                        (a.getY() - b.getY()), 2) + (Math.pow((a.getZ() - b
                        .getZ()), 2)))));

        return resu;

    }

    public double getBreite() {
        return breite;
    }

    public double getHöhe() {
        return höhe;
    }

    public double getLänge() {
        return länge;
    }

    public Point getCenter() {
        Point xyz = new Point(0, 0, 0);
        double resultXsumme = 0;
        double resultYsumme = 0;
        double resultZsumme = 0;
        for (int i = 0; i < p.length; i++) {
            resultXsumme += p[i].getX();
            resultYsumme += p[i].getY();
            resultZsumme += p[i].getZ();
        }
        xyz.setX(resultXsumme / 8);
        xyz.setY(resultYsumme / 8);
        xyz.setZ(resultZsumme / 8);
        return xyz;
    }

    public double getSurface() {
        return 2 * (getHöhe() * getBreite() + getHöhe() * getLänge() + getBreite()
                * getLänge());
    }

    public double getVolume() {
        return (getHöhe() * getBreite() * getLänge());
    }

    // myToString wird in Cube überschrieben
    public String toString() {
        return myToString()
                + String
                        .format(
                                "\nPoints %s \nCenter: %s \nOberfläche: %s \nVolumen: %s",
                                Arrays.toString(p), getCenter(), getSurface(),
                                getVolume());
    }

    public String myToString() {
        return cuboid ? String.format("%s", "Quader")
                : String
                        .format("%s",
                                "Das Objekt ist kein Quader oder die Ahnzahl der Punkte ist Falsch");
    }
}