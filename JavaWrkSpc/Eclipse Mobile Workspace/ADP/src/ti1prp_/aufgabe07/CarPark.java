/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

import java.util.ArrayList;
import java.util.List;

public class CarPark {

	public static List<Vehicle> vehicle;
	
    /**
     * @param args
     */

    public static void main(String[] args) {
        
    	vehicle = new ArrayList<Vehicle>();
    	
        // ##########   LKW   ################
    	vehicle.add(new Truck("Homer", Color.red, Fuel.Kernenergie, 20));                           // Id 1
    	vehicle.add(new Truck("Lisa", Color.green, Fuel.Biodiesel, 45));                    // Id 2
    	vehicle.add(new Truck("Bart", Color.white, Fuel.Erdgas, 80));                            // Id 3    
    	vehicle.add(new Truck("Felix", Color.black, Fuel.Biodiesel, 45));                     // Id 4
    	vehicle.add(new Truck("Sven", Color.blue, Fuel.Kernenergie,10));                    // Id 5
    	vehicle.add(new Truck("Marge", Color.black, Fuel.Elektro, 15));                      // Id 6
                
        // ##########   PKW   ################
    	vehicle.add(new Car("Franz", Color.green, Fuel.Benzin, 120, 60));                           // Id 7    
    	vehicle.add(new Car("Hela", Color.brown, Fuel.Erdgas, 100, 3));                            // Id 8
    	vehicle.add(new Car("Otto", Color.red, Fuel.Biodiesel, 150, 5));                           // Id 9
    	vehicle.add(new Car("Klaus", Color.yellow, Fuel.Super, 25, 3));                            // Id 10
    	vehicle.add(new Car("Ingo", Color.green, Fuel.Benzin, 180, 4));                            // Id 11
    	vehicle.add(new Car("Willy", Color.green, Fuel.Kernenergie, 700, 2));                      // Id 12
        
        // ##########   Bus   ################
    	vehicle.add(new Bus("Reisebus", Color.red, Fuel.Diesel, 65, BusType.Normal));                // Id 13
    	vehicle.add(new Bus("Kohlfahrt", Color.white, Fuel.Biodiesel, 200, BusType.Panorama));        // Id 14
        
        // ##########   Motorrad   ################
    	vehicle.add(new Moped("Liebling", Color.brown, Fuel.Benzin, 1000));                              // Id 15
    	vehicle.add(new Moped("Raser", Color.black, Fuel.Benzin, 600));                                     // Id 16
    	vehicle.add(new Moped("Schatz", Color.red, Fuel.Benzin, 750));                                      // Id 17
        
        // ##########   Fahrrad   ################
    	vehicle.add(new Bicycle("Fahrrad", Color.red));                                            // Id 18
    	vehicle.add(new Bicycle("Oscar", Color.black));                                            // Id 19
    	vehicle.add(new Bicycle("Schnell", Color.red));                                        // Id 20
    	vehicle.add(new Bicycle("Radball", Color.green));                                          // Id 21
        
        // ##########   Dreirad   ################
    	vehicle.add(new Tricycle("Speedy", Color.yellow));                                // Id 22
    	vehicle.add(new Tricycle("Flash", Color.red));                                    // Id 23
    	vehicle.add(new Tricycle("Voyager", Color.green));                                // Id 24
        
    	vehicle.add(new Scooter("Rolli",	Color.brown));                                    // Id 25
    	vehicle.add(new Scooter("Firefox", Color.orange));                                 // Id 26
        
    	vehicle.get(25).serviceStart();
    	vehicle.get(25).defect = true;
    	
        //available();
        System.out.println("----------------------------------------------------------");       
        available(VehicleType.KFZ, Color.blue);
        System.out.println("----------------------------------------------------------");
        available(VehicleType.KFZ, Fuel.Diesel);
        System.out.println("----------------------------------------------------------");
        available(VehicleSubType.Bus, BusType.Panorama);
        System.out.println("----------------------------------------------------------");
        available(VehicleSubType.Roller, Color.orange);
        System.out.println("----------------------------------------------------------");
        available(VehicleSubType.LKW, 20);
        System.out.println("----------------------------------------------------------");
        available(VehicleType.KFZ, Fuel.Kernenergie);
    }
    
    
    public static void available() {
        for (int i = 0; i < vehicle.size(); i++) {
            if(vehicle.get(i).available == true) {
                System.out.println(vehicle.get(i));
            }
        }
    }

    public static void verf�gbar(VehicleType type) {
        for (int i = 0; i < vehicle.size(); i++) {
            if (vehicle.get(i).type == type || type == VehicleType.All) {
                System.out.println(vehicle.get(i));
            }
        }
    }

    public static void available(VehicleType type, Color color) {
        for (int i = 0; i < vehicle.size(); i++) {
            if ((vehicle.get(i).type == type || type == VehicleType.All) &&
            	 (vehicle.get(i).color == color || color == Color.All)) {
                System.out.println(vehicle.get(i));
            }
        }
    }

    public static void available(VehicleType type, Fuel fuel) {
        if (VehicleType.KFZ == type) {
            for (int i = 0; i < vehicle.size(); i++) {
                if (vehicle.get(i).type == type &&
                    (Kfz.class.cast(vehicle.get(i)).fuel == fuel || fuel == Fuel.All)) {
                    System.out.println(vehicle.get(i));
                }
            }
        }
    }

    public static void available(VehicleSubType subtype, BusType bustype) {
        if (VehicleSubType.Bus == subtype) {
            for (int i = 0; i < vehicle.size(); i++) {
                if ((vehicle.get(i).subtype == subtype || subtype == VehicleSubType.All) &&
                    (Bus.class.cast(vehicle.get(i)).bustype == bustype || bustype == BusType.All)) {
                    System.out.println(vehicle.get(i));
                }
            }
        }
    }

    public static void available(VehicleSubType subtype, int load_ccm) {
        for (int i = 0; i < vehicle.size(); i++) {
            if (VehicleSubType.LKW == subtype && vehicle.get(i).subtype == subtype &&
                Truck.class.cast(vehicle.get(i)).load >= load_ccm) {
                System.out.println(vehicle.get(i));
            }
            else if (VehicleSubType.Motorrad == subtype &&
                     vehicle.get(i).subtype == subtype &&
                     Moped.class.cast(vehicle.get(i)).ccm >= load_ccm) {
                System.out.println(vehicle.get(i));
            }
        }
    }

    public static void verf�gbar(VehicleSubType subtype, int speed, int seats) {
        if (VehicleSubType.PKW == subtype) {
            for (int i = 0; i < vehicle.size(); i++) {
                if (vehicle.get(i).subtype == subtype &&
                    Car.class.cast(vehicle.get(i)).speed >= speed &&
                    Car.class.cast(vehicle.get(i)).seats >= seats) {
                    System.out.println(vehicle.get(i));
                }
            }
        }
    }

    public static void available(VehicleSubType subtype, Color color) {
        if (VehicleSubType.Roller == subtype) {
            for (int i = 0; i < vehicle.size(); i++) {
                if (vehicle.get(i).subtype == subtype &&
                	(vehicle.get(i).color == color || color == Color.All)) {
                    System.out.println(vehicle.get(i).toString());
                }
            }
        }
    }
}
