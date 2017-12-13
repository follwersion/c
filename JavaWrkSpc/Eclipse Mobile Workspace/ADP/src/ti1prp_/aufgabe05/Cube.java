/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A5 - Klassen, Konstruktoren & Methoden
 */

package ti1prp_.aufgabe05;

public class Cube extends Cuboid {

    /*
     * Constructor
     */
    public Cube(Point[] points){
        super(points);
    }

    /*
     * getSurface
     * Calculates the surface of this cube, (a * 2 + b * 2 + c * 2) where a, b, c are side surfaces.
     */
    public double getSurface(){
        return points[0].getDistance(points[1]) * points[1].getDistance(points[2])* 2 +
               points[0].getDistance(points[1]) * points[1].getDistance(points[3])* 2 +
               points[1].getDistance(points[3]) * points[1].getDistance(points[2])* 2;
    }

    /*
     * getVolume
     * Calculates the volume of this cube, (a * b * c) where a, b, c are side lengths.
     */
    public double getVolume(){
        return points[0].getDistance(points[1]) *
               points[1].getDistance(points[2]) *
               points[1].getDistance(points[3]);
    }

    /*
     * getCenter
     * Calculates the center of this cube, a + (b - a) / 2 where a, b are points/vectors.
     */
    public Point getCenter(){
        return points[0].addPoint( points[4].subPoint( points[0] ).divPoint(2.0) );
    }

    /*
     * check
     * Checks if this is a valid cube.
     */
    public boolean check(){
        int cube = 0;
        Point cont[] = new Point[8];
        int indexLong = 0, indexShort = 0, indexFound4 = 0, indexFound5 = 0;
        double vLong = 0, vShort = 0;

        /*
         * Get point with longest distance from starting point (point 0).
         * Save its index in the points array.
         */
        for(int i = 1; i < this.points.length; i++){
            if(this.points[0].getDistance(this.points[i]) > vLong){
                vLong = this.points[0].getDistance(this.points[i]);
                indexLong = i;
            }
        }

        /*
         * Get point with shortest distance from starting point (point 0).
         * Save its index in the points array.
         */
        vShort = vLong;
        for(int i = 1; i < this.points.length; i++){
            if(this.points[0].getDistance(this.points[i]) < vShort){
                vShort = this.points[0].getDistance(this.points[i]);
                indexShort = i;
            }
        }

        /*
         * Substract point at shortest distance from starting point.
         * Then in each loop, substract point at shortest distance from
         * point at index i. If scalar product of vectorA and vectcorB
         * is zero, save index of this point. Point are orthographic to
         * each other.
         */
        Point vectorA, vectorB;
        vectorA = this.points[indexShort].subPoint(this.points[0]);
        for(int i = 0; i < this.points.length; i++){
            if(i != indexShort && i != indexLong){
                vectorB = this.points[indexShort].subPoint(this.points[i]);
                if(vectorA.scalar(vectorB) == 0){
                    if(indexFound4 == 0){
                        indexFound4 = i;
                    }
                    indexFound5 = i;
                }
            }
        }

        /*
         * Substract point at shortest distance from starting point.
         * Calculate points at other remaining locations.
         */
        vectorA = this.points[0].subPoint(this.points[indexShort]);
        Point point10 = this.points[indexFound4].addPoint(vectorA);
        Point point11 = this.points[indexFound5].addPoint(vectorA);
        Point point12 = this.points[indexLong].addPoint(vectorA);

        /*
         * Save all calculated points in a new array
         * and at the right locations to ensure right
         * calculation if attributes later.
         * Calculations expect points at exact indexes.
         */
        cont[7] = point10;
        cont[6] = point11;
        cont[5] = point12;
        cont[0] = this.points[0];
        cont[2] = this.points[indexFound4];
        cont[3] = this.points[indexFound5];
        cont[1] = this.points[indexShort];
        cont[4] = this.points[indexLong];

        /*
         * Compare calculates points with give points.
         * Increase the number of matches if two points
         * are equal.
         */
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(cont[i].equals(this.points[j])){
                    cube++;
                }
            }
        }

        /*
         * Save distances of all points to point 0.
         */
        double vector[] = new double[8];
        for(int i = 1; i < cont.length; i++){
            vector[i] = cont[0].getDistance(cont[i]);
        }

        /*
         * Sort distances.
         */
        double temp;
        for(int i = 1; i < 8; i++){
            for(int j = 1; j < 8; j++){
                if(vector[j] < vector[i]){
                    temp = vector[j];
                    vector[j] = vector[i];
                    vector[i] = temp;
                }
            }
        }

        /*
         * If two distances next to each other match,
         * increase count by 1.
         */
        int count = 0;
        for(int i = 1; i < 8; i++){
            if(vector[i - 1] - vector[i] == 0){
                count++;
            }
        }

        /*
         * If cube is 8 and count is 4, we have a valid cube.
         * Write points to right indexes in points array.
         * Return true if valid, false if invalid cube.
         */
        if(cube == 8 && count == 4){
            for(int i = 0; i < this.points.length; i++){
                this.points[i] = cont[i];
            }
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * toString
     * Returns a string containing all attributes of this cube (points, surface, volume, center).
     */
    public String toString(){
        return String.format("[[%s | %s | %s | %s | %s | %s | %s | %s] | %.3f | %.3f | %s]",
               this.points[0], this.points[1], this.points[2], this.points[3],
               this.points[4], this.points[5], this.points[6], this.points[7],
               this.getSurface(), this.getVolume(), this.getCenter());
    }
}
