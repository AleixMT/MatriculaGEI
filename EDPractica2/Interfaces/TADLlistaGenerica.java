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
	 * Consulta un element de la llista
	 * @param c - element a consultar
	 * @return element a consultar
	 * @throws LlistaBuida
	 */
	public E consultar(E c) throws LlistaBuida;
	
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
	
	/**
	 * M�tode per comparar objectes
	 * @param c - objecte a comparar
	 * @return -1 si �s m�s petit, 0 si �s igual o 1 si �s m�s gran
	 */
	public int compareTo(E c);
	
	/**
	 * M�tode per a comparar dos elements
	 * @return true o false
	 */
	public boolean equals();
	
	/**
	 * M�tode per a l'iterator
	 * @return true o false
	 */
	public boolean hasNext();
	
	/**
	 * M�tode per a l'iterator
	 * @return seg�ent objecte
	 */
	public E next();
	
	
}
