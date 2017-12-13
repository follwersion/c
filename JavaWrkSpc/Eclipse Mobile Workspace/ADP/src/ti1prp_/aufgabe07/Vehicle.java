/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Vehicle {

	protected String name;
    
    protected Color color;
    protected double costs;
    
    protected boolean defect;
    protected boolean available;
    protected boolean service;
    
    protected VehicleType type;
    protected VehicleSubType subtype;
    
    private int id;
    private static int counter;
        
    public Vehicle(String name, Color color) {
        this.name      = name;
        this.color     = color;
        
        this.defect    = false;
        this.available = true;
        this.service   = false;
        
        this.id        = ++counter;
    }

    public void rename(String name){
        this.name = name;
    }
    
    public void rentStart(){
        this.available = false;
    }
    
    public void rentFinish(){
        this.available = true;
    }
    
    public void serviceStart(){
        this.service = true;
    }

    public void serviceFinish(int id){
        this.repair();
        this.service = false;
    }
    
    public void repair(){
        this.defect = false;
    }
    
    public void paint(Color color){
        this.color = color;
    }

    public String toString() {
         return String.format("Typ: %s\tSubtyp: %s\tName: %s\tWartung: %s\tID: %d\tFarbe: %s\tStatus: %s\tZustand: %s\t",
                              this.type,
                              this.subtype,
                              this.name,
                              (this.service == true)?"# Im Wartungszustand #":"",
                              this.id,
                              this.color,
                              (this.available == true)?"Verfügbar":"Verliehen",
                              (this.defect == true)?"# Defekt #":"Funktionsfähig");
    }
    
}
