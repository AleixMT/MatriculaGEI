package Interfaces;

import TAD.Iterator;
import Exceptions.*;

/**
 * Interface per a definir una llista gen�rica.
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public abstract interface TADLlistaGenerica<T extends Comparable<T>> {
	
	/**
	 * Afegeix un element a la llista
	 * @param a - element a afegir
	 * @throws LlistaPlena
	 */
	public boolean afegir(T a) throws LlistaPlena;
	
	/**
	 * Esborra un element de la llista
	 * @param e - element a esborrar
	 * @return element esborrat
	 * @throws LlistaBuida
	 */
	public T esborrar(T e) throws LlistaBuida;
	
	/**
	 * Consulta un element de la llista
	 * @param c - element a consultar
	 * @return element a consultar
	 * @throws LlistaBuida
	 */
	public T consultar(T c);
	
	/**
	 * Getter del n�mero d'elements
	 * @return n�mero d'elements a la llista
	 * @throws LlistaBuida
	 */
	public int getNumElem();
	
	/**
	 * Crea un nou iterador per a la propia classe i ho retorna
	 * @return objecte iterable de la llista
	 */
	public Iterator<T> Iterator();
	
	/**
	 * m�tode toString
	 * @return String amb els elements de la llista
	 */	
	public String toString();
	
	/**
	 * M�tode per comparar objectes
	 * @param c - objecte a comparar
	 * @return -1 si �s m�s petit, 0 si �s igual o 1 si �s m�s gran
	 */
}
