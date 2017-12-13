/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A5 - Klassen, Konstruktoren & Methoden
 */

package ti1prp_.aufgabe05;

public interface Field {
    /*
     * Methods to get Surface, Volume and Center of geometric field.
     */
    public double getSurface();
    public double getVolume();
    public Point getCenter();

    /*
     * Method to check if geometric field is valid.
     */
    public boolean check();

    /*
     * Converts object to string.
     */
    public String toString();
}
