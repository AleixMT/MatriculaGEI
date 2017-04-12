package Interfaces;

import Exceptions.*;

/**
 * Interface per a definir una llista genèrica.
 * @author Cristina Izquierdo i Aleix Mariné
 *
 */
public interface TADLlistaGenerica<E> {
	
	/**
	 * Afegeix un element a la llista
	 * @param a - element a afegir
	 * @throws LlistaPlena
	 */
	public void afegir(E a) throws LlistaPlena;
	
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
	 * Getter del número d'elements
	 * @return número d'elements a la llista
	 * @throws LlistaBuida
	 */
	public int getNumElem() throws LlistaBuida;

	/**
	 * mètode toString
	 * @return String amb els elements de la llista
	 */	
	public String toString();
	
	/**
	 * Mètode per comparar objectes
	 * @param c - objecte a comparar
	 * @return -1 si és més petit, 0 si és igual o 1 si és més gran
	 */
	public int compareTo(E c);
	
	/**
	 * Mètode per a comparar dos elements
	 * @return true o false
	 */
	public boolean equals();
	
	/**
	 * Mètode per a l'iterator
	 * @return true o false
	 */
	public boolean hasNext();
	
	/**
	 * Mètode per a l'iterator
	 * @return següent objecte
	 */
	public E next();
	
	
}
