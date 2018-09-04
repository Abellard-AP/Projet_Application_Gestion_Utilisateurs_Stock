package fr.formation.exception;

public class FournisseurException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String message;


	public FournisseurException(String message) {
		
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}	
	
}
