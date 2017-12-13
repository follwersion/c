/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        B1
 * Kontrolleur:     
 * Datum der Abnahme:   14.01.2010
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr5_v06.pdf
 */
package b1;

public class Knoten<E> {
        private E objekt;
        private Knoten<E> prev;
        private Knoten<E> next;
        
        public Knoten(E objekt,Knoten<E> prev,Knoten<E> next){
            this.objekt = objekt;
            this.prev = prev;
            this.next = next;           
        }
     
        public E getObjekt() {
            return objekt;
        }
     
        public Knoten<E> getPrev() {
            return prev;
        }
     
        public Knoten<E> getNext() {
            return next;
        }
     
        public void setObjekt(E objekt) {
            this.objekt = objekt;
        }
     
        public void setPrev(Knoten<E> prev) {
            this.prev = prev;
        }
     
        public void setNext(Knoten<E> next) {
            this.next = next;
          
        }
        public boolean hasNext(){
            return this.getNext().getObjekt()!=null? true : false;
            
        }
        public boolean hasPrev(){
            return this.getPrev().getObjekt()!=null? true : false;
            
        }
        public String toString() {
            return String.format("%s", getObjekt());
        }
}