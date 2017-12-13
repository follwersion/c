/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        B1
 * Kontrolleur:         Behnke
 * Datum der Abnahme:   14.01.2010
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr5_v06.pdf
 */
package b1;

import java.util.NoSuchElementException;

public class MagicList<E> {
    public Knoten<E> start;
    private int      size;

    public MagicList() {
        this.start = new Knoten<E>(null, null, null); // Start/Endeknoten referenziert sich selbst
        this.start.setNext(this.start);
        this.start.setPrev(this.start);
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ----------------------------------------------------------
    public void printF2L() {
        if (isEmpty())
            System.out.println("[]");
        Knoten<E> temp = start;
        while (temp.hasNext()) {
            System.out.println(temp.getNext());
            temp = temp.getNext();
        }
    }

    public void printL2F() {
        if (isEmpty())
            System.out.println("[]");
        Knoten<E> temp = start;
        while (temp.hasPrev()) {
            System.out.println(temp.getPrev());
            temp = temp.getPrev();
        }
    }

    // -----------------------------------------------------------
    public void putF(E objekt) {
        Knoten<E> temp = new Knoten<E>(objekt, start, start.getNext()); // "tmp" bekommt "start" als prev und "start.getNext" als next
        start.getNext().setPrev(temp); // "start.getNext" bekommt "tmp" als prev
        start.setNext(temp); // "start" bekommt "tmp" als next
        size++;
    }

    public void putL(E objekt) {
        Knoten<E> temp = new Knoten<E>(objekt, start.getPrev(), start);
        start.getPrev().setNext(temp);
        start.setPrev(temp);
        size++;
    }

    public boolean putNo(int index, E objekt) {
        if (index < 0 || index > size) // Prüfung ob Indexposition gültig
            return false;
        Knoten<E> temp1 = durchlauf(index);
        Knoten<E> temp2 = new Knoten<E>(objekt, temp1.getPrev(), temp1); // "temp2" zwischen "temp1" & "temp1.getPrev" einfügen
        temp1.getPrev().setNext(temp2); // Referenzen Updaten
        temp1.setPrev(temp2);
        size++;
        return true;
    }

    // -----------------------------------------------------------
    public E setNo(int index, E objekt) {
        if (index < 0 || index >= size)
            return null;

        E temp1;
        Knoten<E> temp = durchlauf(index);
        temp1 = temp.getObjekt();
        temp.setObjekt(objekt);
        return temp1;
    }

    // ------------------------------------------------------------
    public E peekF() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Keine Objekte in der Liste");
        return start.getNext().getObjekt();
    }

    public E peekL() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Keine Objekte in der Liste");
        return start.getPrev().getObjekt();
    }

    public E peekNo(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Knoten<E> temp = durchlauf(index);
        return temp.getObjekt();
    }

    // -------------------------------------------------------------
    public E getF() throws NoSuchElementException {
        E temp;
        if (isEmpty())
            throw new NoSuchElementException("Keine Objekte in der Liste");
        temp = start.getNext().getObjekt();
        removeNode(start.getNext());
        return temp;
    }

    public E getL() throws NoSuchElementException {
        E temp;
        if (isEmpty())
            throw new NoSuchElementException("Keine Objekte in der Liste");
        temp = start.getPrev().getObjekt();
        removeNode(start.getPrev());
        return temp;
    }

    public E getNo(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E oldData;
        Knoten<E> temp = durchlauf(index);
        oldData = temp.getObjekt();
        removeNode(temp);
        return oldData;
    }

    // -------------------------------------------------------------
    public int pos(E objekt) {
        if (isEmpty())
            return -1;
        int count = 0;
        Knoten<E> tmp = start;
        while (count < size) {
            tmp = tmp.getNext();
            if (tmp.getObjekt().equals(objekt))
                return count;
            count++;
        }
        return -1;
    }
    
   private Knoten<E> posNode(E objekt){
       if (isEmpty())
           return null;
       int count = 0;
       Knoten<E> tmp = start;
       while (count < size) {
           tmp = tmp.getNext();
           if (tmp.getObjekt().equals(objekt))
               return tmp;
           count++;
       }
       return null;       
   }
  
    // ----------------------------------------------------------------
    public boolean remove(E objekt) {
        Knoten<E> temp = posNode(objekt);
        if (temp == null)
            return false;
        removeNode(temp);
        return true;
    }
    private void removeNode(Knoten<E> a){
        a.getPrev().setNext(a.getNext());
        a.getNext().setPrev(a.getPrev());
        size--;
    }

    public boolean remove(int index) { // Überladen von "remove"
        if (index < 0 || index >= size)
            return false;
        Knoten<E> temp = durchlauf(index);
        removeNode(temp);
        return true;
    }

    // --------------------------------------------------------------
    public MagicList<E> sublist(E objekt) {
        MagicList<E> sub = new MagicList<E>();
        int index = pos(objekt);
        if (index == -1)
            return sub;
        Knoten<E> temp = durchlauf(index);
        while (index < size) {
            sub.putL(temp.getObjekt()); // Adde alle Objekte von "index" bis "size" in "sub"
            temp = temp.getNext();
            index++;
        }
        return sub;
    }

    public MagicList<E> sublist(E objekt1, E objekt2) {
        MagicList<E> sub = new MagicList<E>();
        int indexTmp1 = pos(objekt1); // Indexpositionen nach größe sortieren
        int indexTmp2 = pos(objekt2);
        if (indexTmp1 == -1 || indexTmp2 == -1) {
            System.out.println("Mind. eines der Eingegebenen Objekte kann nicht in der Liste gefunden werden!");            
        } else {
            int index1 = indexTmp1 < indexTmp2 ? indexTmp1 : indexTmp2;
            int index2 = indexTmp1 > indexTmp2 ? indexTmp1 : indexTmp2;
            if (index1 == -1 || index2 == -1)
                return sub;
            Knoten<E> temp = durchlauf(index1);
            while (index1 < index2) {
                sub.putL(temp.getObjekt());
                temp = temp.getNext();
                index1++;
            }
        }
        return sub;
    }
    
    private Knoten<E> durchlauf(int index) { // Vermeidung von Redundanz
        Knoten<E> temp = start;
        for (int i = -1; i < index; i++)
            temp = temp.getNext();
        return temp;        
    }
}