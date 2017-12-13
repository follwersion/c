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

public class Sphere implements Field {
    double radius;
    Point  p;
    Point  q;    

    Sphere(double r, Point p) {
        this.radius = r;
        this.p = p;
    }   
    public Point getCenter() {
        return p;
    }
    public double getSurface() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
    public double getVolume() {
        double V = (4.0 / 3.0) * Math.PI * radius * radius * radius;
        return V;
    }   
    public String toString() {
        return String
                .format(
                        "Sphere:\n%s\nradius = %s \nCenter: %s \nOberfläche:  %s \nVolumen: %s",
                        p, radius, getCenter(), getSurface(), getVolume());
    }        
}