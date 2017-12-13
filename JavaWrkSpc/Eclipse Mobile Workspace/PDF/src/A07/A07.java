/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A07
 * Kontrolleur:     
 * Datum der Abnahme:   19.11.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr3_v05.pdf
 */
package a07;

public class A07 {

	public static void main(String[] args) {
	    // Daten Sphere
		double radius = 6; 
		Point unserTestSphere = new Point(1,1,1);	
		Sphere p = new Sphere(radius,unserTestSphere);
		
		// Daten Cube
		System.out.println(p+"\n");
		Point [] unserTestCube = new Point[8];
        unserTestCube = new Point[] {
                new Point(-1.0, 1.0, 1.0),
                new Point(-1.0, 3.0, 1.0), 
                new Point(-1.0, 1.0, 3.0),
                new Point(-1.0, 3.0, 3.0),
                new Point(-3.0, 1.0, 1.0),
                new Point(-3.0, 3.0, 1.0), 
                new Point(-3.0, 1.0, 3.0),
                new Point(-3.0, 3.0, 3.0) };
		
		// Daten Cube2
		Point [] unserTestCube2 = new Point[8];
		unserTestCube2[0] = new Point (6.7, 3.9, 1.3 );
		unserTestCube2[1] = new Point( -8.3, 4.9, 5.3 );
		unserTestCube2[2] = new Point( -6.3, -1.1, 14.3 );
		unserTestCube2[3] = new Point( 2.7, 4.9, 16.3 ); 
		unserTestCube2[4] = new Point( -0.3, -8.1, 8.3 );
		unserTestCube2[5] = new Point( 0.7, 10.9, 7.3 ); 
		unserTestCube2[6] = new Point( -2.3, -2.1, -0.7 ); 
		unserTestCube2[7] = new Point( 8.7, -2.1, 10.3 );
		
		Cube b = new Cube(unserTestCube2); 
		System.out.println(b+"\n");
		Cube c = new Cube(unserTestCube); 
		System.out.println(c+"\n");
		
		// Daten Cuboid
		Point[] cuboidpoints = new Point[8];
        cuboidpoints[0] = new Point(1, 0, 1);
        cuboidpoints[1] = new Point(4, 0, 1);
        cuboidpoints[2] = new Point(4, 0, 3);
        cuboidpoints[3] = new Point(1, 0, 3);
        cuboidpoints[4] = new Point(1, 2, 1);
        cuboidpoints[5] = new Point(4, 2, 1);
        cuboidpoints[6] = new Point(4, 2, 3);
        cuboidpoints[7] = new Point(1, 2, 3);
       
		Cuboid q = new Cuboid(cuboidpoints);
		System.out.println(q+"\n");	
		
		
		
		
		
		
        Point[] cp = new Point[] {
                new Point(-1.0, 1.0, 1.0),
                new Point(-1.0, 3.0, 1.0), 
                new Point(-1.0, 1.0, 3.0),
                new Point(-1.0, 3.0, 3.0),
                new Point(-3.0, 3.0, 1.0), 
                new Point(-3.0, 1.0, 3.0),
                new Point(-3.0, 3.0, 3.0) };
	       
	        Cuboid q2 = new Cuboid(cp);
	        System.out.println(q2+"\n"); 
	}
}