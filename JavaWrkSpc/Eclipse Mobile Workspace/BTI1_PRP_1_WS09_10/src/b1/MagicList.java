package b1;



public class MagicList<E> {
    public Knoten<E> start;
    private int size;
    
    public MagicList() {
    this.start = new Knoten<E>(null, null , null);
    this.start.setNext(this.start);
    this.start.setPrev(this.start);
    this.size = 0; 
    }
    
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0? true : false;
    }
    //----------------------------------------------------------
    public void printF2L(){
        if(size==0)
            System.out.println("[]");
        Knoten<E> temp = start;
        while(temp.hasNext()) {            
            System.out.println(temp.getNext());
            temp=temp.getNext();
            
        }
    }
    public void printL2F(){
        if(size==0)
            System.out.println("[]");
        Knoten<E> temp = start;       
        while(temp.hasPrev()){
            System.out.println(temp.getPrev());
            temp=temp.getPrev();
        }
    }
    //-----------------------------------------------------------
    public void putF(E o){
        Knoten<E> temp = new Knoten<E>(o,start,start.getNext());
        System.out.println();
        start.getNext().setPrev(temp);
        start.setNext(temp);
        size++;
    }
    public void putL(E o){
        Knoten<E> temp = new Knoten<E>(o,start.getPrev(), start);
        start.getPrev().setNext(temp);
        start.setPrev(temp);
        size++;
    }
    public boolean putNo(int index,E o){
        if(index < 0 || index > size)
            return false;
        Knoten<E> temp = start;
        for(int i=-1;i < index; i++)
            temp = temp.getNext();
         Knoten<E> temp1 = new Knoten<E>(o,temp.getPrev(),temp);
         temp.getPrev().setNext(temp1);
         temp.setPrev(temp1);
         size++;
        return true;
        
    }
    //-----------------------------------------------------------
    public E setNo(int index,E o){
        if(index < 0 || index >= size)
            return null;
        
        E temp1; 
        Knoten<E> temp = start;
        for(int i=-1;i < index; i++)
            temp = temp.getNext();
        temp1=temp.getO();
        temp.setO(o);
        return temp1;
    }
    //------------------------------------------------------------
    public E peekF() throws Exception{
        if(size==0)
            throw new Exception("Keine Objekte in der Liste");
        return start.getNext().getO();
    }
    public E peekL() throws Exception{
        if(size==0)
            throw new Exception("Keine Objekte in der Liste");
        return start.getPrev().getO();
    }
    public E peekNo(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();       
        
       Knoten<E> temp = start;
           for(int i=-1;i < index; i++)
            temp = temp.getNext();
            
        return temp.getO();
    }
    //-------------------------------------------------------------
    public E getF() throws Exception{
        E temp;
        if(size==0)
            throw new Exception("Keine Objekte in der Liste");
        temp = start.getNext().getO();
        remove(0);
       
        return temp;
    }
    public E getL() throws Exception{
        E temp;
        if(size==0)
            throw new Exception("Keine Objekte in der Liste");
        temp = start.getPrev().getO();
        remove(size-1);
        
        return temp;
    }
    public E getNo(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();       
       E temp1; 
       Knoten<E> temp = start;
           for(int i=-1;i < index; i++)
            temp = temp.getNext();
            temp1=temp.getO();
            System.out.println(pos(temp.getO()));
            remove(pos(temp.getO()));
        return temp1;
        
    }
    //-------------------------------------------------------------
    public int pos(E o){
        if(isEmpty())
            return -1;
        int count = 0;
        Knoten<E> tmp = start;
        while(count < size){
            tmp = tmp.getNext();
            if(tmp.getO().equals(o))
                return count;
                count++;
        }
        return -1;
    }
    //----------------------------------------------------------------
    public boolean remove(E o){
        int index = pos(o);
        if(index < 0 || index >= size)
            return false;
        remove(pos(o));
        return true;
    }
    public boolean remove(int index){
        if(index < 0 || index >= size)
            return false;     
        
        Knoten<E> temp = start;
        for(int i=-1;i < index; i++)
            temp = temp.getNext();
        
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        size--;
        return true;
    }
    //--------------------------------------------------------------
    public MagicList<E> sublist(E t1){
        MagicList<E> sub = new MagicList<E>();
        Knoten<E> temp=start;
        int index1 = pos(t1);     
        if(index1==-1)
            return sub;
        for(int i=-1; i<index1 ;i++)
            temp = temp.getNext();
        while(index1<size){
            System.out.println("++++++++++++++++");
            sub.putL(temp.getO());
            temp = temp.getNext();
            index1++;
        }
        return sub;
        
    }
    public MagicList<E> sublist(E t1, E t2){
        MagicList<E> sub = new MagicList<E>();
        Knoten<E> temp=start;
        int index1 = pos(t1)< pos(t2) ? pos(t1): pos(t2);
        int index2 = pos(t1)>pos(t2) ? pos(t1): pos(t2);
        System.out.println(index1+" "+index2);
        if(index1==-1|| index2==-1)
            return sub;
        for(int i=-1; i<index1 ;i++)
            temp = temp.getNext();
        while(index1<index2){
            System.out.println("++++++++++++++++");
            sub.putL(temp.getO());
            temp = temp.getNext();
            index1++;
        }
        return sub;
        
    }
    

}
