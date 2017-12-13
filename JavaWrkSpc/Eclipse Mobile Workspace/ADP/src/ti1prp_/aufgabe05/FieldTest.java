/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A5 - Klassen, Konstruktoren & Methoden
 */

package ti1prp_.aufgabe05;

public class FieldTest {

    /**
     * @param args
     */
    public static void main(String[] args){
                Point points[]= new Point[8];

                points[0] = new Point(-7, -5, -3);
                points[1] = new Point(-7, -5,  7);
                points[2] = new Point(-7,  5, -3);
                points[3] = new Point( 3, -5, -3);
                points[4] = new Point( 3,  5,  7);
                points[5] = new Point( 3,  5, -3);
                points[6] = new Point( 3, -5,  7);
                points[7] = new Point(-7,  5,  7);

                Field cube = new Cube(points);
              
                System.out.printf("%s:\n", cube.getClass());
                System.out.printf("\tOberfläche:\t%.3f\n", cube.getSurface());
                System.out.printf("\tVolumen:\t%.3f\n",    cube.getVolume());
                System.out.printf("\tMittelpunkt:\t%s\n\n",  cube.getCenter());

                Field sphere = new Sphere(new Point(-3, 5, -7), 3.5);

                System.out.printf("%s:\n", sphere.getClass());
                System.out.printf("\tOberfläche:\t%.3f\n", sphere.getSurface());
                System.out.printf("\tVolumen:\t%.3f\n",    sphere.getVolume());
                System.out.printf("\tMittelpunkt:\t%s\n",  sphere.getCenter());
    }
}
