package Interfaces;

import Exceptions.*;

/**
 * Interface per a definir una llista gen�rica.
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public abstract interface TADLlistaGenerica<E> {
	
	/**
	 * Afegeix un element a la llista
	 * @param a - element a afegir
	 * @throws LlistaPlena
	 */
	public boolean afegir(E a) throws LlistaPlena;
	
	/**
	 * Esborra un element de la llista
	 * @param e - element a esborrar
	 * @return element esborrat
	 * @throws LlistaBuida
	 */
	public E esborrar(E e) throws LlistaBuida;
	
	/**
	 * Getter del n�mero d'elements
	 * @return n�mero d'elements a la llista
	 * @throws LlistaBuida
	 */
	public int getNumElem() throws LlistaBuida;

	/**
	 * m�tode toString
	 * @return String amb els elements de la llista
	 */	
	public String toString();
}
