/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A5 - Klassen, Konstruktoren & Methoden
 */

package ti1prp_.aufgabe05;

public class Point {
    double x;
    double y;
    double z;

    /*
     * Constructor
     */
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /*
     * Substracts Point p from this point.
     */
    public Point subPoint(Point p){
        return new Point(this.x - p.x, this.y - p.y, this.z - p.z);
    }

    /*
     * Adds Point p to this point.
     */
    public Point addPoint(Point p){
        return new Point(this.x + p.x, this.y + p.y, this.z + p.z);
    }

    /*
     * Divides this point by v.
     */
    public Point divPoint(double v){
        return new Point(this.x / v, this.y / v, this.z / v);
    }

    /*
     * Get x value.
     */
    public double getX(){
        return this.x;
    }

    /*
     * Get y value.
     */
    public double getY(){
        return this.y;
    }

    /*
     * Get z value.
     */
    public double getZ(){
        return this.z;
    }

    /*
     * Calculates the distance between Point p and this point.
     */
    public double getDistance(Point p) {
        p = this.subPoint(p);

        return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2) + Math.pow(p.z, 2));
    }

    /*
     * Multiplies Point p with this point.
     */
    public double scalar(Point p) {
        return this.x * p.x + this.y * p.y + this.z * p.z;
    }

    /*
     * Returns x, y and z values of this point as a string.
     */
    public String toString(){
        return String.format("[%.3f | %.3f | %.3f]", this.x, this.y, this.z);
    }

    /*
     * Checks if Point p equals this point.
     */
    public boolean equals(Point p) {
        return this.x == p.x && this.y == p.y && this.z == p.z;
    }
}
