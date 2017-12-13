package a06;



public class Buch extends Medium {
	
	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 04.05.09
	 * Aufgabe 6
	 */
	
	private String author ;
	private String isbn10 ;
	private String isbn13 ;
	
	
	Buch (String author, String isbn10,String isbn13,String title, String realase) {
		super(title, realase);
		this.setAuthor(author);
		this.setIsbn10(isbn10);
		this.setIsbn13(isbn13);
	
	}	

	public String toString() {
	      return super.toString() + "Author: " + this.getAuthor()+"\nISBN10: "+this.getIsbn10()+"\nISBN13:"+this.getIsbn13();
	   }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

}