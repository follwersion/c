package magicList;

public class Element<T> {

	private Element<T> previous = null;
	private T data = null;
	private Element<T> next = null;
	
	public Element(Element<T> previouse , T data , Element<T> next ) {
		this.previous = previouse;
		this.data = data;		
		this.next = next;
	}

	public Element<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(Element<T> previous) {
		this.previous = previous;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Element<T> getNext() {
		return this.next;
	}

	public void setNext(Element<T> next) {
		this.next = next;
	}	
	
	@Override
	public String toString() {
		return this.getData().toString();
	}
	
	
	
	
}
