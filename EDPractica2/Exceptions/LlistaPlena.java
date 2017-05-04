package Exceptions;
/**
 * Excepcio. Salta quan la llista esta plena
 * @author Aleix Marine i Cristina Izquierdo
 *
 */
public class LlistaPlena extends Exception{

	private static final long serialVersionUID = 1L;

	public LlistaPlena(){
		super("ERROR: la llista està plena.");
	}
}
