package magicList;

public class MagicList<T> {

	private Element<T> first = null;
	private Element<T> last = null;
	private int size = 0;
	
	
	public MagicList() {		
	}
	
	public void addFirst(T data){
		if (this.first == null){
			this.last = this.first = new Element<T>(null , data , null);
			size++;
		}else{
		Element<T> tmp = new Element<T>(null , data , this.first);
		this.first.setPrevious(tmp);
		this.first = tmp;
		size++;
		}
	}
	
	public void addLast(T data) {
		if(this.last == null){
			this.last = this.first = new Element<T>(null , data , null);
			size++;
		}else{
		Element<T> tmp = new Element<T>(this.last , data , null);
		this.last.setNext(tmp);
		this.last = tmp;
		size++;}
	}
	
	public boolean isEmpty(){
		return (this.size == 0)?true:false;
	}
		
	@Override
	public String toString() {
		System.out.println(this.size);
		Element<T> tmpE = first;
		String tmpS = "";
		for (int i = 0; i < size; i++) {
			tmpS += tmpE.toString()+ " , ";
			
			tmpE = tmpE.getNext();
		}
		return tmpS;
	}
	
}
