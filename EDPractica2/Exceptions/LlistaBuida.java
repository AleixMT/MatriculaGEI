package Exceptions;
/**
 * Excepcio. Salta quan la llista esta buida
 * @author Aleix Marine i Cristina Izquierdo
 *
 */
public class LlistaBuida extends Exception{
	private static final long serialVersionUID = 1L;

	public LlistaBuida(){
		super("ERROR: la llista està buida.");
	}

}
