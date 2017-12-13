package ti1prp_.aufgabe09;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A9 - Computer Shop
 */

public class NonExistingComponentException extends Throwable {
	private int errorCode;
	static final long serialVersionUID = 0;
	
	public NonExistingComponentException(String msg, int errorCode){
		this.errorCode = errorCode;
	}
	
    int getErrorCode(){
        return this.errorCode;        
    }
}
