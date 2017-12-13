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

public class Point {
	
	private double x;
	private double y;
	private double z;
	
	public Point(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;		
	}	
	public double getX() {
		return x;
	}		
	public double getY() {
		return y;
	}	
	public double getZ() {
		return z;
	}
	public void setX(double x) {
        this.x = x;
    }
	public void setY(double y) {
        this.y = y;
    }
	public void setZ(double z) {
        this.z = z;
    }
	public static double checkDem (Point p){
	    double ergb;
	    ergb = Math.sqrt((Math.pow((p.getX() - p.getX()), 2) + (Math.pow((p.getY() - p.getY()), 2) + (Math.pow((p.getZ() - p.getZ()),
                2)))));
	    System.out.println(ergb);
        return ergb;
	    
	}
	public String toString(){
		return String.format("Point ("+getX()+" "+getY()+" "+getZ()+")");
	}
}