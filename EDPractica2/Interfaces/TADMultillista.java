package Interfaces;

import Exceptions.*;

/**
 * Interf�cie del TAD Multillista
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public abstract interface TADMultillista<E> {

	/**
	 * Afegeix una relaci�
	 * @param e - element a afegir
	 * @throws LlistaPlena
	 */
	public boolean afegir(E e) throws LlistaPlena;
	
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
	 * m�tode toString
	 * @return String amb les relacions de la multillista
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
