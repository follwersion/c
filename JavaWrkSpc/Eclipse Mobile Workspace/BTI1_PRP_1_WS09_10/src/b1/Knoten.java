package b1;

public class Knoten<E> {
        private E o;
        private Knoten<E> prev;
        private Knoten<E> next;
        
        public Knoten(E o,Knoten<E> prev,Knoten<E> next){
            this.o = o;
            this.prev = prev;
            this.next = next;
           
        }
     
        public E getO() {
            return o;
        }
     
        public Knoten<E> getPrev() {
            return prev;
        }
     
        public Knoten<E> getNext() {
            return next;
        }
     
        public void setO(E o) {
            this.o = o;
        }
     
        public void setPrev(Knoten<E> prev) {
            this.prev = prev;
        }
     
        public void setNext(Knoten<E> next) {
            this.next = next;
      
    
        }
        public boolean hasNext(){
            return this.getNext().getO()!=null? true : false;
            
        }
        public boolean hasPrev(){
            return this.getPrev().getO()!=null? true : false;
            
        }
        @Override
        public String toString() {
            return String.format("%s", getO());
        }

}
