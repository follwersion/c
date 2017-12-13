/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A5 - Klassen, Konstruktoren & Methoden
 */

package ti1prp_.aufgabe05;

public class Sphere implements Field {
    Point p;
    double r;

    /*
     * Constructor
     */
    public Sphere(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    /*
     * getSurface
     * Calculates the surface of this sphere, (4 * PI * r ^ 2).
     */
    public double getSurface(){
        return 4 * Math.PI * Math.pow(this.r, 2);
    }

    /*
     * getVolume
     * Calculates the volume of this sphere, ((4 / 3) * PI * r ^ 3).
     */    
    public double getVolume(){
        return (4.0 / 3.0) * Math.PI * Math.pow(this.r, 3);
    }

    /*
     * getCenter
     * Returns the center of this sphere.
     */
    public Point getCenter(){
        return this.p;
    }

    /*
     * check
     * Always true, nothing to check.
     */
    public boolean check(){
        return true;
    }

    /*
     * toString
     * Returns a string containing all attributes of this sphere (surface, volume, center).
     */
    public String toString(){
        return String.format("[Surface: %.3f | Volume: %.3f | Center: %s]",
               this.getSurface(), this.getVolume(), this.p);
    }
}
