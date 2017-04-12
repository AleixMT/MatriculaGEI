package Interfaces;

import Exceptions.*;

/**
 * Interfície del TAD Multillista
 * @author Cristina Izquierdo i Aleix Mariné
 *
 */
public interface TADMultillista<E> {

	/**
	 * Afegeix una relació
	 * @param e - element a afegir
	 * @throws LlistaPlena
	 */
	public void afegir(E e) throws LlistaPlena;
	
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
	public E consultar(E c)throws LlistaBuida;
	
	/**
	 * mètode toString
	 * @return String amb les relacions de la multillista
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
