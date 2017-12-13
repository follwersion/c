/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A04
 * Kontrolleur:         Behnke
 * Datum der Abnahme:   05.10.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr2_v05.pdf
 */
package a04;

public class A04 {

    public static void main (String [] args){
        
        int[][] r2 = {{5,5}, {1,1}};
        int[][] r1 = {{5,5}, {9,9}};  //touching
                
        int r1px = (r1[0][0] < r1[1][0]) ? r1[0][0] : r1[1][0];
        int r1qx = (r1[0][0] > r1[1][0]) ? r1[0][0] : r1[1][0];
        int r1py = (r1[0][1] < r1[1][1]) ? r1[0][1] : r1[1][1];
        int r1qy = (r1[0][1] > r1[1][1]) ? r1[0][1] : r1[1][1];
        int r2px = (r2[0][0] < r2[1][0]) ? r2[0][0] : r2[1][0];
        int r2qx = (r2[0][0] > r2[1][0]) ? r2[0][0] : r2[1][0];
        int r2py = (r2[0][1] < r2[1][1]) ? r2[0][1] : r2[1][1];
        int r2qy = (r2[0][1] > r2[1][1]) ? r2[0][1] : r2[1][1];
        
        if ( (r1px == r2px)&&(r1qx == r2qx) && (r1py == r2py)&&(r1qy == r2qy) ) {
            System.out.println("same");
        }
        else if ( ((r2qx <= r1qx)&&(r2px >= r1px) && (r2qy <= r1qy)&&(r2py >= r1py)) ||
                   (r1qx <= r2qx)&&(r1px >= r2px) && (r1qy <= r2qy)&&(r1py >= r2py) ) {
               System.out.println("contained");
        }
        else if ( ((r2px==r1qx)&&(r2py==r1qy)) || ((r2px == r1px)&&(r2py==r1py)) ||
             ((r2qx==r1qx)&&(r2qy==r1qy)) || ((r2qx == r1px)&&(r2qy==r1py)) ){
           System.out.println("touching");
        }
        else if ( ((r1px == r2qx)||(r1qx == r2px)) || ((r2py == r1qy)||(r1py == r2qy)) ){
            System.out.println("aligned");
        }
        else if ( ((r2px > r1qx)||(r2px < r1px)) && ((r2py > r1qy)||(r2py < r1py)) ) {
            System.out.println("disjoint");
        }
        else {
            System.out.println("intersecting");
        }
    }
}